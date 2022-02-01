import android.os.Bundle;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.RspBody;
import tencent.im.oidb.cmd0xe5c.cmd0xe5c.VideoRspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWriteWatchWordModel$fetchVideoWatchWord$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qti
  extends nkq
{
  qti(Function3 paramFunction3) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    QLog.i("RIJWriteWatchWordModel", 1, "fetchVideoWatchWord error code = " + paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new cmd0xe5c.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (cmd0xe5c.VideoRspBody)paramBundle.video_rsp_body.get();
      paramBundle = this.a;
      if (paramBundle != null)
      {
        String str1 = paramArrayOfByte.watch_word.get();
        String str2 = paramArrayOfByte.url.get();
        Intrinsics.checkExpressionValueIsNotNull(str2, "videoRspBody.url.get()");
        paramArrayOfByte = (Unit)paramBundle.invoke(str1, str2, Boolean.valueOf(paramArrayOfByte.is_open.get()));
      }
    }
    do
    {
      return;
      paramArrayOfByte = this.a;
    } while (paramArrayOfByte == null);
    paramArrayOfByte = (Unit)paramArrayOfByte.invoke(null, "", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qti
 * JD-Core Version:    0.7.0.1
 */