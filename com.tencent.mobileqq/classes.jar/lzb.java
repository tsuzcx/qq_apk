import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class lzb
  extends lfe
{
  lzb(lyy paramlyy) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onConnected, seq[" + paramLong + "]");
    }
    lhu.a(32);
    if (this.a.jdField_a_of_type_Lzd != null) {
      this.a.jdField_a_of_type_Lzd.v();
    }
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_c_of_type_Boolean) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      ((ley)localObject).a(paramLong, bool);
      if (this.a.jdField_c_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      }
      if (this.a.jdField_a_of_type_Lzd != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().k;
        this.a.jdField_a_of_type_Lzd.a((String)localObject, 1, bool, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 1) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, false);
      }
      if (this.a.jdField_a_of_type_Lzd != null) {
        this.a.jdField_a_of_type_Lzd.a(0, 0, true);
      }
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.c();
      }
      if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      mih.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      return;
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onDetectNoDevicePermission, DeviceType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if ((paramInt == 2) || (paramInt == 1))
    {
      this.a.jdField_a_of_type_Mbx.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
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
    if (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString)) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, false);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011)
      {
        this.a.jdField_a_of_type_Lzd.a(paramString, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
        this.a.jdField_a_of_type_Lzd.a(false, false);
        this.a.jdField_a_of_type_Lzd.w_();
      }
    } while (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null);
    this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c(paramInt);
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_Lzd != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null)) {
      this.a.jdField_a_of_type_Lzd.a(0, 0, true);
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
    if (this.a.jdField_a_of_type_Lzd != null)
    {
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      this.a.jdField_a_of_type_Lzd.a(str, 1, true, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
      this.a.jdField_a_of_type_Lzd.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (paramInt != this.a.jdField_a_of_type_ComTencentAvVideoController.a().S) {
      QLog.d("SmallScreenVideoController", 1, "setGlassWaitTime nTime=" + paramInt + ", mCurrentVideoGlassWaitTime=" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().S);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().S = paramInt;
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
      if (this.a.jdField_a_of_type_Lzd != null)
      {
        paramString = bgsg.a(this.a.jdField_a_of_type_AndroidContentContext).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_Lzd.g());
        paramString.commit();
      }
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 1, "WL_DEBUG showRedPacketFloatWinAni isSend = " + paramBoolean1 + ", show=" + paramBoolean2);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {}
    for (Object localObject = null;; localObject = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1))
    {
      if (localObject != null)
      {
        if (!paramBoolean2) {
          break;
        }
        this.a.a((ViewGroup)localObject, paramBoolean1);
      }
      return;
    }
    lyy.a((ViewGroup)localObject);
  }
  
  protected void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onPauseVideo, seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_Lzd != null)
    {
      lyy.a(this.a, 1);
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      this.a.jdField_a_of_type_Lzd.a(str, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString));
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 1011) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
    {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l, true);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().I == 3) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 0;
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = bhjt.a();
    Object localObject = bhjt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (localObject == null) {}
    do
    {
      return;
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().g != 4) && (this.a.jdField_c_of_type_Int == 1) && (this.a.jdField_a_of_type_Lzd != null)) {
        this.a.jdField_a_of_type_Lzd.w();
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
    if ((this.a.jdField_a_of_type_Lzd != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Lzd.a(paramString, paramBoolean);
    }
    mih.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
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
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 2;
    this.a.b();
  }
  
  public void f(String paramString)
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenVideoController", 1, "onAcceptVideoMode, fromUin[" + paramString + "], seq[" + l + "]");
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 3;
    this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l);
    if (this.a.jdField_a_of_type_Lzd != null)
    {
      this.a.jdField_a_of_type_Lzd.a(true, false);
      this.a.jdField_a_of_type_Lzd.c(l, this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 0;
  }
  
  protected void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onCancelVideoMode fromUin = " + paramString);
    }
    super.h(paramString);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().I = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzb
 * JD-Core Version:    0.7.0.1
 */