package com.tencent.superplayer.bandwidth;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.NetworkUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SPBandwidthPredictor
  implements Handler.Callback, ISPBandwidthPredictor
{
  public static final String CONFIG_RESET_TIME_SECOND_FOR_WIFI = "reset_time_threshold_wifi";
  public static final String CONFIG_RESET_TIME_SECOND_FOR_XG = "reset_time_threshold_xg";
  private static final int DEFAULT_RESET_TIME_THRESHOLD_WIFI = 3600;
  private static final int DEFAULT_RESET_TIME_THRESHOLD_XG = 600;
  private static final long INTERVAL_SAMPLE = 1000L;
  public static final boolean LOG = false;
  private static final int MSG_SAMPLE = 0;
  private static final int SAMPLE_EXPIRE_DURATION = 5;
  private static final String TAG = "BandwidthPredictor";
  private Context appContext;
  private ArrayList<IBandwidthObtainer> bandwidthObtainers;
  private ArrayList<AbstractPredictor> bandwidthPredictors;
  private Map<String, String> configMap;
  private long currentPrediction = 0L;
  private Handler handler;
  private int idleTimes = 0;
  private long lastBandwidth = 0L;
  private long lastRestTimeStamp = 0L;
  private long resetTimeThreshold = 600000L;
  private long sampleThreshold = 0L;
  private int scene;
  
  public SPBandwidthPredictor(Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public SPBandwidthPredictor(Context paramContext, @Nullable ArrayList<AbstractPredictor> paramArrayList, @Nullable ArrayList<IBandwidthObtainer> paramArrayList1, @Nullable Map<String, String> paramMap)
  {
    this.appContext = paramContext.getApplicationContext();
    this.configMap = paramMap;
    this.handler = new Handler(ThreadUtil.getSubThreadLooper(), this);
    this.lastRestTimeStamp = SystemClock.elapsedRealtime();
    this.bandwidthPredictors = paramArrayList;
    this.bandwidthObtainers = paramArrayList1;
    if (this.bandwidthObtainers == null)
    {
      this.bandwidthObtainers = new ArrayList();
      this.bandwidthObtainers.add(new DefaultBandwidthObtainer());
    }
    if (this.bandwidthPredictors == null)
    {
      this.bandwidthPredictors = new ArrayList();
      this.bandwidthPredictors.add(new ExoPredictor(5.0F));
    }
    if (this.configMap == null) {
      this.configMap = new HashMap();
    }
    regsiterNetworkChangeListener();
  }
  
  private long getCurrentBandwidth()
  {
    Iterator localIterator = this.bandwidthObtainers.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      long l2 = ((IBandwidthObtainer)localIterator.next()).getCurrentBandwidth();
      l1 = l2;
      if (l2 > 0L) {
        l1 = l2;
      }
    }
    LogUtil.d("BandwidthPredictor", "getCurrentBandwidth: bandwidth=" + l1);
    return l1;
  }
  
  private void predict()
  {
    Iterator localIterator = this.bandwidthPredictors.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      AbstractPredictor localAbstractPredictor = (AbstractPredictor)localIterator.next();
      l = Math.max(localAbstractPredictor.prediction, l);
      LogUtil.d("BandwidthPredictor", "predict: predictor=" + localAbstractPredictor + ", currentPrediction=" + localAbstractPredictor.currentPredition + ", prediction=" + localAbstractPredictor.prediction);
    }
    this.sampleThreshold = (((float)l / 10.0F));
    this.currentPrediction = l;
  }
  
  private void regsiterNetworkChangeListener()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.appContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        localConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new SPBandwidthPredictor.NetworkCallbackImpl(this, null));
        return;
      }
      this.appContext.registerReceiver(new SPBandwidthPredictor.NetworkChangeReceiver(this, null), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      return;
    }
    this.appContext.registerReceiver(new SPBandwidthPredictor.NetworkChangeReceiver(this, null), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  private void reset()
  {
    LogUtil.d("BandwidthPredictor", "reset: ");
    this.lastRestTimeStamp = SystemClock.elapsedRealtime();
    Iterator localIterator = this.bandwidthPredictors.iterator();
    while (localIterator.hasNext()) {
      ((AbstractPredictor)localIterator.next()).reset();
    }
    if (NetworkUtil.isWifiConnected())
    {
      this.resetTimeThreshold = (CommonUtil.a((String)this.configMap.get("reset_time_threshold_wifi"), 3600) * 1000L);
      return;
    }
    this.resetTimeThreshold = (CommonUtil.a((String)this.configMap.get("reset_time_threshold_xg"), 600) * 1000L);
  }
  
  private void sample()
  {
    long l = getCurrentBandwidth();
    Iterator localIterator;
    if (l > this.sampleThreshold)
    {
      this.idleTimes = 0;
      if (this.lastBandwidth > this.sampleThreshold)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((AbstractPredictor)localIterator.next()).sample(this.lastBandwidth);
        }
      }
      this.lastBandwidth = l;
    }
    for (;;)
    {
      return;
      localIterator = this.bandwidthPredictors.iterator();
      while (localIterator.hasNext())
      {
        AbstractPredictor localAbstractPredictor = (AbstractPredictor)localIterator.next();
        if (this.lastBandwidth > localAbstractPredictor.prediction) {
          localAbstractPredictor.sample(this.lastBandwidth);
        }
      }
      this.lastBandwidth = 0L;
      this.idleTimes += 1;
      if (this.idleTimes >= 5)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((AbstractPredictor)localIterator.next()).onIdle();
        }
        if (SystemClock.elapsedRealtime() - this.lastRestTimeStamp > this.resetTimeThreshold) {}
        for (int i = 1; i != 0; i = 0)
        {
          reset();
          return;
        }
      }
    }
  }
  
  public final long getCurrentPrediction()
  {
    return this.currentPrediction;
  }
  
  public long getLastBandwidth()
  {
    return this.lastBandwidth;
  }
  
  public boolean handleMessage(@Nullable Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessage != null)
    {
      bool1 = bool2;
      if (paramMessage.what == 0)
      {
        sample();
        predict();
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, 1000L);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void start(Context paramContext)
  {
    if (this.scene <= 0)
    {
      this.scene = paramContext.hashCode();
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessage(0);
    }
  }
  
  public void stop(Context paramContext)
  {
    if (paramContext.hashCode() == this.scene)
    {
      this.handler.removeMessages(0);
      this.scene = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthPredictor
 * JD-Core Version:    0.7.0.1
 */