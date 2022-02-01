package com.tencent.mobileqq.persistence;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class CommonFunctionPublishConfigProcessor$Config
{
  public boolean a = false;
  public boolean b = true;
  public boolean c = true;
  public boolean d = true;
  public boolean e = true;
  public boolean f = false;
  public boolean g = false;
  public boolean h = true;
  public boolean i = true;
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config parse configText -> ");
    localStringBuilder.append(paramString);
    QLog.d("CommonFunctionPublishConfigProcessor", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("is_localized", 0) != 1) {
          break label250;
        }
        bool = true;
        this.a = bool;
        if (paramString.optInt("is_wal", 1) != 1) {
          break label255;
        }
        bool = true;
        this.b = bool;
        if (paramString.optInt("is_new_unread_count", 1) != 1) {
          break label260;
        }
        bool = true;
        this.c = bool;
        if (paramString.optInt("is_new_invalid_unread_mark_threshold", 1) != 1) {
          break label265;
        }
        bool = true;
        this.d = bool;
        if (paramString.optInt("is_init_cache_parall", 1) != 1) {
          break label270;
        }
        bool = true;
        this.e = bool;
        if (paramString.optInt("is_copy_db_command_enable", 0) != 1) {
          break label275;
        }
        bool = true;
        this.f = bool;
        if (paramString.optInt("msg_refresh_delay", 0) != 1) {
          break label280;
        }
        bool = true;
        this.g = bool;
        if (paramString.optInt("is_ignore_invalid_unread_mark", 1) != 1) {
          break label285;
        }
        bool = true;
        this.h = bool;
        if (paramString.optInt("is_turing_risk_detect_enable_after_login", 1) != 1) {
          break label290;
        }
        bool = true;
        this.i = bool;
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("CommonFunctionPublishConfigProcessor", 1, paramString, new Object[0]);
      }
      return;
      label250:
      boolean bool = false;
      continue;
      label255:
      bool = false;
      continue;
      label260:
      bool = false;
      continue;
      label265:
      bool = false;
      continue;
      label270:
      bool = false;
      continue;
      label275:
      bool = false;
      continue;
      label280:
      bool = false;
      continue;
      label285:
      bool = false;
      continue;
      label290:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */