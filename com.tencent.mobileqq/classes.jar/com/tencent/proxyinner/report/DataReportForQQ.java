package com.tencent.proxyinner.report;

import android.os.Bundle;
import android.util.Log;
import com.tencent.proxyinner.log.XLog;
import java.util.List;

public class DataReportForQQ
  extends DataReport
{
  public static final int SDK_DATA_VERSION = 2;
  private static final String TAG = "ODSDK|DataReport";
  
  public DataReportForQQ(String paramString)
  {
    this.mPluginID = paramString;
  }
  
  private void reportInHost(Bundle paramBundle)
  {
    if (this.mEventList != null)
    {
      int i = 0;
      while (i < this.mEventList.size())
      {
        ((DataReport.Event)this.mEventList.get(i)).onDataReport(paramBundle);
        i += 1;
      }
    }
  }
  
  public void reportBootComplete(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4)
  {
    for (;;)
    {
      try
      {
        Log.i("ODSDK|DataReport", "reportBootComplete, retry times " + paramInt4);
        this.bootCompleteTime = System.currentTimeMillis();
        Bundle localBundle = new Bundle();
        try
        {
          localBundle.putString("op_name", "boot");
          localBundle.putInt("op_in", paramInt2);
          localBundle.putString("sdkversion", String.valueOf(paramInt1));
          localBundle.putInt("op_result", paramInt3);
          localBundle.putString("d1", paramString2);
          if (!this.mHasLocalPlugin) {
            continue;
          }
          paramString2 = "1";
          localBundle.putString("d2", paramString2);
          localBundle.putString("d3", paramString1);
          localBundle.putString("d4", String.valueOf(paramInt4));
          localBundle.putString("roomtype", String.valueOf(2));
          localBundle.putString("timeconsume", String.valueOf(this.bootCompleteTime - this.bootTimeStart));
          reportInHost(localBundle);
        }
        catch (Exception paramString1)
        {
          XLog.e("ODSDK|DataReport", "reportBootComplete Exception");
          continue;
        }
        return;
      }
      finally {}
      paramString2 = "0";
    }
  }
  
  public void reportBootFail(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4)
  {
    for (;;)
    {
      try
      {
        Log.i("ODSDK|DataReport", "reportBootFail, retry times " + paramInt4);
        this.bootCompleteTime = System.currentTimeMillis();
        Bundle localBundle = new Bundle();
        try
        {
          localBundle.putString("op_name", "boot_fail");
          localBundle.putInt("op_in", paramInt2);
          localBundle.putString("sdkversion", String.valueOf(paramInt1));
          localBundle.putInt("op_result", paramInt3);
          localBundle.putString("d1", paramString2);
          if (!this.mHasLocalPlugin) {
            continue;
          }
          paramString2 = "1";
          localBundle.putString("d2", paramString2);
          localBundle.putString("d3", paramString1);
          localBundle.putString("d4", String.valueOf(paramInt4));
          localBundle.putString("roomtype", String.valueOf(2));
          localBundle.putString("timeconsume", String.valueOf(this.bootCompleteTime - this.bootTimeStart));
          reportInHost(localBundle);
        }
        catch (Exception paramString1)
        {
          XLog.e("ODSDK|DataReport", "reportBootComplete Exception");
          continue;
        }
        return;
      }
      finally {}
      paramString2 = "0";
    }
  }
  
  public void reportBootStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        this.mHasLocalPlugin = paramBoolean1;
        this.bootTimeStart = System.currentTimeMillis();
        Bundle localBundle = new Bundle();
        localBundle.putString("op_name", "run_now_plugin");
        if (!paramBoolean1) {
          continue;
        }
        str = "1";
        localBundle.putString("d1", str);
        localBundle.putString("d2", String.valueOf(2));
        if (!paramBoolean2) {
          continue;
        }
        str = "0";
        localBundle.putString("d3", str);
        reportInHost(localBundle);
      }
      catch (Exception localException)
      {
        String str;
        XLog.e("ODSDK|DataReport", "reportBootStart Exception");
        continue;
      }
      finally {}
      return;
      str = "0";
      continue;
      str = "1";
    }
  }
  
  public void reportCancelRun(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    for (;;)
    {
      Bundle localBundle;
      try
      {
        Log.i("ODSDK|DataReport", "reportCancelRun");
        this.cancelTime = System.currentTimeMillis();
        localBundle = new Bundle();
      }
      finally {}
      try
      {
        localBundle.putString("op_name", "cancel_run");
        localBundle.putInt("op_in", paramInt2);
        localBundle.putString("sdkversion", String.valueOf(paramInt1));
        localBundle.putInt("op_result", paramInt5);
        localBundle.putString("d1", String.valueOf(paramInt4));
        if (!this.mHasLocalPlugin) {
          continue;
        }
        str = "1";
        localBundle.putString("d2", str);
        localBundle.putString("d3", String.valueOf(paramInt3));
        localBundle.putString("timeconsume", String.valueOf(this.cancelTime - this.bootTimeStart));
        reportInHost(localBundle);
      }
      catch (Exception localException)
      {
        continue;
      }
      return;
      String str = "0";
    }
  }
  
  public void reportCheckVersionComplete(int paramInt, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.bootTimeStart = System.currentTimeMillis();
        Bundle localBundle = new Bundle();
        localBundle.putString("op_name", "check_version_complete");
        localBundle.putString("d1", String.valueOf(paramInt));
        localBundle.putString("d2", String.valueOf(paramString));
        if (!paramBoolean) {
          continue;
        }
        paramString = "1";
        localBundle.putString("d3", paramString);
        reportInHost(localBundle);
      }
      catch (Exception paramString)
      {
        XLog.e("ODSDK|DataReport", "reportCheckVersionComplete Exception");
        continue;
      }
      finally {}
      return;
      paramString = "2";
    }
  }
  
  public void reportCheckVersionStart(String paramString)
  {
    try
    {
      this.bootTimeStart = System.currentTimeMillis();
      Bundle localBundle = new Bundle();
      localBundle.putString("op_name", "check_version_start");
      localBundle.putString("d1", paramString);
      reportInHost(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        XLog.e("ODSDK|DataReport", "reportBootStart Exception");
      }
    }
    finally {}
  }
  
  public void reportConfigCheck(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    try
    {
      XLog.i("ODSDK|DataReport", "reportConfigCheck");
      Bundle localBundle = new Bundle();
      localBundle.putString("op_name", "config_check");
      localBundle.putInt("op_result", paramInt1);
      localBundle.putString("d1", paramString);
      localBundle.putString("d2", String.valueOf(paramInt2));
      localBundle.putString("d3", String.valueOf(paramInt3));
      localBundle.putString("d4", String.valueOf(paramLong2));
      localBundle.putString("timeconsume", String.valueOf(paramLong1));
      reportInHost(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        XLog.e("ODSDK|DataReport", "reportLoadComplete Exception");
      }
    }
    finally {}
  }
  
  public void reportDex2Oat(int paramInt1, int paramInt2, long paramLong)
  {
    Log.i("ODSDK|DataReport", "reportDex2Oat");
    this.loadStartTime = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("op_name", "dex2oat");
      localBundle.putInt("op_in", paramInt2);
      localBundle.putString("sdkversion", String.valueOf(paramInt1));
      localBundle.putString("timeconsume", String.valueOf(paramLong));
      reportInHost(localBundle);
      return;
    }
    catch (Exception localException)
    {
      XLog.e("ODSDK|DataReport", "reportDex2Oat Exception");
    }
  }
  
  /* Error */
  public void reportDownloadComplete(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, int paramInt6, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 193
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 196	com/tencent/proxyinner/report/DataReportForQQ:downloadCompleteTime	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore 8
    //   26: aload 8
    //   28: ldc 82
    //   30: ldc 198
    //   32: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload 8
    //   37: ldc 90
    //   39: iload 7
    //   41: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   44: aload 8
    //   46: ldc 104
    //   48: iload_1
    //   49: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   52: aload 8
    //   54: ldc 106
    //   56: iload 6
    //   58: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   61: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload 8
    //   66: ldc 114
    //   68: iload_3
    //   69: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   72: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 8
    //   77: ldc 116
    //   79: iload 5
    //   81: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 8
    //   89: ldc 118
    //   91: aload 4
    //   93: invokestatic 165	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 8
    //   101: ldc 96
    //   103: iload_2
    //   104: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   107: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 8
    //   112: ldc 122
    //   114: aload_0
    //   115: getfield 196	com/tencent/proxyinner/report/DataReportForQQ:downloadCompleteTime	J
    //   118: aload_0
    //   119: getfield 201	com/tencent/proxyinner/report/DataReportForQQ:downloadStartTime	J
    //   122: lsub
    //   123: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   126: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload 8
    //   132: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: astore 4
    //   140: ldc 11
    //   142: ldc 203
    //   144: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: goto -13 -> 135
    //   151: astore 4
    //   153: aload_0
    //   154: monitorexit
    //   155: aload 4
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	DataReportForQQ
    //   0	158	1	paramInt1	int
    //   0	158	2	paramInt2	int
    //   0	158	3	paramInt3	int
    //   0	158	4	paramString1	String
    //   0	158	5	paramInt4	int
    //   0	158	6	paramInt5	int
    //   0	158	7	paramInt6	int
    //   0	158	8	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   26	135	138	java/lang/Exception
    //   2	26	151	finally
    //   26	135	151	finally
    //   140	148	151	finally
  }
  
  /* Error */
  public void reportDownloadFail(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, int paramInt6, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 193
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 196	com/tencent/proxyinner/report/DataReportForQQ:downloadCompleteTime	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore 8
    //   26: aload 8
    //   28: ldc 82
    //   30: ldc 206
    //   32: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload 8
    //   37: ldc 90
    //   39: iload 7
    //   41: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   44: aload 8
    //   46: ldc 104
    //   48: iload_1
    //   49: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   52: aload 8
    //   54: ldc 106
    //   56: iload 6
    //   58: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   61: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload 8
    //   66: ldc 114
    //   68: iload_3
    //   69: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   72: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 8
    //   77: ldc 116
    //   79: iload 5
    //   81: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 8
    //   89: ldc 118
    //   91: aload 4
    //   93: invokestatic 165	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 8
    //   101: ldc 96
    //   103: iload_2
    //   104: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   107: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 8
    //   112: ldc 122
    //   114: aload_0
    //   115: getfield 196	com/tencent/proxyinner/report/DataReportForQQ:downloadCompleteTime	J
    //   118: aload_0
    //   119: getfield 201	com/tencent/proxyinner/report/DataReportForQQ:downloadStartTime	J
    //   122: lsub
    //   123: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   126: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload 8
    //   132: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: astore 4
    //   140: ldc 11
    //   142: ldc 203
    //   144: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: goto -13 -> 135
    //   151: astore 4
    //   153: aload_0
    //   154: monitorexit
    //   155: aload 4
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	DataReportForQQ
    //   0	158	1	paramInt1	int
    //   0	158	2	paramInt2	int
    //   0	158	3	paramInt3	int
    //   0	158	4	paramString1	String
    //   0	158	5	paramInt4	int
    //   0	158	6	paramInt5	int
    //   0	158	7	paramInt6	int
    //   0	158	8	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   26	135	138	java/lang/Exception
    //   2	26	151	finally
    //   26	135	151	finally
    //   140	148	151	finally
  }
  
  /* Error */
  public void reportDownloadStart(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 209
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 201	com/tencent/proxyinner/report/DataReportForQQ:downloadStartTime	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 82
    //   30: ldc 211
    //   32: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload 5
    //   37: ldc 90
    //   39: iload_3
    //   40: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   43: aload 5
    //   45: ldc 106
    //   47: iload_2
    //   48: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   51: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload 5
    //   56: ldc 114
    //   58: aload 4
    //   60: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload 5
    //   65: ldc 96
    //   67: iload_1
    //   68: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: aload 5
    //   77: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore 4
    //   85: ldc 11
    //   87: ldc 213
    //   89: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: goto -13 -> 80
    //   96: astore 4
    //   98: aload_0
    //   99: monitorexit
    //   100: aload 4
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	DataReportForQQ
    //   0	103	1	paramInt1	int
    //   0	103	2	paramInt2	int
    //   0	103	3	paramInt3	int
    //   0	103	4	paramString	String
    //   24	52	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   26	80	83	java/lang/Exception
    //   2	26	96	finally
    //   26	80	96	finally
    //   85	93	96	finally
  }
  
  /* Error */
  public void reportInstallComplete(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 215
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 218	com/tencent/proxyinner/report/DataReportForQQ:installComplete	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 82
    //   30: ldc 220
    //   32: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload 5
    //   37: ldc 90
    //   39: iload_2
    //   40: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   43: aload 5
    //   45: ldc 106
    //   47: aload 4
    //   49: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload 5
    //   54: ldc 104
    //   56: iload_3
    //   57: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: aload 5
    //   62: ldc 96
    //   64: iload_1
    //   65: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 5
    //   73: ldc 122
    //   75: aload_0
    //   76: getfield 218	com/tencent/proxyinner/report/DataReportForQQ:installComplete	J
    //   79: aload_0
    //   80: getfield 223	com/tencent/proxyinner/report/DataReportForQQ:installStart	J
    //   83: lsub
    //   84: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: aload 5
    //   93: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: astore 4
    //   101: ldc 11
    //   103: ldc 225
    //   105: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   108: pop
    //   109: goto -13 -> 96
    //   112: astore 4
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 4
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	DataReportForQQ
    //   0	119	1	paramInt1	int
    //   0	119	2	paramInt2	int
    //   0	119	3	paramInt3	int
    //   0	119	4	paramString	String
    //   24	68	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   26	96	99	java/lang/Exception
    //   2	26	112	finally
    //   26	96	112	finally
    //   101	109	112	finally
  }
  
  /* Error */
  public void reportInstallStart(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 228
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 223	com/tencent/proxyinner/report/DataReportForQQ:installStart	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: ldc 82
    //   30: ldc 230
    //   32: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload 5
    //   37: ldc 90
    //   39: iload_2
    //   40: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   43: aload 5
    //   45: ldc 106
    //   47: aload_3
    //   48: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload 5
    //   53: ldc 114
    //   55: aload 4
    //   57: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 5
    //   62: ldc 96
    //   64: iload_1
    //   65: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload 5
    //   74: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_3
    //   81: ldc 11
    //   83: ldc 232
    //   85: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   88: pop
    //   89: goto -12 -> 77
    //   92: astore_3
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_3
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	DataReportForQQ
    //   0	97	1	paramInt1	int
    //   0	97	2	paramInt2	int
    //   0	97	3	paramString1	String
    //   0	97	4	paramString2	String
    //   24	49	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   26	77	80	java/lang/Exception
    //   2	26	92	finally
    //   26	77	92	finally
    //   81	89	92	finally
  }
  
  public void reportLoadComplete(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    try
    {
      Log.i("ODSDK|DataReport", "reportLoadComplete");
      this.loadCompleteTime = System.currentTimeMillis();
      Bundle localBundle = new Bundle();
      localBundle.putString("op_name", "load_complete");
      localBundle.putInt("op_in", paramInt2);
      localBundle.putString("sdkversion", String.valueOf(paramInt1));
      localBundle.putInt("op_result", paramInt3);
      localBundle.putString("d1", paramString);
      localBundle.putString("d2", String.valueOf(paramInt4));
      localBundle.putString("timeconsume", String.valueOf(this.loadCompleteTime - this.loadStartTime));
      reportInHost(localBundle);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        XLog.e("ODSDK|DataReport", "reportLoadComplete Exception");
      }
    }
    finally {}
  }
  
  /* Error */
  public void reportLoadDirect(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 243
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 186	com/tencent/proxyinner/report/DataReportForQQ:loadStartTime	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc 82
    //   28: ldc 245
    //   30: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_3
    //   34: ldc 90
    //   36: iload_2
    //   37: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   40: aload_3
    //   41: ldc 96
    //   43: iload_1
    //   44: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   47: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: aload_3
    //   52: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_3
    //   59: ldc 11
    //   61: ldc 247
    //   63: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: goto -12 -> 55
    //   70: astore_3
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	DataReportForQQ
    //   0	75	1	paramInt1	int
    //   0	75	2	paramInt2	int
    //   24	28	3	localBundle	Bundle
    //   58	1	3	localException	Exception
    //   70	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	55	58	java/lang/Exception
    //   2	25	70	finally
    //   25	55	70	finally
    //   59	67	70	finally
  }
  
  /* Error */
  public void reportLoadStart(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 249
    //   6: invokestatic 67	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   14: putfield 186	com/tencent/proxyinner/report/DataReportForQQ:loadStartTime	J
    //   17: new 79	android/os/Bundle
    //   20: dup
    //   21: invokespecial 80	android/os/Bundle:<init>	()V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc 82
    //   28: ldc 251
    //   30: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_3
    //   34: ldc 90
    //   36: iload_2
    //   37: invokevirtual 94	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   40: aload_3
    //   41: ldc 96
    //   43: iload_1
    //   44: invokestatic 102	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   47: invokevirtual 88	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: aload_3
    //   52: invokespecial 130	com/tencent/proxyinner/report/DataReportForQQ:reportInHost	(Landroid/os/Bundle;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_3
    //   59: ldc 11
    //   61: ldc 253
    //   63: invokestatic 139	com/tencent/proxyinner/log/XLog:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: goto -12 -> 55
    //   70: astore_3
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	DataReportForQQ
    //   0	75	1	paramInt1	int
    //   0	75	2	paramInt2	int
    //   24	28	3	localBundle	Bundle
    //   58	1	3	localException	Exception
    //   70	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	55	58	java/lang/Exception
    //   2	25	70	finally
    //   25	55	70	finally
    //   59	67	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.report.DataReportForQQ
 * JD-Core Version:    0.7.0.1
 */