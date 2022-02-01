package com.tencent.mobileqq.qqgift.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqgift.api.IQQGiftUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGiftUtilImpl
  implements IQQGiftUtil
{
  public static final String TAG = "IQQGiftUtilImpl";
  
  public boolean checkIsQQGiftUrl(String paramString1, String paramString2, Intent paramIntent)
  {
    try
    {
      paramString1 = new JSONObject(paramString2).optJSONObject("options");
      if (paramString1 == null) {
        return false;
      }
      int i = paramString1.optInt("isQQGiftRecharge", 0);
      if (i == 1) {
        return true;
      }
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkIsQQGiftUrl throw e:");
      paramString2.append(paramString1.getMessage());
      QLog.e("IQQGiftUtilImpl", 1, paramString2.toString());
    }
    return false;
  }
  
  public Intent getOpenQQGiftUrlIntent(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    paramBundle.remove("isTransparentTitle");
    paramBundle.remove("hide_left_button");
    return new Intent(paramActivity, QQBrowserActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.QQGiftUtilImpl
 * JD-Core Version:    0.7.0.1
 */