package com.tencent.mobileqq.qqgift.updatasystem;

import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResDownloadCallback;
import com.tencent.mobileqq.qqgift.utils.QQGiftResDownloadUtil;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.HashSet;
import java.util.Iterator;

class QQGiftResUpdateManager$1
  implements IUpdateListener
{
  QQGiftResUpdateManager$1(QQGiftResUpdateManager paramQQGiftResUpdateManager) {}
  
  public void onLoadFail(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject1 = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    HashSet localHashSet = QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams, true);
    if (localHashSet == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onLoadFail downloadCallback is null!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLoadFail downloadCallback size:");
      ((StringBuilder)localObject2).append(localHashSet.size());
      QLog.d("QQGiftResUpdateManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
    QQGiftResDownloadUtil.b((String)localObject2);
    int i = ((QQGiftResourceBusiness)localObject1).a((String)localObject2, 1);
    localObject1 = localHashSet.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IQQGiftResDownloadCallback)((Iterator)localObject1).next()).a(i, paramUpdateListenerParams.mErrorCode, paramUpdateListenerParams.mHttpCode, paramUpdateListenerParams.mErrorMessage);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadSinglePanelRes] onLoadFail id:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", errorMessage:");
      ((StringBuilder)localObject1).append(paramUpdateListenerParams.mErrorMessage);
      QLog.d("QQGiftResUpdateManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject1 = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    Object localObject2 = QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams, true);
    if (localObject2 == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onLoadSuccess downloadCallback is null!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onLoadSuccess downloadCallback size:");
      ((StringBuilder)localObject3).append(((HashSet)localObject2).size());
      QLog.d("QQGiftResUpdateManager", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
    paramUpdateListenerParams = ((QQGiftResourceBusiness)localObject1).e((String)localObject3);
    int i = ((QQGiftResourceBusiness)localObject1).a((String)localObject3, 1);
    localObject1 = ((HashSet)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IQQGiftResDownloadCallback)((Iterator)localObject1).next();
      if ((localObject2 instanceof IQQGiftPanelResDownloadCallback)) {
        QQGiftResUpdateManager.a(this.a, i, paramUpdateListenerParams, (IQQGiftPanelResDownloadCallback)localObject2);
      }
    }
  }
  
  public void onProgress(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams, false);
    if (localObject == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onProgress downloadCallback is null!");
      return;
    }
    int i = ((QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class)).a(paramUpdateListenerParams.mBusinessUpdateParams.mScid, 1);
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IQQGiftResDownloadCallback)((Iterator)localObject).next()).a(i, paramUpdateListenerParams.mProgress, paramUpdateListenerParams.mProgressMax, paramUpdateListenerParams.mProgressRate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */