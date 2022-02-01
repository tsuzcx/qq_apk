package com.tencent.mobileqq.qzonevip.gift;

import com.tencent.TMG.utils.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

class QzoneGiftUtil$1$1
  implements QzoneZipCacheHelperCallBack
{
  QzoneGiftUtil$1$1(QzoneGiftUtil.1 param1) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      QzoneGiftUtil.1.a(this.a);
    } else {
      QzoneGiftUtil.1.b(this.a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadGiftZip onResult mLoadSuccessTimes = ");
    localStringBuilder.append(QzoneGiftUtil.1.c(this.a));
    localStringBuilder.append(" mLoadFailTimes = ");
    localStringBuilder.append(QzoneGiftUtil.1.d(this.a));
    QLog.i("QzoneGiftUtil", 1, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener != null)
    {
      if (QzoneGiftUtil.1.c(this.a) == this.a.jdField_a_of_type_Int)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.a();
        return;
      }
      if (QzoneGiftUtil.1.c(this.a) + QzoneGiftUtil.1.d(this.a) == this.a.jdField_a_of_type_Int) {
        this.a.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.b();
      }
    }
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1.1
 * JD-Core Version:    0.7.0.1
 */