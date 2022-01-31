package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.utility.UtilMisc;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalPlugin
{
  private static final String TAG = "TXProxy|LocalPlugin";
  DebugPlugin debugPlugin = new DebugPlugin();
  String mAppId;
  Context mContext;
  public String mPackageName;
  public String mPluginName;
  private int retryTimes = 0;
  
  private boolean checkExistAPKFile(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString).listFiles();
    boolean bool1 = bool2;
    int i;
    if (paramString != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramString.length) {}
      try
      {
        bool1 = paramString[i].getName().equals(this.mPluginName + ".apk");
        if (bool1)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
      i += 1;
    }
  }
  
  private void clearSixgodPath(String paramString, List<String> paramList)
  {
    if ("清除不匹配的版本，rootpath = " + paramString + " " + "retainFile =" + paramList != null) {}
    for (String str = paramList.toString();; str = "")
    {
      Log.i("TXProxy|LocalPlugin", str);
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramString.length) {
          return;
        }
        try
        {
          str = paramString[i].getName();
          if ((paramList == null) || (!paramList.contains(str))) {
            deleteFoler(paramString[i]);
          }
        }
        catch (Exception localException)
        {
          label104:
          break label104;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  private void clearVersionPath(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 48	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   9: ldc 70
    //   11: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 72
    //   20: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 74
    //   25: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 84	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: new 35	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 42	java/io/File:listFiles	()[Ljava/io/File;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +59 -> 111
    //   55: iconst_0
    //   56: istore_3
    //   57: iload_3
    //   58: aload_1
    //   59: arraylength
    //   60: if_icmpge +51 -> 111
    //   63: aload_1
    //   64: iload_3
    //   65: aaload
    //   66: invokevirtual 46	java/io/File:getName	()Ljava/lang/String;
    //   69: astore 4
    //   71: aload 4
    //   73: aload_2
    //   74: invokevirtual 102	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   77: ifne +22 -> 99
    //   80: aload_0
    //   81: aload_1
    //   82: iload_3
    //   83: aaload
    //   84: invokespecial 93	com/tencent/proxyinner/plugin/LocalPlugin:deleteFoler	(Ljava/io/File;)V
    //   87: aload_0
    //   88: aload 4
    //   90: invokestatic 108	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   93: ldc 95
    //   95: iconst_0
    //   96: invokevirtual 112	com/tencent/proxyinner/plugin/LocalPlugin:setPreinstalledPlugin	(ILjava/lang/String;Z)V
    //   99: iload_3
    //   100: iconst_1
    //   101: iadd
    //   102: istore_3
    //   103: goto -46 -> 57
    //   106: astore 4
    //   108: goto -9 -> 99
    //   111: return
    //   112: astore 4
    //   114: goto -15 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	LocalPlugin
    //   0	117	1	paramString1	String
    //   0	117	2	paramString2	String
    //   56	47	3	i	int
    //   69	20	4	str	String
    //   106	1	4	localException1	Exception
    //   112	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   63	87	106	java/lang/Exception
    //   87	99	112	java/lang/Exception
  }
  
  private void deleteFoler(File paramFile)
  {
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        deleteFoler(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private boolean isFileExist(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.isFile());
  }
  
  public void addRetryTimes()
  {
    this.retryTimes += 1;
  }
  
  public void clearAllExpiredPluginData()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("data");
    localArrayList.add("lib_" + getMaxSdkVersion());
    localArrayList.add("multi_dexes");
    localArrayList.add("optDex_" + getMaxSdkVersion());
    clearSixgodPath(getPluginSoDir(), localArrayList);
  }
  
  public void clearAllExpiredSdkVersion()
  {
    clearVersionPath(getSdkPath(), "7");
    clearVersionPath(getSdkPath() + "/" + 7, "" + getMaxSdkVersion());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("data");
    localArrayList.add("lib_" + getMaxSdkVersion());
    localArrayList.add("multi_dexes");
    localArrayList.add("optDex_" + getMaxSdkVersion());
    clearSixgodPath(getPluginSoDir(), localArrayList);
  }
  
  public void clearAllPluginData()
  {
    XLog.i("TXProxy|LocalPlugin", "删除所有本地插件数据文件");
    clearVersionPath(getSdkPath(), "7");
    clearVersionPath(getSdkPath() + "/" + 7, "");
    ArrayList localArrayList = new ArrayList();
    clearSixgodPath(getPluginSoDir(), localArrayList);
  }
  
  public void createFolder(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {
      deleteFoler(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdir();
    }
  }
  
  public boolean getHasDex2Oat(int paramInt)
  {
    boolean bool = false;
    if (this.mContext.getSharedPreferences(String.valueOf(paramInt), 0).getInt("hasdex2oat", 0) == 0) {}
    for (;;)
    {
      XLog.d("TXProxy|LocalPlugin", "getHasDex2Oat hasdex2oat = " + bool);
      return bool;
      bool = true;
    }
  }
  
  public int getMaxInstalledVersion()
  {
    String str1 = getSdkPathForCurrentProxy();
    createFolder(getSdkPath());
    createFolder(str1);
    int i = 0;
    int j = 0;
    File[] arrayOfFile = new File(str1).listFiles();
    if (arrayOfFile != null)
    {
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= arrayOfFile.length) {
          return i;
        }
        i = 0;
        try
        {
          String str2 = arrayOfFile[k].getName();
          if (isFileExist(str1 + "/" + str2 + "/" + this.mPluginName + ".apk")) {
            i = Integer.parseInt(str2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            i = 0;
          }
        }
        m = j;
        if (i > j)
        {
          m = j;
          if (!TextUtils.isEmpty(getPreInstalledPlugin(i))) {
            m = i;
          }
        }
        k += 1;
        j = m;
      }
    }
    return i;
  }
  
  public int getMaxSdkVersion()
  {
    String str1 = getSdkPathForCurrentProxy();
    createFolder(getSdkPath());
    createFolder(str1);
    int i = 0;
    int j = 0;
    File[] arrayOfFile = new File(str1).listFiles();
    if (arrayOfFile != null)
    {
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= arrayOfFile.length) {
          return i;
        }
        i = 0;
        try
        {
          String str2 = arrayOfFile[k].getName();
          if (isFileExist(str1 + "/" + str2 + "/" + this.mPluginName + ".apk")) {
            i = Integer.parseInt(str2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            i = 0;
          }
        }
        m = j;
        if (i > j) {
          m = i;
        }
        k += 1;
        j = m;
      }
    }
    return i;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public String getPath()
  {
    String str = this.debugPlugin.getPath();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return getPluginPath();
  }
  
  public String getPluginOptDexDir()
  {
    String str = this.mContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator;
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public String getPluginPath()
  {
    int i = getMaxSdkVersion();
    if (i == 0) {
      return "";
    }
    String str = getSdkPath() + "/" + 7;
    str = str + "/" + i;
    return str + "/" + this.mPluginName + ".apk";
  }
  
  public String getPluginPathWihoutConfirm()
  {
    String str = this.debugPlugin.getPath();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    int i = getMaxSdkVersion();
    if (i == 0) {
      return "";
    }
    str = getSdkPath() + "/" + 7;
    str = str + "/" + i;
    return str + "/" + this.mPluginName + ".apk";
  }
  
  public String getPluginSoDir()
  {
    return getPluginOptDexDir() + this.mPackageName + File.separator;
  }
  
  public String getPreInstalledPlugin(int paramInt)
  {
    String str = this.mContext.getSharedPreferences(String.valueOf(paramInt), 0).getString("preinstall", "");
    XLog.d("TXProxy|LocalPlugin", "getPreInstalledPlugin version = " + paramInt + "path = " + str);
    return str;
  }
  
  public int getRetryTimes()
  {
    return this.retryTimes;
  }
  
  public String getSdkPath()
  {
    String str2 = this.mAppId;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "pluginsdk";
    }
    return this.mContext.getDir(str1, 0).getAbsolutePath();
  }
  
  public String getSdkPathForCurrentProxy()
  {
    File localFile = new File(getSdkPath() + "/" + 7);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return getSdkPath() + "/" + 7;
  }
  
  public boolean haslocalInstalledPlugin()
  {
    if (isExistDebugPlugin()) {}
    while (getMaxInstalledVersion() != 0) {
      return true;
    }
    return false;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2)
  {
    XLog.i("TXProxy|LocalPlugin", "localPlugin init");
    this.mContext = paramContext;
    this.mAppId = paramString1;
    this.mPluginName = paramString2;
    if (UtilMisc.isTestEnv(this.mAppId)) {
      this.debugPlugin.init(paramContext, this.mAppId);
    }
    paramContext = paramContext.getSharedPreferences("Proxy", 0);
    int i = paramContext.getInt("Version", 0);
    if ((i != 7) && (i > 0))
    {
      if (UtilMisc.isTestEnv(this.mAppId)) {
        Log.i("TXProxy|LocalPlugin", "监测到覆盖安装了，且版本号修改，清掉本地安装的插件");
      }
      paramContext = paramContext.edit();
      paramContext.putInt("Version", 7);
      paramContext.commit();
    }
    clearAllExpiredSdkVersion();
    clearAllExpiredPluginData();
  }
  
  public boolean isExistDebugPlugin()
  {
    return !TextUtils.isEmpty(this.debugPlugin.getPath());
  }
  
  public boolean isExistInstallPlugin()
  {
    return getMaxSdkVersion() != 0;
  }
  
  public boolean isRetrying()
  {
    return this.retryTimes != 0;
  }
  
  public void resetRetryTimes()
  {
    this.retryTimes = 0;
  }
  
  public void setNeedConfirm(boolean paramBoolean, int paramInt)
  {
    Log.i("TXProxy|LocalPlugin", "setNeedConfirm version = " + paramInt);
    SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences(String.valueOf(paramInt), 0).edit();
    localEditor.putBoolean("needconfirm", paramBoolean);
    localEditor.commit();
  }
  
  public void setPackageName(String paramString)
  {
    this.mPackageName = paramString;
  }
  
  public void setPreinstalledPlugin(int paramInt, String paramString, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = this.mContext.getSharedPreferences(String.valueOf(paramInt), 0);
    ((SharedPreferences)localObject).getString("preinstall", "");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("preinstall", paramString);
    if (paramBoolean) {
      i = 1;
    }
    ((SharedPreferences.Editor)localObject).putInt("hasdex2oat", i);
    XLog.d("TXProxy|LocalPlugin", "setPreinstalledPlugin version = " + paramInt + "path = " + paramString + " hasDex2Oat = " + paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.LocalPlugin
 * JD-Core Version:    0.7.0.1
 */