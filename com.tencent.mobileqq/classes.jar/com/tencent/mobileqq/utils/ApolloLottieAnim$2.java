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
    if (3 == paramDownloadTask.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(true, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "downloadZip onDone task.getStatus()->" + paramDownloadTask.a());
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a = 2;
      this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(false, this.jdField_a_of_type_JavaLangString, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.2
 * JD-Core Version:    0.7.0.1
 */