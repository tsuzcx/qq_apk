import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.RemoteException;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.record.QavRecordUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class jma
  implements Runnable
{
  public jma(AVRedPacketConfigManager paramAVRedPacketConfigManager, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3) {}
  
  public void run()
  {
    QLog.d("AVRedPacketConfigManger", 1, "onDownloadFinish,subHandler runnable start,threadName = " + Thread.currentThread().getName());
    boolean bool;
    if (this.jdField_a_of_type_Int == 0) {
      bool = true;
    }
    for (;;)
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4);
      if ((bool) && (localFile.exists()))
      {
        long l1 = localSharedPreferences.getLong(this.jdField_b_of_type_JavaLangString, -1L);
        long l2 = localFile.lastModified();
        if ((l1 != -1L) && (l1 != l2)) {
          localSharedPreferences.edit().putInt("pcm_" + this.jdField_b_of_type_JavaLangString, 0).commit();
        }
        if ((this.jdField_b_of_type_Int == 2) && (l1 != l2))
        {
          QavRecordDpc localQavRecordDpc = QavRecordDpc.a();
          if ((localQavRecordDpc == null) || (localQavRecordDpc.g != 1) || (!QavRecordUtils.a(this.jdField_b_of_type_JavaLangString))) {
            break label620;
          }
          AVRedPacketConfigManager.a(this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager).removeMessages(100);
          AVRedPacketConfigManager.a(this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager).sendEmptyMessageDelayed(100, 60000L);
          l2 = System.currentTimeMillis();
          QavRecordUtils.a(this.jdField_a_of_type_JavaLangString);
          long l3 = System.currentTimeMillis();
          AVRedPacketConfigManager.a(this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager).removeMessages(100);
          QavRecordReporter.a(l3 - l2);
        }
        label262:
        l2 = localFile.lastModified();
        localSharedPreferences.edit().putLong(this.jdField_b_of_type_JavaLangString, l2).commit();
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + this.c + ",md5 = " + this.jdField_b_of_type_JavaLangString + ",errCode = " + this.jdField_a_of_type_Int + ",path = " + this.jdField_a_of_type_JavaLangString + ",modifyTime = " + l2 + ", spModifiedTime=" + l1);
        }
      }
      if (this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_ComTencentAvServiceIAVRedPacketCallback != null)
      {
        if (this.jdField_b_of_type_Int != 1) {
          break label631;
        }
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        label419:
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + this.c + ",md5 = " + this.jdField_b_of_type_JavaLangString + ",errCode = " + this.jdField_a_of_type_Int + ",path = " + this.jdField_a_of_type_JavaLangString + ",downloadBgMusicFinish = " + this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.c + ",downloadResFinish = " + this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_Boolean + ",downloadCallBack = " + this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_ComTencentAvServiceIAVRedPacketCallback);
        }
        if ((!this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.c)) {}
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_ComTencentAvServiceIAVRedPacketCallback.a(bool, this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_JavaLangString);
        if (bool) {
          localSharedPreferences.edit().putBoolean("res_exist", true).commit();
        }
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_ComTencentAvServiceIAVRedPacketCallback = null;
        return;
        bool = false;
        continue;
        label620:
        QLog.i("AVRedPacketConfigManger", 1, "convertMp3ToPcm dpc != 1 or is rubbish device");
        break label262;
        label631:
        if (this.jdField_b_of_type_Int != 2) {
          break label419;
        }
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.c = true;
        this.jdField_a_of_type_ComTencentAvRedpacketConfigAVRedPacketConfigManager.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          localRemoteException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jma
 * JD-Core Version:    0.7.0.1
 */