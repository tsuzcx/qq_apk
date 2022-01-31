package com.tencent.proxyinner.utility;

import android.os.Environment;
import com.tencent.proxyinner.log.XLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UtilMisc
{
  static final String TAG = "XProxy|UtilMisc";
  private static Map<String, Boolean> isCheckEnvMap = new HashMap();
  private static boolean isTestEnv = false;
  
  public static int getTargetSdkVersion(String paramString)
  {
    String str = "";
    paramString = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + paramString + "/config.txt");
    if ((paramString == null) || (!paramString.exists())) {
      return 0;
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      paramString = str;
      if (localFileInputStream != null)
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
        paramString = str;
        for (;;)
        {
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (str.startsWith("TargetVersion")) {
            paramString = str.substring(str.lastIndexOf("=") + 1);
          }
        }
        localFileInputStream.close();
      }
      int i;
      return 0;
    }
    catch (Exception paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      paramString.printStackTrace();
      return 0;
    }
  }
  
  public static String getTestPluginPath(String paramString)
  {
    Object localObject2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + paramString + "/xproxy.test");
    if ((localObject2 == null) || (!((File)localObject2).exists())) {
      return null;
    }
    paramString = " ";
    Object localObject1 = paramString;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream((File)localObject2);
      localObject2 = paramString;
      if (localFileInputStream != null)
      {
        localObject1 = paramString;
        localObject2 = new BufferedReader(new InputStreamReader(localFileInputStream));
        for (;;)
        {
          localObject1 = paramString;
          String str = ((BufferedReader)localObject2).readLine();
          if (str == null) {
            break;
          }
          localObject1 = paramString;
          paramString = paramString + str;
        }
        localObject1 = paramString;
        localFileInputStream.close();
        localObject2 = paramString;
      }
      localObject1 = localObject2;
      paramString = ((String)localObject2).trim();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localObject1;
  }
  
  public static boolean isTestEnv(String paramString)
  {
    XLog.i("XProxy|UtilMisc", "isTestEnv  pluginid = " + paramString);
    if ((!isCheckEnvMap.containsKey(paramString)) || (!((Boolean)isCheckEnvMap.get(paramString)).booleanValue()))
    {
      isCheckEnvMap.put(paramString, Boolean.valueOf(true));
      isTestEnv = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + paramString + "/xproxy.test").exists();
      XLog.i("XProxy|UtilMisc", "isTestEnv = " + isTestEnv + " pluginid = " + paramString);
    }
    return isTestEnv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.UtilMisc
 * JD-Core Version:    0.7.0.1
 */