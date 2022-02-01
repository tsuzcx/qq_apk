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
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocAIOPlusPanelEntryConfigBean", 2, "AIO_TENCENTDOC_ENTRY_CONFIG handleAioPlusPenalTencentDocEntryCofig");
    }
    TencentDocAIOPlusPanelEntryConfigBean localTencentDocAIOPlusPanelEntryConfigBean;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      localTencentDocAIOPlusPanelEntryConfigBean = new TencentDocAIOPlusPanelEntryConfigBean();
    }
    for (;;)
    {
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        if (paramArrayOfQConfItem.has("tencentDocAioSendEntry"))
        {
          paramArrayOfQConfItem = paramArrayOfQConfItem.getJSONObject("tencentDocAioSendEntry");
          if (paramArrayOfQConfItem.has("aioSendDocSwitch"))
          {
            int i = paramArrayOfQConfItem.getInt("aioSendDocSwitch");
            bool = true;
            if (i != 1) {
              break label125;
            }
            localTencentDocAIOPlusPanelEntryConfigBean.jdField_a_of_type_Boolean = bool;
          }
          if (paramArrayOfQConfItem.has("webDocSelectorUrl"))
          {
            localTencentDocAIOPlusPanelEntryConfigBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.getString("webDocSelectorUrl");
            return localTencentDocAIOPlusPanelEntryConfigBean;
          }
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      return localTencentDocAIOPlusPanelEntryConfigBean;
      return null;
      label125:
      boolean bool = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigBean
 * JD-Core Version:    0.7.0.1
 */