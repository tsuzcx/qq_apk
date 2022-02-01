package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.AudioHelper;
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
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TencentDocGrayTipsBean localTencentDocGrayTipsBean = new TencentDocGrayTipsBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocGrayTipsBean", 2, "handleTencentDocGrayTipsConfig call after " + paramArrayOfQConfItem.toString());
      }
      a(localTencentDocGrayTipsBean, paramArrayOfQConfItem);
      return localTencentDocGrayTipsBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return localTencentDocGrayTipsBean;
  }
  
  public static void a(TencentDocGrayTipsBean paramTencentDocGrayTipsBean, JSONObject paramJSONObject)
  {
    if ((paramTencentDocGrayTipsBean == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      if ((AudioHelper.d()) && (AudioHelper.a(10) == 1)) {
        AudioHelper.a(HardCodeUtil.a(2131714708));
      }
      try
      {
        paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
        paramJSONObject.put("plainContent", HardCodeUtil.a(2131714701));
        paramJSONObject.put("hightLightContent", HardCodeUtil.a(2131714704));
        paramJSONObject.put("showTimes", 3);
        paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
        label81:
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
        if (!paramJSONObject.has("linkUrl")) {
          continue;
        }
        paramTencentDocGrayTipsBean.c = paramJSONObject.optString("linkUrl");
        return;
      }
      catch (Exception localException)
      {
        break label81;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsBean
 * JD-Core Version:    0.7.0.1
 */