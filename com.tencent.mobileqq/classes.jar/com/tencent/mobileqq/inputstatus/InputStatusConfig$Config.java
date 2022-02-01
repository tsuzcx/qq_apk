package com.tencent.mobileqq.inputstatus;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class InputStatusConfig$Config
{
  public boolean a = false;
  public boolean b = true;
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        this.a = paramString.optBoolean("input_status_gray_switch", false);
        this.b = paramString.optBoolean("expand_chat_input_status_switch", true);
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("InputStatusConfig", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusConfig.Config
 * JD-Core Version:    0.7.0.1
 */