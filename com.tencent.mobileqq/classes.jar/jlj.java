import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class jlj
  implements Runnable
{
  public jlj(AVRedPacketConfigManager paramAVRedPacketConfigManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketConfigManger", 2, "musicPreDownloadTask called");
    }
    if (this.a.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig == null)
    {
      QLog.d("AVRedPacketConfigManger", 1, "musicPreDownloadTask, redPacketConfig is null");
      return;
    }
    this.a.c = false;
    this.a.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.a.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl, this.a.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResMd5, ".zip", true, 4, Integer.valueOf(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlj
 * JD-Core Version:    0.7.0.1
 */