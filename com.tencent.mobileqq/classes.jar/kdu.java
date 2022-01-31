import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.av.service.IAVRedPacketCallback.Stub;
import com.tencent.av.ui.redbag.AVRedBagConfig;
import com.tencent.av.ui.redbag.AVRedBagConfig.Info;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.qphone.base.util.QLog;

public class kdu
  extends IAVRedPacketCallback.Stub
{
  public kdu(AVRedBagConfig paramAVRedBagConfig) {}
  
  public void a(boolean paramBoolean, AVRedPacketConfig paramAVRedPacketConfig)
  {
    this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info = new AVRedBagConfig.Info();
    this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = paramAVRedPacketConfig;
    if ((paramBoolean) && (paramAVRedPacketConfig != null) && (paramAVRedPacketConfig.mainSwitch)) {
      this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a.i, 1, "onGetAVRedPacketConfig红包配置获取结果, isSuccess[" + paramBoolean + "], config[" + paramAVRedPacketConfig + "], mMainSwitch[" + this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_a_of_type_Boolean + "], mNeedDownloadRes[" + this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_b_of_type_Boolean + "], Thread[" + Thread.currentThread().getId() + "]");
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info);
    if ((this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_b_of_type_Boolean) && (paramAVRedPacketConfig != null))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.a.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback))
      {
        QLog.w(this.a.i, 1, "startDownloadAVRedPacketRes, 调用失败");
        return;
      }
      this.a.b(this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info);
      return;
    }
    this.a.b(this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.i, 1, "红包资源下载结果, isSuccess[" + paramBoolean + "], resPath[" + paramString1 + "], bgMusicPath[" + paramString2 + "]");
    }
    this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_a_of_type_JavaLangString = paramString1;
    this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_b_of_type_JavaLangString = paramString2;
    this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.c = paramBoolean;
    if (paramBoolean) {
      RedBagUtil.a(paramString1);
    }
    this.a.b(this.a.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdu
 * JD-Core Version:    0.7.0.1
 */