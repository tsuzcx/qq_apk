import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.qav.AVGameBusinessCtrl.4;
import com.tencent.avgame.qav.AVGameBusinessCtrl.5;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSession.SessionStatus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;
import mqq.util.WeakReference;

public class nfm
{
  private static volatile nfm jdField_a_of_type_Nfm;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nfn(this);
  private bkdo jdField_a_of_type_Bkdo = new nfo(this);
  private AVGameCameraAssistant jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  private final ArrayList<WeakReference<mxw>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private nfq jdField_a_of_type_Nfq;
  private nfw jdField_a_of_type_Nfw;
  private ngc jdField_a_of_type_Ngc;
  private ngf jdField_a_of_type_Ngf;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  private nfm()
  {
    nhp.a().a("param_QAVInit");
    nib.a().b("AVGameBusinessCtrlInit");
    bkdp.d("AVGameBusinessCtrl", "AVGameBusinessCtrl create and init.");
    Object localObject3 = BaseApplicationImpl.getApplication().getQQProcessName();
    QLog.i("AVGameBusinessCtrl", 1, "init, [" + (String)localObject3 + "]");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = null;
    if ((localObject2 instanceof AVGameAppInterface)) {
      localObject1 = (AVGameAppInterface)localObject2;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject2).getManager(5)).registProxyMessagePush(AppSetting.a(), (String)localObject3, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    bkdp.a(new bkdr());
    localObject1 = bkdg.a();
    ((bkdg)localObject1).a((AppRuntime)localObject2);
    ((bkdg)localObject1).a(new nfp(this));
    long l = ((AppRuntime)localObject2).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new ngd((Context)localObject2, (bkdh)localObject1, new ngc((Context)localObject2, l, (bkdh)localObject1));
    bkdd localbkdd = bkdd.a();
    localbkdd.a((bkdk)localObject3);
    localbkdd.a((Context)localObject2, l, (bkdh)localObject1);
    this.jdField_a_of_type_Ngc = ((ngc)bkdd.a().a());
    this.jdField_a_of_type_Ngf = new ngf();
    localbkdd.a(this.jdField_a_of_type_Bkdo);
    nib.a().c("AVGameBusinessCtrlInit");
    nhp.a().a("param_QAVInit", 0);
    nhp.a().a("param_AVGameInit", 0);
  }
  
