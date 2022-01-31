import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.VideoInviteFloatBar;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

public class jvh
  extends VideoObserver
{
  public jvh(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if ((this.a.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_c_of_type_JavaLangString.equals(paramString)))
    {
      this.a.a(paramInt);
      this.a.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onClose, reason:" + paramInt + ", peerUin:" + paramString + ", mPeerUin:" + this.a.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a();
    }
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onDestroyUI, peerUin:" + paramString + ", isQuit:" + paramBoolean + ", mPeerUin:" + this.a.jdField_c_of_type_JavaLangString);
    }
  }
  
  protected void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 1, "onConnected");
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.g();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.d == 1) {
      this.a.f = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    }
    TraeHelper.a().a(this.a.f);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvh
 * JD-Core Version:    0.7.0.1
 */