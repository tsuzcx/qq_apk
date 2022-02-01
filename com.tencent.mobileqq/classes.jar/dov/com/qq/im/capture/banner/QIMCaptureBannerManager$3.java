package dov.com.qq.im.capture.banner;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QIMCaptureBannerManager$3
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a(this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem)) {}
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new QIMCaptureBannerManager.3.1(this);
      localHttpNetReq.mReqUrl = this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(QIMCaptureBannerManager.a, this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgMd5).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("QIMCaptureBannerManager", 2, "preLoadBannerResources, url: " + this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3
 * JD-Core Version:    0.7.0.1
 */