package com.tencent.open.downloadnew;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class DownloaderGetCodeClient
{
  private static volatile DownloaderGetCodeClient jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient = null;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new DownloaderGetCodeClient.2(this);
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, List<ApkGetCodeListener>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  public static DownloaderGetCodeClient a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient = new DownloaderGetCodeClient();
      }
      return jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
    }
    finally {}
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramString + "_" + paramInt;
  }
  
  private void a(String paramString, ApkGetCodeListener paramApkGetCodeListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramApkGetCodeListener == null)) {}
    List localList1;
    do
    {
      return;
      List localList2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
    } while (localList1.contains(paramApkGetCodeListener));
    localList1.add(paramApkGetCodeListener);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList1);
  }
  
  public void a(String paramString, int paramInt, ApkGetCodeListener paramApkGetCodeListener)
  {
    a(a(paramString, paramInt), paramApkGetCodeListener);
    paramApkGetCodeListener = new Bundle();
    paramApkGetCodeListener.putString("PackageName", paramString);
    paramApkGetCodeListener.putInt("VersionCode", paramInt);
    LogUtility.c("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    this.jdField_a_of_type_JavaUtilMap.put(a(paramString, paramInt), Boolean.valueOf(true));
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", paramApkGetCodeListener, this.jdField_a_of_type_EipcEIPCResultCallback);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloaderGetCodeClient.1(this, paramString, paramInt, paramApkGetCodeListener), 3000L);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ApkGetCodeListener paramApkGetCodeListener)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.b.put(a(paramString2, paramInt), paramString1);
    }
    a(paramString2, paramInt, paramApkGetCodeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient
 * JD-Core Version:    0.7.0.1
 */