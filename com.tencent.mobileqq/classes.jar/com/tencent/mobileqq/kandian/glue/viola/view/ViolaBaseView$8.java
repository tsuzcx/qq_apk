package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.ViolaOfflineDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ViolaBaseView$8
  implements ViolaAccessHelper.ViolaOfflineDownloadListener
{
  ViolaBaseView$8(ViolaBaseView paramViolaBaseView, String paramString1, String paramString2, ViolaBaseView.LoadAsyBack paramLoadAsyBack) {}
  
  public void a()
  {
    Object localObject1 = OfflineEnvHelper.b(this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(File.separator);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = HtmlOffline.g(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append((String)localObject2);
    if (new File(localStringBuilder.toString()).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadOfflineSuccess js exists [url:");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("]");
        QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadOfflineSuccess js no exists [url:");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("]");
      QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = ViolaAccessHelper.b(this.b);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.c;
      if (localObject2 != null) {
        ((ViolaBaseView.LoadAsyBack)localObject2).a((String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadOfflineSuccess and jsSource succ [url:");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("]");
        QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      localObject1 = this.c;
      if (localObject1 != null) {
        ((ViolaBaseView.LoadAsyBack)localObject1).a();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadOfflineSuccess but js null [url:");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("]");
        QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((ViolaBaseView.LoadAsyBack)localObject).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadOfflineFailed [url:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
      QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.8
 * JD-Core Version:    0.7.0.1
 */