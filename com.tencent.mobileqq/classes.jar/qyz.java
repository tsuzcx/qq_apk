import com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule.reportTaskCompleted.1;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClientRedPacketModule$reportTaskCompleted$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IReportTaskProgressCallback$Stub;", "onReportFailed", "", "errorCode", "", "errorMsg", "", "onReportSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qyz
  extends qyu
{
  public void a()
  {
    qxx localqxx = this.a.$callback;
    if (localqxx != null) {
      localqxx.a();
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    qxx localqxx = this.a.$callback;
    if (localqxx != null) {
      localqxx.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyz
 * JD-Core Version:    0.7.0.1
 */