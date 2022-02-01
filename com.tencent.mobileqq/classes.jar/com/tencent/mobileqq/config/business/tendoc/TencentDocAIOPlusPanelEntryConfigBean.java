package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocAIOPlusPanelEntryConfigBean
{
  private boolean a = false;
  private String b = "";
  
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
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
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
            localTencentDocAIOPlusPanelEntryConfigBean.a = bool;
          }
          if (paramArrayOfQConfItem.has("webDocSelectorUrl"))
          {
            localTencentDocAIOPlusPanelEntryConfigBean.b = paramArrayOfQConfItem.getString("webDocSelectorUrl");
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
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigBean
 * JD-Core Version:    0.7.0.1
 */