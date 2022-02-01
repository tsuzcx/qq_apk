import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.VideoConstants.EmShareState;
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

public class mbb
  extends lfe
{
  public mbb(AVActivity paramAVActivity) {}
  
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
    if (this.a.jdField_a_of_type_Mgv != null) {
      this.a.jdField_a_of_type_Mgv.a(paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Mgv != null) {
      this.a.jdField_a_of_type_Mgv.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(long paramLong)
  {
    AudioHelper.b(this.a.jdField_b_of_type_JavaLangString + ".onConnected");
    ley localley = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    lhu.a(31);
    String str1 = localley.jdField_d_of_type_JavaLangString;
    String str2 = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onConnected, mVideoLayerUI[");
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      bool = true;
      QLog.w(str2, 1, bool + "], peerUin[" + str1 + "], mShutCamera[" + this.a.f + "], SessionType[" + localley.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.v();
      }
      if ((localley.jdField_d_of_type_Int != 2) && (localley.jdField_d_of_type_Int != 4)) {
        break label554;
      }
      this.a.b(false);
      this.a.f(false);
    }
    for (;;)
    {
      if (localley.jdField_d_of_type_Int == 2)
      {
        if (this.a.f)
        {
          localley.a(paramLong, false);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          str1 = localley.jdField_d_of_type_JavaLangString;
          bool = localley.k;
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, bool, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        }
      }
      if (localley.jdField_d_of_type_Int == 1) {
        localley.a(paramLong, false);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramLong);
      this.a.g(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.c();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramLong);
        if ((2 == localley.jdField_d_of_type_Int) || (this.a.g)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onConnected");
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.M();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      lkz.a().c();
      mih.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 4, 0);
      this.a.a(paramLong, 2000L);
      if (this.a.jdField_a_of_type_Mmj != null) {
        this.a.jdField_a_of_type_Mmj.a();
      }
      return;
      bool = false;
      break;
      label554:
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
    if ((paramString != null) && (!mue.a(paramString, this.a.c))) {
      return;
    }
    if ((paramInt == 49) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.a.jdField_a_of_type_Mih != null)) {
      this.a.jdField_a_of_type_Mih.c();
    }
    if ((this.a.jdField_a_of_type_Mbq != null) && (this.a.jdField_a_of_type_Mbq.a())) {
      this.a.jdField_a_of_type_Mbq.f();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramInt);
    }
    lbc.c(this.a.jdField_b_of_type_JavaLangString, "DataReport onClose: ");
    lhq.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    liq.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    lgo.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    mbp.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    mll.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
    bcsl.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    lgs.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    lgs.a(2, paramString);
    lgs.a(2);
    this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_Mgv != null) {
      this.a.jdField_a_of_type_Mgv.a(paramLong1, paramLong2, paramLong3);
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
  
  @TargetApi(21)
  public void a(VideoConstants.EmShareState paramEmShareState, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 2, "onShareStateChange, shareState[" + paramEmShareState + "], shareType[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong + "], multiAvType[" + paramInt3 + "], seq[" + l + "]");
    }
    paramEmShareState = this.a.jdField_a_of_type_ComTencentAvVideoController;
    if (paramEmShareState == null)
    {
      QLog.i("AVShare", 1, "onShareStateChange, ctrl is null.");
      return;
    }
    paramEmShareState = paramEmShareState.a();
    if ((paramEmShareState.F != paramInt2) || (paramEmShareState.jdField_g_of_type_Long != paramLong))
    {
      QLog.i("AVShare", 1, "onShareStateChange, not same session");
      return;
    }
    if (paramInt1 == 1)
    {
      if (paramEmShareState.a != VideoConstants.EmShareState.START_FAIL) {
        break label229;
      }
      miu localmiu = this.a.a();
      if (localmiu != null) {
        localmiu.a(3);
      }
    }
    for (;;)
    {
      if (paramEmShareState.a == VideoConstants.EmShareState.STOP_SUC) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l);
      }
      this.a.runOnUiThread(new AVActivity.MyVideoObserver.1(this));
      return;
      label229:
      if (paramEmShareState.a == VideoConstants.EmShareState.START_SUC)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l);
        mue.a("0X800AD8F");
      }
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
    ley localley;
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
          localley = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          lbc.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.a.c + "], mIsDoubleVideoMeeting[" + this.a.g + "], mSessionType[" + this.a.jdField_b_of_type_Int + "], mSessionId[" + this.a.jdField_a_of_type_JavaLangString + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], seq[" + l + "], \nsession[" + localley + "]");
          if ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2)) {
            break;
          }
          if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
          {
            this.a.jdField_e_of_type_Boolean = paramBoolean;
            lbc.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 1");
            this.a.finish();
            this.a.b(true);
            if (paramBoolean) {
              break label349;
            }
            i = lyu.a(localley.L);
            this.a.overridePendingTransition(0, i);
          }
          while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
          {
            paramString = bgsg.a(this.a.getApplicationContext()).edit();
            paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
            paramString.commit();
            mqw.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
            return;
            this.a.overridePendingTransition(0, 2130772169);
          }
        }
      } while ((this.a.jdField_b_of_type_Int != 3) && (this.a.jdField_b_of_type_Int != 4));
      str = this.a.jdField_d_of_type_JavaLangString;
    } while (((str == null) || (paramString == null) || (!str.equals(paramString))) && ((!this.a.g) || (!TextUtils.equals(this.a.c, paramString))));
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    lbc.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 2");
    this.a.b(l);
    this.a.h = true;
    this.a.finish();
    this.a.b(true);
    if (!paramBoolean)
    {
      i = lyu.a(localley.L);
      this.a.overridePendingTransition(0, i);
      return;
    }
    this.a.overridePendingTransition(0, 2130772169);
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
    if (this.a.jdField_a_of_type_Mgv != null) {
      this.a.jdField_a_of_type_Mgv.a(paramBoolean, paramInt1, paramString, paramInt2);
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
      if (this.a.jdField_a_of_type_Mli != null) {
        this.a.jdField_a_of_type_Mli.b();
      }
      if (this.a.jdField_a_of_type_Mmj != null) {
        this.a.jdField_a_of_type_Mmj.a();
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
      mts.a().a(paramLong, "DEVICE_SPEAKERPHONE");
    }
    if ((this.a.jdField_a_of_type_Mih != null) && (this.a.jdField_a_of_type_Mih.d() != 1)) {
      this.a.jdField_a_of_type_Mih.m();
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
    lbc.d(this.a.jdField_b_of_type_JavaLangString, "onFinish peerUin = " + paramString + " # isQuit :" + paramBoolean + "|" + this.a.jdField_b_of_type_Int + "|" + this.a.c);
    if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 2)) {
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        this.a.jdField_e_of_type_Boolean = paramBoolean;
        this.a.finish();
        if (paramBoolean) {
          break label261;
        }
        int j = 2130772140;
        int i = j;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          i = j;
          if (paramString != null) {
            i = lyu.a(paramString.L);
          }
        }
        this.a.overridePendingTransition(0, i);
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = bgsg.a(this.a.getApplicationContext()).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
        paramString.commit();
        mqw.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
      }
      return;
      label261:
      this.a.overridePendingTransition(0, 2130772169);
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
      ley localley = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        String str = localley.jdField_d_of_type_JavaLangString;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, str, 1, false, false, this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c));
        if (!localley.r()) {
          this.a.a(1, false);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l, 65535);
      }
      if (this.a.jdField_a_of_type_Mgv != null) {
        this.a.jdField_a_of_type_Mgv.c();
      }
      if (this.a.jdField_a_of_type_Mli != null) {
        this.a.jdField_a_of_type_Mli.b();
      }
      boolean bool5;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_Mih != null) && (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null))
      {
        boolean bool1 = localley.t;
        boolean bool2 = this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l);
        boolean bool3 = localley.k;
        boolean bool4 = localley.B;
        bool5 = localley.C;
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, hangup[" + bool1 + "], cameraOpen[" + bool2 + "], remoteHasVideo[" + bool3 + "], recording[" + bool4 + "], recordedByOther[" + bool5 + "]");
        if ((bool1) || (!bool3))
        {
          if (!bool4) {
            break label452;
          }
          this.a.jdField_a_of_type_Mih.c();
          this.a.jdField_a_of_type_ComTencentAvVideoController.F();
          if (!bool1)
          {
            mno.a("0X8008ACB");
            if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              maf.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131695108);
            }
          }
        }
      }
      while (this.a.jdField_a_of_type_Mmj != null)
      {
        this.a.jdField_a_of_type_Mmj.a();
        return;
        label452:
        if (bool5) {
          this.a.jdField_a_of_type_Mih.m();
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
        i = bhjt.a();
        str = bhjt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
      } while (str == null);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.a.jdField_b_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bhjt.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        if (!bhjt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_Bhjz, paramInt, false)) {}
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
    mih.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
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
      if (this.a.jdField_a_of_type_Mih != null) {
        this.a.jdField_a_of_type_Mih.c();
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.F();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_A_of_type_Boolean = false;
      if (this.a.jdField_a_of_type_Mih != null) {
        this.a.jdField_a_of_type_Mih.n();
      }
      return;
      label308:
      if ((bool) && (this.a.jdField_a_of_type_Mbx != null)) {
        this.a.jdField_a_of_type_Mbx.a("self", String.valueOf(3));
      }
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.C();
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
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.D();
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
 * Qualified Name:     mbb
 * JD-Core Version:    0.7.0.1
 */