import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mei
  extends lgg
{
  mei(mef parammef) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onConnected, seq[" + paramLong + "]");
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.c();
    lyw.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramLong, false);
    if (this.a.jdField_a_of_type_Mki != null) {
      this.a.jdField_a_of_type_Mki.c();
    }
    if (this.a.jdField_a_of_type_Lga.d == 1) {
      this.a.f = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    }
    mtq.a().a(this.a.f);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if ((this.a.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_c_of_type_JavaLangString.equals(paramString)))
    {
      this.a.a(paramLong, paramInt);
      this.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.a.jdField_c_of_type_JavaLangString + "], seq[" + paramLong + "]");
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if (this.a.jdField_a_of_type_Mki != null) {
      this.a.jdField_a_of_type_Mki.a();
    }
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onDestroyUI, peerUin:" + paramString + ", isQuit:" + paramBoolean + ", mPeerUin:" + this.a.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mei
 * JD-Core Version:    0.7.0.1
 */