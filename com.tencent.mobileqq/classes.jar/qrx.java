import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient$RIJServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class qrx
  implements ServiceConnection
{
  public void onServiceConnected(@NotNull ComponentName paramComponentName, @NotNull IBinder paramIBinder)
  {
    Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
    Intrinsics.checkParameterIsNotNull(paramIBinder, "service");
    qrw.a(qrw.a, qru.a(paramIBinder));
    QLog.d("RIJAidlClient", 1, "onServiceConnected: " + paramComponentName);
  }
  
  public void onServiceDisconnected(@NotNull ComponentName paramComponentName)
  {
    Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
    qrw.a(qrw.a, (qrt)null);
    QLog.d("RIJAidlClient", 1, "onServiceDisconnected: " + paramComponentName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrx
 * JD-Core Version:    0.7.0.1
 */