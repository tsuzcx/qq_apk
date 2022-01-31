import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class mbz
  extends lij
{
  mbz(mbw parammbw) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onConnected, seq[" + paramLong + "]");
    }
    lkx.a(32);
    if (this.a.jdField_a_of_type_Mcb != null) {
      this.a.jdField_a_of_type_Mcb.v();
    }
    Object localObject;
    boolean bool2;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_c_of_type_Boolean) {
        break label347;
      }
      bool1 = true;
      ((lid)localObject).a(paramLong, bool1);
      if (this.a.jdField_c_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      }
      if (this.a.jdField_a_of_type_Mcb != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        bool2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().k;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
          break label352;
        }
      }
    }
    label347:
    label352:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.a.jdField_a_of_type_Mcb.a((String)localObject, 1, bool2, false, bool1);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, false);
      }
      if (this.a.jdField_a_of_type_Mcb != null) {
        this.a.jdField_a_of_type_Mcb.a(0, 0, true);
      }
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.c();
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      mlf.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onDetectNoDevicePermission, DeviceType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.a.jdField_a_of_type_Meu.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      paramLong = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, 1);
      if (paramInt != -1) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.remove(paramInt);
    synchronized (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
    {
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().b(paramLong, 1);
      if (paramInt == -1) {
        return;
      }
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], seq[" + paramLong + "]");
    }
    if (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, false);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label195;
      }
    }
    label195:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_Mcb.a(paramString, 1, false, false, bool);
      this.a.jdField_a_of_type_Mcb.a(false, false);
      this.a.jdField_a_of_type_Mcb.s_();
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
    if ((this.a.jdField_a_of_type_Mcb != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.a.jdField_a_of_type_Mcb.a(0, 0, true);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.a.a(paramInt);
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
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.MyVideoObserver.1(this, paramString, paramBoolean), 1500L);
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
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramInt);
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onResumeVideo, seq[" + paramLong + "]");
    }
    String str;
    if (this.a.jdField_a_of_type_Mcb != null)
    {
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label135;
      }
    }
    label135:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_Mcb.a(str, 1, true, false, bool);
      this.a.jdField_a_of_type_Mcb.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
      return;
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (paramInt != this.a.jdField_a_of_type_ComTencentAvVideoController.a().R) {
      QLog.d("SmallScreenVideoController", 1, "setGlassWaitTime nTime=" + paramInt + ", mCurrentVideoGlassWaitTime=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().R);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().R = paramInt;
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "peerUin = " + paramString + " # isQuit :" + paramBoolean);
    }
    if ((this.a.jdField_c_of_type_Int == 1) || (this.a.jdField_c_of_type_Int == 2))
    {
      if ((this.a.jdField_a_of_type_JavaLangString != null) && (paramString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.b = paramBoolean;
        this.a.d();
      }
      if (this.a.jdField_a_of_type_Mcb != null)
      {
        paramString = bdne.a(this.a.jdField_a_of_type_AndroidContentContext).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_Mcb.g());
        paramString.commit();
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
    mbw.a(localSmallScreenRelativeLayout);
  }
  
  protected void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onPauseVideo, seq[" + l + "]");
    }
    String str;
    if (this.a.jdField_a_of_type_Mcb != null)
    {
      mbw.a(this.a, 1);
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label193;
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_Mcb.a(str, 1, false, false, bool);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l, true);
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().H == 3) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 0;
        }
      }
      return;
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = becr.a();
    Object localObject = becr.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (localObject == null) {}
    do
    {
      return;
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().g != 4) && (this.a.jdField_c_of_type_Int == 1) && (this.a.jdField_a_of_type_Mcb != null)) {
        this.a.jdField_a_of_type_Mcb.w();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramString, paramBoolean);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if ((this.a.jdField_a_of_type_Mcb != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString) != 5) {
        break label118;
      }
    }
    label118:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.a.jdField_a_of_type_Mcb.a(paramString, paramBoolean);
      mlf.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.r();
    }
  }
  
  protected void e()
  {
    super.e();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.s();
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRequestVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 2;
    this.a.b();
  }
  
  public void f(String paramString)
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenVideoController", 1, "onAcceptVideoMode, fromUin[" + paramString + "], seq[" + l + "]");
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 3;
    this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l);
    if (this.a.jdField_a_of_type_Mcb != null)
    {
      this.a.jdField_a_of_type_Mcb.a(true, false);
      this.a.jdField_a_of_type_Mcb.c(l, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 0;
  }
  
  protected void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onCancelVideoMode fromUin = " + paramString);
    }
    super.h(paramString);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().H = 0;
  }
  
  protected void i()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.d();
    }
  }
  
  protected void j()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mbz
 * JD-Core Version:    0.7.0.1
 */