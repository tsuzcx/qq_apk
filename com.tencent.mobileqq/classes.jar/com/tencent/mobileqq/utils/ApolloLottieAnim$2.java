package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ApolloLottieAnim$2
  extends DownloadListener
{
  ApolloLottieAnim$2(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (3 == paramDownloadTask.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim;
      ((ApolloLottieAnim)localObject).a = 2;
      ((ApolloLottieAnim)localObject).a(false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZip onDone task.getStatus()->");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      QLog.d("ApolloLottieAnim", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.2
 * JD-Core Version:    0.7.0.1
 */