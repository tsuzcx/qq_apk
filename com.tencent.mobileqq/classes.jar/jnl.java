import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class jnl
  implements Runnable
{
  public jnl(AVRedPacketConfigManager paramAVRedPacketConfigManager, IAVRedPacketCallback paramIAVRedPacketCallback) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("downloadRes, threadName[").append(Thread.currentThread().getName()).append("], threadId[").append(Thread.currentThread().getId()).append("], resDownloadManager[");
    if (this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedPacketConfigManger", 1, bool + "]");
      this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_ComTencentAvServiceIAVRedPacketCallback = this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback;
      this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.c = false;
      if (this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager != null)
      {
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL, this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resMD5, ".zip", true, 4, Integer.valueOf(1));
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl, this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResMd5, ".zip", true, 4, Integer.valueOf(2));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jnl
 * JD-Core Version:    0.7.0.1
 */