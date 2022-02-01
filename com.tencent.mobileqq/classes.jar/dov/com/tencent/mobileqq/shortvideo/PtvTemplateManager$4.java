package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$4
  implements Runnable
{
  PtvTemplateManager$4(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, true)) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = true;
    }
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new PtvTemplateManager.4.1(this);
      localHttpNetReq.mReqUrl = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(PtvTemplateManager.a(), this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    } while (!QLog.isColorLevel());
    QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */