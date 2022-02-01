import com.tencent.biz.pubaccount.readinjoy.service.redpacket.RIJAidlClientRedPacketModule.requestShouldDoTaskTiming.1.onShouldDoTaskTimingCallback.1;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlClientRedPacketModule$requestShouldDoTaskTiming$1", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IShouldDoTaskTimingCallback$Stub;", "onShouldDoTaskTimingCallback", "", "shouldDoTaskTiming", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qsj
  extends qsg
{
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJAidlClientRedPacketModule.requestShouldDoTaskTiming.1.onShouldDoTaskTimingCallback.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qsj
 * JD-Core Version:    0.7.0.1
 */