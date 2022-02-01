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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SPBandwidthPredictor
  implements Handler.Callback, ISPBandwidthPredictor, NetworkListener
{
  public static final String CONFIG_RESET_TIME_SECOND_FOR_WIFI = "reset_time_threshold_wifi";
  public static final String CONFIG_RESET_TIME_SECOND_FOR_XG = "reset_time_threshold_xg";
  private static final float DEFAULT_EXO_WEIGHT = 5.0F;
  private static final int DEFAULT_RESET_TIME_THRESHOLD_WIFI = 3600;
  private static final int DEFAULT_RESET_TIME_THRESHOLD_XG = 600;
  private static final long INTERVAL_SAMPLE = 1000L;
  public static final boolean LOG = false;
  private static final int MSG_SAMPLE = 0;
  private static final int SAMPLE_EXPIRE_DURATION = 5;
  private static final String TAG = "BandwidthPredictor";
  private static volatile SPBandwidthPredictor.NetworkCallbackImpl networkCallback;
  private static volatile SPBandwidthPredictor.NetworkChangeReceiver networkChangeReceiver;
  private static final List<WeakReference<NetworkListener>> networkListeners = new ArrayList();
  private final Context appContext;
  private ArrayList<IBandwidthObtainer> bandwidthObtainers;
  private ArrayList<AbstractPredictor> bandwidthPredictors;
  private Map<String, String> configMap;
  private long currentPrediction = 0L;
  private final Handler handler;
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
    networkListeners.add(new WeakReference(this));
    registerNetworkCallback(this.appContext);
  }
  
  private static void dispatchNetworkChanged()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = networkListeners.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      NetworkListener localNetworkListener = (NetworkListener)localWeakReference.get();
      if (localNetworkListener != null) {
        localNetworkListener.onNetChanged();
      } else {
        localArrayList.add(localWeakReference);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispatchNetworkChanged: toRemoveList.size=");
    ((StringBuilder)localObject).append(localArrayList.size());
    LogUtil.d("BandwidthPredictor", ((StringBuilder)localObject).toString());
    try
    {
      networkListeners.removeAll(localArrayList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private long getCurrentBandwidth()
  {
    Object localObject = this.bandwidthObtainers.iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      long l2 = ((IBandwidthObtainer)((Iterator)localObject).next()).getCurrentBandwidth();
      l1 = l2;
      if (l2 > 0L) {
        l1 = l2;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurrentBandwidth: bandwidth=");
    ((StringBuilder)localObject).append(l1);
    LogUtil.d("BandwidthPredictor", ((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("predict: predictor=");
      localStringBuilder.append(localAbstractPredictor);
      localStringBuilder.append(", currentPrediction=");
      localStringBuilder.append(localAbstractPredictor.currentPredition);
      localStringBuilder.append(", prediction=");
      localStringBuilder.append(localAbstractPredictor.prediction);
      LogUtil.d("BandwidthPredictor", localStringBuilder.toString());
    }
    this.sampleThreshold = (((float)l / 10.0F));
    this.currentPrediction = l;
  }
  
  private static void registerNetworkCallback(Context paramContext)
  {
    if ((networkCallback == null) && (networkChangeReceiver == null))
    {
      LogUtil.d("BandwidthPredictor", "registerNetworkCallback: ");
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if ((Build.VERSION.SDK_INT >= 21) && (localConnectivityManager != null))
        {
          networkCallback = new SPBandwidthPredictor.NetworkCallbackImpl(null);
          localConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), networkCallback);
          return;
        }
        networkChangeReceiver = new SPBandwidthPredictor.NetworkChangeReceiver(null);
        paramContext.registerReceiver(networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        return;
      }
      catch (Exception paramContext)
      {
        LogUtil.e("BandwidthPredictor", paramContext);
      }
    }
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
    long l1 = getCurrentBandwidth();
    long l2 = this.sampleThreshold;
    if (l1 > l2)
    {
      this.idleTimes = 0;
      if (this.lastBandwidth > l2)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((AbstractPredictor)localIterator.next()).sample(this.lastBandwidth);
        }
      }
      this.lastBandwidth = l1;
      return;
    }
    Iterator localIterator = this.bandwidthPredictors.iterator();
    while (localIterator.hasNext())
    {
      AbstractPredictor localAbstractPredictor = (AbstractPredictor)localIterator.next();
      if (this.lastBandwidth > localAbstractPredictor.prediction) {
        localAbstractPredictor.sample(this.lastBandwidth);
      }
    }
    this.lastBandwidth = 0L;
    int j = this.idleTimes;
    int i = 1;
    this.idleTimes = (j + 1);
    if (this.idleTimes >= 5)
    {
      localIterator = this.bandwidthPredictors.iterator();
      while (localIterator.hasNext()) {
        ((AbstractPredictor)localIterator.next()).onIdle();
      }
      if (SystemClock.elapsedRealtime() - this.lastRestTimeStamp <= this.resetTimeThreshold) {
        i = 0;
      }
      if (i != 0) {
        reset();
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
    if ((paramMessage != null) && (paramMessage.what == 0))
    {
      sample();
      predict();
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, 1000L);
      return true;
    }
    return false;
  }
  
  public void onNetChanged()
  {
    LogUtil.d("BandwidthPredictor", "onNetChanged: ");
    this.handler.post(new SPBandwidthPredictor.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthPredictor
 * JD-Core Version:    0.7.0.1
 */