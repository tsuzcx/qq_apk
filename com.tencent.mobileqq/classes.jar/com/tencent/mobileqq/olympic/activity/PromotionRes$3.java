package com.tencent.mobileqq.olympic.activity;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class PromotionRes$3
  implements PromotionResDownload.DownloadListener
{
  PromotionRes$3(PromotionRes paramPromotionRes, AppInterface paramAppInterface) {}
  
  public void a() {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a();
    if (localObject != null)
    {
      if (!TextUtils.equals(paramString, ((PromotionConfigInfo.PromotionItem)localObject).jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.jdField_a_of_type_ArrayOfInt.length) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.jdField_a_of_type_ArrayOfInt[paramInt1] = paramInt2;
      }
      if ((paramInt2 >= 0) && (paramInt2 <= 99))
      {
        PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes, "onDownloadProgress", true);
        return;
      }
      paramString = PromotionRes.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadProgress, index[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], progress[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramString, 1, ((StringBuilder)localObject).toString());
      if ((paramInt2 == 100) && (paramInt1 == 0)) {
        PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes, "onDownloadProgress", this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes, "onDownloadProgress2", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes.3
 * JD-Core Version:    0.7.0.1
 */