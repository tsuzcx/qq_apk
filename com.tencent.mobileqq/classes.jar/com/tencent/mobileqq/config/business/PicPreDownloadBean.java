package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PicPreDownloadBean
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e = 31457280L;
  public long f = 31457280L;
  public long g = 100L;
  public long h = 150L;
  public long i = 40960L;
  public long j = 71680L;
  public long k = 204800L;
  public long l = 1L;
  public long m = 819200L;
  
  public PicPreDownloadBean()
  {
    this.jdField_a_of_type_Long = 1L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 524288000L;
    this.jdField_d_of_type_Long = 31457280L;
    this.jdField_a_of_type_JavaLangString = "12000|600|20000|400|6000|300|20000|200";
    this.jdField_b_of_type_JavaLangString = "20|10|50|10";
    this.jdField_c_of_type_JavaLangString = "51f3f3f7";
    this.jdField_d_of_type_JavaLangString = "20-24;0-1";
    this.jdField_a_of_type_Int = 1000;
    this.jdField_b_of_type_Int = 32;
  }
  
  public static PicPreDownloadBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PicPreDownloadBean localPicPreDownloadBean = new PicPreDownloadBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i1 = paramArrayOfQConfItem.length;
      int n = 0;
      while (n < i1)
      {
        Object localObject = paramArrayOfQConfItem[n];
        if (localObject != null)
        {
          localObject = ((QConfItem)localObject).jdField_a_of_type_JavaLangString;
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
        n += 1;
      }
    }
    return localPicPreDownloadBean;
  }
  
  private static void a(JSONObject paramJSONObject, PicPreDownloadBean paramPicPreDownloadBean)
  {
    if (paramJSONObject.has("PicPreDownSwitchNew")) {
      paramPicPreDownloadBean.jdField_a_of_type_Long = paramJSONObject.optLong("PicPreDownSwitchNew");
    }
    if (paramJSONObject.has("PicAuDownTimePoint")) {
      paramPicPreDownloadBean.jdField_b_of_type_Long = paramJSONObject.optLong("PicAuDownTimePoint");
    }
    if (paramJSONObject.has("MaxWifiFlow")) {
      paramPicPreDownloadBean.jdField_c_of_type_Long = paramJSONObject.optLong("MaxWifiFlow");
    }
    if (paramJSONObject.has("Max4GFlow")) {
      paramPicPreDownloadBean.jdField_d_of_type_Long = paramJSONObject.optLong("Max4GFlow");
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
      paramPicPreDownloadBean.jdField_a_of_type_JavaLangString = paramJSONObject.optString("flowCombination");
    }
    if (paramJSONObject.has("troopCombination")) {
      paramPicPreDownloadBean.jdField_b_of_type_JavaLangString = paramJSONObject.optString("troopCombination");
    }
    if (paramJSONObject.has("maxRequest")) {
      paramPicPreDownloadBean.g = paramJSONObject.optLong("maxRequest");
    }
    if (paramJSONObject.has("xGPreDownPolicy")) {
      paramPicPreDownloadBean.jdField_c_of_type_JavaLangString = paramJSONObject.optString("xGPreDownPolicy");
    }
    if (paramJSONObject.has("AFBFlowHitXG")) {
      paramPicPreDownloadBean.h = paramJSONObject.optLong("AFBFlowHitXG");
    }
    if (paramJSONObject.has("AFBFlowMissXG")) {
      paramPicPreDownloadBean.i = paramJSONObject.optLong("AFBFlowMissXG");
    }
    if (paramJSONObject.has("APicAvgSize")) {
      paramPicPreDownloadBean.j = paramJSONObject.optLong("APicAvgSize");
    }
    if (paramJSONObject.has("APicMaxSize")) {
      paramPicPreDownloadBean.k = paramJSONObject.optLong("APicMaxSize");
    }
    if (paramJSONObject.has("enablePeakFlow")) {
      paramPicPreDownloadBean.l = paramJSONObject.optLong("enablePeakFlow");
    }
    if (paramJSONObject.has("PeakFlowTimePeriod")) {
      paramPicPreDownloadBean.jdField_d_of_type_JavaLangString = paramJSONObject.optString("PeakFlowTimePeriod");
    }
    if (paramJSONObject.has("PeakFlowMaxPicSize")) {
      paramPicPreDownloadBean.m = paramJSONObject.optLong("PeakFlowMaxPicSize");
    }
  }
  
  private static void c(JSONObject paramJSONObject, PicPreDownloadBean paramPicPreDownloadBean)
  {
    if (paramJSONObject.has("gifWifiPreDownloadLimit")) {
      paramPicPreDownloadBean.jdField_a_of_type_Int = paramJSONObject.optInt("gifWifiPreDownloadLimit");
    }
    if (paramJSONObject.has("gifXgPreDownloadLimit")) {
      paramPicPreDownloadBean.jdField_b_of_type_Int = paramJSONObject.optInt("gifXgPreDownloadLimit");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicPreDownloadBean{PreDownSwitchNew=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",PicAuDownTimePoint=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",PreDownMaxWifiFlow=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(",PreDownMax4GFlow=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(",PreDownMax3GFlow=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",PreDownMax2GFlow=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",flowsCombination=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",troopCombination=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",requestListMaxSize=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",xGPreDownPolicy=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",xgFlowHitFeedback=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",XgFlowMissFeedback=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",pisSizeAvg=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",pisSizeMax=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",mEnablePeakFlow=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",mPeakFlowTimePeriod=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(",mPeakFlowMaxPicSize=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",gifWifiPreDownloadLimit=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",gifXgPreDownloadLimit=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicPreDownloadBean
 * JD-Core Version:    0.7.0.1
 */