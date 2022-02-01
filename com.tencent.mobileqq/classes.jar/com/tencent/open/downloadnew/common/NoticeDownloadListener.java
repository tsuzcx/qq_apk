package com.tencent.open.downloadnew.common;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.Iterator;
import java.util.List;

public class NoticeDownloadListener
  implements DownloadListener
{
  protected static NoticeDownloadListener b;
  protected NoticeUpdateHandler a;
  
  public static NoticeDownloadListener a()
  {
    try
    {
      if (b == null) {
        b = new NoticeDownloadListener();
      }
      NoticeDownloadListener localNoticeDownloadListener = b;
      return localNoticeDownloadListener;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.a = new NoticeUpdateHandler(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    if (this.a == null) {
      this.a = new NoticeUpdateHandler();
    }
    this.a.sendMessage(paramMessage);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallSucceed ,appId");
    ((StringBuilder)localObject).append(paramString1);
    LogUtility.a("NoticeDownloadListener", ((StringBuilder)localObject).toString());
    paramString1 = DownloadManager.b().f(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.a.obtainMessage();
      paramString2.what = 6;
      localObject = new Bundle();
      ((Bundle)localObject).putString(DownloadConstants.b, paramString1.c);
      paramString2.setData((Bundle)localObject);
      a(paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadError ,downloadInfo");
    ((StringBuilder)localObject).append(paramDownloadInfo);
    LogUtility.a("NoticeDownloadListener", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.o == 1) {
        return;
      }
      if (paramDownloadInfo.x) {
        return;
      }
      localObject = this.a.obtainMessage();
      ((Message)localObject).what = -2;
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", paramDownloadInfo.c);
      ((Message)localObject).setData(localBundle);
      ((Message)localObject).obj = paramString;
      ((Message)localObject).arg2 = paramInt2;
      a((Message)localObject);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    LogUtility.a("NoticeDownloadListener", "onDownloadFinish ");
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.o == 1) {
        return;
      }
      if (paramDownloadInfo.x) {
        return;
      }
      Message localMessage = this.a.obtainMessage();
      localMessage.what = 4;
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", paramDownloadInfo.c);
      localMessage.setData(localBundle);
      a(localMessage);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadPause ");
    ((StringBuilder)localObject).append(paramDownloadInfo.c);
    LogUtility.a("NoticeDownloadListener", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo.o == 1) {
      return;
    }
    if (paramDownloadInfo.x) {
      return;
    }
    localObject = this.a.obtainMessage();
    ((Message)localObject).what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramDownloadInfo.c);
    ((Message)localObject).setData(localBundle);
    a((Message)localObject);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadUpdate notify enter infos=");
    ((StringBuilder)localObject).append(paramList.size());
    LogUtility.a("NoticeDownloadListener", ((StringBuilder)localObject).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (DownloadInfo)paramList.next();
      if ((localObject != null) && (((DownloadInfo)localObject).o != 1))
      {
        if (((DownloadInfo)localObject).x) {
          return;
        }
        Message localMessage = this.a.obtainMessage();
        localMessage.what = 2;
        Bundle localBundle = new Bundle();
        localBundle.putString("appId", ((DownloadInfo)localObject).c);
        localMessage.setData(localBundle);
        a(localMessage);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.o == 1) {
        return;
      }
      if (paramDownloadInfo.x) {
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDownloadWait notify enter info.id=");
      if (paramDownloadInfo == null) {
        localObject1 = "";
      } else {
        localObject1 = paramDownloadInfo.c;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtility.a("NoticeDownloadListener", ((StringBuilder)localObject2).toString());
      Object localObject1 = this.a.obtainMessage();
      ((Message)localObject1).what = 20;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appId", paramDownloadInfo.c);
      ((Message)localObject1).setData((Bundle)localObject2);
      a((Message)localObject1);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.NoticeDownloadListener
 * JD-Core Version:    0.7.0.1
 */