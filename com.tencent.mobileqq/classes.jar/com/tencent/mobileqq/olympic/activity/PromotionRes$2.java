package com.tencent.mobileqq.olympic.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.qphone.base.util.QLog;

class PromotionRes$2
  implements GestureMgr.GestureStatusListener
{
  PromotionRes$2(PromotionRes paramPromotionRes, AppInterface paramAppInterface) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.jdField_a_of_type_ArrayOfInt[3] = paramInt;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject = PromotionRes.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProgress, index[3], bDownloadSuc[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.jdField_a_of_type_ArrayOfInt;
    if (paramBoolean1) {
      paramInt = 100;
    } else {
      paramInt = -1;
    }
    localObject[3] = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes.a() == 100) {
      PromotionRes.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes, "onDownloadProgress1", this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes.2
 * JD-Core Version:    0.7.0.1
 */