import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.qav.AVGameBusinessCtrl.4;
import com.tencent.avgame.qav.AVGameBusinessCtrl.5;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.PushManager;
import mqq.util.WeakReference;

public class nnm
{
  private static volatile nnm jdField_a_of_type_Nnm;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nnn(this);
  private bjub jdField_a_of_type_Bjub = new nno(this);
  private AVGameCameraAssistant jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  private final ArrayList<WeakReference<ndt>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private nnq jdField_a_of_type_Nnq;
  private nnw jdField_a_of_type_Nnw;
  private noc jdField_a_of_type_Noc;
  private nog jdField_a_of_type_Nog;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  private nnm()
  {
    nqc.a().a("param_QAVInit");
    nqo.a().b("AVGameBusinessCtrlInit");
    bjuc.d("AVGameBusinessCtrl", "AVGameBusinessCtrl create and init.");
    Object localObject3 = BaseApplicationImpl.getApplication().getQQProcessName();
    QLog.i("AVGameBusinessCtrl", 1, "init, [" + (String)localObject3 + "]");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = null;
    if ((localObject2 instanceof AVGameAppInterface)) {
      localObject1 = (AVGameAppInterface)localObject2;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject2).getManager(5)).registProxyMessagePush(AppSetting.a(), (String)localObject3, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    bjuc.a(new bjue());
    localObject1 = bjts.a();
    ((bjts)localObject1).a((AppRuntime)localObject2);
    ((bjts)localObject1).a(new nnp(this));
    long l = ((AppRuntime)localObject2).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new nod((Context)localObject2, new noc((Context)localObject2, l, (bjtt)localObject1));
    bjtp localbjtp = bjtp.a();
    localbjtp.a((bjtx)localObject3);
    localbjtp.a((Context)localObject2, l, (bjtt)localObject1);
    this.jdField_a_of_type_Noc = ((noc)bjtp.a().a());
    this.jdField_a_of_type_Nog = new nog();
    localbjtp.a(this.jdField_a_of_type_Bjub);
    nqo.a().c("AVGameBusinessCtrlInit");
    nqc.a().a("param_QAVInit", 0);
    nqc.a().a("param_AVGameInit", 0);
  }
  
