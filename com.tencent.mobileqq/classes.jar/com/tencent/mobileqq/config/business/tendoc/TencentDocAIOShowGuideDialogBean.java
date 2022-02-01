package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TencentDocAIOShowGuideDialogBean
{
  private int a = 1;
  private boolean b = false;
  
  public static TencentDocAIOShowGuideDialogBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      TencentDocAIOShowGuideDialogBean localTencentDocAIOShowGuideDialogBean = new TencentDocAIOShowGuideDialogBean();
      try
      {
        a(localTencentDocAIOShowGuideDialogBean, new JSONObject(paramArrayOfQConfItem[0].b));
        return localTencentDocAIOShowGuideDialogBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        return localTencentDocAIOShowGuideDialogBean;
      }
    }
    return null;
  }
  
  public static void a(TencentDocAIOShowGuideDialogBean paramTencentDocAIOShowGuideDialogBean, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramTencentDocAIOShowGuideDialogBean == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleTencentDocUniversalEntry call after ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, localStringBuilder.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramTencentDocAIOShowGuideDialogBean.b = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
      if (paramJSONObject.has("dialogShowMaxTimes")) {
        paramTencentDocAIOShowGuideDialogBean.a = paramJSONObject.optInt("dialogShowMaxTimes");
      }
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogBean
 * JD-Core Version:    0.7.0.1
 */