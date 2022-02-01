import com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClientRedPacketModule$reportTaskCompleted$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IReportTaskProgressCallback$Stub;", "onReportFailed", "", "errorCode", "", "errorMsg", "", "onReportSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rlf
  extends rla
{
  public void a()
  {
    rkd localrkd = this.a.$callback;
    if (localrkd != null) {
      localrkd.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    rkd localrkd = this.a.$callback;
    if (localrkd != null) {
      localrkd.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlf
 * JD-Core Version:    0.7.0.1
 */