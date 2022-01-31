package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

public class TbsPVConfig
  extends TbsBaseConfig
{
  private static final String TBS_CFG_FILE = "tbs_pv_config";
  private static TbsPVConfig mInstance;
  private Context mAppContext;
  public SharedPreferences mPreferences;
  
  public static TbsPVConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        mInstance = new TbsPVConfig();
        mInstance.init(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public static void releaseInstance()
  {
    try
    {
      mInstance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getConfigFileName()
  {
    return "tbs_pv_config";
  }
  
  public int getDisabledCoreVersion()
  {
    try
    {
      String str = (String)this.mSyncMap.get("disabled_core_version");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public int getEmergentCoreVersion()
  {
    try
    {
      String str = (String)this.mSyncMap.get("emergent_core_version");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public int getLocalCoreVersionMoreTimes()
  {
    try
    {
      String str = (String)this.mSyncMap.get("get_localcoreversion_moretimes");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public int getReadApk()
  {
    try
    {
      String str = (String)this.mSyncMap.get("read_apk");
      if (!TextUtils.isEmpty(str))
      {
        i = Integer.parseInt(str);
        return i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
    finally {}
  }
  
  public boolean getTbsCoreSandboxModeEnable()
  {
    try
    {
      bool = "true".equals((String)this.mSyncMap.get("tbs_core_sandbox_mode_enable"));
      if (!bool) {
        break label37;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label37:
        boolean bool = false;
      }
    }
    finally {}
    return bool;
  }
  
  public boolean isDisableHostBackupCore()
  {
    try
    {
      String str = (String)this.mSyncMap.get("disable_host_backup");
      if (TextUtils.isEmpty(str)) {
        break label46;
      }
      bool = str.equals("true");
      if (!bool) {
        break label46;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label46:
        boolean bool = false;
      }
    }
    finally {}
    return bool;
  }
  
  public boolean isEnableNoCoreGray()
  {
    try
    {
      String str = (String)this.mSyncMap.get("enable_no_share_gray");
      if (TextUtils.isEmpty(str)) {
        break label46;
      }
      bool = str.equals("true");
      if (!bool) {
        break label46;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label46:
        boolean bool = false;
      }
    }
    finally {}
    return bool;
  }
  
  public void putData(String paramString1, String paramString2)
  {
    try
    {
      this.mSyncMap.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsPVConfig
 * JD-Core Version:    0.7.0.1
 */