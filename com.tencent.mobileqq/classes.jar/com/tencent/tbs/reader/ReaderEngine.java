package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.util.Map;

public class ReaderEngine
{
  private static final String TAG = "ReaderEngine";
  private static volatile ReaderEngine mInstance = null;
  protected ITbsReaderEntry mReaderEntry;
  private int mVersionCode;
  private String mVersionName;
  
  public static String getComponentName()
  {
    return "file";
  }
  
  public static ReaderEngine getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new ReaderEngine();
      }
      return mInstance;
    }
    finally {}
  }
  
  public View createDebugView(Context paramContext)
  {
    TBSOneManager localTBSOneManager = TBSOneManager.getDefaultInstance(paramContext);
    if (localTBSOneManager != null) {
      return localTBSOneManager.getDebugger().createPanelView(paramContext);
    }
    return null;
  }
  
  public ITbsReader createTbsReader(Context paramContext, Integer paramInteger, ITbsReaderCallback paramITbsReaderCallback)
  {
    if (this.mReaderEntry != null) {}
    for (paramContext = (ITbsReader)this.mReaderEntry.createTbsReader(paramContext, paramInteger, paramITbsReaderCallback);; paramContext = null)
    {
      if (paramContext == null) {
        report(1001, "createTbsReader:" + paramInteger, null);
      }
      return paramContext;
    }
  }
  
  public boolean fileEnginePreLoad(Context paramContext, TBSOneCallback paramTBSOneCallback, boolean paramBoolean)
  {
    Log.d("ReaderEngine", "fileEnginePreLoad,isForeground:" + paramBoolean);
    paramContext = TBSOneManager.getDefaultInstance(paramContext);
    paramContext.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
    for (boolean bool1 = false;; bool1 = bool2)
    {
      try
      {
        bool2 = paramContext.isComponentInstalled("file");
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          Log.d("ReaderEngine", "fileEnginePreLoad,into download:FileComponent,isForeground:" + paramBoolean);
          if (!paramBoolean) {
            break label183;
          }
          bool1 = bool2;
          paramTBSOneCallback = new ReaderEngine.1(this, paramTBSOneCallback);
          bool1 = bool2;
          localBundle = new Bundle();
          bool1 = bool2;
          localBundle.putBoolean("is_ignore_wifi_state", true);
          bool1 = bool2;
          localBundle.putBoolean("is_ignore_frequency_limitation", true);
          bool1 = bool2;
          localBundle.putBoolean("is_ignore_flow_control", true);
          bool1 = bool2;
          paramContext.installComponent("file", localBundle, paramTBSOneCallback);
          bool1 = bool2;
        }
      }
      catch (Throwable paramTBSOneCallback)
      {
        for (;;)
        {
          boolean bool2;
          Bundle localBundle;
          label183:
          paramTBSOneCallback.printStackTrace();
        }
      }
      if (bool1) {}
      try
      {
        paramContext.setAutoUpdateEnabled(true);
        return bool1;
      }
      catch (Throwable paramContext) {}
      bool1 = bool2;
      localBundle = new Bundle();
      bool1 = bool2;
      localBundle.putBoolean("is_ignore_wifi_state", true);
      bool1 = bool2;
      paramContext.installComponent("file", localBundle, paramTBSOneCallback);
    }
    return bool1;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String getVersionName()
  {
    return this.mVersionName;
  }
  
  /* Error */
  public boolean initReaderEntry(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/tbs/reader/ReaderEngine:mReaderEntry	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_1
    //   10: invokestatic 38	com/tencent/tbs/one/TBSOneManager:getDefaultInstance	(Landroid/content/Context;)Lcom/tencent/tbs/one/TBSOneManager;
    //   13: astore 4
    //   15: aload 4
    //   17: getstatic 98	com/tencent/tbs/one/TBSOneManager$Policy:BUILTIN_FIRST	Lcom/tencent/tbs/one/TBSOneManager$Policy;
    //   20: invokevirtual 102	com/tencent/tbs/one/TBSOneManager:setPolicy	(Lcom/tencent/tbs/one/TBSOneManager$Policy;)V
    //   23: new 115	android/os/Bundle
    //   26: dup
    //   27: invokespecial 116	android/os/Bundle:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 118
    //   34: iconst_1
    //   35: invokevirtual 122	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   38: aload_1
    //   39: ldc 126
    //   41: iconst_1
    //   42: invokevirtual 122	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   45: aload 4
    //   47: ldc 27
    //   49: invokevirtual 106	com/tencent/tbs/one/TBSOneManager:isComponentInstalled	(Ljava/lang/String;)Z
    //   52: ifne +10 -> 62
    //   55: aload_1
    //   56: ldc 124
    //   58: iconst_1
    //   59: invokevirtual 122	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   62: aload 4
    //   64: ldc 27
    //   66: aload_1
    //   67: invokevirtual 150	com/tencent/tbs/one/TBSOneManager:loadComponentSync	(Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/tbs/one/TBSOneComponent;
    //   70: astore_1
    //   71: aload_0
    //   72: aload_1
    //   73: invokeinterface 154 1 0
    //   78: putfield 144	com/tencent/tbs/reader/ReaderEngine:mVersionName	Ljava/lang/String;
    //   81: aload_0
    //   82: aload_1
    //   83: invokeinterface 156 1 0
    //   88: putfield 141	com/tencent/tbs/reader/ReaderEngine:mVersionCode	I
    //   91: aload_1
    //   92: invokeinterface 160 1 0
    //   97: checkcast 53	com/tencent/tbs/reader/ITbsReaderEntry
    //   100: astore_1
    //   101: aload_1
    //   102: invokeinterface 163 1 0
    //   107: ldc 8
    //   109: new 60	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   116: ldc 165
    //   118: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: getstatic 171	com/tencent/tbs/tbsfile/BuildConfig:SDK_CAN_AUTO_UPDATE	Ljava/lang/Boolean;
    //   124: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 92	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   133: pop
    //   134: getstatic 171	com/tencent/tbs/tbsfile/BuildConfig:SDK_CAN_AUTO_UPDATE	Ljava/lang/Boolean;
    //   137: invokevirtual 177	java/lang/Boolean:booleanValue	()Z
    //   140: ifeq +13 -> 153
    //   143: aload_1
    //   144: ifnonnull +70 -> 214
    //   147: aload 4
    //   149: iconst_1
    //   150: invokevirtual 134	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   153: aload_1
    //   154: instanceof 53
    //   157: ifeq +93 -> 250
    //   160: aload_0
    //   161: aload_1
    //   162: putfield 51	com/tencent/tbs/reader/ReaderEngine:mReaderEntry	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   165: iconst_1
    //   166: istore_2
    //   167: ldc 8
    //   169: new 60	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   176: ldc 179
    //   178: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_2
    //   182: invokevirtual 86	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 92	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   191: pop
    //   192: iload_2
    //   193: ireturn
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_3
    //   198: invokevirtual 137	java/lang/Throwable:printStackTrace	()V
    //   201: aload_0
    //   202: sipush 1000
    //   205: ldc 180
    //   207: aload_3
    //   208: invokevirtual 77	com/tencent/tbs/reader/ReaderEngine:report	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: goto -104 -> 107
    //   214: aload 4
    //   216: aload_1
    //   217: invokeinterface 183 1 0
    //   222: invokevirtual 134	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   225: goto -72 -> 153
    //   228: astore_3
    //   229: aload_3
    //   230: invokevirtual 137	java/lang/Throwable:printStackTrace	()V
    //   233: aload 4
    //   235: iconst_1
    //   236: invokevirtual 134	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   239: goto -86 -> 153
    //   242: astore_3
    //   243: goto -90 -> 153
    //   246: astore_3
    //   247: goto -50 -> 197
    //   250: iconst_0
    //   251: istore_2
    //   252: goto -85 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	ReaderEngine
    //   0	255	1	paramContext	Context
    //   166	86	2	bool	boolean
    //   194	14	3	localThrowable1	Throwable
    //   228	2	3	localThrowable2	Throwable
    //   242	1	3	localThrowable3	Throwable
    //   246	1	3	localThrowable4	Throwable
    //   13	221	4	localTBSOneManager	TBSOneManager
    // Exception table:
    //   from	to	target	type
    //   23	62	194	java/lang/Throwable
    //   62	101	194	java/lang/Throwable
    //   147	153	228	java/lang/Throwable
    //   214	225	228	java/lang/Throwable
    //   233	239	242	java/lang/Throwable
    //   101	107	246	java/lang/Throwable
  }
  
  public boolean isSupportCurrentPlatform()
  {
    boolean bool = false;
    if (this.mReaderEntry != null) {
      bool = this.mReaderEntry.isSupportCurrentPlatform();
    }
    return bool;
  }
  
  public boolean isSupportExt(int paramInt, String paramString)
  {
    boolean bool = false;
    if (this.mReaderEntry != null) {
      bool = this.mReaderEntry.isSupportExt(paramInt, paramString);
    }
    if (!bool) {
      report(1002, paramString, null);
    }
    return bool;
  }
  
  public void report(int paramInt, String paramString, Throwable paramThrowable)
  {
    try
    {
      StatisticReport localStatisticReport = StatisticReport.create("tbs_sdk_file_stat", paramInt);
      localStatisticReport.setDescription(paramString, paramThrowable);
      localStatisticReport.report();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setConfigSetting(Map paramMap)
  {
    if (this.mReaderEntry != null) {
      this.mReaderEntry.initSettings(paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine
 * JD-Core Version:    0.7.0.1
 */