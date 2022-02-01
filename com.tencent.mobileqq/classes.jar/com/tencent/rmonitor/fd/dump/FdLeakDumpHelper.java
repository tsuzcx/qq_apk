package com.tencent.rmonitor.fd.dump;

import android.text.TextUtils;
import com.tencent.rmonitor.common.network.NetworkWatcher;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.fd.FdLeakConfigHelper;
import com.tencent.rmonitor.fd.dump.dumpers.FdHeapDumper;
import com.tencent.rmonitor.fd.dump.dumpers.FdProcFdDumper;
import com.tencent.rmonitor.fd.dump.dumpers.FdStacksDumper;
import com.tencent.rmonitor.fd.dump.dumpers.FdThreadsDumper;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FdLeakDumpHelper
{
  private static final IFdLeakDumper[] a = { new FdProcFdDumper(), new FdThreadsDumper(), new FdHeapDumper(), new FdStacksDumper() };
  
  public static FdLeakDumpResult a(int paramInt, IFdLeakDumpListener paramIFdLeakDumpListener)
  {
    if (paramIFdLeakDumpListener != null) {
      paramIFdLeakDumpListener.a(paramInt);
    }
    Object localObject1 = a;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (((IFdLeakDumper)localObject2).a() == paramInt)
      {
        localObject1 = ((IFdLeakDumper)localObject2).a(a(paramInt, b()));
        break label73;
      }
      i += 1;
    }
    localObject1 = null;
    label73:
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = FdLeakDumpResult.failure(paramInt, 2);
    }
    if (paramIFdLeakDumpListener != null) {
      paramIFdLeakDumpListener.a(paramInt, (FdLeakDumpResult)localObject2);
    }
    return localObject2;
  }
  
  public static String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fd_dump_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    return new File(new File(FdLeakConfigHelper.a, "zips"), (String)localObject).getAbsolutePath();
  }
  
  private static String a(int paramInt, File paramFile)
  {
    String str;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            str = "";
          } else {
            str = "fd_stacks.txt";
          }
        }
        else {
          str = "heap.hprof";
        }
      }
      else {
        str = "threads.txt";
      }
    }
    else {
      str = "fd.txt";
    }
    return new File(paramFile, str).getAbsolutePath();
  }
  
  public static String a(List<FdLeakDumpResult> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FdLeakDumpResult localFdLeakDumpResult = (FdLeakDumpResult)paramList.next();
        if ((localFdLeakDumpResult.isSuccess()) && (!TextUtils.isEmpty(localFdLeakDumpResult.getDumpFilePath())))
        {
          if ((paramBoolean) && (localFdLeakDumpResult.getDumpType() == 3) && (!NetworkWatcher.a.b())) {
            LogUtils.b("FdLeakDumpHelper", "not wifi so don't compress hprof file");
          } else {
            localArrayList.add(localFdLeakDumpResult.getDumpFilePath());
          }
        }
        else {
          LogUtils.c("FdLeakDumpHelper", "dump result error or dump file path is empty");
        }
      }
      return b(localArrayList, true);
    }
    return null;
  }
  
  public static List<FdLeakDumpResult> a(IFdLeakDumpListener paramIFdLeakDumpListener)
  {
    ArrayList localArrayList = new ArrayList(a.length);
    IFdLeakDumper[] arrayOfIFdLeakDumper = a;
    int j = arrayOfIFdLeakDumper.length;
    int i = 0;
    while (i < j)
    {
      IFdLeakDumper localIFdLeakDumper = arrayOfIFdLeakDumper[i];
      if (localIFdLeakDumper.b())
      {
        if (paramIFdLeakDumpListener != null) {
          paramIFdLeakDumpListener.a(localIFdLeakDumper.a());
        }
        FdLeakDumpResult localFdLeakDumpResult = localIFdLeakDumper.a(a(localIFdLeakDumper.a(), b()));
        if (paramIFdLeakDumpListener != null) {
          paramIFdLeakDumpListener.a(localIFdLeakDumper.a(), localFdLeakDumpResult);
        }
        localArrayList.add(localFdLeakDumpResult);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static File b()
  {
    return new File(FdLeakConfigHelper.a, "dump_root");
  }
  
  private static String b(List<String> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      String str = a();
      File localFile = new File(str);
      if ((localFile.exists()) && (localFile.isFile())) {
        FileUtil.a(localFile);
      }
      if (FileUtil.a(paramList, str, false))
      {
        if (paramBoolean)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            FileUtil.a(new File((String)paramList.next()));
          }
        }
        return str;
      }
    }
    return null;
  }
  
  public static void c()
  {
    FileUtil.a(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.FdLeakDumpHelper
 * JD-Core Version:    0.7.0.1
 */