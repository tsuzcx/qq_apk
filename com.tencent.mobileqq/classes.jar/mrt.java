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

public class mrt
  extends ljg
{
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  mrl jdField_a_of_type_Mrl = null;
  mrp jdField_a_of_type_Mrp = null;
  mrs jdField_a_of_type_Mrs;
  public mrz a;
  msb jdField_a_of_type_Msb = null;
  msc jdField_a_of_type_Msc = null;
  msd jdField_a_of_type_Msd;
  public msk a;
  msm jdField_a_of_type_Msm;
  msr jdField_a_of_type_Msr = null;
  msy jdField_a_of_type_Msy = null;
  public boolean a;
  public String b;
  WeakReference<mry> b;
  
  public mrt(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, msq parammsq)
  {
    if (parammsq.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(parammsq.c, parammsq.i, parammsq.jdField_e_of_type_JavaLangString, parammsq.f, parammsq.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + parammsq.i + "], mPlayerGetRedbag_ResultCode[" + parammsq.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + parammsq.f + "], mHitScore[" + parammsq.jdField_a_of_type_Int + "], mSucAboutGame[" + parammsq.jdField_a_of_type_Boolean + "]");
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
      if (!msp.a()) {
        break;
      }
      if (this.jdField_a_of_type_Msk == null) {
        this.jdField_a_of_type_Msk = new msk(this);
      }
      this.jdField_a_of_type_Msk.a("init");
      if ((this.jdField_a_of_type_Mrs == null) || (!this.jdField_a_of_type_Mrs.c)) {
        g();
      }
    } while (this.jdField_a_of_type_Mrl != null);
    this.jdField_a_of_type_Mrl = new mrl(this);
    this.jdField_a_of_type_Mrl.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mru(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Mrp == null) {
      this.jdField_a_of_type_Mrp = new mrp(this);
    }
    this.jdField_a_of_type_Mrp.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Msk != null) {
      return this.jdField_a_of_type_Msk.jdField_a_of_type_Int;
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
  
  public mrs a()
  {
    return this.jdField_a_of_type_Mrs;
  }
  
  mry a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (mry)localWeakReference.get();
    }
    return null;
  }
  
  public msb a()
  {
    if (this.jdField_a_of_type_Msb == null) {
      this.jdField_a_of_type_Msb = new msb(this);
    }
    return this.jdField_a_of_type_Msb;
  }
  
  public msc a(AVActivity paramAVActivity, msq parammsq, WeakReference<msd> paramWeakReference)
  {
    if (this.jdField_a_of_type_Msc != null)
    {
      this.jdField_a_of_type_Msc.a("startActivity_getRegBag");
      this.jdField_a_of_type_Msc = null;
    }
    msc localmsc = new msc(this);
    if (localmsc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity, parammsq, paramWeakReference)) {
      this.jdField_a_of_type_Msc = localmsc;
    }
    return localmsc;
  }
  
  protected void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_Mrz == null) {
      this.jdField_a_of_type_Mrz = new mrz();
    }
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    msp.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    f();
  }
  
  public void a(AVActivity paramAVActivity, msq parammsq)
  {
    this.jdField_a_of_type_Msd = new mrx(this);
    paramAVActivity = a(paramAVActivity, parammsq, new WeakReference(this.jdField_a_of_type_Msd));
    if (paramAVActivity.jdField_a_of_type_Msq.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.jdField_a_of_type_Msq);
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
    lio locallio = lio.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallio == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
    if (j == 4) {
      if (msp.a()) {
        if (this.jdField_a_of_type_Mrs != null) {
          if (this.jdField_a_of_type_Mrs.c) {
            if (k == VideoController.q)
            {
              bool1 = bool2;
              locallio.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_Mrs + "]");
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
        bool2 = azgk.a(BaseApplicationImpl.getContext());
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
      } while (this.jdField_a_of_type_Mrs.jdField_a_of_type_Boolean);
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
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, msq parammsq)
  {
    this.jdField_a_of_type_Msd = null;
    a(paramVideoAppInterface, parammsq);
    paramVideoAppInterface = this.jdField_a_of_type_Msr;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + parammsq + "], src[" + paramVideoAppInterface.jdField_a_of_type_Msq + "]");
      paramVideoAppInterface.a(parammsq);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "prepareAVActivity, Begin, from[" + paramString1 + "], seq[" + l + "]");
    }
    lvt.a().a(8);
    if (this.jdField_a_of_type_Msm == null) {
      this.jdField_a_of_type_Msm = new msm(this);
    }
    this.jdField_a_of_type_Msm.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    new mfa(l, "prepareAVActivity", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((lkt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.a;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        paramString2.a(l);
        mdd.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
  
  public void a(WeakReference<mry> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  void a(mrs parammrs)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    mry localmry;
    do
    {
      return;
      this.jdField_a_of_type_Mrs = parammrs;
      localmry = a();
    } while (localmry == null);
    if (parammrs == null) {}
    for (boolean bool = false;; bool = parammrs.jdField_a_of_type_Boolean)
    {
      localmry.a(bool);
      return;
    }
  }
  
  void a(msb parammsb)
  {
    b(true);
    b("onGameStart_from_GameSink");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().aw = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.6(this));
  }
  
  void a(msq parammsq)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    msr localmsr = new msr(this);
    localmsr.a(parammsq, new mrw(this));
    this.jdField_a_of_type_Msr = localmsr;
  }
  
  public void a(boolean paramBoolean)
  {
    lio locallio = lio.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i;
    Object localObject;
    if (locallio != null)
    {
      if (paramBoolean)
      {
        i = 4;
        locallio.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_Msk != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (locallio == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_Msk != null) {
        this.jdField_a_of_type_Msk.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Msk.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_Mrz != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_Mrz.jdField_b_of_type_Boolean)
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
    if (this.jdField_a_of_type_Msy != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_Msy.a();
      this.jdField_a_of_type_Msy = null;
    }
    this.jdField_a_of_type_Msy = new msy(this);
    boolean bool = this.jdField_a_of_type_Msy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new mrv(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_Msy = null;
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
    if (this.jdField_a_of_type_Msy == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a(alpo.a(2131701260), paramIntent.getExtras());
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
    this.jdField_a_of_type_Msy.a(paramInt, paramIntent);
    a(false);
    this.jdField_a_of_type_Msy = null;
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
  
  void b(mrs parammrs)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    b("onDownloadResResult");
    if ((parammrs != null) && (parammrs.c)) {
      a("onDownloadResResult");
    }
    this.jdField_a_of_type_Mrp = null;
  }
  
  void b(msq parammsq)
  {
    b(false);
    b("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_Msk != null) {
      a(this.jdField_a_of_type_Msk.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().aw = false;
    c(parammsq);
    a(parammsq);
    if (this.jdField_a_of_type_Msm != null)
    {
      this.jdField_a_of_type_Msm.c();
      this.jdField_a_of_type_Msm = null;
    }
    this.jdField_a_of_type_Msb = null;
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
    if (this.jdField_a_of_type_Msy != null)
    {
      this.jdField_a_of_type_Msy.a();
      this.jdField_a_of_type_Msy = null;
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
    Object localObject = this.jdField_a_of_type_Msb;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((msb)localObject).jdField_a_of_type_Msq;
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
    a(paramString, localAVActivity, ((msq)localObject).jdField_b_of_type_JavaLangString);
  }
  
  void c(msq parammsq)
  {
    if ((!parammsq.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.4(this, parammsq));
    }
  }
  
  void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_Msy != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_Msr == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_Msm != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + a() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Msm != null)
        {
          this.jdField_a_of_type_Msm.c();
          this.jdField_a_of_type_Msm = null;
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
    if (this.jdField_a_of_type_Msk != null) {
      return this.jdField_a_of_type_Msk.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d() {}
  
  void d(String paramString)
  {
    msr localmsr = this.jdField_a_of_type_Msr;
    this.jdField_a_of_type_Msr = null;
    if (localmsr != null) {
      localmsr.a(paramString);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Msb != null)
    {
      msq localmsq = this.jdField_a_of_type_Msb.jdField_a_of_type_Msq;
      if (localmsq != null) {
        return localmsq.jdField_b_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void e()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    lio locallio = lio.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallio != null) {
      locallio.a(11, 6, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mrt
 * JD-Core Version:    0.7.0.1
 */