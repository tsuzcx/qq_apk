import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class jpa
  extends VideoObserver
{
  public jpa(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, String.format("onCrmIVRRequestAck, ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    super.a(paramInt1, paramInt2, paramString);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, String.format("onRecvCrmIVRPush, errorCode=%d seq=%d url=%s data=%s, roomId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, Long.valueOf(paramLong) }));
    }
    super.a(paramInt1, paramInt2, paramString1, paramString2, paramLong);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClose");
    }
    if (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString)) {
      return;
    }
    super.a(paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011)
    {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(false);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label154;
      }
    }
    label154:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(paramString, 1, false, false, bool);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b();
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c(paramInt);
      return;
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(0, 0, true);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.a.b(paramInt);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI isQuit = " + paramBoolean + ", mSessionType = " + this.a.jdField_c_of_type_Int);
    }
    super.a(paramString, paramBoolean);
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jpb(this, paramString, paramBoolean), 1500L);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = VipFunCallManager.a();
    Object localObject = VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (localObject == null) {}
    do
    {
      return;
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.a.jdField_c_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.m();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, String.format("onCrmIVRBeforeRequest, errorCode = %d, ivrRequestSeq = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.b(paramInt1, paramInt2);
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (paramInt != this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q) {
      QLog.d("SmallScreenVideoController", 1, "setGlassWaitTime nTime=" + paramInt + ", mCurrentVideoGlassWaitTime=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q = paramInt;
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "peerUin = " + paramString + " # isQuit :" + paramBoolean);
    }
    if ((this.a.jdField_c_of_type_Int == 1) || (this.a.jdField_c_of_type_Int == 2))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) {
        break label162;
      }
      this.a.d();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = false;
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
      {
        SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qav_SP", 0).edit();
        localEditor.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b());
        localEditor.commit();
      }
      super.b(paramString, paramBoolean);
      return;
      label162:
      if ((this.a.jdField_a_of_type_JavaLangString != null) && (paramString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.b = paramBoolean;
        this.a.d();
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 1, "WL_DEBUG showRedPacketFloatWinAni isSend = " + paramBoolean1 + ", show=" + paramBoolean2);
    }
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.b;
    if (localSmallScreenRelativeLayout != null)
    {
      if (paramBoolean2) {
        this.a.a(localSmallScreenRelativeLayout, paramBoolean1);
      }
    }
    else {
      return;
    }
    SmallScreenVideoController.a(localSmallScreenRelativeLayout);
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onConnected");
    }
    super.c();
    VideoNodeManager.a(32);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.l();
    }
    Object localObject;
    boolean bool2;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_c_of_type_Boolean) {
        break label315;
      }
      bool1 = true;
      ((SessionInfo)localObject).f = bool1;
      if (this.a.jdField_c_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        bool2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
          break label320;
        }
      }
    }
    label315:
    label320:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject, 1, bool2, false, bool1);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = false;
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(0, 0, true);
      }
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onDetectNoDevicePermission DeviceType = " + paramInt);
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
      long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
      if (paramInt != -1) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramString, paramBoolean);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label118;
      }
    }
    label118:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(paramString, paramBoolean);
      QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPauseVideo");
    }
    super.d();
    if (!VcSystemInfo.b()) {
      return;
    }
    String str;
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      SmallScreenVideoController.a(this.a, 1);
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label174;
      }
    }
    label174:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(str, 1, false, false, bool);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().i != 1011) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().f)) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(true);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().G != 3) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
      return;
    }
  }
  
  protected void d(int paramInt)
  {
    paramInt *= 1000;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e != paramInt)
    {
      QLog.e("SmallScreenVideoController", 1, "smallscreen onFpsChange|mVideoController.getSessionInfo().cameraFPS = " + this.a.jdField_a_of_type_ComTencentAvVideoController.a().e + ", nNewFps=" + paramInt);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().e = paramInt;
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().e);
    }
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onResumeVideo");
    }
    super.e();
    if (!VcSystemInfo.b()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().p) || (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI == null)) {
      return;
    }
    String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) == 5) {}
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(str, 1, true, false, bool);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
      return;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRequestVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 2;
    this.a.b();
  }
  
  protected void f()
  {
    super.f();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.t();
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 3;
    this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.f(this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.u();
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
  }
  
  protected void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onCancelVideoMode fromUin = " + paramString);
    }
    super.h(paramString);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().G = 0;
  }
  
  protected void k()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
    }
  }
  
  protected void l()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpa
 * JD-Core Version:    0.7.0.1
 */