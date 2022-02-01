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
    if (jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor == null) {
          jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor = new NatMemMonitor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNatMemMonitor;
  }
  
  private void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!new File(paramString).exists()) {
        return;
      }
      FileUtils.deleteFilesInDirectory(paramString);
      if (QLog.isColorLevel())
      {
        QLog.d("NatMem", 2, new Object[] { "delete files in ", paramString });
        return;
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
    //   4: invokestatic 91	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:a	()Ljava/lang/String;
    //   7: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 51	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore_3
    //   26: aload 5
    //   28: invokevirtual 57	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 5
    //   36: invokevirtual 94	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 57	java/io/File:exists	()Z
    //   44: ifne +8 -> 52
    //   47: aload_1
    //   48: invokevirtual 97	java/io/File:createNewFile	()Z
    //   51: pop
    //   52: new 99	java/io/BufferedWriter
    //   55: dup
    //   56: new 101	java/io/FileWriter
    //   59: dup
    //   60: aload_1
    //   61: iconst_1
    //   62: invokespecial 104	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   65: sipush 8192
    //   68: invokespecial 107	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 113	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 116	java/io/BufferedWriter:flush	()V
    //   84: ldc 69
    //   86: ldc 118
    //   88: invokestatic 121	com/tencent/mobileqq/statistics/natmem/NativeMemoryUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 124	java/io/BufferedWriter:close	()V
    //   95: return
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: aload_3
    //   100: astore_1
    //   101: goto +9 -> 110
    //   104: goto +16 -> 120
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 124	java/io/BufferedWriter:close	()V
    //   118: aload_1
    //   119: athrow
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 124	java/io/BufferedWriter:close	()V
    //   128: return
    //   129: astore_1
    //   130: aload 4
    //   132: astore_1
    //   133: goto -13 -> 120
    //   136: astore_2
    //   137: goto -33 -> 104
    //   140: astore_1
    //   141: return
    //   142: astore_2
    //   143: goto -25 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	NatMemMonitor
    //   0	146	1	paramString	String
    //   0	146	2	paramStringBuilder	StringBuilder
    //   25	1	3	localObject1	Object
    //   96	13	3	localObject2	Object
    //   22	109	4	localObject3	Object
    //   10	25	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   72	91	96	finally
    //   26	40	107	finally
    //   40	52	107	finally
    //   52	72	107	finally
    //   26	40	129	java/lang/Throwable
    //   40	52	129	java/lang/Throwable
    //   52	72	129	java/lang/Throwable
    //   72	91	136	java/lang/Throwable
    //   91	95	140	java/io/IOException
    //   124	128	140	java/io/IOException
    //   114	118	142	java/io/IOException
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
          FileUtils.deleteFile(localObject2.getAbsolutePath());
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
    Object localObject2 = null;
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = NativeMemoryUtils.b();
        String str = NativeMemoryUtils.a();
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
            break label225;
          }
          localArrayList.add(localObject4.getAbsolutePath());
          break label225;
        }
        if (localArrayList.size() > 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          ((StringBuilder)localObject1).append(".zip");
          localObject1 = ((StringBuilder)localObject1).toString();
          if (FileUtils.zipFiles(localArrayList, (String)localObject1))
          {
            localObject1 = new File((String)localObject1);
            try
            {
              boolean bool = ((File)localObject1).exists();
              if (!bool) {
                return null;
              }
              return localObject1;
            }
            catch (Throwable localThrowable1) {}
          }
          else
          {
            QLog.e("NatMem", 2, "zip fail");
            return null;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localObject2;
        QLog.e("NatMem", 2, localThrowable2, new Object[0]);
      }
      return localObject1;
      label225:
      i += 1;
    }
  }
  
  public void a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {
        return;
      }
      nativeInitSampleRate(NativeMemoryUtils.a(), NativeMemoryUtils.b(), NativeMemoryUtils.c());
      Object localObject1 = NativeMemoryUtils.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        nativeRegisterAppLib(localObject1[i]);
        i += 1;
      }
      localObject1 = NativeMemoryUtils.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        nativeIgnoreHook((String)((Iterator)localObject1).next());
      }
      if (!NativeMemoryUtils.b())
      {
        localObject1 = NativeMemoryUtils.b.iterator();
        while (((Iterator)localObject1).hasNext()) {
          nativeIgnoreHook((String)((Iterator)localObject1).next());
        }
      }
      nativeRegisterSysLib(NativeMemoryUtils.b());
      nativeStartHook();
      this.c = true;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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
      File localFile = a();
      if (localFile != null)
      {
        e();
        for (;;)
        {
          try
          {
            localJSONObject1 = new JSONObject();
            localObject = new JSONObject();
            ((JSONObject)localObject).put("fileObj1", localFile.getAbsolutePath());
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("p_id", MagnifierSDK.b());
            localJSONObject2.put("plugin", String.valueOf(137));
            localJSONObject2.put("newplugin", String.valueOf(137));
            localJSONObject1.put("fileObj", localObject);
            localJSONObject1.put("clientinfo", localJSONObject2);
            l1 = 0L;
          }
          catch (Throwable localThrowable)
          {
            JSONObject localJSONObject1;
            Object localObject;
            long l1;
            long l2;
            QLog.e("NatMem", 2, "report fail.", localThrowable);
          }
          try
          {
            l2 = Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
            l1 = l2;
          }
          catch (Exception localException)
          {
            continue;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uploadReportFile get uin ");
          ((StringBuilder)localObject).append(0L);
          QLog.e("NatMem", 2, ((StringBuilder)localObject).toString());
          continue;
          ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, localJSONObject1, true, false, l1));
          if (!QLog.isColorLevel()) {
            break label252;
          }
          QLog.d("NatMem", 2, new Object[] { "uploadReportFile success ", localFile.getAbsolutePath() });
          break label252;
        }
        label252:
        NativeMemoryUtils.a(System.currentTimeMillis());
        a(NativeMemoryUtils.b());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NatMem", 2, "no file to report");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("NatMem", 2, "uploadReportFile failed because of interval");
    }
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(NativeMemoryUtils.a());
      ((StringBuilder)localObject1).append("mon_");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(".txt");
      a(((StringBuilder)localObject1).toString(), (StringBuilder)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NatMemMonitor
 * JD-Core Version:    0.7.0.1
 */