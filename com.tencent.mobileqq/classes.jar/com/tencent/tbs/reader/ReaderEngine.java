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
  
  /* Error */
  private boolean loadFileEngine(TBSOneManager paramTBSOneManager, com.tencent.tbs.one.TBSOneComponent paramTBSOneComponent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/tbs/reader/ReaderEngine:mReaderEntry	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   4: ifnull +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_2
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_2
    //   16: invokeinterface 46 1 0
    //   21: astore 4
    //   23: aload_0
    //   24: aload_2
    //   25: invokeinterface 49 1 0
    //   30: putfield 51	com/tencent/tbs/reader/ReaderEngine:mVersionName	Ljava/lang/String;
    //   33: aload_0
    //   34: aload_2
    //   35: invokeinterface 55 1 0
    //   40: putfield 57	com/tencent/tbs/reader/ReaderEngine:mVersionCode	I
    //   43: aload 4
    //   45: instanceof 59
    //   48: ifeq +133 -> 181
    //   51: aload 4
    //   53: checkcast 59	com/tencent/tbs/reader/ITbsReaderEntry
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: putfield 40	com/tencent/tbs/reader/ReaderEngine:mReaderEntry	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   62: aload_2
    //   63: invokeinterface 62 1 0
    //   68: iconst_1
    //   69: istore_3
    //   70: ldc 8
    //   72: new 64	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   79: ldc 67
    //   81: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 77	com/tencent/tbs/tbsfile/BuildConfig:SDK_CAN_AUTO_UPDATE	Ljava/lang/Boolean;
    //   87: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 89	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: getstatic 77	com/tencent/tbs/tbsfile/BuildConfig:SDK_CAN_AUTO_UPDATE	Ljava/lang/Boolean;
    //   100: invokevirtual 95	java/lang/Boolean:booleanValue	()Z
    //   103: ifeq +12 -> 115
    //   106: aload_2
    //   107: ifnonnull +30 -> 137
    //   110: aload_1
    //   111: iconst_1
    //   112: invokevirtual 101	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   115: iload_3
    //   116: ireturn
    //   117: astore 4
    //   119: aconst_null
    //   120: astore_2
    //   121: iconst_0
    //   122: istore_3
    //   123: aload_0
    //   124: sipush 1000
    //   127: ldc 102
    //   129: aload 4
    //   131: invokevirtual 106	com/tencent/tbs/reader/ReaderEngine:report	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: goto -64 -> 70
    //   137: aload_1
    //   138: aload_2
    //   139: invokeinterface 109 1 0
    //   144: invokevirtual 101	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   147: goto -32 -> 115
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   155: aload_1
    //   156: iconst_1
    //   157: invokevirtual 101	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   160: goto -45 -> 115
    //   163: astore_1
    //   164: goto -49 -> 115
    //   167: astore 4
    //   169: iconst_0
    //   170: istore_3
    //   171: goto -48 -> 123
    //   174: astore 4
    //   176: iconst_1
    //   177: istore_3
    //   178: goto -55 -> 123
    //   181: iconst_0
    //   182: istore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: goto -115 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	ReaderEngine
    //   0	188	1	paramTBSOneManager	TBSOneManager
    //   0	188	2	paramTBSOneComponent	com.tencent.tbs.one.TBSOneComponent
    //   69	114	3	bool	boolean
    //   21	31	4	localObject	Object
    //   117	13	4	localThrowable1	Throwable
    //   167	1	4	localThrowable2	Throwable
    //   174	1	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	57	117	java/lang/Throwable
    //   110	115	150	java/lang/Throwable
    //   137	147	150	java/lang/Throwable
    //   155	160	163	java/lang/Throwable
    //   57	62	167	java/lang/Throwable
    //   62	68	174	java/lang/Throwable
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
          paramTBSOneCallback = new ReaderEngine.2(this, paramTBSOneCallback);
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
  
  public boolean initReaderEntry(Context paramContext)
  {
    if (this.mReaderEntry != null) {
      return true;
    }
    localObject = null;
    TBSOneManager localTBSOneManager = TBSOneManager.getDefaultInstance(paramContext);
    localTBSOneManager.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
    try
    {
      paramContext = new Bundle();
      paramContext.putBoolean("is_ignore_wifi_state", true);
      paramContext.putBoolean("is_ignore_flow_control", true);
      if (!localTBSOneManager.isComponentInstalled("file")) {
        paramContext.putBoolean("is_ignore_frequency_limitation", true);
      }
      paramContext = localTBSOneManager.loadComponentSync("file", paramContext);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool;
        paramContext.printStackTrace();
        report(1000, "initReaderEntry", paramContext);
        paramContext = localObject;
      }
    }
    bool = loadFileEngine(localTBSOneManager, paramContext);
    Log.d("ReaderEngine", "initReaderEntry,ret:" + bool);
    return bool;
  }
  
  public void initReaderEntryAsync(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    if (this.mReaderEntry != null) {
      return;
    }
    TBSOneManager localTBSOneManager = TBSOneManager.getDefaultInstance(paramContext);
    localTBSOneManager.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_ignore_wifi_state", true);
      localBundle.putBoolean("is_ignore_flow_control", true);
      if (!localTBSOneManager.isComponentInstalled("file")) {
        localBundle.putBoolean("is_ignore_frequency_limitation", true);
      }
      localTBSOneManager.loadComponentAsync("file", localBundle, new ReaderEngine.1(this, paramContext, localTBSOneManager, paramITbsReaderCallback));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      report(1000, "initReaderEntry", paramContext);
    }
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