import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/push/mvp/RIJPushNotifyDialog$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "onChannelRefreshed", "", "success", "", "channelID", "", "articleSeqList", "", "", "noMoreData", "onPushNotifyDialogDismiss", "needAnimation", "uin", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qos
  extends pkt
{
  public void a(boolean paramBoolean1, int paramInt, @Nullable List<Long> paramList, boolean paramBoolean2)
  {
    this.a.b(true);
    qor.a(this.a).a().invoke(Boolean.valueOf(false), Boolean.valueOf(qor.a(this.a)), Integer.valueOf(0));
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if ((Intrinsics.areEqual(paramString, qor.a(this.a).b())) || (Intrinsics.areEqual(paramString, "MATCH_ALL_UIN")))
    {
      this.a.b(paramBoolean);
      qor.a(this.a).a().invoke(Boolean.valueOf(false), Boolean.valueOf(qor.a(this.a)), Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qos
 * JD-Core Version:    0.7.0.1
 */