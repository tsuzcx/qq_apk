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

public class mqb
  extends lgp
{
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  mpt jdField_a_of_type_Mpt = null;
  mpx jdField_a_of_type_Mpx = null;
  mqa jdField_a_of_type_Mqa;
  public mqh a;
  mqj jdField_a_of_type_Mqj = null;
  mqk jdField_a_of_type_Mqk = null;
  mql jdField_a_of_type_Mql;
  public mqs a;
  mqu jdField_a_of_type_Mqu;
  mqz jdField_a_of_type_Mqz = null;
  mrg jdField_a_of_type_Mrg = null;
  public boolean a;
  public String b;
  WeakReference<mqg> b;
  
  public mqb(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, mqy parammqy)
  {
    if (parammqy.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(parammqy.c, parammqy.i, parammqy.jdField_e_of_type_JavaLangString, parammqy.f, parammqy.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + parammqy.i + "], mPlayerGetRedbag_ResultCode[" + parammqy.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + parammqy.f + "], mHitScore[" + parammqy.jdField_a_of_type_Int + "], mSucAboutGame[" + parammqy.jdField_a_of_type_Boolean + "]");
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
      if (!mqx.a()) {
        break;
      }
      if (this.jdField_a_of_type_Mqs == null) {
        this.jdField_a_of_type_Mqs = new mqs(this);
      }
      this.jdField_a_of_type_Mqs.a("init");
      if ((this.jdField_a_of_type_Mqa == null) || (!this.jdField_a_of_type_Mqa.c)) {
        g();
      }
    } while (this.jdField_a_of_type_Mpt != null);
    this.jdField_a_of_type_Mpt = new mpt(this);
    this.jdField_a_of_type_Mpt.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mqc(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Mpx == null) {
      this.jdField_a_of_type_Mpx = new mpx(this);
    }
    this.jdField_a_of_type_Mpx.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Mqs != null) {
      return this.jdField_a_of_type_Mqs.jdField_a_of_type_Int;
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
  
  public mqa a()
  {
    return this.jdField_a_of_type_Mqa;
  }
  
  mqg a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (mqg)localWeakReference.get();
    }
    return null;
  }
  
  public mqj a()
  {
    if (this.jdField_a_of_type_Mqj == null) {
      this.jdField_a_of_type_Mqj = new mqj(this);
    }
    return this.jdField_a_of_type_Mqj;
  }
  
  public mqk a(AVActivity paramAVActivity, mqy parammqy, WeakReference<mql> paramWeakReference)
  {
    if (this.jdField_a_of_type_Mqk != null)
    {
      this.jdField_a_of_type_Mqk.a("startActivity_getRegBag");
      this.jdField_a_of_type_Mqk = null;
    }
    mqk localmqk = new mqk(this);
    if (localmqk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity, parammqy, paramWeakReference)) {
      this.jdField_a_of_type_Mqk = localmqk;
    }
    return localmqk;
  }
  
  protected void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_Mqh == null) {
      this.jdField_a_of_type_Mqh = new mqh();
    }
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    mqx.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    f();
  }
  
  public void a(AVActivity paramAVActivity, mqy parammqy)
  {
    this.jdField_a_of_type_Mql = new mqf(this);
    paramAVActivity = a(paramAVActivity, parammqy, new WeakReference(this.jdField_a_of_type_Mql));
    if (paramAVActivity.jdField_a_of_type_Mqy.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.jdField_a_of_type_Mqy);
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
    lfx locallfx = lfx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallfx == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().k();
    if (j == 4) {
      if (mqx.a()) {
        if (this.jdField_a_of_type_Mqa != null) {
          if (this.jdField_a_of_type_Mqa.c) {
            if (k == VideoController.k)
            {
              bool1 = bool2;
              locallfx.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_Mqa + "]");
      return;
      if (k == VideoController.l)
      {
        i = 2;
        bool1 = bool2;
        break;
      }
      bool1 = bool3;
      if (k == VideoController.j)
      {
        bool2 = bnky.b(bnkt.b);
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
      } while (this.jdField_a_of_type_Mqa.jdField_a_of_type_Boolean);
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
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, mqy parammqy)
  {
    this.jdField_a_of_type_Mql = null;
    a(paramVideoAppInterface, parammqy);
    paramVideoAppInterface = this.jdField_a_of_type_Mqz;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + parammqy + "], src[" + paramVideoAppInterface.jdField_a_of_type_Mqy + "]");
      paramVideoAppInterface.a(parammqy);
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
    if (this.jdField_a_of_type_Mqu == null) {
      this.jdField_a_of_type_Mqu = new mqu(this);
    }
    this.jdField_a_of_type_Mqu.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    new mdd(l, "prepareAVActivity", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((lid)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.a;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        paramString2.a(l);
        mbf.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
  
  public void a(WeakReference<mqg> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  void a(mqa parammqa)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    mqg localmqg;
    do
    {
      return;
      this.jdField_a_of_type_Mqa = parammqa;
      localmqg = a();
    } while (localmqg == null);
    if (parammqa == null) {}
    for (boolean bool = false;; bool = parammqa.jdField_a_of_type_Boolean)
    {
      localmqg.a(bool);
      return;
    }
  }
  
  void a(mqj parammqj)
  {
    b(true);
    b("onGameStart_from_GameSink");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().ax = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.6(this));
  }
  
  void a(mqy parammqy)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    mqz localmqz = new mqz(this);
    localmqz.a(parammqy, new mqe(this));
    this.jdField_a_of_type_Mqz = localmqz;
  }
  
  public void a(boolean paramBoolean)
  {
    lfx locallfx = lfx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i;
    Object localObject;
    if (locallfx != null)
    {
      if (paramBoolean)
      {
        i = 4;
        locallfx.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_Mqs != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (locallfx == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_Mqs != null) {
        this.jdField_a_of_type_Mqs.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Mqs.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_Mqh != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_Mqh.jdField_b_of_type_Boolean)
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
    if (this.jdField_a_of_type_Mrg != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_Mrg.a();
      this.jdField_a_of_type_Mrg = null;
    }
    this.jdField_a_of_type_Mrg = new mrg(this);
    boolean bool = this.jdField_a_of_type_Mrg.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new mqd(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_Mrg = null;
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
    if (this.jdField_a_of_type_Mrg == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a(anvx.a(2131700390), paramIntent.getExtras());
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
    this.jdField_a_of_type_Mrg.a(paramInt, paramIntent);
    a(false);
    this.jdField_a_of_type_Mrg = null;
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
  
  void b(mqa parammqa)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    b("onDownloadResResult");
    if ((parammqa != null) && (parammqa.c)) {
      a("onDownloadResResult");
    }
    this.jdField_a_of_type_Mpx = null;
  }
  
  void b(mqy parammqy)
  {
    b(false);
    b("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_Mqs != null) {
      a(this.jdField_a_of_type_Mqs.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().ax = false;
    c(parammqy);
    a(parammqy);
    if (this.jdField_a_of_type_Mqu != null)
    {
      this.jdField_a_of_type_Mqu.c();
      this.jdField_a_of_type_Mqu = null;
    }
    this.jdField_a_of_type_Mqj = null;
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
    if (this.jdField_a_of_type_Mrg != null)
    {
      this.jdField_a_of_type_Mrg.a();
      this.jdField_a_of_type_Mrg = null;
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
    Object localObject = this.jdField_a_of_type_Mqj;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((mqj)localObject).jdField_a_of_type_Mqy;
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
    a(paramString, localAVActivity, ((mqy)localObject).jdField_b_of_type_JavaLangString);
  }
  
  void c(mqy parammqy)
  {
    if ((!parammqy.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.4(this, parammqy));
    }
  }
  
  void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_Mrg != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_Mqz == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_Mqu != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + a() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Mqu != null)
        {
          this.jdField_a_of_type_Mqu.c();
          this.jdField_a_of_type_Mqu = null;
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
    if (this.jdField_a_of_type_Mqs != null) {
      return this.jdField_a_of_type_Mqs.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d() {}
  
  void d(String paramString)
  {
    mqz localmqz = this.jdField_a_of_type_Mqz;
    this.jdField_a_of_type_Mqz = null;
    if (localmqz != null) {
      localmqz.a(paramString);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Mqj != null)
    {
      mqy localmqy = this.jdField_a_of_type_Mqj.jdField_a_of_type_Mqy;
      if (localmqy != null) {
        return localmqy.jdField_b_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void e()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    lfx locallfx = lfx.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (locallfx != null) {
      locallfx.a(11, 6, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqb
 * JD-Core Version:    0.7.0.1
 */