  public static nfm a()
  {
    return b();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Nfm != null) {
      try
      {
        if (jdField_a_of_type_Nfm != null) {
          jdField_a_of_type_Nfm.b();
        }
        jdField_a_of_type_Nfm = null;
        return;
      }
      finally {}
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(b()), Boolean.valueOf(c()), Integer.valueOf(paramInt2) }));
    bkdl localbkdl = bkdd.a().a();
    if (localbkdl != null) {
      localbkdl.b(paramInt1);
    }
    AVGameSession localAVGameSession = this.jdField_a_of_type_Ngf.a();
    if (localAVGameSession != null) {
      if (paramInt1 != 1) {
        break label110;
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(localbkdl.a(), paramInt2);
      return;
      label110:
      bool = false;
    }
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    ngk.a().a().post(new AVGameBusinessCtrl.4(this, paramIntent, paramContext));
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 2;
    bkdp.c("AVGameBusinessCtrl", "onMemberShareInOrOut, shareIn[" + paramBoolean + "], userUin[" + paramLong1 + "]");
    ??? = AVGameSession.a(paramInt1, paramLong2);
    ??? = this.jdField_a_of_type_Ngf.a((String)???);
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onMemberShareInOrOut failed, session is null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((AVGameSession)???).b(paramLong1, paramBoolean, paramInt1);
      bkdp.c("AVGameBusinessCtrl", "onMemberShareInOrOut, updateUserSubVideoStatus result[" + bool + "]");
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((mxw)localWeakReference.get()).b(paramBoolean, paramLong1, 2);
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Nfm == null) {
      bkdp.b("AVGameBusinessCtrl", "ERROR!!! Instance == null. ", new Throwable("打印调用栈"));
    }
    return jdField_a_of_type_Nfm != null;
  }
  
  public static nfm b()
  {
    if (jdField_a_of_type_Nfm == null) {}
    try
    {
      if (jdField_a_of_type_Nfm == null) {
        jdField_a_of_type_Nfm = new nfm();
      }
      return jdField_a_of_type_Nfm;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ngk.a().b().post(new AVGameBusinessCtrl.5(this, paramInt1, paramInt2));
  }
  
  private void c(int paramInt)
  {
    int j = 3;
    int i = 2;
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(b()), Boolean.valueOf(c()), Integer.valueOf(paramInt) }));
    bkdl localbkdl = bkdd.a().a();
    AVGameSession localAVGameSession;
    if (localbkdl != null)
    {
      if ((paramInt == 0) || (!b())) {
        break label125;
      }
      localbkdl.b(0);
      i = 0;
      paramInt = j;
      localAVGameSession = this.jdField_a_of_type_Ngf.a();
      if (localAVGameSession != null) {
        if (i != 1) {
          break label165;
        }
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(localbkdl.a(), paramInt);
      return;
      label125:
      if ((paramInt != 2) && (c()))
      {
        localbkdl.b(2);
        paramInt = 0;
        break;
      }
      localbkdl.b(1);
      paramInt = 0;
      i = 1;
      break;
      label165:
      bool = false;
    }
  }
  
  private boolean c()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    int i;
    int j;
    int k;
    if (((BluetoothAdapter)localObject).isEnabled())
    {
      i = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      j = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      k = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i != 2) {}
    }
    for (;;)
    {
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if ((i != -1) || (((AudioManager)localObject).isBluetoothA2dpOn()))
      {
        return true;
        i = j;
        if (j == 2) {
          continue;
        }
        if (k == 2) {
          i = k;
        }
      }
      else
      {
        return false;
      }
      i = -1;
    }
  }
  
  private void g()
  {
    int i = 2;
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(b()), Boolean.valueOf(c()) }));
    bkdl localbkdl = bkdd.a().a();
    AVGameSession localAVGameSession;
    if (localbkdl != null)
    {
      if (!b()) {
        break label104;
      }
      localbkdl.b(0);
      i = 0;
      localAVGameSession = this.jdField_a_of_type_Ngf.a();
      if (localAVGameSession != null) {
        if (i != 1) {
          break label133;
        }
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(localbkdl.a(), -1);
      return;
      label104:
      if (c())
      {
        localbkdl.b(2);
        break;
      }
      localbkdl.b(1);
      i = 1;
      break;
      label133:
      bool = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Nfw == null)
    {
      this.jdField_a_of_type_Nfw = new nfw();
      this.jdField_a_of_type_Nfw.d();
    }
  }
  
  public int a()
  {
    if (!a()) {
      return 0;
    }
    return this.jdField_a_of_type_Ngc.a();
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt, nfq paramnfq)
  {
    if (!a()) {
      return -1;
    }
    nhp.a().a("param_QAVEnterRoom");
    bkdp.d("AVGameBusinessCtrl", "enterRoom. businessRoomId[" + paramString + "], onEnterRoom[" + paramnfq + "], svrRecordFlag[" + paramInt + "]");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AVGameAppInterface)) {}
    for (localObject = ((AVGameAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      if (nhs.a((String)localObject) == 0L)
      {
        bkdp.a("AVGameBusinessCtrl", "enterRoom failed. selfUin[" + (String)localObject + "] is illegal.");
        return -1;
      }
      int i = nhs.a(paramString);
      if (i == 0)
      {
        bkdp.a("AVGameBusinessCtrl", "enterRoom failed. invalid args. [" + paramString + "]");
        return -1;
      }
      paramString = this.jdField_a_of_type_Ngf.a();
      if (paramString != null)
      {
        bkdp.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id(or peer uin) = " + paramString.jdField_a_of_type_Long + ", sessionId = " + paramString.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = AVGameSession.a(11, i);
      AVGameSession localAVGameSession = this.jdField_a_of_type_Ngf.a(paramString);
      if (localAVGameSession != null)
      {
        bkdp.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id = " + localAVGameSession.jdField_a_of_type_Long + ", sessionId = " + localAVGameSession.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = this.jdField_a_of_type_Ngf.a(1, paramString, true);
      paramString.jdField_b_of_type_Int = 11;
      paramString.jdField_a_of_type_Long = i;
      paramString.jdField_b_of_type_Boolean = false;
      paramString.c = true;
      paramString.a(AVGameSession.SessionStatus.ENTERING);
      paramString.jdField_b_of_type_Long = nhs.a((String)localObject);
      localObject = new bkdc();
      ((bkdc)localObject).jdField_a_of_type_Int = 11;
      ((bkdc)localObject).jdField_b_of_type_Int = 14;
      ((bkdc)localObject).c = 1;
      ((bkdc)localObject).d = i;
      ((bkdc)localObject).jdField_a_of_type_JavaLangString = "";
      ((bkdc)localObject).jdField_a_of_type_Long = paramString.jdField_b_of_type_Long;
      ((bkdc)localObject).e = 2;
      ((bkdc)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((bkdc)localObject).f = paramInt;
      paramInt = this.jdField_a_of_type_Ngc.a((bkdc)localObject);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_Nfq = paramnfq;
        return paramInt;
      }
      bkdp.a("AVGameBusinessCtrl", "enterRoom failed. retCode = " + paramInt);
      this.jdField_a_of_type_Ngf.b(this.jdField_a_of_type_Ngf.a().jdField_a_of_type_JavaLangString);
      return paramInt;
    }
  }
  
  public AVGameCameraAssistant a()
  {
    if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
        this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant = new AVGameCameraAssistant(this, (AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get());
      }
      if (this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant == null) {
        QLog.i("AVGameBusinessCtrl", 1, "getCameraAssistant, assistant is null.");
      }
      return this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
    }
    finally {}
  }
  
  public AVGameSession a()
  {
    if ((!a()) || (this.jdField_a_of_type_Ngf == null)) {
      return null;
    }
    return this.jdField_a_of_type_Ngf.a();
  }
  
  public String a()
  {
    if (!a()) {
      return null;
    }
    return this.jdField_a_of_type_Ngc.a();
  }
  
  public nfw a()
  {
    return this.jdField_a_of_type_Nfw;
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (!a()) {
      return;
    }
    bkdp.c("AVGameBusinessCtrl", "setAudioRoute route = " + paramInt);
    this.jdField_a_of_type_Ngc.b(paramInt);
    AVGameSession localAVGameSession = this.jdField_a_of_type_Ngf.a();
    if (localAVGameSession != null) {
      if (paramInt != 1) {
        break label71;
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(paramInt, 0);
      return;
      label71:
      bool = false;
    }
  }
  
  public void a(mxw parammxw)
  {
    if (parammxw == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parammxw)) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parammxw));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      long l = Long.valueOf(((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin()).longValue();
      AVGameSession localAVGameSession = this.jdField_a_of_type_Ngf.a();
      if (localAVGameSession != null) {
        a(paramBoolean, l, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int, 0L, 0);
      }
    }
  }
  
  public void b()
  {
    bkdp.d("AVGameBusinessCtrl", "AVGameBusinessCtrl destroy.");
    bkdd.a().b(this.jdField_a_of_type_Bkdo);
    this.jdField_a_of_type_Bkdo = null;
    this.jdField_a_of_type_Ngf = null;
    this.jdField_a_of_type_Ngc = null;
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bkdd.a().a();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b(int paramInt)
  {
    AVGameSession localAVGameSession = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOnStage, from[" + paramInt + "], session[" + localAVGameSession + "]");
    }
    if (localAVGameSession == null) {
      return;
    }
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localAVGameSession.g = bool;
      if (SecurityPolicyChecker.a().b()) {
        localAVGameSession.g = true;
      }
      Object localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).a("goOnStage");
      }
      localObject = bkdd.a().a();
      if (!(localObject instanceof ngc)) {
        break;
      }
      localAVGameSession.a(1);
      if (((ngc)localObject).a()) {
        break;
      }
      this.jdField_a_of_type_Bkdo.onGoOnStageRet(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
      return;
    }
  }
  
  public void b(mxw parammxw)
  {
    if (parammxw == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parammxw))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localWeakReference);
          return;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!a()) {}
    AVGameSession localAVGameSession;
    do
    {
      return;
      this.jdField_a_of_type_Ngc.a(paramBoolean);
      localAVGameSession = this.jdField_a_of_type_Ngf.a();
    } while (localAVGameSession == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAVGameSession.e = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ngc.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!a()) {}
    AVGameSession localAVGameSession;
    do
    {
      return;
      this.jdField_a_of_type_Ngc.b(paramBoolean);
      localAVGameSession = this.jdField_a_of_type_Ngf.a();
    } while (localAVGameSession == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAVGameSession.f = paramBoolean;
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ngc.b();
  }
  
  public void e()
  {
    if (!a()) {
      return;
    }
    Object localObject = (AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject != null) {
      AVGameUtilService.b(((AVGameAppInterface)localObject).getApp());
    }
    AVGameSession localAVGameSession = this.jdField_a_of_type_Ngf.a();
    StringBuilder localStringBuilder = new StringBuilder().append("exitRoom, session[");
    if (localAVGameSession == null) {}
    for (localObject = null;; localObject = localAVGameSession.jdField_a_of_type_JavaLangString)
    {
      bkdp.a("AVGameBusinessCtrl", (String)localObject + "]");
      if (this.jdField_a_of_type_Nfw != null)
      {
        this.jdField_a_of_type_Nfw.g();
        this.jdField_a_of_type_Nfw = null;
      }
      bkdd.a().a().a_(-1L, true, false);
      mzt.b();
      localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).b(localAVGameSession);
      }
      if (localAVGameSession != null) {
        break;
      }
      bkdp.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return;
    }
    localAVGameSession.a(AVGameSession.SessionStatus.EXITING);
    this.jdField_a_of_type_Ngf.b(this.jdField_a_of_type_Ngf.a().jdField_a_of_type_JavaLangString);
    bkdp.d("AVGameBusinessCtrl", "exitRoom mSessionManager has clear");
    this.jdField_a_of_type_Ngc.e();
    localAVGameSession.a(AVGameSession.SessionStatus.EXITED);
    this.c = true;
    bkds.a().b();
  }
  
  public void f()
  {
    AVGameSession localAVGameSession = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOffStage, session[" + localAVGameSession + "]");
    }
    if (localAVGameSession == null) {}
    bkdl localbkdl;
    do
    {
      do
      {
        return;
        localAVGameSession.g = false;
        localbkdl = bkdd.a().a();
      } while (!(localbkdl instanceof ngc));
      localAVGameSession.a(4);
    } while (((ngc)localbkdl).b());
    this.jdField_a_of_type_Bkdo.onGoOffStageRet(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfm
 * JD-Core Version:    0.7.0.1
 */