import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlClientRedPacketModule;", "", "()V", "TAG", "", "rowkey", "currentContentTaskRowkey", "getCurrentContentTaskRowkey", "()Ljava/lang/String;", "setCurrentContentTaskRowkey", "(Ljava/lang/String;)V", "taskTimeInMs", "", "currentContentTaskTimeInMs", "getCurrentContentTaskTimeInMs", "()I", "setCurrentContentTaskTimeInMs", "(I)V", "type", "currentContentType", "getCurrentContentType", "setCurrentContentType", "curTaskTime", "globalCurrentTaskTimeInMs", "getGlobalCurrentTaskTimeInMs", "setGlobalCurrentTaskTimeInMs", "globalTotalTaskTimeInMs", "getGlobalTotalTaskTimeInMs", "isHighestRedPacketAuthorityOn", "", "()Z", "isNowInKanDianTab", "lastTaskContentRowkey", "getLastTaskContentRowkey", "lastTaskTimeForContentInMs", "getLastTaskTimeForContentInMs", "maxTaskTimePerContentInMs", "getMaxTaskTimePerContentInMs", "rijAidlInterfaceForRedPacket", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket;", "getRijAidlInterfaceForRedPacket", "()Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket;", "taskTimePerRoundInMs", "getTaskTimePerRoundInMs", "totalRound", "getTotalRound", "canDoTaskThisTime", "getInstance", "getTaskTimeFromCache", "rowKey", "hasRead", "hasRedPacketPermission", "reportTaskProgress", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager$IReportTaskProgressCallback;", "requestShouldDoTaskTiming", "Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager$IShouldDoTaskTimingCallback;", "saveTaskTimeToCache", "setCanDoTaskThisTime", "canDoTask", "nextRequestCanDoTaskTs", "", "setLastTaskTimeForContent", "setMaxTaskTimePerContent", "maxTaskTimeInMs", "setRead", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qig
{
  public static final qig a = new qig();
  
  private final qhx a()
  {
    Object localObject2 = null;
    qhr localqhr = qhu.a.a();
    Object localObject1 = localObject2;
    if (localqhr != null) {}
    try
    {
      localObject1 = localqhr.a();
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("RIJAidlClientRedPacketModule", 2, localRemoteException.getMessage());
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final qig a()
  {
    return a;
  }
  
  public final int a()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.a();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = a();
    if (localObject != null) {
      try
      {
        localObject = ((qhx)localObject).a();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "aidlInterface.currentContentTaskRowkey");
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return "";
  }
  
  public final void a(int paramInt)
  {
    qhx localqhx = a();
    if (localqhx != null) {}
    try
    {
      localqhx.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    qhx localqhx = a();
    if (localqhx != null) {}
    try
    {
      localqhx.a(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2, @Nullable qfs paramqfs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    qhx localqhx = a();
    if (localqhx != null) {}
    try
    {
      localqhx.a(paramString, paramInt1, paramInt2, (qia)new qih(paramqfs));
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
    }
  }
  
  public final void a(@NotNull qft paramqft)
  {
    Intrinsics.checkParameterIsNotNull(paramqft, "callback");
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        localqhx.a((qid)new qii(paramqft));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
        paramqft.a(false);
        return;
      }
    }
    paramqft.a(false);
  }
  
  public final boolean a()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        boolean bool = localqhx.d();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        boolean bool = localqhx.b(paramString);
        return bool;
      }
      catch (RemoteException paramString)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
      }
    }
    return false;
  }
  
  public final int b()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.b();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  @Nullable
  public final String b()
  {
    Object localObject = a();
    if (localObject != null) {
      try
      {
        localObject = ((qhx)localObject).b();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return null;
  }
  
  public final void b(int paramInt)
  {
    qhx localqhx = a();
    if (localqhx != null) {}
    try
    {
      localqhx.b(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final boolean b()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        boolean bool = localqhx.c();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final int c()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.c();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final void c(int paramInt)
  {
    qhx localqhx = a();
    if (localqhx != null) {}
    try
    {
      localqhx.d(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final boolean c()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        boolean bool = localqhx.a();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final int d()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.d();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final void d(int paramInt)
  {
    qhx localqhx = a();
    if (localqhx != null) {}
    try
    {
      localqhx.c(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final boolean d()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        boolean bool = localqhx.b();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final int e()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.f();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int f()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.g();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int g()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.h();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int h()
  {
    qhx localqhx = a();
    if (localqhx != null) {
      try
      {
        int i = localqhx.e();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qig
 * JD-Core Version:    0.7.0.1
 */