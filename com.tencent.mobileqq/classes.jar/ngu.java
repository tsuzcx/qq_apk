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

public class ngu
{
  private static volatile ngu jdField_a_of_type_Ngu;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ngv(this);
  private biiz jdField_a_of_type_Biiz = new ngw(this);
  private AVGameCameraAssistant jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant;
  private final ArrayList<WeakReference<myh>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final WeakReference<AVGameAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private ngy jdField_a_of_type_Ngy;
  private nhe jdField_a_of_type_Nhe;
  private nhk jdField_a_of_type_Nhk;
  private nho jdField_a_of_type_Nho;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  
  private ngu()
  {
    nje.a().a("param_QAVInit");
    njq.a().b("AVGameBusinessCtrlInit");
    bija.d("AVGameBusinessCtrl", "AVGameBusinessCtrl create and init.");
    Object localObject3 = BaseApplicationImpl.getApplication().getQQProcessName();
    QLog.i("AVGameBusinessCtrl", 1, "init, [" + (String)localObject3 + "]");
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = null;
    if ((localObject2 instanceof AVGameAppInterface)) {
      localObject1 = (AVGameAppInterface)localObject2;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject1);
    ((PushManager)((AppRuntime)localObject2).getManager(5)).registProxyMessagePush(AppSetting.a(), (String)localObject3, "", new String[] { "MultiVideo.c2sack", "MultiVideo.s2c", "VideoCCSvc.Adaptation", "OnlinePush.ReqPush" });
    bija.a(new bijc());
    localObject1 = biiq.a();
    ((biiq)localObject1).a((AppRuntime)localObject2);
    ((biiq)localObject1).a(new ngx(this));
    long l = ((AppRuntime)localObject2).getLongAccountUin();
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    localObject3 = new nhl((Context)localObject2, new nhk((Context)localObject2, l, (biir)localObject1));
    biin localbiin = biin.a();
    localbiin.a((biiv)localObject3);
    localbiin.a((Context)localObject2, l, (biir)localObject1);
    this.jdField_a_of_type_Nhk = ((nhk)biin.a().a());
    this.jdField_a_of_type_Nho = new nho();
    localbiin.a(this.jdField_a_of_type_Biiz);
    njq.a().c("AVGameBusinessCtrlInit");
    nje.a().a("param_QAVInit", 0);
    nje.a().a("param_AVGameInit", 0);
  }
  
