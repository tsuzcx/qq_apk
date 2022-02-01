package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IAudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocGrayTipsBean
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private String b = "";
  private String c = "";
  
  public static TencentDocGrayTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocGrayTipsBean localTencentDocGrayTipsBean = new TencentDocGrayTipsBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleTencentDocGrayTipsConfig call after ");
          localStringBuilder.append(paramArrayOfQConfItem.toString());
          QLog.d("TencentDocGrayTipsBean", 2, localStringBuilder.toString());
        }
        a(localTencentDocGrayTipsBean, paramArrayOfQConfItem);
        return localTencentDocGrayTipsBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return localTencentDocGrayTipsBean;
      }
    }
    return null;
  }
  
  public static void a(TencentDocGrayTipsBean paramTencentDocGrayTipsBean, JSONObject paramJSONObject)
  {
    if (paramTencentDocGrayTipsBean != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      if ((((IAudioHelper)QRoute.api(IAudioHelper.class)).isDev()) && (((IAudioHelper)QRoute.api(IAudioHelper.class)).getDebugValue(10) == 1)) {
        ((IAudioHelper)QRoute.api(IAudioHelper.class)).writeTestLog(HardCodeUtil.a(2131714637));
      }
    }
    try
    {
      paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
      paramJSONObject.put("plainContent", HardCodeUtil.a(2131714630));
      paramJSONObject.put("hightLightContent", HardCodeUtil.a(2131714633));
      paramJSONObject.put("showTimes", 3);
      paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
    }
    catch (Exception localException)
    {
      label114:
      break label114;
    }
    if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
      paramTencentDocGrayTipsBean.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
    }
    if (paramJSONObject.has("plainContent")) {
      paramTencentDocGrayTipsBean.jdField_a_of_type_JavaLangString = paramJSONObject.optString("plainContent");
    }
    if (paramJSONObject.has("hightLightContent")) {
      paramTencentDocGrayTipsBean.b = paramJSONObject.optString("hightLightContent");
    }
    if (paramJSONObject.has("showTimes")) {
      paramTencentDocGrayTipsBean.jdField_a_of_type_Int = paramJSONObject.optInt("showTimes");
    }
    if (paramJSONObject.has("linkUrl")) {
      paramTencentDocGrayTipsBean.c = paramJSONObject.optString("linkUrl");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsBean
 * JD-Core Version:    0.7.0.1
 */