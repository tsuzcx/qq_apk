import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/comment/handler/CreateFirstCommentHandler$send0xd1eRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorCode", "", "errorMsg", "", "bundle", "Landroid/os/Bundle;", "onResult", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owb
  extends nkq
{
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      owa.a(this.a, paramArrayOfByte);
      return;
    }
    this.a.a(paramInt, "Empty error message.");
  }
  
  public boolean a(int paramInt, @Nullable String paramString, @Nullable Bundle paramBundle)
  {
    paramBundle = this.a;
    if (paramString != null) {}
    for (;;)
    {
      paramBundle.a(paramInt, paramString);
      return true;
      paramString = "Empty error message.";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owb
 * JD-Core Version:    0.7.0.1
 */