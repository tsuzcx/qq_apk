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

public class ndt
{
  private static volatile ndt jdField_a_of_type_Ndt;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ndu(this);
  private bjcp jdField_a_of_type_Bjcp = new ndv(this);
  private AVGameCameraAssistant jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  private final ArrayList<WeakReference<mwx>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private ndx jdField_a_of_type_Ndx;
  private ned jdField_a_of_type_Ned;
  private nej jdField_a_of_type_Nej;
  private nem jdField_a_of_type_Nem;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  private ndt()
  {
    nfu.a().a("param_QAVInit");
    ngg.a().b("AVGameBusinessCtrlInit");
    bjcq.d("AVGameBusinessCtrl", "AVGameBusinessCtrl create and init.");
    Object localObject3 = BaseApplicationImpl.getApplication().getQQProcessName();
    QLog.i("AVGameBusinessCtrl", 1, "init, [" + (String)localObject3 + "]");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = null;
    if ((localObject2 instanceof AVGameAppInterface)) {
      localObject1 = (AVGameAppInterface)localObject2;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject2).getManager(5)).registProxyMessagePush(AppSetting.a(), (String)localObject3, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    bjcq.a(new bjcs());
    localObject1 = bjch.a();
    ((bjch)localObject1).a((AppRuntime)localObject2);
    ((bjch)localObject1).a(new ndw(this));
    long l = ((AppRuntime)localObject2).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new nek((Context)localObject2, (bjci)localObject1, new nej((Context)localObject2, l, (bjci)localObject1));
    bjce localbjce = bjce.a();
    localbjce.a((bjcl)localObject3);
    localbjce.a((Context)localObject2, l, (bjci)localObject1);
    this.jdField_a_of_type_Nej = ((nej)bjce.a().a());
    this.jdField_a_of_type_Nem = new nem();
    localbjce.a(this.jdField_a_of_type_Bjcp);
    ngg.a().c("AVGameBusinessCtrlInit");
    nfu.a().a("param_QAVInit", 0);
    nfu.a().a("param_AVGameInit", 0);
  }
  
