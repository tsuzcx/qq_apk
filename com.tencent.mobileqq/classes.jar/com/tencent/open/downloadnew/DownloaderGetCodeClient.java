package com.tencent.open.downloadnew;

import alph;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResultCallback;

public class DownloaderGetCodeClient
{
  private static DownloaderGetCodeClient jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
  private ApkGetCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new alph(this);
  
  public static DownloaderGetCodeClient a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient == null) {}
    try
    {
      jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient = new DownloaderGetCodeClient();
      return jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
    }
    finally {}
  }
  
  public void a(ApkGetCodeListener paramApkGetCodeListener)
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener = paramApkGetCodeListener;
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("PackageName", paramString);
    localBundle.putInt("VersionCode", paramInt);
    LogUtility.c("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", localBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient
 * JD-Core Version:    0.7.0.1
 */