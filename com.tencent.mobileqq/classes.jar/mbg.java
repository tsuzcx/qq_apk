import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVActivity.MyVideoObserver.1;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class mbg
  extends lff
{
  public mbg(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    super.a();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o();
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (this.a.c != null) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_d_of_type_Int, this.a.c, this.a.i);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.a.jdField_e_of_type_Int = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Int;
        this.a.m = this.a.jdField_a_of_type_ComTencentAvVideoController.a().p;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "setBindInfo: mBindType = " + this.a.jdField_e_of_type_Int + ",mBindId = " + this.a.m);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_e_of_type_Int, this.a.m);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      AVActivity.b(this.a);
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Mha != null) {
      this.a.jdField_a_of_type_Mha.a(paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Mha != null) {
      this.a.jdField_a_of_type_Mha.a(paramInt1, paramInt2);
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 2, "onShareStateChange, shareState[" + paramInt1 + "], shareType[" + paramInt2 + "], relationType[" + paramInt3 + "], relationId[" + paramLong + "], multiAvType[" + paramInt4 + "], seq[" + l + "]");
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject == null)
    {
      QLog.i("AVShare", 1, "onShareStateChange, ctrl is null.");
      return;
    }
    localObject = ((VideoController)localObject).a();
    if ((((lez)localObject).F != paramInt3) || (((lez)localObject).jdField_g_of_type_Long != paramLong))
    {
      QLog.i("AVShare", 1, "onShareStateChange, not same session");
      return;
    }
    if (paramInt2 == 1)
    {
      if (((lez)localObject).ae != 3) {
        break label224;
      }
      miz localmiz = this.a.a();
      if (localmiz != null) {
        localmiz.a(3);
      }
    }
    for (;;)
    {
      if (((lez)localObject).ae == 5) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l);
      }
      this.a.runOnUiThread(new AVActivity.MyVideoObserver.1(this));
      return;
      label224:
      if (((lez)localObject).ae == 2)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l);
        mum.a("0X800AD8F");
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(long paramLong)
  {
    AudioHelper.b(this.a.jdField_b_of_type_JavaLangString + ".onConnected");
    lez locallez = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    lhw.a(31);
    String str1 = locallez.jdField_d_of_type_JavaLangString;
    String str2 = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onConnected, mVideoLayerUI[");
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      bool = true;
      QLog.w(str2, 1, bool + "], peerUin[" + str1 + "], mShutCamera[" + this.a.f + "], SessionType[" + locallez.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.v();
      }
      if ((locallez.jdField_d_of_type_Int != 2) && (locallez.jdField_d_of_type_Int != 4)) {
        break label555;
      }
      this.a.b(false);
      this.a.f(false);
    }
    for (;;)
    {
      if (locallez.jdField_d_of_type_Int == 2)
      {
        if (this.a.f)
        {
          locallez.a(paramLong, false);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          str1 = locallez.jdField_d_of_type_JavaLangString;
          bool = locallez.k;
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, bool, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        }
      }
      if (locallez.jdField_d_of_type_Int == 1) {
        locallez.a(paramLong, false);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramLong);
      this.a.g(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.b();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramLong);
        if ((2 == locallez.jdField_d_of_type_Int) || (this.a.g)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onConnected");
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.N();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      llf.a().c();
      mim.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 4, 0);
      this.a.a(paramLong, 2000L);
      if (this.a.jdField_a_of_type_Mmp != null) {
        this.a.jdField_a_of_type_Mmp.a();
      }
      return;
      bool = false;
      break;
      label555:
      this.a.b(true);
      this.a.f(true);
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, paramInt);
    }
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a("AVnotify", paramLong, paramInt1, paramInt2);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], mPeerUin[" + this.a.c + "], seq[" + paramLong + "]");
    if ((paramString != null) && (!mum.a(paramString, this.a.c))) {
      return;
    }
    if ((paramInt == 49) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.a.jdField_a_of_type_Mim != null)) {
      this.a.jdField_a_of_type_Mim.c();
    }
    if ((this.a.jdField_a_of_type_Mbv != null) && (this.a.jdField_a_of_type_Mbv.a())) {
      this.a.jdField_a_of_type_Mbv.f();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramInt);
    }
    lba.f(this.a.jdField_b_of_type_JavaLangString, "DataReport onClose: ");
    lhs.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    lis.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    lgq.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    mbu.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    mlr.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
    bcdx.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    lgu.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    lgu.a(2, paramString);
    lgu.a(2);
    this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_Mha != null) {
      this.a.jdField_a_of_type_Mha.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramString, paramBoolean);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, paramBoolean);
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.a.g(-1033L);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      if ((i == 1) || (i == 2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j(2);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(true);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.j(1);
  }
  
  protected void a(String paramString)
  {
    AVActivity.a(this.a, paramString);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onGroundGlassSwitch, fromUin[" + paramString + "], nOff[" + paramInt + "], mSessionType[" + this.a.jdField_b_of_type_Int + "]");
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
    }
  }
  
  protected void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    int i = 2;
    int m = (int)(0x3 & paramLong);
    int j = (int)(paramLong >> 4 & 0x7);
    int k = (int)(paramLong >> 7 & 0x7);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, String.format("onNetLevel_S2C, peerUin[%s], level[%s], detail[%s], netLevel[%s], s2cSelfNetLevel[%s], s2cPeerNetLevel[%s]", new Object[] { paramString, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      switch (m)
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      paramString = null;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(i, j, k, paramString);
      return;
      i = 3;
      continue;
      i = 1;
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if ((this.a.jdField_d_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramString2);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    long l;
    lez locallez;
    int i;
    label349:
    String str;
    do
    {
      do
      {
        for (;;)
        {
          return;
          l = AudioHelper.b();
          locallez = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          lba.g(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.a.c + "], mIsDoubleVideoMeeting[" + this.a.g + "], mSessionType[" + this.a.jdField_b_of_type_Int + "], mSessionId[" + this.a.jdField_a_of_type_JavaLangString + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], seq[" + l + "], \nsession[" + locallez + "]");
          if ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2)) {
            break;
          }
          if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
          {
            this.a.jdField_e_of_type_Boolean = paramBoolean;
            lba.g(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 1");
            this.a.finish();
            this.a.b(true);
            if (paramBoolean) {
              break label349;
            }
            i = lzb.a(locallez.L);
            this.a.overridePendingTransition(0, i);
          }
          while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
          {
            paramString = bfyz.a(this.a.getApplicationContext()).edit();
            paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
            paramString.commit();
            mrd.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
            return;
            this.a.overridePendingTransition(0, 2130772177);
          }
        }
      } while ((this.a.jdField_b_of_type_Int != 3) && (this.a.jdField_b_of_type_Int != 4));
      str = this.a.jdField_d_of_type_JavaLangString;
    } while (((str == null) || (paramString == null) || (!str.equals(paramString))) && ((!this.a.g) || (!TextUtils.equals(this.a.c, paramString))));
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    lba.g(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 2");
    this.a.b(l);
    this.a.h = true;
    this.a.finish();
    this.a.b(true);
    if (!paramBoolean)
    {
      i = lzb.a(locallez.L);
      this.a.overridePendingTransition(0, i);
      return;
    }
    this.a.overridePendingTransition(0, 2130772177);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Mha != null) {
      this.a.jdField_a_of_type_Mha.a(paramBoolean, paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramBoolean1, paramBoolean2);
    }
  }
  
  @TargetApi(17)
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRecvAudioFrame=" + paramArrayOfByte.length + ", type=" + paramInt1 + ", size=" + paramInt2);
    }
  }
  
  protected void b()
  {
    super.b();
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
      if (paramInt == 0) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(true);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(false);
  }
  
  protected void b(long paramLong)
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onResumeVideo, mIsDoubleVideoMeeting[").append(this.a.g).append("], mVideoLayerUI[");
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], isResume[" + this.a.isResume() + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
      }
      AVActivity.a(this.a);
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.isResume()))
      {
        str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, 1, true, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, false);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.g))) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onResumeVideo");
      }
      if (this.a.jdField_a_of_type_Mlo != null) {
        this.a.jdField_a_of_type_Mlo.b();
      }
      if (this.a.jdField_a_of_type_Mmp != null) {
        this.a.jdField_a_of_type_Mmp.a();
      }
      return;
    }
  }
  
  protected void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onCloseSessionFinished, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    if (paramString.equals(this.a.c)) {
      mua.a().a(paramLong, "DEVICE_SPEAKERPHONE");
    }
    if ((this.a.jdField_a_of_type_Mim != null) && (this.a.jdField_a_of_type_Mim.d() != 1)) {
      this.a.jdField_a_of_type_Mim.m();
    }
  }
  
  protected void b(String paramString)
  {
    AVActivity.a(this.a, paramString);
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGroundGlassWaitTimeChange : nTime=" + paramInt);
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramInt);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    lba.g(this.a.jdField_b_of_type_JavaLangString, "onFinish peerUin = " + paramString + " # isQuit :" + paramBoolean + "|" + this.a.jdField_b_of_type_Int + "|" + this.a.c);
    if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 2)) {
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        this.a.jdField_e_of_type_Boolean = paramBoolean;
        this.a.finish();
        if (paramBoolean) {
          break label261;
        }
        int j = 2130772148;
        int i = j;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          i = j;
          if (paramString != null) {
            i = lzb.a(paramString.L);
          }
        }
        this.a.overridePendingTransition(0, i);
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = bfyz.a(this.a.getApplicationContext()).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
        paramString.commit();
        mrd.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
      }
      return;
      label261:
      this.a.overridePendingTransition(0, 2130772177);
    }
  }
  
  protected void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, begin, seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    for (;;)
    {
      return;
      lez locallez = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        String str = locallez.jdField_d_of_type_JavaLangString;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, str, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        if (!locallez.r()) {
          this.a.a(1, false);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l, 65535);
      }
      if (this.a.jdField_a_of_type_Mha != null) {
        this.a.jdField_a_of_type_Mha.c();
      }
      if (this.a.jdField_a_of_type_Mlo != null) {
        this.a.jdField_a_of_type_Mlo.b();
      }
      boolean bool5;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_Mim != null) && (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null))
      {
        boolean bool1 = locallez.t;
        boolean bool2 = this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l);
        boolean bool3 = locallez.k;
        boolean bool4 = locallez.B;
        bool5 = locallez.C;
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, hangup[" + bool1 + "], cameraOpen[" + bool2 + "], remoteHasVideo[" + bool3 + "], recording[" + bool4 + "], recordedByOther[" + bool5 + "]");
        if ((bool1) || (!bool3))
        {
          if (!bool4) {
            break label452;
          }
          this.a.jdField_a_of_type_Mim.c();
          this.a.jdField_a_of_type_ComTencentAvVideoController.E();
          if (!bool1)
          {
            mnu.a("0X8008ACB");
            if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              mak.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695290);
            }
          }
        }
      }
      while (this.a.jdField_a_of_type_Mmp != null)
      {
        this.a.jdField_a_of_type_Mmp.a();
        return;
        label452:
        if (bool5) {
          this.a.jdField_a_of_type_Mim.m();
        }
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    if (this.a.isDestroyed()) {}
    do
    {
      int i;
      String str;
      do
      {
        return;
        i = bgqr.a();
        str = bgqr.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
      } while (str == null);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.a.jdField_b_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bgqr.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        if (!bgqr.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_Bgqx, paramInt, false)) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2);
    }
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString);
    }
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal, bStartSwitch[" + paramBoolean + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBoolean);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString, paramBoolean);
    }
    mim.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.a().B;
      bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().C;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal, recording=" + paramBoolean + ", beenRecorded=" + bool);
      }
      if (!paramBoolean) {
        break label308;
      }
      if (this.a.jdField_a_of_type_Mim != null) {
        this.a.jdField_a_of_type_Mim.c();
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.E();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean = false;
      if (this.a.jdField_a_of_type_Mim != null) {
        this.a.jdField_a_of_type_Mim.n();
      }
      return;
      label308:
      if ((bool) && (this.a.jdField_a_of_type_Mcc != null)) {
        this.a.jdField_a_of_type_Mcc.a("self", String.valueOf(3));
      }
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.D();
    }
  }
  
  protected void d(String paramString)
  {
    if ((this.a.jdField_d_of_type_Int == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString);
    }
    super.d(paramString);
  }
  
  protected void e()
  {
    super.e();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.E();
    }
  }
  
  protected void f()
  {
    super.f();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j();
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onNeedShowPeerVideo, mIsDoubleVideoMeeting[" + this.a.g + "], mPeerUin" + this.a.c + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
    }
  }
  
  protected void i()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.t();
    }
  }
  
  protected void j()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mbg
 * JD-Core Version:    0.7.0.1
 */