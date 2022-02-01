package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PicPreDownloadBean
{
  public long a = 1L;
  public long b = 0L;
  public long c = 524288000L;
  public long d = 31457280L;
  public long e = 31457280L;
  public long f = 31457280L;
  public String g = "12000|600|20000|400|6000|300|20000|200";
  public String h = "20|10|50|10";
  public long i = 100L;
  public String j = "51f3f3f7";
  public long k = 150L;
  public long l = 40960L;
  public long m = 71680L;
  public long n = 204800L;
  public long o = 1L;
  public String p = "20-24;0-1";
  public long q = 819200L;
  public int r = 1000;
  public int s = 32;
  
  public static PicPreDownloadBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PicPreDownloadBean localPicPreDownloadBean = new PicPreDownloadBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i2 = paramArrayOfQConfItem.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramArrayOfQConfItem[i1];
        if (localObject != null)
        {
          localObject = ((QConfItem)localObject).b;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localPicPreDownloadBean);
            b(localJSONObject, localPicPreDownloadBean);
            c(localJSONObject, localPicPreDownloadBean);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse: ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" bean:");
            localStringBuilder.append(localPicPreDownloadBean.toString());
            QLog.i("PicPreDownloadBean", 2, localStringBuilder.toString());
          }
        }
        i1 += 1;
      }
    }
    return localPicPreDownloadBean;
  }
  
  private static void a(JSONObject paramJSONObject, PicPreDownloadBean paramPicPreDownloadBean)
  {
    if (paramJSONObject.has("PicPreDownSwitchNew")) {
      paramPicPreDownloadBean.a = paramJSONObject.optLong("PicPreDownSwitchNew");
    }
    if (paramJSONObject.has("PicAuDownTimePoint")) {
      paramPicPreDownloadBean.b = paramJSONObject.optLong("PicAuDownTimePoint");
    }
    if (paramJSONObject.has("MaxWifiFlow")) {
      paramPicPreDownloadBean.c = paramJSONObject.optLong("MaxWifiFlow");
    }
    if (paramJSONObject.has("Max4GFlow")) {
      paramPicPreDownloadBean.d = paramJSONObject.optLong("Max4GFlow");
    }
    if (paramJSONObject.has("Max3GFlow")) {
      paramPicPreDownloadBean.e = paramJSONObject.optLong("Max3GFlow");
    }
    if (paramJSONObject.has("Max2GFlow")) {
      paramPicPreDownloadBean.f = paramJSONObject.optLong("Max2GFlow");
    }
  }
  
  private static void b(JSONObject paramJSONObject, PicPreDownloadBean paramPicPreDownloadBean)
  {
    if (paramJSONObject.has("flowCombination")) {
      paramPicPreDownloadBean.g = paramJSONObject.optString("flowCombination");
    }
    if (paramJSONObject.has("troopCombination")) {
      paramPicPreDownloadBean.h = paramJSONObject.optString("troopCombination");
    }
    if (paramJSONObject.has("maxRequest")) {
      paramPicPreDownloadBean.i = paramJSONObject.optLong("maxRequest");
    }
    if (paramJSONObject.has("xGPreDownPolicy")) {
      paramPicPreDownloadBean.j = paramJSONObject.optString("xGPreDownPolicy");
    }
    if (paramJSONObject.has("AFBFlowHitXG")) {
      paramPicPreDownloadBean.k = paramJSONObject.optLong("AFBFlowHitXG");
    }
    if (paramJSONObject.has("AFBFlowMissXG")) {
      paramPicPreDownloadBean.l = paramJSONObject.optLong("AFBFlowMissXG");
    }
    if (paramJSONObject.has("APicAvgSize")) {
      paramPicPreDownloadBean.m = paramJSONObject.optLong("APicAvgSize");
    }
    if (paramJSONObject.has("APicMaxSize")) {
      paramPicPreDownloadBean.n = paramJSONObject.optLong("APicMaxSize");
    }
    if (paramJSONObject.has("enablePeakFlow")) {
      paramPicPreDownloadBean.o = paramJSONObject.optLong("enablePeakFlow");
    }
    if (paramJSONObject.has("PeakFlowTimePeriod")) {
      paramPicPreDownloadBean.p = paramJSONObject.optString("PeakFlowTimePeriod");
    }
    if (paramJSONObject.has("PeakFlowMaxPicSize")) {
      paramPicPreDownloadBean.q = paramJSONObject.optLong("PeakFlowMaxPicSize");
    }
  }
  
  private static void c(JSONObject paramJSONObject, PicPreDownloadBean paramPicPreDownloadBean)
  {
    if (paramJSONObject.has("gifWifiPreDownloadLimit")) {
      paramPicPreDownloadBean.r = paramJSONObject.optInt("gifWifiPreDownloadLimit");
    }
    if (paramJSONObject.has("gifXgPreDownloadLimit")) {
      paramPicPreDownloadBean.s = paramJSONObject.optInt("gifXgPreDownloadLimit");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicPreDownloadBean{PreDownSwitchNew=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",PicAuDownTimePoint=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",PreDownMaxWifiFlow=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",PreDownMax4GFlow=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",PreDownMax3GFlow=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",PreDownMax2GFlow=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",flowsCombination=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",troopCombination=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",requestListMaxSize=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",xGPreDownPolicy=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",xgFlowHitFeedback=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",XgFlowMissFeedback=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",pisSizeAvg=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",pisSizeMax=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",mEnablePeakFlow=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(",mPeakFlowTimePeriod=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(",mPeakFlowMaxPicSize=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(",gifWifiPreDownloadLimit=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(",gifXgPreDownloadLimit=");
    localStringBuilder.append(this.s);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicPreDownloadBean
 * JD-Core Version:    0.7.0.1
 */