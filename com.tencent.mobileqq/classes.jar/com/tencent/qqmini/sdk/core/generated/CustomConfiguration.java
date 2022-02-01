package com.tencent.qqmini.sdk.core.generated;

import android.content.SharedPreferences;
import android.text.TextUtils;
import arfd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver1;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI1;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI2;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.GameActivity2;
import com.tencent.mobileqq.minigame.ui.GameActivity6;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver3;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver4;
import com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class CustomConfiguration
{
  public static final Boolean DEXLOADER_ENABLED;
  public static String DEX_CONFIG;
  public static final Boolean FLUTTER_ENABLED = Boolean.valueOf(false);
  public static final Map MINI_PROCESS_0;
  public static final Map MINI_PROCESS_1;
  public static final Map MINI_PROCESS_2;
  public static final Map MINI_PROCESS_3;
  public static final Map MINI_PROCESS_4;
  public static final Map MINI_PROCESS_5;
  public static final Map MINI_PROCESS_6;
  public static final List MINI_PROCESS_LIST;
  
  static
  {
    DEXLOADER_ENABLED = Boolean.valueOf(true);
    MINI_PROCESS_LIST = new ArrayList();
    MINI_PROCESS_0 = new HashMap();
    MINI_PROCESS_1 = new HashMap();
    MINI_PROCESS_2 = new HashMap();
    MINI_PROCESS_3 = new HashMap();
    MINI_PROCESS_4 = new HashMap();
    MINI_PROCESS_5 = new HashMap();
    MINI_PROCESS_6 = new HashMap();
    DEX_CONFIG = "";
    MINI_PROCESS_0.put("name", "mini");
    MINI_PROCESS_0.put("processType", "MINI_APP");
    MINI_PROCESS_0.put("ui", AppBrandUI.class);
    MINI_PROCESS_0.put("internalUI", "com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3");
    MINI_PROCESS_0.put("receiver", AppBrandTaskPreloadReceiver.class);
    MINI_PROCESS_0.put("supportRuntimeType", Integer.valueOf(3));
    MINI_PROCESS_LIST.add(MINI_PROCESS_0);
    MINI_PROCESS_1.put("name", "mini1");
    MINI_PROCESS_1.put("processType", "MINI_APP");
    MINI_PROCESS_1.put("ui", AppBrandUI1.class);
    MINI_PROCESS_1.put("receiver", AppBrandTaskPreloadReceiver1.class);
    MINI_PROCESS_1.put("supportRuntimeType", Integer.valueOf(1));
    MINI_PROCESS_LIST.add(MINI_PROCESS_1);
    MINI_PROCESS_2.put("name", "mini2");
    MINI_PROCESS_2.put("processType", "MINI_APP");
    MINI_PROCESS_2.put("ui", AppBrandUI2.class);
    MINI_PROCESS_2.put("receiver", AppBrandTaskPreloadReceiver2.class);
    MINI_PROCESS_2.put("supportRuntimeType", Integer.valueOf(1));
    MINI_PROCESS_LIST.add(MINI_PROCESS_2);
    MINI_PROCESS_3.put("name", "mini3");
    MINI_PROCESS_3.put("processType", "MINI_GAME");
    MINI_PROCESS_3.put("ui", GameActivity1.class);
    MINI_PROCESS_3.put("receiver", AppBrandMainReceiver3.class);
    MINI_PROCESS_3.put("supportRuntimeType", Integer.valueOf(4));
    MINI_PROCESS_LIST.add(MINI_PROCESS_3);
    MINI_PROCESS_4.put("name", "mini4");
    MINI_PROCESS_4.put("processType", "MINI_GAME");
    MINI_PROCESS_4.put("ui", GameActivity2.class);
    MINI_PROCESS_4.put("receiver", AppBrandMainReceiver4.class);
    MINI_PROCESS_4.put("supportRuntimeType", Integer.valueOf(4));
    MINI_PROCESS_LIST.add(MINI_PROCESS_4);
    MINI_PROCESS_5.put("name", "mini5");
    MINI_PROCESS_5.put("processType", "MINI_GAME");
    MINI_PROCESS_5.put("ui", GameActivity6.class);
    MINI_PROCESS_5.put("receiver", AppBrandMainReceiver5.class);
    MINI_PROCESS_5.put("supportRuntimeType", Integer.valueOf(4));
    MINI_PROCESS_LIST.add(MINI_PROCESS_5);
    DEX_CONFIG = arfd.a("sdk_dex_config", "");
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_safe_mode", 0);
      int i = ((SharedPreferences)localObject).getInt("key_count_crash", 0);
      String str = ((SharedPreferences)localObject).getString("key_crash_info", "");
      long l = ((SharedPreferences)localObject).getLong("key_crash_time", 0L);
      QLog.w("minisdk-start", 1, "CrashInfo crashCount=" + i + " time=" + l + " detail=" + str);
      if (((i > 2) || (!TextUtils.isEmpty(DEX_CONFIG))) || (!TextUtils.isEmpty(DEX_CONFIG)))
      {
        localObject = new JSONObject(DEX_CONFIG);
        if (!TextUtils.isEmpty(((JSONObject)localObject).optString("ver")))
        {
          ((JSONObject)localObject).putOpt("app_version", "8.4.5.4745");
          DEX_CONFIG = ((JSONObject)localObject).toString();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk-start", 1, "CustomConfiguration DEX_CONFIG init error! DEX_CONFIG=" + DEX_CONFIG, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.CustomConfiguration
 * JD-Core Version:    0.7.0.1
 */