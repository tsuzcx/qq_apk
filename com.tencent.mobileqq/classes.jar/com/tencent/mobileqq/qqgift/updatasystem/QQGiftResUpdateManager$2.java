package com.tencent.mobileqq.qqgift.updatasystem;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResDownloadCallback;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

class QQGiftResUpdateManager$2
  implements IUpdateListener
{
  QQGiftResUpdateManager$2(QQGiftResUpdateManager paramQQGiftResUpdateManager) {}
  
  public void onLoadFail(UpdateListenerParams paramUpdateListenerParams)
  {
    QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams);
  }
  
  public void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject1 = QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams, true);
    if (localObject1 == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onLoadSuccess downloadCallback is null!");
      return;
    }
    Object localObject2 = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    paramUpdateListenerParams = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
    int i = ((QQGiftResourceBusiness)localObject2).a(paramUpdateListenerParams, 2);
    paramUpdateListenerParams = ((QQGiftResourceBusiness)localObject2).e(paramUpdateListenerParams);
    new File(paramUpdateListenerParams).list(new QQGiftResUpdateManager.2.1(this));
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IQQGiftResDownloadCallback)((Iterator)localObject1).next();
      if ((localObject2 instanceof IQQGiftAnimationResDownloadCallback)) {
        ((IQQGiftAnimationResDownloadCallback)localObject2).a(i, paramUpdateListenerParams);
      }
    }
  }
  
  public void onProgress(UpdateListenerParams paramUpdateListenerParams)
  {
    QQGiftResUpdateManager.b(this.a, paramUpdateListenerParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */