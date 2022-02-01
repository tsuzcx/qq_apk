import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyModule$requestUpdatePushStatus$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qpx
  extends niv
{
  qpx(Function1 paramFunction1) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    QLog.i("RIJPushNotifyModule", 1, "requestUpdatePushStatus response errorCode: " + paramInt);
    this.a.invoke(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpx
 * JD-Core Version:    0.7.0.1
 */