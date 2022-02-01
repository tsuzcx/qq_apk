package com.tencent.mobileqq.widget;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class QQToast$ShowToastMessage
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference<QQToast.IToastValidListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  QQToast$ShowToastMessage(QQToast paramQQToast, QQToast.IToastValidListener paramIToastValidListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIToastValidListener);
  }
  
  private boolean a()
  {
    QQToast.IToastValidListener localIToastValidListener = (QQToast.IToastValidListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localIToastValidListener != null) && (localIToastValidListener.a());
  }
  
  @Nullable
  QQToast a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ShowToastMessage
 * JD-Core Version:    0.7.0.1
 */