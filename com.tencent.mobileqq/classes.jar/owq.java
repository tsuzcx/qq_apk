import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/helper/RIJBiuNetworkHelper$requestBiuAfterComment$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owq
  extends nkq
{
  owq(Function1 paramFunction1) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      this.a.invoke(Boolean.valueOf(true));
      return;
    }
    this.a.invoke(Boolean.valueOf(false));
  }
  
  public boolean a(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    this.a.invoke(Boolean.valueOf(false));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owq
 * JD-Core Version:    0.7.0.1
 */