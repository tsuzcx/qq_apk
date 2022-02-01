package com.tencent.qqlive.mediaplayer.api;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TVK_PlayerVideoInfo
  implements Serializable
{
  public static final String EXTRA_PARAM_KEY_BUS_TYPE_KEY = "shouq_bus_type";
  public static final String EXTRA_PARAM_KEY_BUS_WIFI_CHANNEL_ID = "channelid";
  public static final String EXTRA_PARAM_KEY_BUS_WIFI_DEVICE_ID = "deviceid";
  public static final String EXTRA_PARAM_KEY_BUS_WIFI_NETWORK_ID = "networkid";
  public static final String EXTRA_PARAM_KEY_BUS_WIFI_VIDEO_ID = "videoid";
  public static final int PLAY_START_WINDOW_FULL_SCREEN = 0;
  public static final int PLAY_START_WINDOW_SMALL_WINDOW = 1;
  public static final int SOURCE_TYPE_INVALID = -1;
  public static final int SOURCE_TYPE_SEARCH = 1;
  private static final long serialVersionUID = -374236133868823816L;
  private String a = "";
  private String b = "";
  private int c = 5;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private String g = "";
  private String h = "";
  private boolean i = false;
  private int j;
  private int k;
  private String l;
  private int m = 0;
  private int n = -1;
  private String o;
  private boolean p;
  private int q = 0;
  private int r = 0;
  private String s = "";
  private Map<String, String> t;
  private Map<String, String> u;
  private Map<String, String> v;
  private Map<String, String> w;
  private Map<String, String> x;
  private boolean y = false;
  private boolean z = false;
  
  public TVK_PlayerVideoInfo()
  {
    this.a = "";
    this.b = "";
    this.c = 5;
    a();
  }
  
  public TVK_PlayerVideoInfo(int paramInt, String paramString1, String paramString2)
  {
    this.c = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    a();
  }
  
  private void a()
  {
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = "";
    this.h = "";
    this.i = false;
    this.j = 0;
    this.k = 0;
    this.l = "";
    this.m = 0;
    this.n = -1;
    this.s = "";
    this.u = new HashMap();
    this.v = new HashMap();
    this.w = new HashMap();
  }
  
  public void addAdRequestParamMap(String paramString1, String paramString2)
  {
    if (this.u == null) {
      this.u = new HashMap();
    }
    this.u.put(paramString1, paramString2);
  }
  
  public void addExtraParamsMap(String paramString1, String paramString2)
  {
    if (this.v == null) {
      this.v = new HashMap();
    }
    this.v.put(paramString1, paramString2);
  }
  
  public void addOtherParamsMap(String paramString1, String paramString2)
  {
    if (this.w == null) {
      this.w = new HashMap();
    }
    this.w.put(paramString1, paramString2);
  }
  
  public Map<String, String> getAdRequestParamMap()
  {
    return this.u;
  }
  
  public String getCid()
  {
    return this.b;
  }
  
  public Map<String, String> getConfigMap()
  {
    return this.x;
  }
  
  public Map<String, String> getExtraRequestParamsMap()
  {
    return this.v;
  }
  
  public String getNextCid()
  {
    return this.h;
  }
  
  public String getNextVid()
  {
    return this.g;
  }
  
  public String getOtherParams(String paramString)
  {
    Map localMap = this.w;
    if (localMap == null) {
      return null;
    }
    return (String)localMap.get(paramString);
  }
  
  public int getPayType()
  {
    return this.j;
  }
  
  public String getPlayMode()
  {
    return this.o;
  }
  
  public int getPlayType()
  {
    return this.c;
  }
  
  public int getPlayWindowType()
  {
    return this.m;
  }
  
  public int getPlayerForceType()
  {
    return this.r;
  }
  
  public int getPlayerRetryType()
  {
    return this.q;
  }
  
  public String getReportExtraInfo()
  {
    return this.s;
  }
  
  public Map<String, String> getReportInfoMap()
  {
    return this.t;
  }
  
  public int getSourceType()
  {
    return this.n;
  }
  
  public int getTypeID()
  {
    return this.k;
  }
  
  public String getVid()
  {
    return this.a;
  }
  
  public String getVideoName()
  {
    return this.l;
  }
  
  public boolean isDrm()
  {
    return this.f;
  }
  
  public boolean isMiniWindow()
  {
    return this.y;
  }
  
  public boolean isNeedCharge()
  {
    return this.d;
  }
  
  public boolean isOnlyAudio()
  {
    return this.e;
  }
  
  public boolean isPreLoad()
  {
    return this.p;
  }
  
  public boolean isScreenShotPage()
  {
    return this.i;
  }
  
  public boolean ismDownloadAndPlay()
  {
    return this.z;
  }
  
  public void setCid(String paramString)
  {
    this.b = paramString;
  }
  
  public void setConfigMap(String paramString1, String paramString2)
  {
    if (this.x == null) {
      this.x = new HashMap();
    }
    this.x.put(paramString1, paramString2);
  }
  
  public void setDrm(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setMiniWindow(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setNeedCharge(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setNextCid(String paramString)
  {
    this.h = paramString;
  }
  
  public void setNextVid(String paramString)
  {
    this.g = paramString;
  }
  
  public void setOnlyAudio(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setPayType(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setPid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.v == null) {
      this.v = new HashMap();
    }
    Map localMap;
    if (this.c == 1)
    {
      localMap = this.v;
      if (localMap != null) {
        localMap.put("livepid", paramString);
      }
    }
    if (this.u == null) {
      this.u = new HashMap();
    }
    if (this.c == 1)
    {
      localMap = this.u;
      if (localMap != null) {
        localMap.put("livepid", paramString);
      }
    }
  }
  
  public void setPlayMode(String paramString)
  {
    this.o = paramString;
  }
  
  public void setPlayType(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setPlayWindowType(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setPlayerForceType(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setPlayerRetryType(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setPreLoad(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setReportExtraInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str1 = paramString;
    String str2;
    if (paramString.length() > 1024) {
      try
      {
        str1 = paramString.substring(0, 1024);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str2 = paramString;
      }
    }
    this.s = str2;
  }
  
  public void setReportInfoMap(Map<String, String> paramMap)
  {
    this.t = paramMap;
  }
  
  public void setScreenShotPage(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setSourceType(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setTypeID(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setVid(String paramString)
  {
    this.a = paramString;
  }
  
  public void setVideoName(String paramString)
  {
    this.l = paramString;
  }
  
  public void setmDownloadAndPlay(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo
 * JD-Core Version:    0.7.0.1
 */