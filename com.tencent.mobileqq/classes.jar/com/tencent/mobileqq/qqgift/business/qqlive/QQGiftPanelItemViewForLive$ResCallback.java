package com.tencent.mobileqq.qqgift.business.qqlive;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class QQGiftPanelItemViewForLive$ResCallback
  implements IQQGiftPanelResDownloadCallback
{
  private WeakReference<QQGiftPanelItemViewForLive> a;
  
  public QQGiftPanelItemViewForLive$ResCallback(QQGiftPanelItemViewForLive paramQQGiftPanelItemViewForLive)
  {
    this.a = new WeakReference(paramQQGiftPanelItemViewForLive);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadFail] id:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", errorCode:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", httpCode:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", errorMessage:");
      localStringBuilder.append(paramString);
      QLog.d("QQGiftPanelItemViewForLive", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onProgress] id:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", progress:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", progressRate:");
      localStringBuilder.append(paramInt2);
      QLog.d("QQGiftPanelItemViewForLive", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, QQGiftPanelResource paramQQGiftPanelResource)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onLoadSuccess] id:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", panelResource:");
      ((StringBuilder)localObject).append(paramQQGiftPanelResource);
      QLog.d("QQGiftPanelItemViewForLive", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      if (paramQQGiftPanelResource != null)
      {
        Drawable localDrawable = ((QQGiftPanelItemViewForLive)this.a.get()).a;
        localObject = localDrawable;
        if (!TextUtils.isEmpty(paramQQGiftPanelResource.b))
        {
          localObject = localDrawable;
          if (new File(paramQQGiftPanelResource.b).exists()) {
            localObject = QQGiftImageUtil.a(paramQQGiftPanelResource.b, ((QQGiftPanelItemViewForLive)this.a.get()).a, ((QQGiftPanelItemViewForLive)this.a.get()).a);
          }
        }
        QQGiftPanelItemViewForLive.a((QQGiftPanelItemViewForLive)this.a.get(), (Drawable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelItemViewForLive.ResCallback
 * JD-Core Version:    0.7.0.1
 */