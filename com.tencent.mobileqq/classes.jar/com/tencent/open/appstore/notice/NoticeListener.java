package com.tencent.open.appstore.notice;

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

public class NoticeListener
  implements DownloadListener
{
  protected static NoticeListener a;
  protected NoticeHintHandler a;
  
  public static NoticeListener a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeListener == null) {
        jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeListener = new NoticeListener();
      }
      NoticeListener localNoticeListener = jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeListener;
      return localNoticeListener;
    }
    finally {}
  }
  
  public void a(Looper paramLooper)
  {
    this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler = new NoticeHintHandler(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler == null) {
      this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler = new NoticeHintHandler();
    }
    this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.sendMessage(paramMessage);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInstallSucceed ,appId");
    ((StringBuilder)localObject).append(paramString1);
    LogUtility.a("NoticeListener", ((StringBuilder)localObject).toString());
    paramString1 = DownloadManager.a().b(paramString2);
    if (paramString1 != null)
    {
      paramString2 = this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.obtainMessage();
      paramString2.what = 6;
      localObject = new Bundle();
      ((Bundle)localObject).putString(DownloadConstants.a, paramString1.jdField_b_of_type_JavaLangString);
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
    LogUtility.a("NoticeListener", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.jdField_c_of_type_Int == 1) {
        return;
      }
      if (paramDownloadInfo.jdField_b_of_type_Boolean) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.obtainMessage();
      ((Message)localObject).what = -2;
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
      ((Message)localObject).setData(localBundle);
      ((Message)localObject).obj = paramString;
      ((Message)localObject).arg2 = paramInt2;
      a((Message)localObject);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    LogUtility.a("NoticeListener", "onDownloadFinish ");
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.jdField_c_of_type_Int == 1) {
        return;
      }
      if (paramDownloadInfo.jdField_b_of_type_Boolean) {
        return;
      }
      Message localMessage = this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.obtainMessage();
      localMessage.what = 4;
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
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
    ((StringBuilder)localObject).append(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    LogUtility.a("NoticeListener", ((StringBuilder)localObject).toString());
    if (paramDownloadInfo.jdField_c_of_type_Int == 1) {
      return;
    }
    if (paramDownloadInfo.jdField_b_of_type_Boolean) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.obtainMessage();
    ((Message)localObject).what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    ((Message)localObject).setData(localBundle);
    a((Message)localObject);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadUpdate notify enter infos=");
    ((StringBuilder)localObject).append(paramList.size());
    LogUtility.a("NoticeListener", ((StringBuilder)localObject).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (DownloadInfo)paramList.next();
      if ((localObject != null) && (((DownloadInfo)localObject).jdField_c_of_type_Int != 1))
      {
        if (((DownloadInfo)localObject).jdField_b_of_type_Boolean) {
          return;
        }
        Message localMessage = this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.obtainMessage();
        localMessage.what = 2;
        Bundle localBundle = new Bundle();
        localBundle.putString(DownloadConstants.a, ((DownloadInfo)localObject).jdField_b_of_type_JavaLangString);
        localMessage.setData(localBundle);
        a(localMessage);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.jdField_c_of_type_Int == 1) {
        return;
      }
      if (paramDownloadInfo.jdField_b_of_type_Boolean) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadWait notify enter info.id=");
      ((StringBuilder)localObject).append(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      LogUtility.a("NoticeListener", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeHintHandler.obtainMessage();
      ((Message)localObject).what = 20;
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, paramDownloadInfo.jdField_b_of_type_JavaLangString);
      ((Message)localObject).setData(localBundle);
      a((Message)localObject);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeListener
 * JD-Core Version:    0.7.0.1
 */