package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class PtvTemplateManager$4$1
  implements INetEngineListener
{
  PtvTemplateManager$4$1(PtvTemplateManager.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "onResp url: " + this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl + " resultcode: " + paramNetResp.mHttpCode);
    }
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable = this.a.this$0.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo, false);
    if (this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable) {}
    try
    {
      ZipUtils.unZipFile(new File(PtvTemplateManager.a(), this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleName), PtvTemplateManager.a());
      this.a.this$0.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUsable);
      if (paramNetResp.mResult == 0)
      {
        PreDownloadController localPreDownloadController = (PreDownloadController)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        if (localPreDownloadController.isEnable()) {
          localPreDownloadController.preDownloadSuccess(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfo.doodleUrl, paramNetResp.mTotalFileLen);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("PtvTemplateManager", 1, "preDownloadDoodleTemplate error, ", localIOException);
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.4.1
 * JD-Core Version:    0.7.0.1
 */