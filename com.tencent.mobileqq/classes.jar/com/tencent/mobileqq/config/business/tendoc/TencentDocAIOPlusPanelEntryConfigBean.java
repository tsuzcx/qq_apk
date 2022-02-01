package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocAIOPlusPanelEntryConfigBean
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TencentDocAIOPlusPanelEntryConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      paramArrayOfQConfItem = null;
      return paramArrayOfQConfItem;
    }
    TencentDocAIOPlusPanelEntryConfigBean localTencentDocAIOPlusPanelEntryConfigBean = new TencentDocAIOPlusPanelEntryConfigBean();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        paramArrayOfQConfItem = localTencentDocAIOPlusPanelEntryConfigBean;
        if (!localJSONObject.has("tencentDocAioSendEntry")) {
          break;
        }
        localJSONObject = localJSONObject.getJSONObject("tencentDocAioSendEntry");
        if (localJSONObject.has("aioSendDocSwitch"))
        {
          if (localJSONObject.getInt("aioSendDocSwitch") == 1) {
            localTencentDocAIOPlusPanelEntryConfigBean.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramArrayOfQConfItem = localTencentDocAIOPlusPanelEntryConfigBean;
          if (!localJSONObject.has("webDocSelectorUrl")) {
            break;
          }
          localTencentDocAIOPlusPanelEntryConfigBean.jdField_a_of_type_JavaLangString = localJSONObject.getString("webDocSelectorUrl");
          return localTencentDocAIOPlusPanelEntryConfigBean;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return localTencentDocAIOPlusPanelEntryConfigBean;
      }
      bool = false;
    }
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigBean
 * JD-Core Version:    0.7.0.1
 */