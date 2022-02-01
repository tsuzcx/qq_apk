package com.tencent.mobileqq.qzonevip.gift;

import com.tencent.TMG.utils.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

class QzoneGiftUtil$1$1
  implements QzoneZipCacheHelperCallBack
{
  QzoneGiftUtil$1$1(QzoneGiftUtil.1 param1) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QzoneGiftUtil.1.a(this.a);
      QLog.i("QzoneGiftUtil", 1, "downloadGiftZip onResult mLoadSuccessTimes = " + QzoneGiftUtil.1.c(this.a) + " mLoadFailTimes = " + QzoneGiftUtil.1.d(this.a));
      if (this.a.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener != null)
      {
        if (QzoneGiftUtil.1.c(this.a) != this.a.jdField_a_of_type_Int) {
          break label109;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.a();
      }
    }
    label109:
    while (QzoneGiftUtil.1.c(this.a) + QzoneGiftUtil.1.d(this.a) != this.a.jdField_a_of_type_Int)
    {
      return;
      QzoneGiftUtil.1.b(this.a);
      break;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.b();
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1.1
 * JD-Core Version:    0.7.0.1
 */