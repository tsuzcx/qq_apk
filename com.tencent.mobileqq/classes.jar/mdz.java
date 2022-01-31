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

public class mdz
  extends lij
{
  public mdz(AVActivity paramAVActivity) {}
  
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
        this.a.jdField_e_of_type_Int = this.a.jdField_a_of_type_ComTencentAvVideoController.a().z;
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
    if (this.a.jdField_a_of_type_Mjs != null) {
      this.a.jdField_a_of_type_Mjs.a(paramInt);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_Mjs != null) {
      this.a.jdField_a_of_type_Mjs.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(long paramLong)
  {
    AudioHelper.b(this.a.jdField_b_of_type_JavaLangString + ".onConnected");
    lid locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    lkx.a(31);
    String str1 = locallid.jdField_d_of_type_JavaLangString;
    String str2 = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onConnected, mVideoLayerUI[");
    label208:
    label229:
    boolean bool2;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      bool1 = true;
      QLog.w(str2, 1, bool1 + "], peerUin[" + str1 + "], mShutCamera[" + this.a.f + "], SessionType[" + locallid.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.v();
      }
      if ((locallid.jdField_d_of_type_Int != 2) && (locallid.jdField_d_of_type_Int != 4)) {
        break label575;
      }
      this.a.b(false);
      this.a.f(false);
      if (locallid.jdField_d_of_type_Int == 2)
      {
        if (this.a.f) {
          break label594;
        }
        bool1 = true;
        locallid.a(paramLong, bool1);
        if (this.a.f) {
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          str1 = locallid.jdField_d_of_type_JavaLangString;
          bool2 = locallid.k;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
            break label599;
          }
        }
      }
    }
    label575:
    label594:
    label599:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, bool2, false, bool1);
      if (locallid.jdField_d_of_type_Int == 1) {
        locallid.a(paramLong, false);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramLong);
      this.a.g(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.c();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramLong);
        if ((2 == locallid.jdField_d_of_type_Int) || (this.a.g)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onConnected");
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.M();
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      loc.a().c();
      mlf.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 4, 0);
      this.a.a(paramLong, 2000L);
      if (this.a.jdField_a_of_type_Mpe != null) {
        this.a.jdField_a_of_type_Mpe.a();
      }
      return;
      bool1 = false;
      break;
      this.a.b(true);
      this.a.f(true);
      break label208;
      bool1 = false;
      break label229;
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
    if ((paramString != null) && (!mww.a(paramString, this.a.c))) {
      return;
    }
    if ((paramInt == 49) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().B) && (this.a.jdField_a_of_type_Mlf != null)) {
      this.a.jdField_a_of_type_Mlf.c();
    }
    if ((this.a.jdField_a_of_type_Men != null) && (this.a.jdField_a_of_type_Men.a())) {
      this.a.jdField_a_of_type_Men.f();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramInt);
    }
    lek.c(this.a.jdField_b_of_type_JavaLangString, "DataReport onClose: ");
    lku.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    llt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    ljt.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    mem.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    moi.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
    azmb.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString) + "";
    ljx.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    ljx.a(2, paramString);
    ljx.a(2);
    this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong, this.a, 3, 2);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a.jdField_a_of_type_Mjs != null) {
      this.a.jdField_a_of_type_Mjs.a(paramLong1, paramLong2, paramLong3);
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
    if ((paramEmShareState.E != paramInt2) || (paramEmShareState.jdField_g_of_type_Long != paramLong) || (paramEmShareState.jdField_C_of_type_Int != paramInt3))
    {
      QLog.i("AVShare", 1, "onShareStateChange, not same session");
      return;
    }
    if (paramInt1 == 1)
    {
      if (paramEmShareState.a != VideoConstants.EmShareState.START_FAIL) {
        break label238;
      }
      mls localmls = this.a.a();
      if (localmls != null) {
        localmls.a(4);
      }
    }
    for (;;)
    {
      if (paramEmShareState.a == VideoConstants.EmShareState.STOP_SUC) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.z(l);
      }
      this.a.runOnUiThread(new AVActivity.MyVideoObserver.1(this));
      return;
      label238:
      if (paramEmShareState.a == VideoConstants.EmShareState.START_SUC)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.y(l);
        mww.a("0x800AD8F");
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
    lid locallid;
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
          locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          lek.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mPeerUin[" + this.a.c + "], mIsDoubleVideoMeeting[" + this.a.g + "], mSessionType[" + this.a.jdField_b_of_type_Int + "], mSessionId[" + this.a.jdField_a_of_type_JavaLangString + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], seq[" + l + "], \nsession[" + locallid + "]");
          if ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2)) {
            break;
          }
          if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
          {
            this.a.jdField_e_of_type_Boolean = paramBoolean;
            lek.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 1");
            this.a.finish();
            this.a.b(true);
            if (paramBoolean) {
              break label349;
            }
            i = mbt.a(locallid.K);
            this.a.overridePendingTransition(0, i);
          }
          while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
          {
            paramString = bdiv.a(this.a.getApplicationContext()).edit();
            paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
            paramString.commit();
            mtq.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
            return;
            this.a.overridePendingTransition(0, 2130772165);
          }
        }
      } while ((this.a.jdField_b_of_type_Int != 3) && (this.a.jdField_b_of_type_Int != 4));
      str = this.a.jdField_d_of_type_JavaLangString;
    } while (((str == null) || (paramString == null) || (!str.equals(paramString))) && ((!this.a.g) || (!TextUtils.equals(this.a.c, paramString))));
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    lek.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 2");
    this.a.b(l);
    this.a.h = true;
    this.a.finish();
    this.a.b(true);
    if (!paramBoolean)
    {
      i = mbt.a(locallid.K);
      this.a.overridePendingTransition(0, i);
      return;
    }
    this.a.overridePendingTransition(0, 2130772165);
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
    if (this.a.jdField_a_of_type_Mjs != null) {
      this.a.jdField_a_of_type_Mjs.a(paramBoolean, paramInt1, paramString, paramInt2);
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
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      bool = true;
      QLog.w(str, 1, bool + "], isResume[" + this.a.isResume() + "], seq[" + paramLong + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
      }
      AVActivity.a(this.a);
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.isResume()))
      {
        str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
          break label330;
        }
      }
    }
    label330:
    for (boolean bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str, 1, true, false, bool);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, false);
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.g))) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, "onResumeVideo");
      }
      if (this.a.jdField_a_of_type_Mof != null) {
        this.a.jdField_a_of_type_Mof.b();
      }
      if (this.a.jdField_a_of_type_Mpe != null) {
        this.a.jdField_a_of_type_Mpe.a();
      }
      return;
      bool = false;
      break;
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
      mwk.a().a(paramLong, "DEVICE_SPEAKERPHONE");
    }
    if ((this.a.jdField_a_of_type_Mlf != null) && (this.a.jdField_a_of_type_Mlf.d() != 1)) {
      this.a.jdField_a_of_type_Mlf.m();
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
    lek.d(this.a.jdField_b_of_type_JavaLangString, "onFinish peerUin = " + paramString + " # isQuit :" + paramBoolean + "|" + this.a.jdField_b_of_type_Int + "|" + this.a.c);
    if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 2)) {
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        this.a.jdField_e_of_type_Boolean = paramBoolean;
        this.a.finish();
        if (paramBoolean) {
          break label261;
        }
        int j = 2130772136;
        int i = j;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          i = j;
          if (paramString != null) {
            i = mbt.a(paramString.K);
          }
        }
        this.a.overridePendingTransition(0, i);
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        paramString = bdiv.a(this.a.getApplicationContext()).edit();
        paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
        paramString.commit();
        mtq.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.g());
      }
      return;
      label261:
      this.a.overridePendingTransition(0, 2130772165);
    }
  }
  
  protected void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, begin, seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label459:
    label464:
    label480:
    for (;;)
    {
      return;
      lid locallid = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      boolean bool1;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        String str = locallid.jdField_d_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
          break label459;
        }
        bool1 = true;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, str, 1, false, false, bool1);
        if (!locallid.q()) {
          this.a.a(1, false);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(l, 65535);
      }
      if (this.a.jdField_a_of_type_Mjs != null) {
        this.a.jdField_a_of_type_Mjs.c();
      }
      if (this.a.jdField_a_of_type_Mof != null) {
        this.a.jdField_a_of_type_Mof.b();
      }
      boolean bool5;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_Mlf != null) && (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null))
      {
        bool1 = locallid.t;
        boolean bool2 = this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(l);
        boolean bool3 = locallid.k;
        boolean bool4 = locallid.B;
        bool5 = locallid.jdField_C_of_type_Boolean;
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onPauseVideo, hangup[" + bool1 + "], cameraOpen[" + bool2 + "], remoteHasVideo[" + bool3 + "], recording[" + bool4 + "], recordedByOther[" + bool5 + "]");
        if ((bool1) || (!bool3))
        {
          if (!bool4) {
            break label464;
          }
          this.a.jdField_a_of_type_Mlf.c();
          this.a.jdField_a_of_type_ComTencentAvVideoController.F();
          if (!bool1)
          {
            mqj.a("0X8008ACB");
            if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              mdd.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1023, 2131696226);
            }
          }
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Mpe == null) {
          break label480;
        }
        this.a.jdField_a_of_type_Mpe.a();
        return;
        bool1 = false;
        break;
        if (bool5) {
          this.a.jdField_a_of_type_Mlf.m();
        }
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = bdyi.a();
    String str = bdyi.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (str == null) {}
    do
    {
      return;
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.a.jdField_b_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.w();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bdyi.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        if (!bdyi.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_Bdyo, paramInt, false)) {}
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
    boolean bool;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().k))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) == 5)
      {
        paramBoolean = true;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString, paramBoolean);
      }
    }
    else
    {
      mlf.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.a().B;
        bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_C_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal, recording=" + paramBoolean + ", beenRecorded=" + bool);
        }
        if (!paramBoolean) {
          break label318;
        }
        if (this.a.jdField_a_of_type_Mlf != null) {
          this.a.jdField_a_of_type_Mlf.c();
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.F();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().A = false;
      if (this.a.jdField_a_of_type_Mlf != null) {
        this.a.jdField_a_of_type_Mlf.n();
      }
      return;
      paramBoolean = false;
      break;
      label318:
      if ((bool) && (this.a.jdField_a_of_type_Meu != null)) {
        this.a.jdField_a_of_type_Meu.a("self", String.valueOf(3));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdz
 * JD-Core Version:    0.7.0.1
 */