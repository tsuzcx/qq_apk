package dov.com.qq.im.capture.banner;

import baps;
import bapv;
import baqx;
import bdee;
import blmy;
import blmz;
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
      baps localbaps = new baps();
      localbaps.jdField_a_of_type_Bapx = new blmz(this);
      localbaps.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl;
      localbaps.jdField_a_of_type_Int = 0;
      localbaps.jdField_c_of_type_JavaLangString = new File(blmy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgMd5).getPath();
      localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a(localbaps);
    } while (!QLog.isColorLevel());
    QLog.i("QIMCaptureBannerManager", 2, "preLoadBannerResources, url: " + this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3
 * JD-Core Version:    0.7.0.1
 */