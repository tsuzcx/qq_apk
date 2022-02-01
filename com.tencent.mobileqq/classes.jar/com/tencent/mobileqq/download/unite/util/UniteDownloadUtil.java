package com.tencent.mobileqq.download.unite.util;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.download.unite.DownloadDialogFragment;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class UniteDownloadUtil
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new UniteDownloadUtil.1());
  private static ConcurrentHashMap<Long, UniteDownloadUtil.DownloadDialogListener> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static Handler a()
  {
    return jdField_a_of_type_AndroidOsHandler;
  }
  
  public static void a(DownloadInfo paramDownloadInfo, UniteDownloadUtil.DownloadDialogListener paramDownloadDialogListener)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Random localRandom = new Random();
      for (localObject = Long.valueOf(localRandom.nextLong()); jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject); localObject = Long.valueOf(localRandom.nextLong())) {}
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramDownloadDialogListener);
      DownloadDialogFragment.a(paramDownloadInfo, ((Long)localObject).longValue());
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putParcelable("downloadInfoKey", paramDownloadInfo);
    QIPCClientHelper.getInstance().callServer("UniteDownloadIPCModule", "showDialogAction", (Bundle)localObject, new UniteDownloadIPCModule.UniteDownloadIPCListenerWrapper(paramDownloadDialogListener));
  }
  
  public static void a(String paramString)
  {
    ReportHelperKt.a("0X800B538", 0, "", paramString);
  }
  
  public static void b(String paramString)
  {
    ReportHelperKt.a("0X800B539", 0, "", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.util.UniteDownloadUtil
 * JD-Core Version:    0.7.0.1
 */