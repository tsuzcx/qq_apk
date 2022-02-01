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
    Object localObject1 = OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(File.separator);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = HtmlOffline.d(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append((String)localObject2);
    if (new File(localStringBuilder.toString()).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = ViolaBaseView.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadOfflineSuccess js exists [url:");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("]");
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = ViolaBaseView.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadOfflineSuccess js no exists [url:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("]");
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ViolaAccessHelper.b(this.b);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$LoadAsyBack;
      if (localObject2 != null) {
        ((ViolaBaseView.LoadAsyBack)localObject2).a((String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = ViolaBaseView.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadOfflineSuccess and jsSource succ [url:");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("]");
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$LoadAsyBack;
      if (localObject1 != null) {
        ((ViolaBaseView.LoadAsyBack)localObject1).a();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = ViolaBaseView.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadOfflineSuccess but js null [url:");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append("]");
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$LoadAsyBack;
    if (localObject != null) {
      ((ViolaBaseView.LoadAsyBack)localObject).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = ViolaBaseView.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadOfflineFailed [url:");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.e((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.8
 * JD-Core Version:    0.7.0.1
 */