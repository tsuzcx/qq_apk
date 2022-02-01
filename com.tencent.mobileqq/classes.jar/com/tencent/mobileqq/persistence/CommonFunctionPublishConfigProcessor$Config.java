package com.tencent.mobileqq.persistence;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class CommonFunctionPublishConfigProcessor$Config
{
  public boolean a = true;
  public boolean b = true;
  public boolean c = true;
  public boolean d = true;
  public boolean e = true;
  public boolean f = false;
  
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
        if (paramString.optInt("is_localized", 1) != 1) {
          break label187;
        }
        bool = true;
        this.a = bool;
        if (paramString.optInt("is_wal", 1) != 1) {
          break label192;
        }
        bool = true;
        this.b = bool;
        if (paramString.optInt("is_new_unread_count", 1) != 1) {
          break label197;
        }
        bool = true;
        this.c = bool;
        if (paramString.optInt("is_new_invalid_unread_mark_threshold", 1) != 1) {
          break label202;
        }
        bool = true;
        this.d = bool;
        if (paramString.optInt("is_init_cache_parall", 1) != 1) {
          break label207;
        }
        bool = true;
        this.e = bool;
        if (paramString.optInt("is_copy_db_command_enable", 0) != 1) {
          break label212;
        }
        bool = true;
        this.f = bool;
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("CommonFunctionPublishConfigProcessor", 1, paramString, new Object[0]);
      }
      return;
      label187:
      boolean bool = false;
      continue;
      label192:
      bool = false;
      continue;
      label197:
      bool = false;
      continue;
      label202:
      bool = false;
      continue;
      label207:
      bool = false;
      continue;
      label212:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */