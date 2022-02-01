package dov.com.qq.im.capture.banner;

import beum;
import beuo;
import bevn;
import bhnv;
import bpmj;
import bpmk;
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
      beum localbeum = new beum();
      localbeum.jdField_a_of_type_Beuq = new bpmk(this);
      localbeum.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl;
      localbeum.jdField_a_of_type_Int = 0;
      localbeum.c = new File(bpmj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgMd5).getPath();
      localbeum.b = bhnv.a(bevn.a().a());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a(localbeum);
    } while (!QLog.isColorLevel());
    QLog.i("QIMCaptureBannerManager", 2, "preLoadBannerResources, url: " + this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig$BannerItem.imgUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3
 * JD-Core Version:    0.7.0.1
 */