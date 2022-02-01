package com.tencent.mobileqq.msf.core.net.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsfCmdConfig
{
  private static final String CMD_DELETE_FILE = "rm";
  private static final String CMD_DELETE_SP_KEY = "rm_kv";
  private static final String CMD_NOT_AUTO_RESTART = "not_auto_restart";
  private static final String CMD_NOT_EXIT = "not_exit";
  private static final String CMD_SAFE_MODE_TEST_FLAG = "test_flag";
  public static final String KEY_NOT_AUTO_RESTART_CRASH_STACK = "key_not_restart_crash_stack";
  public static final String KEY_NOT_AUTO_RESTART_CRASH_TYPE = "key_not_restart_crash_type";
  public static final String KEY_NOT_AUTO_RESTART_DELAY_MILL = "key_not_restart_delay_mill";
  public static final String KEY_NOT_AUTO_RESTART_ENABLE = "key_not_restart_enable";
  public static final String KEY_NOT_AUTO_RESTART_MAX_CRASH_NUM = "key_not_restart_max_crash";
  public static final String KEY_NOT_AUTO_RESTART_VERSION = "key_not_restart_version";
  public static final String KEY_NOT_EXIT_CRASH_STACK = "key_not_exit_crash_stack";
  public static final String KEY_NOT_EXIT_CRASH_TYPE = "key_not_exit_crash_type";
  public static final String KEY_NOT_EXIT_ENABLE = "key_not_exit_enable";
  private static final String KEY_NOT_EXIT_VERSION = "key_not_exit_version";
  public static final String NOT_AUTO_RESTART_CONTROL_FILE = "not_restart_control_file";
  public static final String SP_SAFEMODE_NOT_EXIT = "pref_safemode_not_exit";
  private static final String TAG = "MsfCmdConfig";
  
  public static void executeSafeModeCmd(int paramInt, String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.getJSONObject(i);
        if (localObject != null)
        {
          localObject = getCmdFactory((JSONObject)localObject);
          if (localObject != null) {
            ((MsfCmdConfig.a)localObject).a(paramInt);
          }
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("MsfCmdConfig", 1, "handleSafeModeCmd exception=", paramString);
    }
  }
  
  private static MsfCmdConfig.a getCmdFactory(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("cmd", "");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("params");
    String str2 = paramJSONObject.optString("multiprocess", "");
    paramJSONObject = paramJSONObject.optString("deleteonetimemode", "");
    boolean bool1 = str2.equals("true");
    boolean bool2 = paramJSONObject.equals("true");
    paramJSONObject = new ArrayList();
    int i = 0;
    while (i < localJSONArray.length())
    {
      try
      {
        Object localObject = localJSONArray.getJSONObject(i);
        str2 = ((JSONObject)localObject).optString("key", "");
        localObject = ((JSONObject)localObject).optString("value", "");
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramJSONObject.add(new Pair(str2, localObject));
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("MsfCmdConfig", 1, "getCmdFactory JSONException=", localJSONException);
      }
      i += 1;
    }
    if ("rm".equals(str1)) {
      return new MsfCmdConfig.b(str1, paramJSONObject, bool1, bool2);
    }
    if ("rm_kv".equals(str1)) {
      return new MsfCmdConfig.c(str1, paramJSONObject, bool1, bool2);
    }
    if ("not_exit".equals(str1)) {
      return new MsfCmdConfig.e(str1, paramJSONObject, bool1);
    }
    if ("test_flag".equals(str1)) {
      return new MsfCmdConfig.f(str1, paramJSONObject, bool1);
    }
    if ("not_auto_restart".equals(str1)) {
      return new MsfCmdConfig.d(str1, paramJSONObject, bool1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig
 * JD-Core Version:    0.7.0.1
 */