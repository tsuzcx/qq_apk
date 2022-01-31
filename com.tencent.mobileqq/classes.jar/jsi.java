import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.av.ui.BeautyToolbar.DataReport;
import com.tencent.av.ui.ChildGuideUi;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VoiceChangeChooseDialog;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class jsi
  extends VideoObserver
{
  public jsi(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    super.a();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.u();
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l();
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (this.a.c != null) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.d, this.a.c, this.a.h);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.a.jdField_e_of_type_Int = this.a.jdField_a_of_type_ComTencentAvVideoController.a().A;
        this.a.l = this.a.jdField_a_of_type_ComTencentAvVideoController.a().n;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "setBindInfo: mBindType = " + this.a.jdField_e_of_type_Int + ",mBindId = " + this.a.l);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_e_of_type_Int, this.a.l);
    }
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
      if (paramInt == 0) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.q(true);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.q(false);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a("AVnotify", paramInt1, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, String.format("onCrmIVRRequestAck, ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    super.a(paramInt1, paramInt2, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramString);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, String.format("onRecvCrmIVRPush, errorCode=%d seq=%d url=%s data=%s, roomId=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, Long.valueOf(paramLong) }));
    }
    super.a(paramInt1, paramInt2, paramString1, paramString2, paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramString1, paramString2, paramLong);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "mControlUI is null, so we don't do onRecvCrmIVRPush");
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "onClose, peerUin[" + paramString + "], mPeerUin[" + this.a.c);
    if ((paramString != null) && (!UITools.a(paramString, this.a.c))) {
      return;
    }
    if ((paramInt == 49) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().y) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown())) {
      AVActivity.b(this.a, false, -1);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
      this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramInt);
    }
    AVLog.c(this.a.jdField_b_of_type_JavaLangString, "DataReport onClose: ");
    EffectPendantTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    EffectZimuManager.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    EffectFilterTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    BeautyToolbar.DataReport.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    VoiceChangeDataReport.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
    MultiVideoRichActionReportCollection.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c) + "";
    MagicDataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    MagicDataReport.a(2, paramString);
    MagicDataReport.a(2);
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.a.m();
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().d;
      if ((i == 1) || (i == 2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(2);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(true);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(1);
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    AVActivity.b(this.a, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(paramString);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGroundGlassSwitch : nOff=" + paramInt);
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(paramInt);
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
    if ((this.a.d == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
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
    int i = 2131034240;
    AVLog.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], mSessionType[" + this.a.jdField_b_of_type_Int + "]");
    if ((this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.isShown()) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {}
    label386:
    int j;
    label439:
    String str;
    do
    {
      do
      {
        for (;;)
        {
          return;
          super.a(paramString, paramBoolean);
          if ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2)) {
            break;
          }
          if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
          {
            this.a.jdField_e_of_type_Boolean = paramBoolean;
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().p))
            {
              SessionMgr.a();
              paramString = SessionMgr.a(3, "beautySetting", new int[0]);
              SessionMgr.a().c(paramString);
              this.a.jdField_a_of_type_ComTencentAvVideoController.i = false;
            }
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f())) {
              this.a.jdField_a_of_type_ComTencentAvVideoController.i = false;
            }
            AVLog.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 1");
            this.a.finish();
            if (paramBoolean) {
              break label439;
            }
            if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) {
              break label386;
            }
            this.a.overridePendingTransition(2131034227, 2131034228);
          }
          while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
          {
            paramString = this.a.getApplicationContext().getSharedPreferences("qav_SP", 0).edit();
            paramString.putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b());
            paramString.commit();
            DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b());
            return;
            j = i;
            if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
            {
              paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
              j = i;
              if (paramString != null) {
                j = SmallScreenUtils.a(paramString.J);
              }
            }
            this.a.overridePendingTransition(0, j);
            continue;
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)) {
              this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = false;
            }
            this.a.overridePendingTransition(0, 2131034269);
          }
        }
      } while ((this.a.jdField_b_of_type_Int != 3) && (this.a.jdField_b_of_type_Int != 4));
      str = null;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
        str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().q;
      }
    } while ((str == null) || (paramString == null) || (!str.equals(paramString)));
    this.a.jdField_e_of_type_Boolean = paramBoolean;
    AVLog.d(this.a.jdField_b_of_type_JavaLangString, "onDestroyUI exit 2");
    this.a.finish();
    if (!paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
      {
        this.a.overridePendingTransition(2131034227, 2131034228);
        return;
      }
      j = i;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        j = i;
        if (paramString != null) {
          j = SmallScreenUtils.a(paramString.J);
        }
      }
      this.a.overridePendingTransition(0, j);
      return;
    }
    this.a.overridePendingTransition(0, 2131034269);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
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
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate receive id:" + paramInt);
    }
    int i = VipFunCallManager.a();
    String str = VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
    if (str == null) {}
    do
    {
      return;
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 4) && (this.a.jdField_b_of_type_Int == 1) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.m();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = VipFunCallManager.a((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), (RelativeLayout)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent(), false);
        }
        if (!VipFunCallManager.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, str, i, this.a.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallMediaListener, paramInt, false)) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "yiler onPlayAnnimate finish id:" + paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, String.format("onCrmIVRBeforeRequest, errorCode = %d, ivrRequestSeq = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.b(paramInt1, paramInt2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramInt1, paramInt2);
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    super.b(paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    AVActivity.b(this.a, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(paramString);
    }
  }
  
  protected void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onGroundGlassWaitTimeChange : nTime=" + paramInt);
    }
    if ((2 == this.a.jdField_b_of_type_Int) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(paramInt);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    AVLog.d(this.a.jdField_b_of_type_JavaLangString, "onFinish peerUin = " + paramString + " # isQuit :" + paramBoolean + "|" + this.a.jdField_b_of_type_Int + "|" + this.a.c);
    Object localObject;
    if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 2))
    {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().p)) {
        break label259;
      }
      SessionMgr.a();
      localObject = SessionMgr.a(3, "beautySetting", new int[0]);
      SessionMgr.a().c((String)localObject);
      this.a.finish();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = false;
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        localObject = this.a.getApplicationContext().getSharedPreferences("qav_SP", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("video_position", this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b());
        ((SharedPreferences.Editor)localObject).commit();
        DataReport.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b());
      }
      super.b(paramString, paramBoolean);
      return;
      label259:
      if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)))
      {
        this.a.jdField_e_of_type_Boolean = paramBoolean;
        this.a.finish();
        if (!paramBoolean)
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
          {
            this.a.overridePendingTransition(2131034227, 2131034228);
          }
          else
          {
            int j = 2131034240;
            int i = j;
            if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
            {
              localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
              i = j;
              if (localObject != null) {
                i = SmallScreenUtils.a(((SessionInfo)localObject).J);
              }
            }
            this.a.overridePendingTransition(0, i);
          }
        }
        else {
          this.a.overridePendingTransition(0, 2131034269);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(paramBoolean);
    }
  }
  
  protected void c()
  {
    AudioHelper.b(this.a.jdField_b_of_type_JavaLangString + ".onConnected");
    VideoNodeManager.a(31);
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onConnected, mVideoLayerUI[");
    label185:
    label225:
    boolean bool2;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      bool1 = true;
      QLog.w(str, 1, bool1 + "], peerUin[" + (String)localObject + "]");
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l();
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
        break label559;
      }
      this.a.b(false);
      this.a.d(false);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        if (this.a.f) {
          break label578;
        }
        bool1 = true;
        ((SessionInfo)localObject).f = bool1;
        if (this.a.f) {
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
          bool2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
            break label583;
          }
        }
      }
    }
    label559:
    label578:
    label583:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, bool2, false, bool1);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().f = false;
      }
      this.a.m();
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m();
        if ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().d) || (this.a.jdField_g_of_type_Boolean)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b("onConnected");
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.ai();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
        this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a("onConnected", false);
      }
      ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
      DoodleLogic.a().b();
      QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      return;
      bool1 = false;
      break;
      this.a.b(true);
      this.a.d(true);
      break label185;
      bool1 = false;
      break label225;
    }
  }
  
  protected void c(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramInt);
    }
    while (this.a.jdField_a_of_type_ComTencentAvUiBeautySettingUi == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiBeautySettingUi.b(paramInt);
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
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramString);
    }
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString, paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null) {
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a("onPeerSwitchTerminal", false);
    }
    ZimuToolbar.sendSupportionToPeer(this.a.jdField_a_of_type_ComTencentAvVideoController);
    boolean bool;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean))
    {
      paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) == 5)
      {
        paramBoolean = true;
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString, paramBoolean);
      }
    }
    else
    {
      QavVideoRecordUICtrl.a(this.a.jdField_a_of_type_ComTencentAvVideoController);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramBoolean = this.a.jdField_a_of_type_ComTencentAvVideoController.a().y;
        bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().z;
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onPeerSwitchTerminal, recording=" + paramBoolean + ", beenRecorded=" + bool);
        }
        if (!paramBoolean) {
          break label320;
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.P();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().x = false;
      if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
      }
      return;
      paramBoolean = false;
      break;
      label320:
      if ((bool) && (this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.a("self", String.valueOf(3));
      }
    }
  }
  
  protected void d()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onPauseVideo");
    }
    super.d();
    if (!VcSystemInfo.b()) {}
    boolean bool5;
    label438:
    label443:
    do
    {
      return;
      Object localObject;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
          break label438;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject, 1, false, false, bool1);
        AVActivity.a(this.a, 1, false);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o();
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi != null)
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi;
          bool1 = bool2;
          if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a() == 2) {
            bool1 = true;
          }
          ((EffectSettingUi)localObject).a("onPauseVideo", bool1);
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.a();
        }
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl == null) || (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)) {
          break;
        }
        bool1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().o;
        bool2 = this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        boolean bool3 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
        boolean bool4 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().y;
        bool5 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().z;
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "record_camera:onPauseVideo hangup=" + bool1 + ", cameraOpen=" + bool2 + ", remoteHasVideo=" + bool3 + ", recording=" + bool4 + ", beenRecorded=" + bool5);
        if ((!bool1) && (bool3)) {
          break;
        }
        if (!bool4) {
          break label443;
        }
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        this.a.jdField_a_of_type_ComTencentAvVideoController.P();
        if (bool1) {
          break;
        }
        QavRecordReporter.a("0X8008ACB");
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(1003, this.a.getResources().getString(2131429629), 3000L, 1);
        return;
      }
    } while (!bool5);
    this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
  }
  
  protected void d(int paramInt)
  {
    int i = 15000;
    if (paramInt > 20) {
      i = 30000;
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int != i)
    {
      QLog.e(this.a.jdField_b_of_type_JavaLangString, 1, "AvActivity onFpsChange|mVideoController.getSessionInfo().cameraFPS = " + this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int + ", nNewFps=" + i);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int = i;
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int);
    }
  }
  
  protected void d(String paramString)
  {
    if ((this.a.d == 25) && (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString);
    }
    super.d(paramString);
  }
  
  protected void d(String paramString, boolean paramBoolean)
  {
    super.d(paramString, paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString, paramBoolean);
    }
  }
  
  protected void e()
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onResumeVideo, mIsDoubleVideoMeeting[").append(this.a.jdField_g_of_type_Boolean).append("], beautySetting[").append(this.a.jdField_a_of_type_ComTencentAvVideoController.a().p).append("], mVideoLayerUI[");
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], isResume[" + this.a.isResume() + "]");
      super.e();
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.p();
      }
      if (VcSystemInfo.b()) {
        break;
      }
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.isResume()))
    {
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().c;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.c) != 5) {
        break label353;
      }
    }
    label353:
    for (bool = true;; bool = false)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str, 1, true, false, bool);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1, this.a.jdField_a_of_type_AndroidGraphicsBitmap, true, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m();
        if ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().d) || (this.a.jdField_g_of_type_Boolean)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b("onResumeVideo");
        }
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.a();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiEffectSettingUi.a("onResumeVideo", false);
      return;
    }
  }
  
  protected void e(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onCloseSessionFinished peerUin = " + paramString + ", isQuit = " + paramBoolean);
    }
    if (paramString.equals(this.a.c)) {
      TraeHelper.a().b("DEVICE_SPEAKERPHONE");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a() != 1)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
    }
  }
  
  protected void f()
  {
    super.f();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.X();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o(false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.Y();
    }
  }
  
  protected void h()
  {
    super.h();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.q();
    }
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onNeedShowPeerVideo, mIsDoubleVideoMeeting[" + this.a.jdField_g_of_type_Boolean + "], mPeerUin" + this.a.c + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.r();
    }
  }
  
  protected void k()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.B();
    }
  }
  
  protected void l()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.C();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsi
 * JD-Core Version:    0.7.0.1
 */