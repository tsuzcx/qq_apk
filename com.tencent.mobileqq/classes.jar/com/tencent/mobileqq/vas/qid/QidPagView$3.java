package com.tencent.mobileqq.vas.qid;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import org.libpag.PAGView;

class QidPagView$3
  implements URLDrawable.URLDrawableListener
{
  QidPagView$3(QidPagView paramQidPagView, PAGView paramPAGView, int paramInt, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/0/2d/body/100.png")) || (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/1/2d/body/100.png"))) {}
    do
    {
      return;
      QidPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView).d = QidCardManager.a();
    } while (TextUtils.isEmpty(QidPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView).d));
    QidPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView, this.jdField_a_of_type_OrgLibpagPAGView, this.jdField_a_of_type_Int, QidPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView).d);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QidPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasQidQidPagView, this.jdField_a_of_type_OrgLibpagPAGView, this.jdField_a_of_type_Int, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidPagView.3
 * JD-Core Version:    0.7.0.1
 */