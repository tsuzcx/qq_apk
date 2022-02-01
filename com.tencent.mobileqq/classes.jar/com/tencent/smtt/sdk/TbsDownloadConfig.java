package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TbsDownloadConfig
{
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400L;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  private static TbsDownloadConfig a;
  private Context b;
  public SharedPreferences mPreferences;
  public Map<String, Object> mSyncMap = new HashMap();
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = a;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new TbsDownloadConfig(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.mSyncMap.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void commit()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 83 1 0
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 46	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   16: invokeinterface 95 1 0
    //   21: invokeinterface 101 1 0
    //   26: astore_2
    //   27: aload_2
    //   28: invokeinterface 106 1 0
    //   33: ifeq +157 -> 190
    //   36: aload_2
    //   37: invokeinterface 110 1 0
    //   42: checkcast 112	java/lang/String
    //   45: astore_3
    //   46: aload_0
    //   47: getfield 46	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   50: aload_3
    //   51: invokeinterface 116 2 0
    //   56: astore 4
    //   58: aload 4
    //   60: instanceof 112
    //   63: ifeq +19 -> 82
    //   66: aload_1
    //   67: aload_3
    //   68: aload 4
    //   70: checkcast 112	java/lang/String
    //   73: invokeinterface 120 3 0
    //   78: pop
    //   79: goto -52 -> 27
    //   82: aload 4
    //   84: instanceof 122
    //   87: ifeq +22 -> 109
    //   90: aload_1
    //   91: aload_3
    //   92: aload 4
    //   94: checkcast 122	java/lang/Boolean
    //   97: invokevirtual 125	java/lang/Boolean:booleanValue	()Z
    //   100: invokeinterface 129 3 0
    //   105: pop
    //   106: goto -79 -> 27
    //   109: aload 4
    //   111: instanceof 131
    //   114: ifeq +22 -> 136
    //   117: aload_1
    //   118: aload_3
    //   119: aload 4
    //   121: checkcast 131	java/lang/Long
    //   124: invokevirtual 135	java/lang/Long:longValue	()J
    //   127: invokeinterface 139 4 0
    //   132: pop
    //   133: goto -106 -> 27
    //   136: aload 4
    //   138: instanceof 141
    //   141: ifeq +22 -> 163
    //   144: aload_1
    //   145: aload_3
    //   146: aload 4
    //   148: checkcast 141	java/lang/Integer
    //   151: invokevirtual 145	java/lang/Integer:intValue	()I
    //   154: invokeinterface 149 3 0
    //   159: pop
    //   160: goto -133 -> 27
    //   163: aload 4
    //   165: instanceof 151
    //   168: ifeq -141 -> 27
    //   171: aload_1
    //   172: aload_3
    //   173: aload 4
    //   175: checkcast 151	java/lang/Float
    //   178: invokevirtual 155	java/lang/Float:floatValue	()F
    //   181: invokeinterface 159 3 0
    //   186: pop
    //   187: goto -160 -> 27
    //   190: aload_1
    //   191: invokeinterface 91 1 0
    //   196: pop
    //   197: aload_0
    //   198: getfield 46	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   201: invokeinterface 77 1 0
    //   206: goto +12 -> 218
    //   209: astore_1
    //   210: goto +11 -> 221
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   218: aload_0
    //   219: monitorexit
    //   220: return
    //   221: aload_0
    //   222: monitorexit
    //   223: goto +5 -> 228
    //   226: aload_1
    //   227: athrow
    //   228: goto -2 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	TbsDownloadConfig
    //   11	180	1	localEditor	SharedPreferences.Editor
    //   209	1	1	localObject1	Object
    //   213	14	1	localException	Exception
    //   26	11	2	localIterator	java.util.Iterator
    //   45	128	3	str	String
    //   56	118	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	209	finally
    //   27	79	209	finally
    //   82	106	209	finally
    //   109	133	209	finally
    //   136	160	209	finally
    //   163	187	209	finally
    //   190	206	209	finally
    //   214	218	209	finally
    //   2	27	213	java/lang/Exception
    //   27	79	213	java/lang/Exception
    //   82	106	213	java/lang/Exception
    //   109	133	213	java/lang/Exception
    //   136	160	213	java/lang/Exception
    //   163	187	213	java/lang/Exception
    //   190	206	213	java/lang/Exception
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int j = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int i = j;
      if (j == 0) {
        i = 100;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDownloadInterruptCode()
  {
    try
    {
      bool = this.mPreferences.contains("tbs_download_interrupt_code");
      if (bool) {}
    }
    finally
    {
      boolean bool;
      int i;
      label83:
      int j;
      for (;;)
      {
        label161:
        throw localObject;
      }
    }
    try
    {
      if (!new File(new File(this.b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists())
      {
        i = -97;
      }
      else
      {
        bool = this.mPreferences.contains("tbs_needdownload");
        if (!bool) {
          i = -96;
        } else {
          i = -101;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
    i = -95;
    break label161;
    i = this.mPreferences.getInt("tbs_download_interrupt_code", -99);
    if (i != -119)
    {
      j = i;
      if (i != -121) {}
    }
    else
    {
      j = this.mPreferences.getInt("tbs_download_interrupt_code_reason", -119);
    }
    i = j;
    if (System.currentTimeMillis() - this.mPreferences.getLong("tbs_download_interrupt_time", 0L) > 86400000L) {
      i = j - 98000;
    }
    if ((this.b != null) && ("com.tencent.mobileqq".equals(this.b.getApplicationInfo().packageName)))
    {
      bool = "CN".equals(Locale.getDefault().getCountry());
      if (bool) {}
    }
    for (i = -320;; i = i * 1000 + j)
    {
      return i;
      j = this.mPreferences.getInt("tbs_install_interrupt_code", -1);
    }
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int j = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int i = j;
      if (j == 0) {
        i = 20;
      }
      long l = i * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDownloadMinFreeSpace()
  {
    try
    {
      int j = this.mPreferences.getInt("tbs_download_min_free_space", 0);
      int i = j;
      if (j == 0) {
        i = 0;
      }
      long l = i * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l2 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 1200000L;
      }
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int j = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int i = j;
      if (j == 0) {
        i = 3;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getRetryInterval()
  {
    try
    {
      if (TbsDownloader.getRetryIntervalInSeconds() >= 0L)
      {
        l = TbsDownloader.getRetryIntervalInSeconds();
        return l;
      }
      long l = this.mPreferences.getLong("retry_interval", 86400L);
      return l;
    }
    finally {}
  }
  
  /* Error */
  public boolean getTbsCoreLoadRenameFileLockEnable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 56	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 267
    //   11: iconst_1
    //   12: invokeinterface 271 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: istore_1
    //   20: goto +8 -> 28
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: astore_3
    //   33: goto -5 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	TbsDownloadConfig
    //   3	28	1	bool1	boolean
    //   17	2	2	bool2	boolean
    //   23	4	3	localObject	Object
    //   32	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	23	finally
    //   4	18	32	java/lang/Exception
  }
  
  /* Error */
  public boolean getTbsCoreLoadRenameFileLockWaitEnable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 56	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc_w 274
    //   11: iconst_1
    //   12: invokeinterface 271 3 0
    //   17: istore_2
    //   18: iload_2
    //   19: istore_1
    //   20: goto +8 -> 28
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: astore_3
    //   33: goto -5 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	TbsDownloadConfig
    //   3	28	1	bool1	boolean
    //   17	2	2	bool2	boolean
    //   23	4	3	localObject	Object
    //   32	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   4	18	23	finally
    //   4	18	32	java/lang/Exception
  }
  
  public boolean isOverSea()
  {
    try
    {
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setDownloadInterruptCode(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 83 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc 174
    //   15: iload_1
    //   16: invokeinterface 149 3 0
    //   21: pop
    //   22: aload_2
    //   23: ldc 203
    //   25: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   28: invokeinterface 139 4 0
    //   33: pop
    //   34: aload_2
    //   35: invokeinterface 91 1 0
    //   40: pop
    //   41: goto +8 -> 49
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_2
    //   53: goto -4 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	TbsDownloadConfig
    //   0	56	1	paramInt	int
    //   11	24	2	localEditor	SharedPreferences.Editor
    //   44	4	2	localObject	Object
    //   52	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
    //   2	41	52	java/lang/Exception
  }
  
  public void setInstallInterruptCode(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putInt("tbs_install_interrupt_code", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void setTbsCoreLoadRenameFileLockEnable(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 83 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 267
    //   16: iload_1
    //   17: invokeinterface 129 3 0
    //   22: pop
    //   23: aload_2
    //   24: invokeinterface 91 1 0
    //   29: pop
    //   30: goto +8 -> 38
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_2
    //   42: goto -4 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	TbsDownloadConfig
    //   0	45	1	paramBoolean	boolean
    //   11	13	2	localEditor	SharedPreferences.Editor
    //   33	4	2	localObject	Object
    //   41	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   2	30	41	java/lang/Exception
  }
  
  /* Error */
  public void setTbsCoreLoadRenameFileLockWaitEnable(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 83 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 274
    //   16: iload_1
    //   17: invokeinterface 129 3 0
    //   22: pop
    //   23: aload_2
    //   24: invokeinterface 91 1 0
    //   29: pop
    //   30: goto +8 -> 38
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_2
    //   42: goto -4 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	TbsDownloadConfig
    //   0	45	1	paramBoolean	boolean
    //   11	13	2	localEditor	SharedPreferences.Editor
    //   33	4	2	localObject	Object
    //   41	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	33	finally
    //   2	30	41	java/lang/Exception
  }
  
  public void uploadDownloadInterruptCodeIfNeeded(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      boolean bool;
      label112:
      TbsLogReport.TbsLogInfo localTbsLogInfo;
      StringBuilder localStringBuilder;
      try
      {
        if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName))
        {
          j = 1;
          bool = this.mPreferences.contains("tbs_download_interrupt_code");
          if (bool) {}
        }
      }
      finally {}
    }
    catch (Throwable paramContext)
    {
      break label225;
    }
    try
    {
      if (!new File(new File(this.b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists())
      {
        i = -97;
      }
      else
      {
        bool = this.mPreferences.contains("tbs_needdownload");
        if (!bool) {
          i = -96;
        } else {
          i = -101;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label112;
      if (((i <= -302) && (i >= -316)) || ((i <= -318) && (i >= -322))) {
        break label149;
      }
      j = 0;
      break label149;
    }
    i = -95;
    break label149;
    i = this.mPreferences.getInt("tbs_download_interrupt_code", -99);
    if ((i <= -206) && (i >= -219))
    {
      label149:
      if (j != 0)
      {
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        localTbsLogInfo.setErrorCode(128);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ");
        localStringBuilder.append(i);
        localTbsLogInfo.setFailDetail(localStringBuilder.toString());
        TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
      }
      label225:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadConfig
 * JD-Core Version:    0.7.0.1
 */