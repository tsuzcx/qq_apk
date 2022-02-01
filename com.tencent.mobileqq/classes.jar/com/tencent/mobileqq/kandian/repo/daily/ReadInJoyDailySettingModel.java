package com.tencent.mobileqq.kandian.repo.daily;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.base.report.UserActionReportUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadinjoySensorUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDailySettingModel
{
  public String a;
  public List<String> a;
  public String b;
  public List<String> b;
  public String c = "";
  public String d = "";
  
  public ReadInJoyDailySettingModel()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ReadInJoyDailySettingModel a(JSONObject paramJSONObject)
  {
    ReadInJoyDailySettingModel localReadInJoyDailySettingModel = new ReadInJoyDailySettingModel();
    if (paramJSONObject != null)
    {
      localReadInJoyDailySettingModel.jdField_a_of_type_JavaLangString = paramJSONObject.optString("key");
      localReadInJoyDailySettingModel.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
      localReadInJoyDailySettingModel.d = paramJSONObject.optString("value");
      localReadInJoyDailySettingModel.c = paramJSONObject.optString("id");
      Object localObject = paramJSONObject.optJSONArray("valuelist");
      int j = 0;
      int i;
      if (localObject != null)
      {
        localReadInJoyDailySettingModel.jdField_b_of_type_JavaUtilList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).optString(i);
          localReadInJoyDailySettingModel.jdField_b_of_type_JavaUtilList.add(str);
          i += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("idlist");
      if (paramJSONObject != null)
      {
        localReadInJoyDailySettingModel.jdField_a_of_type_JavaUtilList = new ArrayList();
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject = paramJSONObject.optString(i);
          localReadInJoyDailySettingModel.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
    }
    return localReadInJoyDailySettingModel;
  }
  
  public static String a()
  {
    return a(-1);
  }
  
  public static String a(int paramInt)
  {
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        boolean bool = RIJShowKanDianTabSp.a(paramInt);
        Object localObject3 = null;
        Object localObject1 = null;
        if (bool)
        {
          if (-1 != paramInt)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("DAILY_CHILD_FEEDS_REQUEST_CONFIG");
            ((StringBuilder)localObject1).append(paramInt);
            localObject1 = (String)RIJSPUtils.a(((StringBuilder)localObject1).toString(), "");
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("daily_sub_channel_request_data", localObject1);
            localJSONArray.put(localObject3);
          }
        }
        else
        {
          localObject1 = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
          String str = (String)RIJSPUtils.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", "");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label221;
          }
          localObject1 = new JSONArray((String)localObject1);
          if (!TextUtils.isEmpty(str)) {
            localObject3 = new JSONArray(str);
          }
          a((JSONArray)localObject1, localJSONArray);
          a((JSONArray)localObject3, localJSONArray);
          if (DailyModeConfigHandler.b()) {
            localJSONArray.put(DailyDynamicHeaderModule.a(true));
          }
        }
        if (a()) {
          localJSONArray.put(b());
        }
        localJSONArray.put(c());
        localObject1 = localJSONArray.toString();
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      label221:
      Object localObject2 = null;
    }
  }
  
  private static String a(double[] paramArrayOfDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0000");
    if (paramArrayOfDouble != null)
    {
      int i = 0;
      while (i < paramArrayOfDouble.length)
      {
        localStringBuilder.append(localDecimalFormat.format(paramArrayOfDouble[i]));
        if (i != paramArrayOfDouble.length - 1) {
          localStringBuilder.append("_");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray1 != null)
    {
      int i = 0;
      while (i < paramJSONArray1.length())
      {
        JSONObject localJSONObject = paramJSONArray1.optJSONObject(i);
        String str1 = localJSONObject.optString("key");
        String str2 = localJSONObject.optString("id");
        if (!TextUtils.isEmpty(str2))
        {
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put(str1, str2);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          paramJSONArray2.put(localJSONObject);
        }
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(227);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("report_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private static JSONObject b()
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      Object localObject = BaseApplicationImpl.getContext();
      localJSONObject2.put("bettery_level", UserActionReportUtils.getBatteryLevel());
      localJSONObject2.put("network_type", UserActionReportUtils.getNetType());
      localJSONObject2.put("king_card", RIJCUKingCardUtils.a());
      localJSONObject2.put("system_brightness", UserActionReportUtils.getScreenLightness((Context)localObject));
      localJSONObject2.put("headset_on", UserActionReportUtils.isHasHeadset((Context)localObject));
      localJSONObject2.put("volume", UserActionReportUtils.getDeviceVolume((Context)localObject));
      localObject = ReadinjoySensorUtils.a();
      localJSONObject2.put("acceleration", a(((ReadinjoySensorUtils)localObject).b()));
      localJSONObject2.put("gyroscope", a(((ReadinjoySensorUtils)localObject).a()));
      localObject = RIJSPUtils.a("daily_cba_report_key", "");
      if ((localObject != null) && (!TextUtils.isEmpty(localObject.toString()))) {
        localJSONObject2.put("click_articles_list", new JSONArray(localObject.toString()));
      }
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getDailyCbaRequestData error,msg=");
      localStringBuilder2.append(localException2.toString());
      QLog.e("ReadInJoyLog", 1, localStringBuilder2.toString());
    }
    try
    {
      localJSONObject1.put("cba_request_report_info", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException1)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("exception ,msg=");
      localStringBuilder1.append(localException1.toString());
      QLog.e("ReadInJoyLog", 1, localStringBuilder1.toString());
    }
    return localJSONObject1;
  }
  
  private static JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("daily_location", DailyDynamicHeaderModule.a());
    return localJSONObject;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("name", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("id", this.c);
      localJSONObject.put("value", this.d);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
      }
      localJSONObject.put("valuelist", localJSONArray);
      localJSONArray = new JSONArray();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
      }
      localJSONObject.put("idlist", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel
 * JD-Core Version:    0.7.0.1
 */