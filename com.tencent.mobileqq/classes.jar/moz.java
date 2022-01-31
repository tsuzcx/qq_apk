import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.PopupMenu;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.redbag.AVRedBagMgr.4;
import com.tencent.av.ui.redbag.AVRedBagMgr.6;
import com.tencent.av.ui.redbag.AVRedBagMgr.7;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class moz
  extends lhd
{
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  mor jdField_a_of_type_Mor = null;
  mov jdField_a_of_type_Mov = null;
  moy jdField_a_of_type_Moy;
  public mpf a;
  mph jdField_a_of_type_Mph = null;
  mpi jdField_a_of_type_Mpi = null;
  mpj jdField_a_of_type_Mpj;
  public mpq a;
  mps jdField_a_of_type_Mps;
  mpx jdField_a_of_type_Mpx = null;
  mqe jdField_a_of_type_Mqe = null;
  public boolean a;
  public String b;
  WeakReference<mpe> b;
  
  public moz(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, mpw parammpw)
  {
    if (parammpw.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(parammpw.c, parammpw.i, parammpw.jdField_e_of_type_JavaLangString, parammpw.f, parammpw.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + parammpw.i + "], mPlayerGetRedbag_ResultCode[" + parammpw.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + parammpw.f + "], mHitScore[" + parammpw.jdField_a_of_type_Int + "], mSucAboutGame[" + parammpw.jdField_a_of_type_Boolean + "]");
  }
  
  private void f()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d))) {}
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d;
      QLog.w("AVRedBag", 1, "init, mPeerUin[" + str + "->" + this.jdField_b_of_type_JavaLangString + "]");
      if (!mpv.a()) {
        break;
      }
      if (this.jdField_a_of_type_Mpq == null) {
        this.jdField_a_of_type_Mpq = new mpq(this);
      }
      this.jdField_a_of_type_Mpq.a("init");
      if ((this.jdField_a_of_type_Moy == null) || (!this.jdField_a_of_type_Moy.c)) {
        g();
      }
    } while (this.jdField_a_of_type_Mor != null);
    this.jdField_a_of_type_Mor = new mor(this);
    this.jdField_a_of_type_Mor.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mpa(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Mov == null) {
      this.jdField_a_of_type_Mov = new mov(this);
    }
    this.jdField_a_of_type_Mov.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Mpq != null) {
      return this.jdField_a_of_type_Mpq.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public VideoAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  }
  
  public AVActivity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (AVActivity)localWeakReference.get();
    }
    return null;
  }
  
  public moy a()
  {
    return this.jdField_a_of_type_Moy;
  }
  
  mpe a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (mpe)localWeakReference.get();
    }
    return null;
  }
  
  public mph a()
  {
    if (this.jdField_a_of_type_Mph == null) {
      this.jdField_a_of_type_Mph = new mph(this);
    }
    return this.jdField_a_of_type_Mph;
  }
  
  public mpi a(AVActivity paramAVActivity, mpw parammpw, WeakReference<mpj> paramWeakReference)
  {
    if (this.jdField_a_of_type_Mpi != null)
    {
      this.jdField_a_of_type_Mpi.a("startActivity_getRegBag");
      this.jdField_a_of_type_Mpi = null;
    }
    mpi localmpi = new mpi(this);
    if (localmpi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity, parammpw, paramWeakReference)) {
      this.jdField_a_of_type_Mpi = localmpi;
    }
    return localmpi;
  }
  
  protected void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_Mpf == null) {
      this.jdField_a_of_type_Mpf = new mpf();
    }
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    mpv.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    f();
  }
  
  public void a(AVActivity paramAVActivity, mpw parammpw)
  {
    this.jdField_a_of_type_Mpj = new mpd(this);
    paramAVActivity = a(paramAVActivity, parammpw, new WeakReference(this.jdField_a_of_type_Mpj));
    if (paramAVActivity.jdField_a_of_type_Mpw.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.jdField_a_of_type_Mpw);
      return;
    }
    QLog.w("AVRedBag", 1, "callGetRedBag, 发送中，等红包回调通知, getRedBag[" + paramAVActivity.jdField_a_of_type_Long + "]");
  }
  
  void a(String paramString)
  {
    int i = 3;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    lgl locallgl = lgl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallgl == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
    if (j == 4) {
      if (mpv.a()) {
        if (this.jdField_a_of_type_Moy != null) {
          if (this.jdField_a_of_type_Moy.c) {
            if (k == VideoController.q)
            {
              bool1 = bool2;
              locallgl.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_Moy + "]");
      return;
      if (k == VideoController.r)
      {
        i = 2;
        bool1 = bool2;
        break;
      }
      bool1 = bool3;
      if (k == VideoController.p)
      {
        bool2 = axle.a(BaseApplicationImpl.getContext());
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = bool2;
      }
      do
      {
        i = 2;
        break;
        bool1 = bool3;
      } while (this.jdField_a_of_type_Moy.jdField_a_of_type_Boolean);
      i = 1;
      bool1 = bool2;
      break;
      i = 1;
      bool1 = bool2;
      break;
      i = 0;
      bool1 = bool2;
      break;
      i = 0;
    }
  }
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, mpw parammpw)
  {
    this.jdField_a_of_type_Mpj = null;
    a(paramVideoAppInterface, parammpw);
    paramVideoAppInterface = this.jdField_a_of_type_Mpx;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + parammpw + "], src[" + paramVideoAppInterface.jdField_a_of_type_Mpw + "]");
      paramVideoAppInterface.a(parammpw);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "prepareAVActivity, Begin, from[" + paramString1 + "], seq[" + l + "]");
    }
    ltm.a().a(8);
    if (this.jdField_a_of_type_Mps == null) {
      this.jdField_a_of_type_Mps = new mps(this);
    }
    this.jdField_a_of_type_Mps.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    new mcl(l, "prepareAVActivity", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((liq)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.a;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        paramString2.a(l);
        mao.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      d(paramString1);
      paramString1 = new StringBuilder().append("prepareAVActivity, end, from[").append(paramString1).append("], seq[").append(l).append("], isPendantActive[").append(bool3).append("], setVideoToBigView[").append(bool1).append("], avActivity[").append(paramAVActivity).append("], videoLayerUI[");
      bool1 = bool2;
      if (localVideoLayerUI != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + "]");
      return;
    }
  }
  
  public void a(WeakReference<mpe> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  void a(moy parammoy)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    mpe localmpe;
    do
    {
      return;
      this.jdField_a_of_type_Moy = parammoy;
      localmpe = a();
    } while (localmpe == null);
    if (parammoy == null) {}
    for (boolean bool = false;; bool = parammoy.jdField_a_of_type_Boolean)
    {
      localmpe.a(bool);
      return;
    }
  }
  
  void a(mph parammph)
  {
    b(true);
    b("onGameStart_from_GameSink");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().av = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.6(this));
  }
  
  void a(mpw parammpw)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    mpx localmpx = new mpx(this);
    localmpx.a(parammpw, new mpc(this));
    this.jdField_a_of_type_Mpx = localmpx;
  }
  
  public void a(boolean paramBoolean)
  {
    lgl locallgl = lgl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i;
    Object localObject;
    if (locallgl != null)
    {
      if (paramBoolean)
      {
        i = 4;
        locallgl.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_Mpq != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (locallgl == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_Mpq != null) {
        this.jdField_a_of_type_Mpq.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Mpq.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_Mpf != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_Mpf.jdField_b_of_type_Boolean)
      {
        str = "10000448011711161400109338189700";
        bool1 = true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (bool1) && (!TextUtils.isEmpty(str)))
    {
      ((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6)).a(true, str, paramInt);
      return;
    }
    paramString = new StringBuilder().append("startGame, fail, mApp[");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = paramString.append(paramBoolean).append("], bSuc[").append(bool1).append("], redbagId[");
      paramBoolean = bool2;
      if (!TextUtils.isEmpty(str)) {
        paramBoolean = true;
      }
      QLog.w("AVRedBag", 1, paramBoolean + "]");
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(AVActivity paramAVActivity, int paramInt)
  {
    if (this.jdField_a_of_type_Mqe != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_Mqe.a();
      this.jdField_a_of_type_Mqe = null;
    }
    this.jdField_a_of_type_Mqe = new mqe(this);
    boolean bool = this.jdField_a_of_type_Mqe.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new mpb(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_Mqe = null;
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.7(this));
    }
  }
  
  void b(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Mqe == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a(ajya.a(2131700891), paramIntent.getExtras());
      }
      return;
    }
    Object localObject = a();
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "onActivityResult_SendRedBag, activity为空");
      return;
    }
    if ((paramIntent == null) && (((AVActivity)localObject).e()))
    {
      QLog.w("AVRedBag", 1, "onActivityResult_SendRedBag, 忽略");
      return;
    }
    this.jdField_a_of_type_Mqe.a(paramInt, paramIntent);
    a(false);
    this.jdField_a_of_type_Mqe = null;
  }
  
  public void b(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = b();
    int i = a();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("notifyStatusChangedEvent[").append(paramString).append("], remoteHasVideo[").append(bool3).append("], peerSupportRedBag[").append(i).append("], isPeerInSendMode[").append(c()).append("], mInGameMode[").append(a()).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        bool1 = true;
        QLog.w("AVRedBag", 2, bool1 + "]");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break label132;
      }
    }
    label132:
    do
    {
      return;
      bool1 = false;
      break;
      paramString = a();
    } while (paramString == null);
    if (i == 1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.a(bool3, bool1, this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  void b(moy parammoy)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    b("onDownloadResResult");
    if ((parammoy != null) && (parammoy.c)) {
      a("onDownloadResResult");
    }
    this.jdField_a_of_type_Mov = null;
  }
  
  void b(mpw parammpw)
  {
    b(false);
    b("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_Mpq != null) {
      a(this.jdField_a_of_type_Mpq.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().av = false;
    c(parammpw);
    a(parammpw);
    if (this.jdField_a_of_type_Mps != null)
    {
      this.jdField_a_of_type_Mps.c();
      this.jdField_a_of_type_Mps = null;
    }
    this.jdField_a_of_type_Mph = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      b();
    }
  }
  
  public boolean b()
  {
    return VideoController.a().a().k;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Mqe != null)
    {
      this.jdField_a_of_type_Mqe.a();
      this.jdField_a_of_type_Mqe = null;
      a(false);
    }
  }
  
  public void c(String paramString)
  {
    if (!a())
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], 不是GameMode");
      return;
    }
    Object localObject = this.jdField_a_of_type_Mph;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((mph)localObject).jdField_a_of_type_Mpw;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], ResultData为空");
      return;
    }
    AVActivity localAVActivity = a();
    if ((localAVActivity == null) || (!localAVActivity.isResume()))
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], 等待AVActivity显示, avActivity[" + localAVActivity + "]");
      return;
    }
    a(paramString, localAVActivity, ((mpw)localObject).jdField_b_of_type_JavaLangString);
  }
  
  void c(mpw parammpw)
  {
    if ((!parammpw.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.4(this, parammpw));
    }
  }
  
  void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_Mqe != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_Mpx == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_Mps != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + a() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Mps != null)
        {
          this.jdField_a_of_type_Mps.c();
          this.jdField_a_of_type_Mps = null;
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      c();
      d("clearWhenAVactivityStop");
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Mpq != null) {
      return this.jdField_a_of_type_Mpq.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d() {}
  
  void d(String paramString)
  {
    mpx localmpx = this.jdField_a_of_type_Mpx;
    this.jdField_a_of_type_Mpx = null;
    if (localmpx != null) {
      localmpx.a(paramString);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Mph != null)
    {
      mpw localmpw = this.jdField_a_of_type_Mph.jdField_a_of_type_Mpw;
      if (localmpw != null) {
        return localmpw.jdField_b_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void e()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    lgl locallgl = lgl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallgl != null) {
      locallgl.a(11, 6, null);
    }
  }
  
  boolean e()
  {
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      return localAVActivity.e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     moz
 * JD-Core Version:    0.7.0.1
 */