package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.config.QConfItem;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocMiniProgramGrayTipsBean
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static TencentDocMiniProgramGrayTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TencentDocMiniProgramGrayTipsBean localTencentDocMiniProgramGrayTipsBean = new TencentDocMiniProgramGrayTipsBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
      localTencentDocMiniProgramGrayTipsBean.jdField_a_of_type_Boolean = paramArrayOfQConfItem.getBoolean("enable");
      localTencentDocMiniProgramGrayTipsBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.getString("content");
      return localTencentDocMiniProgramGrayTipsBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfQConfItem.getLocalizedMessage(), paramArrayOfQConfItem);
    }
    return localTencentDocMiniProgramGrayTipsBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocMiniProgramGrayTipsBean
 * JD-Core Version:    0.7.0.1
 */