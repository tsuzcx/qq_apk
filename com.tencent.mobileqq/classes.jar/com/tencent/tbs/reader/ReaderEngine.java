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
  private static volatile ReaderEngine mInstance;
  protected ITbsReaderEntry mReaderEntry;
  private int mVersionCode;
  private String mVersionName;
  
  public static String getComponentName()
  {
    return "file";
  }
  
  public static ReaderEngine getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new ReaderEngine();
        }
      }
      finally {}
    }
    return mInstance;
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
    //   9: iconst_0
    //   10: istore_3
    //   11: iconst_0
    //   12: istore 4
    //   14: aload_2
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 6
    //   26: aload_2
    //   27: invokeinterface 46 1 0
    //   32: astore 7
    //   34: aload_0
    //   35: aload_2
    //   36: invokeinterface 49 1 0
    //   41: putfield 51	com/tencent/tbs/reader/ReaderEngine:mVersionName	Ljava/lang/String;
    //   44: aload_0
    //   45: aload_2
    //   46: invokeinterface 55 1 0
    //   51: putfield 57	com/tencent/tbs/reader/ReaderEngine:mVersionCode	I
    //   54: aload 5
    //   56: astore_2
    //   57: aload 7
    //   59: instanceof 59
    //   62: ifeq +59 -> 121
    //   65: aload 7
    //   67: checkcast 59	com/tencent/tbs/reader/ITbsReaderEntry
    //   70: astore_2
    //   71: aload_0
    //   72: aload_2
    //   73: putfield 40	com/tencent/tbs/reader/ReaderEngine:mReaderEntry	Lcom/tencent/tbs/reader/ITbsReaderEntry;
    //   76: aload_2
    //   77: invokeinterface 62 1 0
    //   82: iconst_1
    //   83: istore_3
    //   84: goto +37 -> 121
    //   87: astore 5
    //   89: iconst_1
    //   90: istore_3
    //   91: goto +19 -> 110
    //   94: astore 5
    //   96: iload 4
    //   98: istore_3
    //   99: goto +11 -> 110
    //   102: astore 5
    //   104: aload 6
    //   106: astore_2
    //   107: iload 4
    //   109: istore_3
    //   110: aload_0
    //   111: sipush 1000
    //   114: ldc 63
    //   116: aload 5
    //   118: invokevirtual 67	com/tencent/tbs/reader/ReaderEngine:report	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: new 69	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   128: astore 5
    //   130: aload 5
    //   132: ldc 72
    //   134: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: getstatic 82	com/tencent/tbs/tbsfile/BuildConfig:SDK_CAN_AUTO_UPDATE	Ljava/lang/Boolean;
    //   143: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 8
    //   149: aload 5
    //   151: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 94	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: getstatic 82	com/tencent/tbs/tbsfile/BuildConfig:SDK_CAN_AUTO_UPDATE	Ljava/lang/Boolean;
    //   161: invokevirtual 100	java/lang/Boolean:booleanValue	()Z
    //   164: ifeq +36 -> 200
    //   167: aload_2
    //   168: ifnonnull +10 -> 178
    //   171: aload_1
    //   172: iconst_1
    //   173: invokevirtual 106	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   176: iload_3
    //   177: ireturn
    //   178: aload_1
    //   179: aload_2
    //   180: invokeinterface 109 1 0
    //   185: invokevirtual 106	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   188: iload_3
    //   189: ireturn
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   195: aload_1
    //   196: iconst_1
    //   197: invokevirtual 106	com/tencent/tbs/one/TBSOneManager:setAutoUpdateEnabled	(Z)V
    //   200: iload_3
    //   201: ireturn
    //   202: astore_1
    //   203: iload_3
    //   204: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	ReaderEngine
    //   0	205	1	paramTBSOneManager	TBSOneManager
    //   0	205	2	paramTBSOneComponent	com.tencent.tbs.one.TBSOneComponent
    //   10	194	3	bool1	boolean
    //   12	96	4	bool2	boolean
    //   21	34	5	localObject1	Object
    //   87	1	5	localThrowable1	Throwable
    //   94	1	5	localThrowable2	Throwable
    //   102	15	5	localThrowable3	Throwable
    //   128	22	5	localStringBuilder	StringBuilder
    //   24	81	6	localObject2	Object
    //   32	34	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   76	82	87	java/lang/Throwable
    //   71	76	94	java/lang/Throwable
    //   26	54	102	java/lang/Throwable
    //   57	71	102	java/lang/Throwable
    //   171	176	190	java/lang/Throwable
    //   178	188	190	java/lang/Throwable
    //   195	200	202	java/lang/Throwable
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
    ITbsReaderEntry localITbsReaderEntry = this.mReaderEntry;
    if (localITbsReaderEntry != null) {
      paramContext = (ITbsReader)localITbsReaderEntry.createTbsReader(paramContext, paramInteger, paramITbsReaderCallback);
    } else {
      paramContext = null;
    }
    if (paramContext == null)
    {
      paramITbsReaderCallback = new StringBuilder();
      paramITbsReaderCallback.append("createTbsReader:");
      paramITbsReaderCallback.append(paramInteger);
      report(1001, paramITbsReaderCallback.toString(), null);
    }
    return paramContext;
  }
  
  public boolean fileEnginePreLoad(Context paramContext, TBSOneCallback paramTBSOneCallback, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fileEnginePreLoad,isForeground:");
    ((StringBuilder)localObject).append(paramBoolean);
    Log.d("ReaderEngine", ((StringBuilder)localObject).toString());
    paramContext = TBSOneManager.getDefaultInstance(paramContext);
    paramContext.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.isComponentInstalled("file");
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        localObject = new StringBuilder();
        bool1 = bool2;
        ((StringBuilder)localObject).append("fileEnginePreLoad,into download:FileComponent,isForeground:");
        bool1 = bool2;
        ((StringBuilder)localObject).append(paramBoolean);
        bool1 = bool2;
        Log.d("ReaderEngine", ((StringBuilder)localObject).toString());
        if (paramBoolean)
        {
          bool1 = bool2;
          paramTBSOneCallback = new ReaderEngine.2(this, paramTBSOneCallback);
          bool1 = bool2;
          localObject = new Bundle();
          bool1 = bool2;
          ((Bundle)localObject).putBoolean("is_ignore_flow_control", true);
          bool1 = bool2;
          ((Bundle)localObject).putBoolean("is_ignore_frequency_limitation", true);
          bool1 = bool2;
          ((Bundle)localObject).putBoolean("is_ignore_wifi_state", true);
          bool1 = bool2;
          paramContext.configure("is_ignore_update_wifi_network", Boolean.valueOf(true));
          bool1 = bool2;
          paramContext.installComponent("file", (Bundle)localObject, paramTBSOneCallback);
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          localObject = new Bundle();
          bool1 = bool2;
          ((Bundle)localObject).putBoolean("is_ignore_wifi_state", true);
          bool1 = bool2;
          paramContext.configure("is_ignore_update_wifi_network", Boolean.valueOf(true));
          bool1 = bool2;
          paramContext.installComponent("file", (Bundle)localObject, paramTBSOneCallback);
          bool1 = bool2;
        }
      }
    }
    catch (Throwable paramTBSOneCallback)
    {
      paramTBSOneCallback.printStackTrace();
    }
    if (bool1) {}
    try
    {
      paramContext.setAutoUpdateEnabled(true);
      return bool1;
    }
    catch (Throwable paramContext) {}
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
    Object localObject = null;
    TBSOneManager localTBSOneManager = TBSOneManager.getDefaultInstance(paramContext);
    localTBSOneManager.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
    try
    {
      paramContext = new Bundle();
      paramContext.putBoolean("is_ignore_wifi_state", true);
      paramContext.putBoolean("is_ignore_flow_control", true);
      localTBSOneManager.configure("is_ignore_update_wifi_network", Boolean.valueOf(true));
      paramContext = localTBSOneManager.loadComponentSync("file", paramContext, 5000L);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      report(1000, "initReaderEntry", paramContext);
      paramContext = localObject;
    }
    boolean bool = loadFileEngine(localTBSOneManager, paramContext);
    paramContext = new StringBuilder();
    paramContext.append("initReaderEntry,ret:");
    paramContext.append(bool);
    Log.d("ReaderEngine", paramContext.toString());
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
      localTBSOneManager.configure("is_ignore_update_wifi_network", Boolean.valueOf(true));
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
    ITbsReaderEntry localITbsReaderEntry = this.mReaderEntry;
    if (localITbsReaderEntry != null) {
      return localITbsReaderEntry.isSupportCurrentPlatform();
    }
    return false;
  }
  
  public boolean isSupportExt(int paramInt, String paramString)
  {
    ITbsReaderEntry localITbsReaderEntry = this.mReaderEntry;
    boolean bool;
    if (localITbsReaderEntry != null) {
      bool = localITbsReaderEntry.isSupportExt(paramInt, paramString);
    } else {
      bool = false;
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
    ITbsReaderEntry localITbsReaderEntry = this.mReaderEntry;
    if (localITbsReaderEntry != null) {
      localITbsReaderEntry.initSettings(paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine
 * JD-Core Version:    0.7.0.1
 */