package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class QQGiftPanelItemViewImpl$ResCallback
  implements IQQGiftPanelResDownloadCallback
{
  private WeakReference<QQGiftPanelItemViewImpl> a = null;
  
  public QQGiftPanelItemViewImpl$ResCallback(QQGiftPanelItemViewImpl paramQQGiftPanelItemViewImpl)
  {
    this.a = new WeakReference(paramQQGiftPanelItemViewImpl);
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
      QLog.d("QQGiftPanelItemViewImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadFail] id:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", progress:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", progressRate:");
      localStringBuilder.append(paramInt2);
      QLog.d("QQGiftPanelItemViewImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, QQGiftPanelResource paramQQGiftPanelResource)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onLoadSuccess] id:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", panelResource:");
      ((StringBuilder)localObject1).append(paramQQGiftPanelResource);
      QLog.d("QQGiftPanelItemViewImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      if (paramQQGiftPanelResource != null)
      {
        Object localObject2 = ((QQGiftPanelItemViewImpl)this.a.get()).a;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramQQGiftPanelResource.b))
        {
          localObject1 = localObject2;
          if (new File(paramQQGiftPanelResource.b).exists()) {
            localObject1 = QQGiftImageUtil.a(paramQQGiftPanelResource.b, ((QQGiftPanelItemViewImpl)this.a.get()).a, ((QQGiftPanelItemViewImpl)this.a.get()).a);
          }
        }
        Object localObject3 = null;
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(paramQQGiftPanelResource.d))
        {
          localObject2 = localObject3;
          if (new File(paramQQGiftPanelResource.d).exists()) {
            localObject2 = QQGiftImageUtil.a(paramQQGiftPanelResource.d, URLDrawableHelperConstants.a, URLDrawableHelperConstants.a);
          }
        }
        QQGiftPanelItemViewImpl.a((QQGiftPanelItemViewImpl)this.a.get(), (Drawable)localObject1, (Drawable)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPanelItemViewImpl.ResCallback
 * JD-Core Version:    0.7.0.1
 */