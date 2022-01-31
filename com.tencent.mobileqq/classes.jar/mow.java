import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.qphone.base.util.QLog;

class mow
  extends lwg
{
  mow(mov parammov) {}
  
  public void a(boolean paramBoolean, AVRedPacketConfig paramAVRedPacketConfig)
  {
    this.a.jdField_a_of_type_Moy = new moy();
    this.a.jdField_a_of_type_Moy.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig = paramAVRedPacketConfig;
    if ((paramBoolean) && (paramAVRedPacketConfig != null) && (paramAVRedPacketConfig.mainSwitch)) {
      this.a.jdField_a_of_type_Moy.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a.i, 1, "onGetAVRedPacketConfig红包配置获取结果, isSuccess[" + paramBoolean + "], config[" + paramAVRedPacketConfig + "], mMainSwitch[" + this.a.jdField_a_of_type_Moy.jdField_a_of_type_Boolean + "], mNeedDownloadRes[" + this.a.jdField_a_of_type_Moy.jdField_b_of_type_Boolean + "], Thread[" + Thread.currentThread().getId() + "]");
    }
    this.a.a(this.a.jdField_a_of_type_Moy);
    if ((this.a.jdField_a_of_type_Moy.jdField_b_of_type_Boolean) && (paramAVRedPacketConfig != null))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.a.jdField_a_of_type_Lwf))
      {
        QLog.w(this.a.i, 1, "startDownloadAVRedPacketRes, 调用失败");
        return;
      }
      this.a.b(this.a.jdField_a_of_type_Moy);
      return;
    }
    this.a.b(this.a.jdField_a_of_type_Moy);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.i, 1, "红包资源下载结果, isSuccess[" + paramBoolean + "], resPath[" + paramString1 + "], bgMusicPath[" + paramString2 + "]");
    }
    this.a.jdField_a_of_type_Moy.jdField_a_of_type_JavaLangString = paramString1;
    this.a.jdField_a_of_type_Moy.jdField_b_of_type_JavaLangString = paramString2;
    this.a.jdField_a_of_type_Moy.c = paramBoolean;
    if (paramBoolean) {
      mpv.a(paramString1);
    }
    this.a.b(this.a.jdField_a_of_type_Moy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mow
 * JD-Core Version:    0.7.0.1
 */