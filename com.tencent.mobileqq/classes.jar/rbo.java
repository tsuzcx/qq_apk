import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlClientRedPacketModule;", "", "()V", "TAG", "", "rowkey", "currentContentTaskRowkey", "getCurrentContentTaskRowkey", "()Ljava/lang/String;", "setCurrentContentTaskRowkey", "(Ljava/lang/String;)V", "taskTimeInMs", "", "currentContentTaskTimeInMs", "getCurrentContentTaskTimeInMs", "()I", "setCurrentContentTaskTimeInMs", "(I)V", "type", "currentContentType", "getCurrentContentType", "setCurrentContentType", "curTaskTime", "globalCurrentTaskTimeInMs", "getGlobalCurrentTaskTimeInMs", "setGlobalCurrentTaskTimeInMs", "globalTotalTaskTimeInMs", "getGlobalTotalTaskTimeInMs", "isHighestRedPacketAuthorityOn", "", "()Z", "isNowInKanDianTab", "lastTaskContentRowkey", "getLastTaskContentRowkey", "lastTaskTimeForContentInMs", "getLastTaskTimeForContentInMs", "maxTaskTimePerContentInMs", "getMaxTaskTimePerContentInMs", "rijAidlInterfaceForRedPacket", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket;", "getRijAidlInterfaceForRedPacket", "()Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket;", "taskTimePerRoundInMs", "getTaskTimePerRoundInMs", "totalRound", "getTotalRound", "canDoTaskThisTime", "getInstance", "getTaskTimeFromCache", "rowKey", "hasRead", "hasRedPacketPermission", "reportTaskProgress", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager$IReportTaskProgressCallback;", "requestShouldDoTaskTiming", "Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager$IShouldDoTaskTimingCallback;", "saveTaskTimeToCache", "setCanDoTaskThisTime", "canDoTask", "nextRequestCanDoTaskTs", "", "setLastTaskTimeForContent", "setMaxTaskTimePerContent", "maxTaskTimeInMs", "setRead", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rbo
{
  public static final rbo a = new rbo();
  
  private final rbf a()
  {
    Object localObject2 = null;
    raz localraz = rbc.a.a();
    Object localObject1 = localObject2;
    if (localraz != null) {}
    try
    {
      localObject1 = localraz.a();
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
  public static final rbo a()
  {
    return a;
  }
  
  public final int a()
  {
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.a();
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
        localObject = ((rbf)localObject).a();
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
    rbf localrbf = a();
    if (localrbf != null) {}
    try
    {
      localrbf.a(paramInt);
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
    rbf localrbf = a();
    if (localrbf != null) {}
    try
    {
      localrbf.a(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
    }
  }
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2, @Nullable qza paramqza)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    rbf localrbf = a();
    if (localrbf != null) {}
    try
    {
      localrbf.a(paramString, paramInt1, paramInt2, (rbi)new rbp(paramqza));
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
    }
  }
  
  public final void a(@NotNull qzb paramqzb)
  {
    Intrinsics.checkParameterIsNotNull(paramqzb, "callback");
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        localrbf.a((rbl)new rbq(paramqzb));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
        paramqzb.a(false);
        return;
      }
    }
    paramqzb.a(false);
  }
  
  public final boolean a()
  {
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        boolean bool = localrbf.d();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        boolean bool = localrbf.b(paramString);
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.b();
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
        localObject = ((rbf)localObject).b();
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
    rbf localrbf = a();
    if (localrbf != null) {}
    try
    {
      localrbf.b(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final boolean b()
  {
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        boolean bool = localrbf.c();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.c();
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
    rbf localrbf = a();
    if (localrbf != null) {}
    try
    {
      localrbf.d(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final boolean c()
  {
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        boolean bool = localrbf.a();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.d();
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
    rbf localrbf = a();
    if (localrbf != null) {}
    try
    {
      localrbf.c(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final boolean d()
  {
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        boolean bool = localrbf.b();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.f();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.g();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.h();
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
    rbf localrbf = a();
    if (localrbf != null) {
      try
      {
        int i = localrbf.e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbo
 * JD-Core Version:    0.7.0.1
 */