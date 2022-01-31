import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class jli
  implements Runnable
{
  public jli(AVRedPacketConfigManager paramAVRedPacketConfigManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "picPreDownloadTask called");
    }
    if (this.a.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
    {
      QLog.d("AVRedPacketConfigManger", 1, "picPreDownloadTask, redPacketConfig is null");
      return;
    }
    this.a.b = false;
    this.a.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.a.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL, this.a.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resMD5, ".zip", true, 4, Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jli
 * JD-Core Version:    0.7.0.1
 */