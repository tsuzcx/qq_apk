package com.tencent.superplayer.bandwidth;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Callback;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Stat;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class SPBandwidthMonitor
  implements ISPBandwidthMonitor
{
  private int a;
  private int b;
  private long c = 60000L;
  private Map<String, ISPBandwidthMonitor.Stat> d = new HashMap();
  private ITPDownloadProxy e;
  private final Handler f;
  private ISPBandwidthMonitor.Callback g;
  private boolean h = false;
  private int i;
  
  public SPBandwidthMonitor(int paramInt)
  {
    this.a = paramInt;
    this.f = new Handler(ThreadUtil.getSubThreadLooper());
    a();
  }
  
  private Map<String, ISPBandwidthMonitor.Stat> a(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject(String.valueOf(this.b));
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramString.getJSONObject(str);
        ISPBandwidthMonitor.Stat localStat = new ISPBandwidthMonitor.Stat();
        localStat.httpBandwidth = localJSONObject.getLong("http");
        localStat.pcdnBandwidth = localJSONObject.getLong("pcdn");
        localStat.p2pBandwidth = localJSONObject.getLong("p2p");
        localHashMap.put(str, localStat);
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private Map<String, ISPBandwidthMonitor.Stat> a(Map<String, ISPBandwidthMonitor.Stat> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ISPBandwidthMonitor.Stat)((Map.Entry)localObject).getValue();
      ISPBandwidthMonitor.Stat localStat = (ISPBandwidthMonitor.Stat)this.d.get(str);
      if (localStat != null) {
        localHashMap.put(str, ISPBandwidthMonitor.Stat.diff(localStat, (ISPBandwidthMonitor.Stat)localObject));
      } else {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  private void a()
  {
    if (this.e == null)
    {
      int j = this.a;
      if (j > 0)
      {
        this.b = CommonUtil.b(j);
        ITPProxyManagerAdapter localITPProxyManagerAdapter = TPProxyGlobalManager.getInstance().getPlayerProxy(this.b);
        if (localITPProxyManagerAdapter != null) {
          this.e = localITPProxyManagerAdapter.getDownloadProxy();
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    if (this.h) {
      this.f.postDelayed(new SPBandwidthMonitor.3(this), paramLong);
    }
  }
  
  private long b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.c;
    return l2 - l1 % l2;
  }
  
  private void c()
  {
    a();
    long l = b();
    Object localObject1 = this.e;
    if ((localObject1 != null) && (this.g != null))
    {
      localObject1 = ((ITPDownloadProxy)localObject1).getNativeInfo(2);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sampleBandwidth, info=");
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtil.d("SPBandwidthMonitor", ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = a((String)localObject1);
        localObject2 = a((Map)localObject1);
        this.g.onBandwidthUpdate((Map)localObject2);
        this.d = ((Map)localObject1);
      }
      a(l);
      return;
    }
    LogUtil.d("SPBandwidthMonitor", "sampleBandwidth, proxy or callback null");
    a(l);
  }
  
  public void start(Context paramContext, ISPBandwidthMonitor.Callback paramCallback, long paramLong)
  {
    if ((this.i <= 0) && (paramCallback != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start, interval=");
      localStringBuilder.append(paramLong);
      LogUtil.d("SPBandwidthMonitor", localStringBuilder.toString());
      this.i = paramContext.hashCode();
      this.h = true;
      this.g = paramCallback;
      if (paramLong > 0L) {
        this.c = paramLong;
      }
      this.f.removeCallbacksAndMessages(null);
      a(0L);
    }
  }
  
  public void stop(Context paramContext)
  {
    if ((paramContext.hashCode() == this.i) && (this.h))
    {
      LogUtil.d("SPBandwidthMonitor", "stop");
      this.h = false;
      this.i = 0;
      this.f.removeCallbacksAndMessages(null);
      this.f.post(new SPBandwidthMonitor.1(this));
      this.f.postDelayed(new SPBandwidthMonitor.2(this), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthMonitor
 * JD-Core Version:    0.7.0.1
 */