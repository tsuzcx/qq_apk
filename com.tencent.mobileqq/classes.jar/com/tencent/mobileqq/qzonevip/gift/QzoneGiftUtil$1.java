package com.tencent.mobileqq.qzonevip.gift;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

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
    Object localObject = new QzoneGiftUtil.1.1(this);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localIQzoneZipCacheHelper = (IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class);
      str = this.jdField_a_of_type_JavaLangString;
      if (localIQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str, "qzone_aio_gift", String.valueOf(str.hashCode()), -1, (QzoneZipCacheHelperCallBack)localObject)) {
        this.jdField_b_of_type_Int += 1;
      }
    }
    IQzoneZipCacheHelper localIQzoneZipCacheHelper = (IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class);
    String str = this.jdField_b_of_type_JavaLangString;
    boolean bool1 = localIQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str, "qzone_aio_gift", String.valueOf(str.hashCode()), -1, (QzoneZipCacheHelperCallBack)localObject);
    if (bool1) {
      this.jdField_b_of_type_Int += 1;
    }
    boolean bool2 = QzoneGiftUtil.a(this.jdField_c_of_type_JavaLangString, "qzone_aio_gift");
    if (bool2) {
      this.jdField_b_of_type_Int += 1;
    } else {
      QzoneGiftUtil.a(this.jdField_c_of_type_JavaLangString, "qzone_aio_gift", (QzoneZipCacheHelperCallBack)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener != null) {
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.a();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftUtil$GiftLoadListener.c();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" isGiftZipFileExist = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" isGiftExist = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" mLoadSuccessTimes = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(" mLoadFailTimes = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    QLog.i("QzoneGiftUtil", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1
 * JD-Core Version:    0.7.0.1
 */