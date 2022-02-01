import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "shouldDoTaskTiming", "", "onShouldDoTaskTimingCallback"}, k=3, mv={1, 1, 16})
final class rbv
  implements qzb
{
  rbv(rbl paramrbl) {}
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.a.a(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      QLog.e("RIJAidlServerRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbv
 * JD-Core Version:    0.7.0.1
 */