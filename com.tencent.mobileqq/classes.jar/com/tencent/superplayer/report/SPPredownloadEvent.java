package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.MathUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SPPredownloadEvent
{
  public boolean a = false;
  public boolean b = true;
  private int c;
  private String d;
  private String e;
  private int f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private List<Integer> u = new ArrayList();
  private List<Integer> v = new ArrayList();
  private List<Integer> w = new ArrayList();
  private Set<Integer> x = new HashSet();
  
  public SPPredownloadEvent(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt)
  {
    this.c = paramSuperPlayerVideoInfo.getVideoSource();
    this.d = paramSuperPlayerVideoInfo.getVid();
    this.e = paramSuperPlayerVideoInfo.getPlayUrl();
    this.f = paramInt;
  }
  
  public String a()
  {
    return "actSPPredownload";
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.a) {
      return;
    }
    this.g = Math.max(paramLong2, this.g);
    this.h = Math.max(paramLong1, this.h);
    try
    {
      paramString = new JSONObject(paramString);
      this.i = Math.max(paramString.optLong("HttpDownloadSize"), this.i);
      this.j = Math.max(paramString.optLong("HttpRepeatedSize"), this.j);
      this.k = Math.max(paramString.optLong("PcdnDownloadSize"), this.k);
      this.l = Math.max(paramString.optLong("PcdnRepeatedSize"), this.l);
      this.m = Math.max(paramString.optLong("P2PDownloadSize"), this.m);
      this.n = Math.max(paramString.optLong("P2PRepeatedSize"), this.n);
      this.o = Math.max(paramString.optLong("pcdnRequestSize"), this.o);
      this.p = Math.max(paramString.optInt("pcdnRequestCount"), this.p);
      this.q = Math.max(paramString.optInt("pcdnDownloadFailCount"), this.q);
      this.r = Math.max(paramString.optInt("pcdnDownloadSuccessCount"), this.r);
      paramInt1 = paramString.optInt("lastHttpSpeed");
      if (paramInt1 > 0) {
        this.u.add(Integer.valueOf(paramInt1));
      }
      paramInt1 = paramString.optInt("lastPcdnSpeed");
      if (paramInt1 > 0) {
        this.v.add(Integer.valueOf(paramInt1));
      }
      paramInt1 = paramString.optInt("lastP2PSpeed");
      if (paramInt1 > 0)
      {
        this.w.add(Integer.valueOf(paramInt1));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if ((paramInt == 251) && ((paramObject instanceof String))) {
      a((String)paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i2 = paramString.optInt("failLength");
        if (i2 > 0)
        {
          i1 = paramString.optInt("stopReason");
          this.x.add(Integer.valueOf(i1));
          if (paramString.optInt("isError") != 1) {
            break label94;
          }
          i1 = 1;
          if (i1 != 0)
          {
            this.s += 1;
            this.t += i2;
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label94:
      int i1 = 0;
    }
  }
  
  public Map<String, String> b()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("param_videoSource", String.valueOf(this.c));
    localLinkedHashMap.put("param_vid", this.d);
    localLinkedHashMap.put("param_url", this.e);
    localLinkedHashMap.put("param_uin", SuperPlayerSDKMgr.getUid());
    localLinkedHashMap.put("param_appId", String.valueOf(SuperPlayerSDKMgr.getPlatform()));
    localLinkedHashMap.put("param_sdkVersion", String.valueOf(SuperPlayerSDKMgr.getSDKVersion()));
    localLinkedHashMap.put("param_sceneId", String.valueOf(this.f));
    localLinkedHashMap.put("param_success", String.valueOf(this.b));
    localLinkedHashMap.put("param_fileSize", String.valueOf(this.g));
    localLinkedHashMap.put("param_totalDownloadedSize", String.valueOf(this.h));
    localLinkedHashMap.put("param_httpDownloadSize", String.valueOf(this.i));
    localLinkedHashMap.put("param_httpRepeatedSize", String.valueOf(this.j));
    localLinkedHashMap.put("param_pcdnDownloadSize", String.valueOf(this.k));
    localLinkedHashMap.put("param_pcdnRepeatedSize", String.valueOf(this.l));
    localLinkedHashMap.put("param_p2pDownloadSize", String.valueOf(this.m));
    localLinkedHashMap.put("param_p2pRepeatedSize", String.valueOf(this.n));
    localLinkedHashMap.put("param_pcdnRequestSize", String.valueOf(this.o));
    localLinkedHashMap.put("param_pcdnRequestCount", String.valueOf(this.p));
    localLinkedHashMap.put("param_pcdnDownloadFailCount", String.valueOf(this.q));
    localLinkedHashMap.put("param_pcdnDownloadSuccessCount", String.valueOf(this.r));
    localLinkedHashMap.put("param_avgHttpSpeed", String.valueOf(MathUtils.a(this.u)));
    localLinkedHashMap.put("param_avgPcdnSpeed", String.valueOf(MathUtils.a(this.v)));
    localLinkedHashMap.put("param_avgP2PSpeed", String.valueOf(MathUtils.a(this.w)));
    localLinkedHashMap.put("param_pcdnErrorCount", String.valueOf(this.s));
    localLinkedHashMap.put("param_pcdnErrorSize", String.valueOf(this.t));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((Integer)localIterator.next());
      localStringBuilder.append(",");
    }
    localLinkedHashMap.put("param_pcdnStopReason", localStringBuilder.toString());
    long l1 = System.currentTimeMillis() / 1000L;
    localLinkedHashMap.put("param_timeStamp", String.valueOf(l1));
    localLinkedHashMap.put("param_timeStamp_5min", String.valueOf(l1 + 300L - l1 % 300L));
    return localLinkedHashMap;
  }
  
  public void c()
  {
    if (!this.a) {
      SPBeaconReporter.report(a(), b());
    }
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.report.SPPredownloadEvent
 * JD-Core Version:    0.7.0.1
 */