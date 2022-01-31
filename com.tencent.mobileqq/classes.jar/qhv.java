import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/RIJAidlClient$RIJServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class qhv
  implements ServiceConnection
{
  public void onServiceConnected(@NotNull ComponentName paramComponentName, @NotNull IBinder paramIBinder)
  {
    Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
    Intrinsics.checkParameterIsNotNull(paramIBinder, "service");
    qhu.a(qhu.a, qhs.a(paramIBinder));
  }
  
  public void onServiceDisconnected(@NotNull ComponentName paramComponentName)
  {
    Intrinsics.checkParameterIsNotNull(paramComponentName, "name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhv
 * JD-Core Version:    0.7.0.1
 */