  public static ngu a()
  {
    return b();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Ngu != null) {
      try
      {
        if (jdField_a_of_type_Ngu != null) {
          jdField_a_of_type_Ngu.b();
        }
        jdField_a_of_type_Ngu = null;
        return;
      }
      finally {}
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(b()), Boolean.valueOf(c()), Integer.valueOf(paramInt2) }));
    biiw localbiiw = biin.a().a();
    if (localbiiw != null) {
      localbiiw.b(paramInt1);
    }
    nhn localnhn = this.jdField_a_of_type_Nho.a();
    if (localnhn != null) {
      if (paramInt1 != 1) {
        break label115;
      }
    }
    for (;;)
    {
      localnhn.d = bool;
      if (localbiiw != null) {
        b(localbiiw.a(), paramInt2);
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
    nht.a().a().post(new AVGameBusinessCtrl.4(this, paramIntent, paramContext));
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 2;
    bija.c("AVGameBusinessCtrl", "onMemberShareInOrOut, shareIn[" + paramBoolean + "], userUin[" + paramLong1 + "]");
    ??? = nhn.a(paramInt1, paramLong2);
    ??? = this.jdField_a_of_type_Nho.a((String)???);
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onMemberShareInOrOut failed, session is null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((nhn)???).b(paramLong1, paramBoolean, paramInt1);
      bija.c("AVGameBusinessCtrl", "onMemberShareInOrOut, updateUserSubVideoStatus result[" + bool + "]");
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
        ((myh)localWeakReference.get()).b(paramBoolean, paramLong1, 2);
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Ngu == null) {
      bija.b("AVGameBusinessCtrl", "ERROR!!! Instance == null. ", new Throwable("打印调用栈"));
    }
    return jdField_a_of_type_Ngu != null;
  }
  
  public static ngu b()
  {
    if (jdField_a_of_type_Ngu == null) {}
    try
    {
      if (jdField_a_of_type_Ngu == null) {
        jdField_a_of_type_Ngu = new ngu();
      }
      return jdField_a_of_type_Ngu;
    }
    finally {}
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    nht.a().b().post(new AVGameBusinessCtrl.5(this, paramInt1, paramInt2));
  }
  
  private void c(int paramInt)
  {
    int j = 3;
    int i = 2;
    boolean bool = true;
    QLog.d("AVGameBusinessCtrl", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", new Object[] { Boolean.valueOf(b()), Boolean.valueOf(c()), Integer.valueOf(paramInt) }));
    biiw localbiiw = biin.a().a();
    nhn localnhn;
    if (localbiiw != null)
    {
      if ((paramInt == 0) || (!b())) {
        break label125;
      }
      localbiiw.b(0);
      i = 0;
      paramInt = j;
      localnhn = this.jdField_a_of_type_Nho.a();
      if (localnhn != null) {
        if (i != 1) {
          break label165;
        }
      }
    }
    for (;;)
    {
      localnhn.d = bool;
      b(localbiiw.a(), paramInt);
      return;
      label125:
      if ((paramInt != 2) && (c()))
      {
        localbiiw.b(2);
        paramInt = 0;
        break;
      }
      localbiiw.b(1);
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
    biiw localbiiw = biin.a().a();
    nhn localnhn;
    if (localbiiw != null)
    {
      if (!b()) {
        break label104;
      }
      localbiiw.b(0);
      i = 0;
      localnhn = this.jdField_a_of_type_Nho.a();
      if (localnhn != null) {
        if (i != 1) {
          break label133;
        }
      }
    }
    for (;;)
    {
      localnhn.d = bool;
      b(localbiiw.a(), -1);
      return;
      label104:
      if (c())
      {
        localbiiw.b(2);
        break;
      }
      localbiiw.b(1);
      i = 1;
      break;
      label133:
      bool = false;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Nhe == null)
    {
      this.jdField_a_of_type_Nhe = new nhe();
      this.jdField_a_of_type_Nhe.d();
    }
  }
  
  public int a()
  {
    if (!a()) {
      return 0;
    }
    return this.jdField_a_of_type_Nhk.a();
  }
  
  public int a(String paramString, byte[] paramArrayOfByte, int paramInt, ngy paramngy)
  {
    if (!a()) {
      return -1;
    }
    nje.a().a("param_QAVEnterRoom");
    bija.d("AVGameBusinessCtrl", "enterRoom. businessRoomId[" + paramString + "], onEnterRoom[" + paramngy + "], svrRecordFlag[" + paramInt + "]");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof AVGameAppInterface)) {}
    for (localObject = ((AVGameAppInterface)localObject).getCurrentAccountUin();; localObject = "")
    {
      if (njh.a((String)localObject) == 0L)
      {
        bija.a("AVGameBusinessCtrl", "enterRoom failed. selfUin[" + (String)localObject + "] is illegal.");
        return -1;
      }
      int i = njh.a(paramString);
      if (i == 0)
      {
        bija.a("AVGameBusinessCtrl", "enterRoom failed. invalid args. [" + paramString + "]");
        return -1;
      }
      paramString = this.jdField_a_of_type_Nho.a();
      if (paramString != null)
      {
        bija.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id(or peer uin) = " + paramString.jdField_a_of_type_Long + ", sessionId = " + paramString.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = nhn.a(11, i);
      nhn localnhn = this.jdField_a_of_type_Nho.a(paramString);
      if (localnhn != null)
      {
        bija.a("AVGameBusinessCtrl", "enterRoom failed. a call already exist. relation id = " + localnhn.jdField_a_of_type_Long + ", sessionId = " + localnhn.jdField_a_of_type_JavaLangString);
        return -1;
      }
      paramString = this.jdField_a_of_type_Nho.a(1, paramString, true);
      if (paramString == null)
      {
        bija.a("AVGameBusinessCtrl", "enterRoom failed. create session fail");
        return -1;
      }
      paramString.jdField_b_of_type_Int = 11;
      paramString.jdField_a_of_type_Long = i;
      paramString.jdField_b_of_type_Boolean = false;
      paramString.c = true;
      paramString.a(1);
      paramString.jdField_b_of_type_Long = njh.a((String)localObject);
      localObject = new biim();
      ((biim)localObject).jdField_a_of_type_Int = 11;
      ((biim)localObject).jdField_b_of_type_Int = 14;
      ((biim)localObject).c = 1;
      ((biim)localObject).d = i;
      ((biim)localObject).jdField_a_of_type_JavaLangString = "";
      ((biim)localObject).jdField_a_of_type_Long = paramString.jdField_b_of_type_Long;
      ((biim)localObject).e = 2;
      ((biim)localObject).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      ((biim)localObject).f = paramInt;
      paramInt = this.jdField_a_of_type_Nhk.a((biim)localObject);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_Ngy = paramngy;
        return paramInt;
      }
      bija.a("AVGameBusinessCtrl", "enterRoom failed. retCode = " + paramInt);
      this.jdField_a_of_type_Nho.b(this.jdField_a_of_type_Nho.a().jdField_a_of_type_JavaLangString);
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
    return this.jdField_a_of_type_Nhk.a();
  }
  
  public nhe a()
  {
    return this.jdField_a_of_type_Nhe;
  }
  
  public nhn a()
  {
    if ((!a()) || (this.jdField_a_of_type_Nho == null)) {
      return null;
    }
    return this.jdField_a_of_type_Nho.a();
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (!a()) {
      return;
    }
    bija.c("AVGameBusinessCtrl", "setAudioRoute route = " + paramInt);
    this.jdField_a_of_type_Nhk.b(paramInt);
    nhn localnhn = this.jdField_a_of_type_Nho.a();
    if (localnhn != null) {
      if (paramInt != 1) {
        break label71;
      }
    }
    for (;;)
    {
      localnhn.d = bool;
      b(paramInt, 0);
      return;
      label71:
      bool = false;
    }
  }
  
  public void a(myh parammyh)
  {
    if (parammyh == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parammyh)) {
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parammyh));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      long l = Long.valueOf(((AVGameAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin()).longValue();
      nhn localnhn = this.jdField_a_of_type_Nho.a();
      if (localnhn != null) {
        a(paramBoolean, l, localnhn.jdField_a_of_type_Long, localnhn.jdField_b_of_type_Int, 0L, 0);
      }
    }
  }
  
  public void b()
  {
    bija.d("AVGameBusinessCtrl", "AVGameBusinessCtrl destroy.");
    biin.a().b(this.jdField_a_of_type_Biiz);
    this.jdField_a_of_type_Biiz = null;
    this.jdField_a_of_type_Nho = null;
    this.jdField_a_of_type_Nhk = null;
    ((PushManager)BaseApplicationImpl.getApplication().getRuntime().getManager(5)).unregistProxyMessagePush(AppSetting.a(), BaseApplicationImpl.getApplication().getQQProcessName());
    biin.a().a();
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
    nhn localnhn = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOnStage, from[" + paramInt + "], session[" + localnhn + "]");
    }
    if (localnhn == null) {
      return;
    }
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localnhn.g = bool;
      if (SecurityPolicyChecker.a().b()) {
        localnhn.g = true;
      }
      Object localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).a("goOnStage");
      }
      localObject = biin.a().a();
      if (!(localObject instanceof nhk)) {
        break;
      }
      localnhn.b(1);
      if (((nhk)localObject).a()) {
        break;
      }
      this.jdField_a_of_type_Biiz.onGoOnStageRet(false, localnhn.jdField_a_of_type_Long, localnhn.jdField_b_of_type_Int);
      return;
    }
  }
  
  public void b(myh parammyh)
  {
    if (parammyh == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parammyh))
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
    nhn localnhn;
    do
    {
      return;
      this.jdField_a_of_type_Nhk.b(paramBoolean);
      localnhn = this.jdField_a_of_type_Nho.a();
    } while (localnhn == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localnhn.e = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Nhk.a();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!a()) {}
    nhn localnhn;
    do
    {
      return;
      this.jdField_a_of_type_Nhk.c(paramBoolean);
      localnhn = this.jdField_a_of_type_Nho.a();
    } while (localnhn == null);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localnhn.f = paramBoolean;
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nhk.b();
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
    nhn localnhn = this.jdField_a_of_type_Nho.a();
    StringBuilder localStringBuilder = new StringBuilder().append("exitRoom, session[");
    if (localnhn == null) {}
    for (localObject = null;; localObject = localnhn.jdField_a_of_type_JavaLangString)
    {
      bija.a("AVGameBusinessCtrl", (String)localObject + "]");
      if (this.jdField_a_of_type_Nhe != null)
      {
        this.jdField_a_of_type_Nhe.g();
        this.jdField_a_of_type_Nhe = null;
      }
      biin.a().a().a_(-1L, true, false);
      nau.b();
      if (Build.VERSION.SDK_INT >= 16) {
        mxh.a();
      }
      localObject = a();
      if (localObject != null) {
        ((AVGameCameraAssistant)localObject).b(localnhn);
      }
      if (localnhn != null) {
        break;
      }
      bija.a("AVGameBusinessCtrl", "exitRoom failed. session == null.");
      return;
    }
    localnhn.a(3);
    this.jdField_a_of_type_Nho.b(this.jdField_a_of_type_Nho.a().jdField_a_of_type_JavaLangString);
    bija.d("AVGameBusinessCtrl", "exitRoom mSessionManager has clear");
    this.jdField_a_of_type_Nhk.e();
    localnhn.a(4);
    this.c = true;
    bijd.a().b();
  }
  
  public void f()
  {
    nhn localnhn = a();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "goOffStage, session[" + localnhn + "]");
    }
    if (localnhn == null) {}
    biiw localbiiw;
    do
    {
      do
      {
        return;
        localnhn.g = false;
        localbiiw = biin.a().a();
      } while (!(localbiiw instanceof nhk));
      localnhn.b(4);
    } while (((nhk)localbiiw).b());
    this.jdField_a_of_type_Biiz.onGoOffStageRet(false, localnhn.jdField_a_of_type_Long, localnhn.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngu
 * JD-Core Version:    0.7.0.1
 */