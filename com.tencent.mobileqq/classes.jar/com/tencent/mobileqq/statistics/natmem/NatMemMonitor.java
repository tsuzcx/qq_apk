package com.tencent.mobileqq.statistics.natmem;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.qqperf.repoter.ResultObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class NatMemMonitor
{
  private static NatMemMonitor jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor;
  private NativeMemoryInspector jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInspector;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = true;
  
  private NatMemMonitor()
  {
    System.loadLibrary("natmem_monitor");
    this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInspector = new NativeMemoryInspector();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static NatMemMonitor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor = new NatMemMonitor();
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (new File(paramString).exists())
      {
        FileUtils.b(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("NatMem", 2, new Object[] { "delete files in ", paramString });
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("NatMem", 2, paramString.toString());
    }
  }
  
  /* Error */
  private void a(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 51	java/io/File
    //   3: dup
    //   4: invokestatic 90	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:a	()Ljava/lang/String;
    //   7: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: new 51	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aconst_null
    //   22: astore_3
    //   23: aload 4
    //   25: invokevirtual 57	java/io/File:exists	()Z
    //   28: ifne +9 -> 37
    //   31: aload 4
    //   33: invokevirtual 93	java/io/File:mkdirs	()Z
    //   36: pop
    //   37: aload_1
    //   38: invokevirtual 57	java/io/File:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_1
    //   45: invokevirtual 96	java/io/File:createNewFile	()Z
    //   48: pop
    //   49: new 98	java/io/BufferedWriter
    //   52: dup
    //   53: new 100	java/io/FileWriter
    //   56: dup
    //   57: aload_1
    //   58: iconst_1
    //   59: invokespecial 103	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   62: sipush 8192
    //   65: invokespecial 106	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   68: astore_1
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 112	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: invokevirtual 115	java/io/BufferedWriter:flush	()V
    //   81: ldc 68
    //   83: ldc 117
    //   85: invokestatic 120	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 123	java/io/BufferedWriter:close	()V
    //   96: return
    //   97: astore_1
    //   98: aload_3
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull -5 -> 96
    //   104: aload_1
    //   105: invokevirtual 123	java/io/BufferedWriter:close	()V
    //   108: return
    //   109: astore_1
    //   110: return
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 123	java/io/BufferedWriter:close	()V
    //   122: aload_2
    //   123: athrow
    //   124: astore_1
    //   125: return
    //   126: astore_1
    //   127: goto -5 -> 122
    //   130: astore_2
    //   131: goto -17 -> 114
    //   134: astore_2
    //   135: goto -35 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	NatMemMonitor
    //   0	138	1	paramString	String
    //   0	138	2	paramStringBuilder	StringBuilder
    //   22	77	3	localObject	Object
    //   10	22	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   23	37	97	java/lang/Throwable
    //   37	49	97	java/lang/Throwable
    //   49	69	97	java/lang/Throwable
    //   104	108	109	java/io/IOException
    //   23	37	111	finally
    //   37	49	111	finally
    //   49	69	111	finally
    //   92	96	124	java/io/IOException
    //   118	122	126	java/io/IOException
    //   69	88	130	finally
    //   69	88	134	java/lang/Throwable
  }
  
  private void e()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new File(NativeMemoryUtils.a());
        if (!((File)localObject1).exists()) {
          return;
        }
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          String str = localObject2.getAbsolutePath();
          if ((!str.contains(".txt")) && (!str.contains(".zip"))) {
            break label105;
          }
          FileUtils.e(localObject2.getAbsolutePath());
          break label105;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("NatMem", 2, "delete usage files");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("NatMem", 2, localException.toString());
      }
      return;
      label105:
      i += 1;
    }
  }
  
  public File a()
  {
    Object localObject1 = null;
    for (;;)
    {
      String str;
      int i;
      try
      {
        Object localObject3 = NativeMemoryUtils.b();
        str = NativeMemoryUtils.a();
        ArrayList localArrayList = new ArrayList();
        localObject3 = new File((String)localObject3);
        if (!((File)localObject3).exists()) {
          return null;
        }
        localObject3 = ((File)localObject3).listFiles();
        int j = localObject3.length;
        i = 0;
        if (i < j)
        {
          Object localObject4 = localObject3[i];
          if (localObject4.getName().contains(".zip")) {
            break label213;
          }
          localArrayList.add(localObject4.getAbsolutePath());
        }
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("NatMem", 2, localThrowable1, new Object[0]);
        return localObject1;
      }
      if (localThrowable1.size() > 0)
      {
        str = str + System.currentTimeMillis() + ".zip";
        Object localObject2;
        if (FileUtils.a(localThrowable1, str)) {
          localObject2 = new File(str);
        }
        try
        {
          boolean bool = ((File)localObject2).exists();
          if (!bool) {
            break label211;
          }
          return localObject2;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
        QLog.e("NatMem", 2, "zip fail");
        return null;
        continue;
      }
      label211:
      return null;
      label213:
      i += 1;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 17	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:jdField_a_of_type_Boolean	Z
    //   8: istore 4
    //   10: iload 4
    //   12: ifne +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: invokestatic 187	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:a	()I
    //   22: invokestatic 189	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:b	()I
    //   25: invokestatic 191	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:c	()I
    //   28: invokevirtual 195	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:nativeInitSampleRate	(III)V
    //   31: getstatic 198	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:a	[Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: arraylength
    //   39: istore_3
    //   40: iconst_0
    //   41: istore_1
    //   42: iload_1
    //   43: iload_3
    //   44: if_icmpge +19 -> 63
    //   47: aload_0
    //   48: aload 5
    //   50: iload_1
    //   51: aaload
    //   52: invokevirtual 202	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:nativeRegisterAppLib	(Ljava/lang/String;)I
    //   55: pop
    //   56: iload_1
    //   57: iconst_1
    //   58: iadd
    //   59: istore_1
    //   60: goto -18 -> 42
    //   63: getstatic 204	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:b	[Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: arraylength
    //   71: istore_3
    //   72: iconst_0
    //   73: istore_1
    //   74: iload_1
    //   75: iload_3
    //   76: if_icmpge +19 -> 95
    //   79: aload_0
    //   80: aload 5
    //   82: iload_1
    //   83: aaload
    //   84: invokevirtual 207	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:nativeIgnoreHook	(Ljava/lang/String;)I
    //   87: pop
    //   88: iload_1
    //   89: iconst_1
    //   90: iadd
    //   91: istore_1
    //   92: goto -18 -> 74
    //   95: invokestatic 209	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:b	()Z
    //   98: ifne +35 -> 133
    //   101: getstatic 211	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:c	[Ljava/lang/String;
    //   104: astore 5
    //   106: aload 5
    //   108: arraylength
    //   109: istore_3
    //   110: iload_2
    //   111: istore_1
    //   112: iload_1
    //   113: iload_3
    //   114: if_icmpge +19 -> 133
    //   117: aload_0
    //   118: aload 5
    //   120: iload_1
    //   121: aaload
    //   122: invokevirtual 207	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:nativeIgnoreHook	(Ljava/lang/String;)I
    //   125: pop
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -18 -> 112
    //   133: aload_0
    //   134: invokestatic 209	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:b	()Z
    //   137: invokevirtual 215	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:nativeRegisterSysLib	(Z)V
    //   140: aload_0
    //   141: invokevirtual 218	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:nativeStartHook	()I
    //   144: pop
    //   145: aload_0
    //   146: iconst_1
    //   147: putfield 21	com/tencent/mobileqq/statistics/natmem/NatMemMonitor:c	Z
    //   150: goto -135 -> 15
    //   153: astore 5
    //   155: aload_0
    //   156: monitorexit
    //   157: aload 5
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	NatMemMonitor
    //   41	89	1	i	int
    //   1	110	2	j	int
    //   39	76	3	k	int
    //   8	3	4	bool	boolean
    //   34	85	5	arrayOfString	String[]
    //   153	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	153	finally
    //   18	40	153	finally
    //   47	56	153	finally
    //   63	72	153	finally
    //   79	88	153	finally
    //   95	110	153	finally
    //   117	126	153	finally
    //   133	150	153	finally
  }
  
  public void b()
  {
    try
    {
      nativeClearCache();
      this.c = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    if (NativeMemoryUtils.d())
    {
      localFile = a();
      if (localFile != null)
      {
        e();
        for (;;)
        {
          try
          {
            localJSONObject1 = new JSONObject();
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("fileObj1", localFile.getAbsolutePath());
            localJSONObject3 = new JSONObject();
            localJSONObject3.put("p_id", MagnifierSDK.b());
            localJSONObject3.put("plugin", String.valueOf(137));
            localJSONObject3.put("newplugin", String.valueOf(137));
            localJSONObject1.put("fileObj", localJSONObject2);
            localJSONObject1.put("clientinfo", localJSONObject3);
            l1 = 0L;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("NatMem", 2, "report fail.", localThrowable);
            continue;
          }
          try
          {
            l2 = Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
            l1 = l2;
          }
          catch (Exception localException)
          {
            QLog.e("NatMem", 2, "uploadReportFile get uin " + 0L);
          }
        }
        ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, localJSONObject1, true, false, l1));
        if (QLog.isColorLevel()) {
          QLog.d("NatMem", 2, new Object[] { "uploadReportFile success ", localFile.getAbsolutePath() });
        }
        NativeMemoryUtils.a(System.currentTimeMillis());
        a(NativeMemoryUtils.b());
      }
    }
    while (!QLog.isColorLevel())
    {
      File localFile;
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      long l1;
      long l2;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("NatMem", 2, "no file to report");
      return;
    }
    QLog.d("NatMem", 2, "uploadReportFile failed because of interval");
  }
  
  public void d()
  {
    Object localObject2 = a().nativeGetLeakMemoryInfoList();
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList(((ArrayList)localObject2).size());
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        NativeMemoryInfo localNativeMemoryInfo = (NativeMemoryInfo)((Iterator)localObject2).next();
        if ((localNativeMemoryInfo.a()) && (!((List)localObject1).contains(localNativeMemoryInfo))) {
          ((List)localObject1).add(localNativeMemoryInfo);
        }
      }
      localObject2 = new StringBuilder(1024);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(((NativeMemoryInfo)((Iterator)localObject1).next()).toString());
      }
      a(NativeMemoryUtils.a() + "mon_" + System.currentTimeMillis() + ".txt", (StringBuilder)localObject2);
      return;
    }
    NativeMemoryUtils.a("NatMem", "no memory infos");
  }
  
  public native int nativeClearCache();
  
  public native ArrayList<NativeMemoryInfo> nativeGetLeakMemoryInfoList();
  
  public native int nativeIgnoreHook(String paramString);
  
  public native int nativeInit(int paramInt, String paramString1, String paramString2, boolean paramBoolean);
  
  public native int nativeInitLogLevel(int paramInt);
  
  public native void nativeInitSampleRate(int paramInt1, int paramInt2, int paramInt3);
  
  public native int nativeIterateMaps();
  
  public native int nativeOnDestroy();
  
  public native int nativePrintAllocation();
  
  public native int nativePrintUsage();
  
  public native int nativeRegisterAppLib(String paramString);
  
  public native boolean nativeRegisterContHandlerOnce();
  
  public native void nativeRegisterSysLib(boolean paramBoolean);
  
  public native int nativeStartHook();
  
  public native int nativeStartRecordMapInfo(int paramInt);
  
  public native int nativeStopRecordMapInfo(int paramInt);
  
  public native boolean nativeSuspendAndResumeProcess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NatMemMonitor
 * JD-Core Version:    0.7.0.1
 */