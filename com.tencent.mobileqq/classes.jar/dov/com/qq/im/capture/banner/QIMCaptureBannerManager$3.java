package dov.com.qq.im.capture.banner;

import ayrx;
import aysa;
import ayta;
import bbfj;
import bjbo;
import bjbp;
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
      ayrx localayrx = new ayrx();
      localayrx.jdField_a_of_type_Aysc = new bjbp(this);
      localayrx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl;
      localayrx.jdField_a_of_type_Int = 0;
      localayrx.jdField_c_of_type_JavaLangString = new File(bjbo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgMd5).getPath();
      localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a(localayrx);
    } while (!QLog.isColorLevel());
    QLog.i("QIMCaptureBannerManager", 2, "preLoadBannerResources, url: " + this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3
 * JD-Core Version:    0.7.0.1
 */