  public static nnm a()
  {
    return b();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Nnm != null) {
      try
      {
        if (jdField_a_of_type_Nnm != null) {
          jdField_a_of_type_Nnm.b();
        }
        jdField_a_of_type_Nnm = null;
        return;
      }
      finally {}
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(b()), Boolean.valueOf(d()), Integer.valueOf(paramInt2) }));
    bjty localbjty = bjtp.a().a();
    if (localbjty != null) {
      localbjty.b(paramInt1);
    }
    nof localnof = this.jdField_a_of_type_Nog.a();
    if (localnof != null) {
      if (paramInt1 != 1) {
        break label115;
      }
    }
    for (;;)
    {
      localnof.d = bool;
      if (localbjty != null) {
        b(localbjty.a(), paramInt2);
      }
      return;
      label115:
      bool = false;
    }
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    nom.a().a().post(new AVGameBusinessCtrl.4(this, paramIntent, paramContext));
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 2;
    bjuc.c("AVGameBusinessCtrl", "onMemberShareInOrOut, shareIn[" + paramBoolean + "], userUin[" + paramLong1 + "]");
    ??? = nof.a(paramInt1, paramLong2);
    ??? = this.jdField_a_of_type_Nog.a((String)???);
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onMemberShareInOrOut failed, session is null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((nof)???).b(paramLong1, paramBoolean, paramInt1);
      bjuc.c("AVGameBusinessCtrl", "onMemberShareInOrOut, updateUserSubVideoStatus result[" + bool + "]");
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
        ((ndt)localWeakReference.get()).b(paramBoolean, paramLong1, 2);
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Nnm == null) {
      bjuc.b("AVGameBusinessCtrl", "ERROR!!! Instance == null. ", new Throwable("打印调用栈"));
    }
    return jdField_a_of_type_Nnm != null;
  }
  
  public static nnm b()
  {
    if (jdField_a_of_type_Nnm == null) {}
    try
    {
      if (jdField_a_of_type_Nnm == null) {
        jdField_a_of_type_Nnm = new nnm();
      }
      return jdField_a_of_type_Nnm;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    nom.a().b().post(new AVGameBusinessCtrl.5(this, paramInt1, paramInt2));
  }
  
  private void c(int paramInt)
  {
    int j = 3;
    int i = 2;
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(b()), Boolean.valueOf(d()), Integer.valueOf(paramInt) }));
    bjty localbjty = bjtp.a().a();
    nof localnof;
    if (localbjty != null)
    {
      if ((paramInt == 0) || (!b())) {
        break label125;
      }
      localbjty.b(0);
      i = 0;
      paramInt = j;
      localnof = this.jdField_a_of_type_Nog.a();
      if (localnof != null) {
        if (i != 1) {
          break label165;
        }
      }
    }
    for (;;)
    {
      localnof.d = bool;
      b(localbjty.a(), paramInt);
      return;
      label125:
      if ((paramInt != 2) && (d()))
      {
        localbjty.b(2);
        paramInt = 0;
        break;
      }
      localbjty.b(1);
      paramInt = 0;
      i = 1;
      break;
      label165:
      bool = false;
    }
  }
  
  private boolean d()
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
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Boolean.valueOf(b()), Boolean.valueOf(d()) }));
    bjty localbjty = bjtp.a().a();
    nof localnof;
    if (localbjty != null)
    {
      if (!b()) {
        break label104;
      }
      localbjty.b(0);
      i = 0;
      localnof = this.jdField_a_of_type_Nog.a();
      if (localnof != null) {
        if (i != 1) {
          break label133;
        }
      }
    }
    for (;;)
    {
      localnof.d = bool;
      b(localbjty.a(), -1);
      return;
      label104:
      if (d())
      {
        localbjty.b(2);
        break;
      }
      localbjty.b(1);
      i = 1;
      break;
      label133:
      bool = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Nnw == null)
    {
      this.jdField_a_of_type_Nnw = new nnw();
      this.jdField_a_of_type_Nnw.d();
    }
  }
  
  public int a()
  {
    if (!a()) {
      return 0;
    }
    return this.jdField_a_of_type_Noc.a();
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt, nnq paramnnq)
  {
    if (!a()) {
      return -1;
    }
    nqc.a().a("param_QAVEnterRoom");
    bjuc.d("AVGameBusinessCtrl", "enterRoom. businessRoomId[" + paramString + "], onEnterRoom[" + paramnnq + "], svrRecordFlag[" + paramInt + "]");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AVGameAppInterface)) {}
    for (localObject = ((AVGameAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      if (nqf.a((String)localObject) == 0L)
      {
        bjuc.a("AVGameBusinessCtrl", "enterRoom failed. selfUin[" + (String)localObject + "] is illegal.");
        return -1;
      }
      int i = nqf.a(paramString);
      if (i == 0)
      {
        bjuc.a("AVGameBusinessCtrl", "enterRoom failed. invalid args. [" + paramString + "]");
        return -1;
      }
      paramString = this.jdField_a_of_type_Nog.a();
      if (paramString != null)
      {
        bjuc.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id(or peer uin) = " + paramString.jdField_a_of_type_Long + ", sessionId = " + paramString.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = nof.a(11, i);
      nof localnof = this.jdField_a_of_type_Nog.a(paramString);
      if (localnof != null)
      {
        bjuc.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id = " + localnof.jdField_a_of_type_Long + ", sessionId = " + localnof.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = this.jdField_a_of_type_Nog.a(1, paramString, true);
      if (paramString == null)
      {
        bjuc.a("AVGameBusinessCtrl", "enterRoom failed. create session fail");
        return -1;
      }
      paramString.jdField_b_of_type_Int = 11;
      paramString.jdField_a_of_type_Long = i;
      paramString.jdField_b_of_type_Boolean = false;
      paramString.c = true;
      paramString.a(1);
      paramString.jdField_b_of_type_Long = nqf.a((String)localObject);
      localObject = new bjto();
      ((bjto)localObject).jdField_a_of_type_Int = 11;
      ((bjto)localObject).jdField_b_of_type_Int = 14;
      ((bjto)localObject).c = 1;
      ((bjto)localObject).d = i;
      ((bjto)localObject).jdField_a_of_type_JavaLangString = "";
      ((bjto)localObject).jdField_a_of_type_Long = paramString.jdField_b_of_type_Long;
      ((bjto)localObject).e = 2;
      ((bjto)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((bjto)localObject).f = paramInt;
      paramInt = this.jdField_a_of_type_Noc.a((bjto)localObject);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_Nnq = paramnnq;
        return paramInt;
      }
      bjuc.a("AVGameBusinessCtrl", "enterRoom failed. retCode = " + paramInt);
      this.jdField_a_of_type_Nog.b(this.jdField_a_of_type_Nog.a().jdField_a_of_type_JavaLangString);
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
  
  public String a()
  {
    if (!a()) {
      return null;
    }
    return this.jdField_a_of_type_Noc.a();
  }
  
  public nnw a()
  {
    return this.jdField_a_of_type_Nnw;
  }
  
  public nof a()
  {
    if ((!a()) || (this.jdField_a_of_type_Nog == null)) {
      return null;
    }
    return this.jdField_a_of_type_Nog.a();
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (!a()) {
      return;
    }
    bjuc.c("AVGameBusinessCtrl", "setAudioRoute route = " + paramInt);
    this.jdField_a_of_type_Noc.b(paramInt);
    nof localnof = this.jdField_a_of_type_Nog.a();
    if (localnof != null) {
      if (paramInt != 1) {
        break label71;
      }
    }
    for (;;)
    {
      localnof.d = bool;
      b(paramInt, 0);
      return;
      label71:
      bool = false;
    }
  }
  
  public void a(ndt paramndt)
  {
    if (paramndt == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramndt)) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramndt));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      long l = Long.valueOf(((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin()).longValue();
      nof localnof = this.jdField_a_of_type_Nog.a();
      if (localnof != null) {
        a(paramBoolean, l, localnof.jdField_a_of_type_Long, localnof.jdField_b_of_type_Int, 0L, 0);
      }
    }
  }
  
  public void b()
  {
    bjuc.d("AVGameBusinessCtrl", "AVGameBusinessCtrl destroy.");
    bjtp.a().b(this.jdField_a_of_type_Bjub);
    this.jdField_a_of_type_Bjub = null;
    this.jdField_a_of_type_Nog = null;
    this.jdField_a_of_type_Noc = null;
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    bjtp.a().a();
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
    nof localnof = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOnStage, from[" + paramInt + "], session[" + localnof + "]");
    }
    if (localnof == null) {
      return;
    }
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localnof.g = bool;
      if (SecurityPolicyChecker.a().b()) {
        localnof.g = true;
      }
      Object localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).a("goOnStage");
      }
      localObject = bjtp.a().a();
      if (!(localObject instanceof noc)) {
        break;
      }
      localnof.b(1);
      if (((noc)localObject).a()) {
        break;
      }
      this.jdField_a_of_type_Bjub.a(false, localnof.jdField_a_of_type_Long, localnof.jdField_b_of_type_Int);
      return;
    }
  }
  
  public void b(ndt paramndt)
  {
    if (paramndt == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramndt))
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
    nof localnof;
    do
    {
      return;
      this.jdField_a_of_type_Noc.a(paramBoolean);
      localnof = this.jdField_a_of_type_Nog.a();
    } while (localnof == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localnof.e = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Noc.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!a()) {}
    nof localnof;
    do
    {
      return;
      this.jdField_a_of_type_Noc.b(paramBoolean);
      localnof = this.jdField_a_of_type_Nog.a();
    } while (localnof == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localnof.f = paramBoolean;
      return;
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Noc.b();
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
    nof localnof = this.jdField_a_of_type_Nog.a();
    StringBuilder localStringBuilder = new StringBuilder().append("exitRoom, session[");
    if (localnof == null) {}
    for (localObject = null;; localObject = localnof.jdField_a_of_type_JavaLangString)
    {
      bjuc.a("AVGameBusinessCtrl", (String)localObject + "]");
      if (this.jdField_a_of_type_Nnw != null)
      {
        this.jdField_a_of_type_Nnw.g();
        this.jdField_a_of_type_Nnw = null;
      }
      bjtp.a().a().a_(-1L, true, false);
      ngk.b();
      if (Build.VERSION.SDK_INT >= 16) {
        lfm.a();
      }
      localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).b(localnof);
      }
      if (localnof != null) {
        break;
      }
      bjuc.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return;
    }
    localnof.a(3);
    this.jdField_a_of_type_Nog.b(this.jdField_a_of_type_Nog.a().jdField_a_of_type_JavaLangString);
    bjuc.d("AVGameBusinessCtrl", "exitRoom mSessionManager has clear");
    this.jdField_a_of_type_Noc.e();
    localnof.a(4);
    this.c = true;
    bjuf.a().b();
  }
  
  public void f()
  {
    nof localnof = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOffStage, session[" + localnof + "]");
    }
    if (localnof == null) {}
    bjty localbjty;
    do
    {
      do
      {
        return;
        localnof.g = false;
        localbjty = bjtp.a().a();
      } while (!(localbjty instanceof noc));
      localnof.b(4);
    } while (((noc)localbjty).b());
    this.jdField_a_of_type_Bjub.b(false, localnof.jdField_a_of_type_Long, localnof.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnm
 * JD-Core Version:    0.7.0.1
 */