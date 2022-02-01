package com.tencent.mobileqq.qzonevip.gift;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

final class QzoneGiftUtil$1
  implements Runnable
{
  private volatile int jdField_b_of_type_Int;
  private volatile int jdField_c_of_type_Int;
  
  QzoneGiftUtil$1(QzoneGiftUtil.GiftLoadListener paramGiftLoadListener, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    QzoneGiftUtil.1.1 local1 = new QzoneGiftUtil.1.1(this);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, this.jdField_a_of_type_JavaLangString, "qzone_aio_gift", String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode()), -1, local1))) {
      this.jdField_b_of_type_Int += 1;
    }
    boolean bool1 = QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, this.jdField_b_of_type_JavaLangString, "qzone_aio_gift", String.valueOf(this.jdField_b_of_type_JavaLangString.hashCode()), -1, local1);
    if (bool1) {
      this.jdField_b_of_type_Int += 1;
    }
    boolean bool2 = QzoneGiftUtil.a(this.jdField_c_of_type_JavaLangString, "qzone_aio_gift");
    if (bool2)
    {
      this.jdField_b_of_type_Int += 1;
      if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener != null)
      {
        if (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int) {
          break label224;
        }
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.a();
      }
    }
    for (;;)
    {
      QLog.i("QzoneGiftUtil", 1, " isGiftZipFileExist = " + bool1 + " isGiftExist = " + bool2 + " mLoadSuccessTimes = " + this.jdField_b_of_type_Int + " mLoadFailTimes = " + this.jdField_c_of_type_Int);
      return;
      QzoneGiftUtil.a(this.jdField_c_of_type_JavaLangString, "qzone_aio_gift", local1);
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1
 * JD-Core Version:    0.7.0.1
 */