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

public class med
  extends kwt
{
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  mdv jdField_a_of_type_Mdv = null;
  mdz jdField_a_of_type_Mdz = null;
  mec jdField_a_of_type_Mec;
  public mej a;
  mel jdField_a_of_type_Mel = null;
  mem jdField_a_of_type_Mem = null;
  men jdField_a_of_type_Men;
  public meu a;
  mew jdField_a_of_type_Mew;
  mfb jdField_a_of_type_Mfb = null;
  mfi jdField_a_of_type_Mfi = null;
  public boolean a;
  public String b;
  WeakReference<mei> b;
  
  public med(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, mfa parammfa)
  {
    if (parammfa.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(parammfa.c, parammfa.i, parammfa.jdField_e_of_type_JavaLangString, parammfa.f, parammfa.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + parammfa.i + "], mPlayerGetRedbag_ResultCode[" + parammfa.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + parammfa.f + "], mHitScore[" + parammfa.jdField_a_of_type_Int + "], mSucAboutGame[" + parammfa.jdField_a_of_type_Boolean + "]");
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
      if (!mez.a()) {
        break;
      }
      if (this.jdField_a_of_type_Meu == null) {
        this.jdField_a_of_type_Meu = new meu(this);
      }
      this.jdField_a_of_type_Meu.a("init");
      if ((this.jdField_a_of_type_Mec == null) || (!this.jdField_a_of_type_Mec.c)) {
        g();
      }
    } while (this.jdField_a_of_type_Mdv != null);
    this.jdField_a_of_type_Mdv = new mdv(this);
    this.jdField_a_of_type_Mdv.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new mee(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Mdz == null) {
      this.jdField_a_of_type_Mdz = new mdz(this);
    }
    this.jdField_a_of_type_Mdz.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Meu != null) {
      return this.jdField_a_of_type_Meu.jdField_a_of_type_Int;
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
  
  public mec a()
  {
    return this.jdField_a_of_type_Mec;
  }
  
  mei a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (mei)localWeakReference.get();
    }
    return null;
  }
  
  public mel a()
  {
    if (this.jdField_a_of_type_Mel == null) {
      this.jdField_a_of_type_Mel = new mel(this);
    }
    return this.jdField_a_of_type_Mel;
  }
  
  public mem a(AVActivity paramAVActivity, mfa parammfa, WeakReference<men> paramWeakReference)
  {
    if (this.jdField_a_of_type_Mem != null)
    {
      this.jdField_a_of_type_Mem.a("startActivity_getRegBag");
      this.jdField_a_of_type_Mem = null;
    }
    mem localmem = new mem(this);
    if (localmem.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity, parammfa, paramWeakReference)) {
      this.jdField_a_of_type_Mem = localmem;
    }
    return localmem;
  }
  
  protected void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_Mej == null) {
      this.jdField_a_of_type_Mej = new mej();
    }
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    mez.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    f();
  }
  
  public void a(AVActivity paramAVActivity, mfa parammfa)
  {
    this.jdField_a_of_type_Men = new meh(this);
    paramAVActivity = a(paramAVActivity, parammfa, new WeakReference(this.jdField_a_of_type_Men));
    if (paramAVActivity.jdField_a_of_type_Mfa.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.jdField_a_of_type_Mfa);
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
    kwb localkwb = kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localkwb == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
    if (j == 4) {
      if (mez.a()) {
        if (this.jdField_a_of_type_Mec != null) {
          if (this.jdField_a_of_type_Mec.c) {
            if (k == VideoController.q)
            {
              bool1 = bool2;
              localkwb.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_Mec + "]");
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
        bool2 = awlw.a(BaseApplicationImpl.getContext());
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
      } while (this.jdField_a_of_type_Mec.jdField_a_of_type_Boolean);
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
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, mfa parammfa)
  {
    this.jdField_a_of_type_Men = null;
    a(paramVideoAppInterface, parammfa);
    paramVideoAppInterface = this.jdField_a_of_type_Mfb;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + parammfa + "], src[" + paramVideoAppInterface.jdField_a_of_type_Mfa + "]");
      paramVideoAppInterface.a(parammfa);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "prepareAVActivity, Begin, from[" + paramString1 + "], seq[" + l + "]");
    }
    lja.a().a(8);
    if (this.jdField_a_of_type_Mew == null) {
      this.jdField_a_of_type_Mew = new mew(this);
    }
    this.jdField_a_of_type_Mew.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    new lsa(l, "prepareAVActivity", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((kyd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).b(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.a;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        paramString2.a(l);
        lqb.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
  
  public void a(WeakReference<mei> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  void a(mec parammec)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    mei localmei;
    do
    {
      return;
      this.jdField_a_of_type_Mec = parammec;
      localmei = a();
    } while (localmei == null);
    if (parammec == null) {}
    for (boolean bool = false;; bool = parammec.jdField_a_of_type_Boolean)
    {
      localmei.a(bool);
      return;
    }
  }
  
  void a(mel parammel)
  {
    b(true);
    b("onGameStart_from_GameSink");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().av = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.6(this));
  }
  
  void a(mfa parammfa)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    mfb localmfb = new mfb(this);
    localmfb.a(parammfa, new meg(this));
    this.jdField_a_of_type_Mfb = localmfb;
  }
  
  public void a(boolean paramBoolean)
  {
    kwb localkwb = kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i;
    Object localObject;
    if (localkwb != null)
    {
      if (paramBoolean)
      {
        i = 4;
        localkwb.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_Meu != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (localkwb == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_Meu != null) {
        this.jdField_a_of_type_Meu.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Meu.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_Mej != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_Mej.jdField_b_of_type_Boolean)
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
    if (this.jdField_a_of_type_Mfi != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_Mfi.a();
      this.jdField_a_of_type_Mfi = null;
    }
    this.jdField_a_of_type_Mfi = new mfi(this);
    boolean bool = this.jdField_a_of_type_Mfi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new mef(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_Mfi = null;
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
    if (this.jdField_a_of_type_Mfi == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a(ajjy.a(2131635096), paramIntent.getExtras());
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
    this.jdField_a_of_type_Mfi.a(paramInt, paramIntent);
    a(false);
    this.jdField_a_of_type_Mfi = null;
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
  
  void b(mec parammec)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    b("onDownloadResResult");
    if ((parammec != null) && (parammec.c)) {
      a("onDownloadResResult");
    }
    this.jdField_a_of_type_Mdz = null;
  }
  
  void b(mfa parammfa)
  {
    b(false);
    b("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_Meu != null) {
      a(this.jdField_a_of_type_Meu.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().av = false;
    c(parammfa);
    a(parammfa);
    if (this.jdField_a_of_type_Mew != null)
    {
      this.jdField_a_of_type_Mew.c();
      this.jdField_a_of_type_Mew = null;
    }
    this.jdField_a_of_type_Mel = null;
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
    if (this.jdField_a_of_type_Mfi != null)
    {
      this.jdField_a_of_type_Mfi.a();
      this.jdField_a_of_type_Mfi = null;
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
    Object localObject = this.jdField_a_of_type_Mel;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((mel)localObject).jdField_a_of_type_Mfa;
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
    a(paramString, localAVActivity, ((mfa)localObject).jdField_b_of_type_JavaLangString);
  }
  
  void c(mfa parammfa)
  {
    if ((!parammfa.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.4(this, parammfa));
    }
  }
  
  void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_Mfi != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_Mfb == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_Mew != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + a() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Mew != null)
        {
          this.jdField_a_of_type_Mew.c();
          this.jdField_a_of_type_Mew = null;
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
    if (this.jdField_a_of_type_Meu != null) {
      return this.jdField_a_of_type_Meu.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d() {}
  
  void d(String paramString)
  {
    mfb localmfb = this.jdField_a_of_type_Mfb;
    this.jdField_a_of_type_Mfb = null;
    if (localmfb != null) {
      localmfb.a(paramString);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Mel != null)
    {
      mfa localmfa = this.jdField_a_of_type_Mel.jdField_a_of_type_Mfa;
      if (localmfa != null) {
        return localmfa.jdField_b_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void e()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    kwb localkwb = kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localkwb != null) {
      localkwb.a(11, 6, null);
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
 * Qualified Name:     med
 * JD-Core Version:    0.7.0.1
 */