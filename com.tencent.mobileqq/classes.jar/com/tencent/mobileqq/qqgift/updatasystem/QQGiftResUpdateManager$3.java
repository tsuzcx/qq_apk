package com.tencent.mobileqq.qqgift.updatasystem;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResDownloadCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

class QQGiftResUpdateManager$3
  implements IUpdateListener
{
  QQGiftResUpdateManager$3(QQGiftResUpdateManager paramQQGiftResUpdateManager) {}
  
  public void onLoadFail(UpdateListenerParams paramUpdateListenerParams)
  {
    QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams);
  }
  
  public void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject2 = QQGiftResUpdateManager.a(this.a, paramUpdateListenerParams, true);
    if (localObject2 == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onLoadSuccess downloadCallback is null!");
      return;
    }
    Object localObject1 = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    paramUpdateListenerParams = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
    int i = ((QQGiftResourceBusiness)localObject1).a(paramUpdateListenerParams, 2);
    paramUpdateListenerParams = ((QQGiftResourceBusiness)localObject1).e(paramUpdateListenerParams);
    localObject1 = new File(paramUpdateListenerParams).list(new QQGiftResUpdateManager.3.1(this));
    localObject2 = ((HashSet)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (IQQGiftResDownloadCallback)((Iterator)localObject2).next();
      if ((localObject3 instanceof IQQGiftAnimationResDownloadCallback)) {
        if (localObject1.length > 0)
        {
          localObject3 = (IQQGiftAnimationResDownloadCallback)localObject3;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramUpdateListenerParams);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(localObject1[0]);
          ((IQQGiftAnimationResDownloadCallback)localObject3).a(i, localStringBuilder.toString());
        }
        else
        {
          ((IQQGiftResDownloadCallback)localObject3).a(i, -1, -1, "dir is exist but is empty");
          FileUtils.deleteDirectory(paramUpdateListenerParams);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[downloadAnimationRes-onLoadSuccess] file is exist but is empty, dir:");
          ((StringBuilder)localObject3).append(paramUpdateListenerParams);
          QLog.e("QQGiftResUpdateManager", 1, ((StringBuilder)localObject3).toString());
        }
      }
    }
  }
  
  public void onProgress(UpdateListenerParams paramUpdateListenerParams)
  {
    QQGiftResUpdateManager.b(this.a, paramUpdateListenerParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager.3
 * JD-Core Version:    0.7.0.1
 */