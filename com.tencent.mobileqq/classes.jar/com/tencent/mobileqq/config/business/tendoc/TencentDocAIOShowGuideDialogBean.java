package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocAIOShowGuideDialogBean
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TencentDocAIOShowGuideDialogBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TencentDocAIOShowGuideDialogBean localTencentDocAIOShowGuideDialogBean = new TencentDocAIOShowGuideDialogBean();
    try
    {
      a(localTencentDocAIOShowGuideDialogBean, new JSONObject(paramArrayOfQConfItem[0].a));
      return localTencentDocAIOShowGuideDialogBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return localTencentDocAIOShowGuideDialogBean;
  }
  
  public static void a(TencentDocAIOShowGuideDialogBean paramTencentDocAIOShowGuideDialogBean, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramTencentDocAIOShowGuideDialogBean == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramTencentDocAIOShowGuideDialogBean.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramTencentDocAIOShowGuideDialogBean.jdField_a_of_type_Int = paramJSONObject.optInt("dialogShowMaxTimes");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogBean
 * JD-Core Version:    0.7.0.1
 */