  public static ndt a()
  {
    return b();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Ndt != null) {
      try
      {
        if (jdField_a_of_type_Ndt != null) {
          jdField_a_of_type_Ndt.b();
        }
        jdField_a_of_type_Ndt = null;
        return;
      }
      finally {}
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(b()), Boolean.valueOf(c()), Integer.valueOf(paramInt2) }));
    bjcm localbjcm = bjce.a().a();
    if (localbjcm != null) {
      localbjcm.b(paramInt1);
    }
    AVGameSession localAVGameSession = this.jdField_a_of_type_Nem.a();
    if (localAVGameSession != null) {
      if (paramInt1 != 1) {
        break label110;
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(localbjcm.a(), paramInt2);
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
    neq.a().a().post(new AVGameBusinessCtrl.4(this, paramIntent, paramContext));
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 2;
    bjcq.c("AVGameBusinessCtrl", "onMemberShareInOrOut, shareIn[" + paramBoolean + "], userUin[" + paramLong1 + "]");
    ??? = AVGameSession.a(paramInt1, paramLong2);
    ??? = this.jdField_a_of_type_Nem.a((String)???);
    if (??? == null)
    {
      bjcq.a("AVGameBusinessCtrl", "onMemberShareInOrOut failed, session is null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((AVGameSession)???).b(paramLong1, paramBoolean, paramInt1);
      bjcq.c("AVGameBusinessCtrl", "onMemberShareInOrOut, updateUserSubVideoStatus result[" + bool + "]");
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
        ((mwx)localWeakReference.get()).b(paramBoolean, paramLong1, 2);
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Ndt == null) {
      bjcq.b("AVGameBusinessCtrl", "ERROR!!! Instance == null. ", new Throwable("打印调用栈"));
    }
    return jdField_a_of_type_Ndt != null;
  }
  
  public static ndt b()
  {
    if (jdField_a_of_type_Ndt == null) {}
    try
    {
      if (jdField_a_of_type_Ndt == null) {
        jdField_a_of_type_Ndt = new ndt();
      }
      return jdField_a_of_type_Ndt;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    neq.a().b().post(new AVGameBusinessCtrl.5(this, paramInt1, paramInt2));
  }
  
  private void c(int paramInt)
  {
    int j = 3;
    int i = 2;
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(b()), Boolean.valueOf(c()), Integer.valueOf(paramInt) }));
    bjcm localbjcm = bjce.a().a();
    AVGameSession localAVGameSession;
    if (localbjcm != null)
    {
      if ((paramInt == 0) || (!b())) {
        break label125;
      }
      localbjcm.b(0);
      i = 0;
      paramInt = j;
      localAVGameSession = this.jdField_a_of_type_Nem.a();
      if (localAVGameSession != null) {
        if (i != 1) {
          break label165;
        }
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(localbjcm.a(), paramInt);
      return;
      label125:
      if ((paramInt != 2) && (c()))
      {
        localbjcm.b(2);
        paramInt = 0;
        break;
      }
      localbjcm.b(1);
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
    bjcm localbjcm = bjce.a().a();
    AVGameSession localAVGameSession;
    if (localbjcm != null)
    {
      if (!b()) {
        break label104;
      }
      localbjcm.b(0);
      i = 0;
      localAVGameSession = this.jdField_a_of_type_Nem.a();
      if (localAVGameSession != null) {
        if (i != 1) {
          break label133;
        }
      }
    }
    for (;;)
    {
      localAVGameSession.d = bool;
      b(localbjcm.a(), -1);
      return;
      label104:
      if (c())
      {
        localbjcm.b(2);
        break;
      }
      localbjcm.b(1);
      i = 1;
      break;
      label133:
      bool = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Ned == null)
    {
      this.jdField_a_of_type_Ned = new ned();
      this.jdField_a_of_type_Ned.d();
    }
  }
  
  public int a()
  {
    if (!a()) {
      return 0;
    }
    return this.jdField_a_of_type_Nej.a();
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt, ndx paramndx)
  {
    if (!a()) {
      return -1;
    }
    nfu.a().a("param_QAVEnterRoom");
    bjcq.d("AVGameBusinessCtrl", "enterRoom. businessRoomId[" + paramString + "], onEnterRoom[" + paramndx + "], svrRecordFlag[" + paramInt + "]");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AVGameAppInterface)) {}
    for (localObject = ((AVGameAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      if (nfx.a((String)localObject) == 0L)
      {
        bjcq.a("AVGameBusinessCtrl", "enterRoom failed. selfUin[" + (String)localObject + "] is illegal.");
        return -1;
      }
      int i = nfx.a(paramString);
      if (i == 0)
      {
        bjcq.a("AVGameBusinessCtrl", "enterRoom failed. invalid args. [" + paramString + "]");
        return -1;
      }
      paramString = this.jdField_a_of_type_Nem.a();
      if (paramString != null)
      {
        bjcq.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id(or peer uin) = " + paramString.jdField_a_of_type_Long + ", sessionId = " + paramString.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = AVGameSession.a(11, i);
      AVGameSession localAVGameSession = this.jdField_a_of_type_Nem.a(paramString);
      if (localAVGameSession != null)
      {
        bjcq.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id = " + localAVGameSession.jdField_a_of_type_Long + ", sessionId = " + localAVGameSession.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = this.jdField_a_of_type_Nem.a(1, paramString, true);
      paramString.jdField_b_of_type_Int = 11;
      paramString.jdField_a_of_type_Long = i;
      paramString.jdField_b_of_type_Boolean = false;
      paramString.c = true;
      paramString.a(AVGameSession.SessionStatus.ENTERING);
      paramString.jdField_b_of_type_Long = nfx.a((String)localObject);
      localObject = new bjcd();
      ((bjcd)localObject).jdField_a_of_type_Int = 11;
      ((bjcd)localObject).jdField_b_of_type_Int = 14;
      ((bjcd)localObject).c = 1;
      ((bjcd)localObject).d = i;
      ((bjcd)localObject).jdField_a_of_type_JavaLangString = "";
      ((bjcd)localObject).jdField_a_of_type_Long = paramString.jdField_b_of_type_Long;
      ((bjcd)localObject).e = 2;
      ((bjcd)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((bjcd)localObject).f = paramInt;
      paramInt = this.jdField_a_of_type_Nej.a((bjcd)localObject);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_Ndx = paramndx;
        return paramInt;
      }
      bjcq.a("AVGameBusinessCtrl", "enterRoom failed. retCode = " + paramInt);
      this.jdField_a_of_type_Nem.b(this.jdField_a_of_type_Nem.a().jdField_a_of_type_JavaLangString);
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
    if ((!a()) || (this.jdField_a_of_type_Nem == null)) {
      return null;
    }
    return this.jdField_a_of_type_Nem.a();
  }
  
  public ned a()
  {
    return this.jdField_a_of_type_Ned;
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (!a()) {
      return;
    }
    bjcq.c("AVGameBusinessCtrl", "setAudioRoute route = " + paramInt);
    this.jdField_a_of_type_Nej.b(paramInt);
    AVGameSession localAVGameSession = this.jdField_a_of_type_Nem.a();
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
  
  public void a(mwx parammwx)
  {
    if (parammwx == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parammwx)) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parammwx));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      long l = Long.valueOf(((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin()).longValue();
      AVGameSession localAVGameSession = this.jdField_a_of_type_Nem.a();
      if (localAVGameSession != null) {
        a(paramBoolean, l, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int, 0L, 0);
      }
    }
  }
  
  public void b()
  {
    bjcq.d("AVGameBusinessCtrl", "AVGameBusinessCtrl destroy.");
    bjce.a().b(this.jdField_a_of_type_Bjcp);
    this.jdField_a_of_type_Bjcp = null;
    this.jdField_a_of_type_Nem = null;
    this.jdField_a_of_type_Nej = null;
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bjce.a().a();
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
      localObject = bjce.a().a();
      if (!(localObject instanceof nej)) {
        break;
      }
      localAVGameSession.a(1);
      if (((nej)localObject).a()) {
        break;
      }
      this.jdField_a_of_type_Bjcp.onGoOnStageRet(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
      return;
    }
  }
  
  public void b(mwx parammwx)
  {
    if (parammwx == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parammwx))
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
      this.jdField_a_of_type_Nej.a(paramBoolean);
      localAVGameSession = this.jdField_a_of_type_Nem.a();
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
    this.jdField_a_of_type_Nej.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!a()) {}
    AVGameSession localAVGameSession;
    do
    {
      return;
      this.jdField_a_of_type_Nej.b(paramBoolean);
      localAVGameSession = this.jdField_a_of_type_Nem.a();
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
    this.jdField_a_of_type_Nej.b();
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
    AVGameSession localAVGameSession = this.jdField_a_of_type_Nem.a();
    StringBuilder localStringBuilder = new StringBuilder().append("exitRoom, session[");
    if (localAVGameSession == null) {}
    for (localObject = null;; localObject = localAVGameSession.jdField_a_of_type_JavaLangString)
    {
      bjcq.a("AVGameBusinessCtrl", (String)localObject + "]");
      if (this.jdField_a_of_type_Ned != null)
      {
        this.jdField_a_of_type_Ned.g();
        this.jdField_a_of_type_Ned = null;
      }
      bjce.a().a().a_(-1L, true, false);
      myq.b();
      localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).b(localAVGameSession);
      }
      if (localAVGameSession != null) {
        break;
      }
      bjcq.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return;
    }
    localAVGameSession.a(AVGameSession.SessionStatus.EXITING);
    this.jdField_a_of_type_Nem.b(this.jdField_a_of_type_Nem.a().jdField_a_of_type_JavaLangString);
    bjcq.d("AVGameBusinessCtrl", "exitRoom mSessionManager has clear");
    this.jdField_a_of_type_Nej.e();
    localAVGameSession.a(AVGameSession.SessionStatus.EXITED);
    this.c = true;
    bjct.a().b();
  }
  
  public void f()
  {
    AVGameSession localAVGameSession = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOffStage, session[" + localAVGameSession + "]");
    }
    if (localAVGameSession == null) {}
    bjcm localbjcm;
    do
    {
      do
      {
        return;
        localAVGameSession.g = false;
        localbjcm = bjce.a().a();
      } while (!(localbjcm instanceof nej));
      localAVGameSession.a(4);
    } while (((nej)localbjcm).b());
    this.jdField_a_of_type_Bjcp.onGoOffStageRet(false, localAVGameSession.jdField_a_of_type_Long, localAVGameSession.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndt
 * JD-Core Version:    0.7.0.1
 */