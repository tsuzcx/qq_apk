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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mpv
  extends lgj
{
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  mpn jdField_a_of_type_Mpn = null;
  mpr jdField_a_of_type_Mpr = null;
  mpu jdField_a_of_type_Mpu;
  public mqb a;
  mqd jdField_a_of_type_Mqd = null;
  mqe jdField_a_of_type_Mqe = null;
  mqf jdField_a_of_type_Mqf;
  public mqm a;
  mqo jdField_a_of_type_Mqo;
  mqt jdField_a_of_type_Mqt = null;
  mra jdField_a_of_type_Mra = null;
  public boolean a;
  public String b;
  WeakReference<mqa> b;
  
  public mpv(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, mqs parammqs)
  {
    if (parammqs.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(parammqs.c, parammqs.i, parammqs.jdField_e_of_type_JavaLangString, parammqs.f, parammqs.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + parammqs.i + "], mPlayerGetRedbag_ResultCode[" + parammqs.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + parammqs.f + "], mHitScore[" + parammqs.jdField_a_of_type_Int + "], mSucAboutGame[" + parammqs.jdField_a_of_type_Boolean + "]");
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
      if (!mqr.a()) {
        break;
      }
      if (this.jdField_a_of_type_Mqm == null) {
        this.jdField_a_of_type_Mqm = new mqm(this);
      }
      this.jdField_a_of_type_Mqm.a("init");
      if ((this.jdField_a_of_type_Mpu == null) || (!this.jdField_a_of_type_Mpu.c)) {
        g();
      }
    } while (this.jdField_a_of_type_Mpn != null);
    this.jdField_a_of_type_Mpn = new mpn(this);
    this.jdField_a_of_type_Mpn.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mpw(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Mpr == null) {
      this.jdField_a_of_type_Mpr = new mpr(this);
    }
    this.jdField_a_of_type_Mpr.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Mqm != null) {
      return this.jdField_a_of_type_Mqm.jdField_a_of_type_Int;
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
  
  public mpu a()
  {
    return this.jdField_a_of_type_Mpu;
  }
  
  mqa a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (mqa)localWeakReference.get();
    }
    return null;
  }
  
  public mqd a()
  {
    if (this.jdField_a_of_type_Mqd == null) {
      this.jdField_a_of_type_Mqd = new mqd(this);
    }
    return this.jdField_a_of_type_Mqd;
  }
  
  public mqe a(AVActivity paramAVActivity, mqs parammqs, WeakReference<mqf> paramWeakReference)
  {
    if (this.jdField_a_of_type_Mqe != null)
    {
      this.jdField_a_of_type_Mqe.a("startActivity_getRegBag");
      this.jdField_a_of_type_Mqe = null;
    }
    mqe localmqe = new mqe(this);
    if (localmqe.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity, parammqs, paramWeakReference)) {
      this.jdField_a_of_type_Mqe = localmqe;
    }
    return localmqe;
  }
  
  protected void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_Mqb == null) {
      this.jdField_a_of_type_Mqb = new mqb();
    }
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    mqr.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    f();
  }
  
  public void a(AVActivity paramAVActivity, mqs parammqs)
  {
    this.jdField_a_of_type_Mqf = new mpz(this);
    paramAVActivity = a(paramAVActivity, parammqs, new WeakReference(this.jdField_a_of_type_Mqf));
    if (paramAVActivity.jdField_a_of_type_Mqs.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.jdField_a_of_type_Mqs);
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
    lfr locallfr = lfr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallfr == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().k();
    if (j == 4) {
      if (mqr.a()) {
        if (this.jdField_a_of_type_Mpu != null) {
          if (this.jdField_a_of_type_Mpu.c) {
            if (k == VideoController.p)
            {
              bool1 = bool2;
              locallfr.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_Mpu + "]");
      return;
      if (k == VideoController.q)
      {
        i = 2;
        bool1 = bool2;
        break;
      }
      bool1 = bool3;
      if (k == VideoController.o)
      {
        bool2 = bork.b(borf.b);
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
      } while (this.jdField_a_of_type_Mpu.jdField_a_of_type_Boolean);
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
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, mqs parammqs)
  {
    this.jdField_a_of_type_Mqf = null;
    a(paramVideoAppInterface, parammqs);
    paramVideoAppInterface = this.jdField_a_of_type_Mqt;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + parammqs + "], src[" + paramVideoAppInterface.jdField_a_of_type_Mqs + "]");
      paramVideoAppInterface.a(parammqs);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "prepareAVActivity, Begin, from[" + paramString1 + "], seq[" + l + "]");
    }
    ltr.a().a(8);
    if (this.jdField_a_of_type_Mqo == null) {
      this.jdField_a_of_type_Mqo = new mqo(this);
    }
    this.jdField_a_of_type_Mqo.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    new mcz(l, "prepareAVActivity", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((lhx)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.a;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        paramString2.a(l);
        mbb.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
  
  public void a(WeakReference<mqa> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  void a(mpu parammpu)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    mqa localmqa;
    do
    {
      return;
      this.jdField_a_of_type_Mpu = parammpu;
      localmqa = a();
    } while (localmqa == null);
    if (parammpu == null) {}
    for (boolean bool = false;; bool = parammpu.jdField_a_of_type_Boolean)
    {
      localmqa.a(bool);
      return;
    }
  }
  
  void a(mqd parammqd)
  {
    b(true);
    b("onGameStart_from_GameSink");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().ax = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.6(this));
  }
  
  void a(mqs parammqs)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    mqt localmqt = new mqt(this);
    localmqt.a(parammqs, new mpy(this));
    this.jdField_a_of_type_Mqt = localmqt;
  }
  
  public void a(boolean paramBoolean)
  {
    lfr locallfr = lfr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i;
    Object localObject;
    if (locallfr != null)
    {
      if (paramBoolean)
      {
        i = 4;
        locallfr.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_Mqm != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (locallfr == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_Mqm != null) {
        this.jdField_a_of_type_Mqm.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Mqm.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_Mqb != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_Mqb.jdField_b_of_type_Boolean)
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
    if (this.jdField_a_of_type_Mra != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_Mra.a();
      this.jdField_a_of_type_Mra = null;
    }
    this.jdField_a_of_type_Mra = new mra(this);
    boolean bool = this.jdField_a_of_type_Mra.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new mpx(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_Mra = null;
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
    if (this.jdField_a_of_type_Mra == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a(anzj.a(2131699804), paramIntent.getExtras());
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
    this.jdField_a_of_type_Mra.a(paramInt, paramIntent);
    a(false);
    this.jdField_a_of_type_Mra = null;
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
  
  void b(mpu parammpu)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    b("onDownloadResResult");
    if ((parammpu != null) && (parammpu.c)) {
      a("onDownloadResResult");
    }
    this.jdField_a_of_type_Mpr = null;
  }
  
  void b(mqs parammqs)
  {
    b(false);
    b("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_Mqm != null) {
      a(this.jdField_a_of_type_Mqm.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().ax = false;
    c(parammqs);
    a(parammqs);
    if (this.jdField_a_of_type_Mqo != null)
    {
      this.jdField_a_of_type_Mqo.c();
      this.jdField_a_of_type_Mqo = null;
    }
    this.jdField_a_of_type_Mqd = null;
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
    if (this.jdField_a_of_type_Mra != null)
    {
      this.jdField_a_of_type_Mra.a();
      this.jdField_a_of_type_Mra = null;
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
    Object localObject = this.jdField_a_of_type_Mqd;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((mqd)localObject).jdField_a_of_type_Mqs;
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
    a(paramString, localAVActivity, ((mqs)localObject).jdField_b_of_type_JavaLangString);
  }
  
  void c(mqs parammqs)
  {
    if ((!parammqs.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.4(this, parammqs));
    }
  }
  
  void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_Mra != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_Mqt == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_Mqo != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + a() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Mqo != null)
        {
          this.jdField_a_of_type_Mqo.c();
          this.jdField_a_of_type_Mqo = null;
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
    if (this.jdField_a_of_type_Mqm != null) {
      return this.jdField_a_of_type_Mqm.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d() {}
  
  void d(String paramString)
  {
    mqt localmqt = this.jdField_a_of_type_Mqt;
    this.jdField_a_of_type_Mqt = null;
    if (localmqt != null) {
      localmqt.a(paramString);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Mqd != null)
    {
      mqs localmqs = this.jdField_a_of_type_Mqd.jdField_a_of_type_Mqs;
      if (localmqs != null) {
        return localmqs.jdField_b_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void e()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    lfr locallfr = lfr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallfr != null) {
      locallfr.a(11, 6, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpv
 * JD-Core Version:    0.7.0.1
 */