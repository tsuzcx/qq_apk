package com.tencent.mobileqq.qzonevip.gift;

import auok;
import auol;
import auon;
import com.tencent.TMG.utils.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public final class QzoneGiftUtil$1
  implements Runnable
{
  private volatile int jdField_a_of_type_Int;
  private volatile int jdField_b_of_type_Int;
  
  public QzoneGiftUtil$1(auon paramauon, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    auol localauol = new auol(this);
    boolean bool1 = QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, this.jdField_a_of_type_JavaLangString, "qzone_aio_gift", String.valueOf(this.jdField_a_of_type_JavaLangString.hashCode()), -1, localauol);
    if (bool1) {
      this.jdField_a_of_type_Int += 1;
    }
    boolean bool2 = QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, this.jdField_b_of_type_JavaLangString, "qzone_aio_gift", String.valueOf(this.jdField_b_of_type_JavaLangString.hashCode()), -1, localauol);
    if (bool2) {
      this.jdField_a_of_type_Int += 1;
    }
    boolean bool3 = auok.a(this.c, "qzone_aio_gift");
    if (bool3)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Auon != null)
      {
        if (this.jdField_a_of_type_Int != 3) {
          break label226;
        }
        this.jdField_a_of_type_Auon.a();
      }
    }
    for (;;)
    {
      QLog.i("QzoneGiftUtil", 1, "isBoxZipFileExist = " + bool1 + " isGiftZipFileExist = " + bool2 + " isGiftExist = " + bool3 + " mLoadSuccessTimes = " + this.jdField_a_of_type_Int + " mLoadFailTimes = " + this.jdField_b_of_type_Int);
      return;
      auok.a(this.c, "qzone_aio_gift", localauol);
      break;
      label226:
      this.jdField_a_of_type_Auon.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1
 * JD-Core Version:    0.7.0.1
 */