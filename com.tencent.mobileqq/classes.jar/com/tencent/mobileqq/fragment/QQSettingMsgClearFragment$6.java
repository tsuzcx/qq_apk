package com.tencent.mobileqq.fragment;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQSettingMsgClearFragment$6
  implements DownloadListener
{
  QQSettingMsgClearFragment$6(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    QQSettingMsgClearFragment.a(this.a, paramString1, paramString2);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq onDownloadCancel info = ");
      localStringBuilder.append(paramDownloadInfo);
      QLog.w("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq onDownloadError errorCode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("errorMsg = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", state = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", info = ");
      localStringBuilder.append(paramDownloadInfo);
      QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    QQSettingMsgClearFragment.a(paramDownloadInfo, "YYB");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq onDownloadPause info = ");
      localStringBuilder.append(paramDownloadInfo);
      QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("qq onDownloadUpdate progress = ");
        localStringBuilder.append(localDownloadInfo.t);
        localStringBuilder.append(", url = ");
        localStringBuilder.append(localDownloadInfo.d);
        QLog.w("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq onDownloadWait info = ");
      localStringBuilder.append(paramDownloadInfo);
      QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq packageReplaced appid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", packageName = ");
      localStringBuilder.append(paramString2);
      QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq uninstallSucceed appid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", packageName = ");
      localStringBuilder.append(paramString2);
      QLog.e("QQSettingMsgClearFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.6
 * JD-Core Version:    0.7.0.1
 */