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
  private static volatile DownloaderGetCodeClient c;
  private ConcurrentHashMap<String, List<ApkGetCodeListener>> a = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  private Map<String, Boolean> d = new ConcurrentHashMap();
  private EIPCResultCallback e = new DownloaderGetCodeClient.2(this);
  
  public static DownloaderGetCodeClient a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new DownloaderGetCodeClient();
        }
      }
      finally {}
    }
    return c;
  }
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void a(String paramString, ApkGetCodeListener paramApkGetCodeListener)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramApkGetCodeListener == null) {
        return;
      }
      List localList2 = (List)this.a.get(paramString);
      List localList1 = localList2;
      if (localList2 == null) {
        localList1 = Collections.synchronizedList(new ArrayList());
      }
      if (localList1.contains(paramApkGetCodeListener)) {
        return;
      }
      localList1.add(paramApkGetCodeListener);
      this.a.put(paramString, localList1);
    }
  }
  
  public void a(String paramString, int paramInt, ApkGetCodeListener paramApkGetCodeListener)
  {
    a(a(paramString, paramInt), paramApkGetCodeListener);
    paramApkGetCodeListener = new Bundle();
    paramApkGetCodeListener.putString("PackageName", paramString);
    paramApkGetCodeListener.putInt("VersionCode", paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" begin getApkCode ......");
    LogUtility.c("DownloaderGetCodeClient", localStringBuilder.toString());
    this.d.put(a(paramString, paramInt), Boolean.valueOf(true));
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", paramApkGetCodeListener, this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient
 * JD-Core Version:    0.7.0.1
 */