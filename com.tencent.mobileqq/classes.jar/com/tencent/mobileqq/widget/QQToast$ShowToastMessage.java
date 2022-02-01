package com.tencent.mobileqq.widget;

import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class QQToast$ShowToastMessage
{
  private WeakReference<QQToast.IToastValidListener> mListener;
  private QQToast mToast;
  
  QQToast$ShowToastMessage(QQToast paramQQToast, QQToast.IToastValidListener paramIToastValidListener)
  {
    this.mToast = paramQQToast;
    this.mListener = new WeakReference(paramIToastValidListener);
  }
  
  private boolean needToShow()
  {
    QQToast.IToastValidListener localIToastValidListener = (QQToast.IToastValidListener)this.mListener.get();
    return (localIToastValidListener != null) && (localIToastValidListener.canShowToast());
  }
  
  @Nullable
  QQToast getToast()
  {
    if (needToShow()) {
      return this.mToast;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.ShowToastMessage
 * JD-Core Version:    0.7.0.1
 */