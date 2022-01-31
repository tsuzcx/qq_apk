package dov.com.qq.im.capture.banner;

import axro;
import axrr;
import axsr;
import badq;
import bhgf;
import bhgg;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMCaptureBannerManager$3
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a(this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem)) {}
    do
    {
      return;
      axro localaxro = new axro();
      localaxro.jdField_a_of_type_Axrt = new bhgg(this);
      localaxro.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl;
      localaxro.jdField_a_of_type_Int = 0;
      localaxro.jdField_c_of_type_JavaLangString = new File(bhgf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgMd5).getPath();
      localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a(localaxro);
    } while (!QLog.isColorLevel());
    QLog.i("QIMCaptureBannerManager", 2, "preLoadBannerResources, url: " + this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3
 * JD-Core Version:    0.7.0.1
 */