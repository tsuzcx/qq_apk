import com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "uinsFollowStatus", "", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/FollowingMember;", "requestFollowStatusBack", "com/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/DataBridgeInvokeHandler$isFollowUin$1$1$1"}, k=3, mv={1, 1, 16})
public final class tgu
  implements ppq
{
  public tgu(DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1 param1) {}
  
  public final void a(int paramInt, @Nullable Map<Long, ? extends qwb> paramMap)
  {
    if ((paramMap != null) && (paramMap.get(Long.valueOf(Long.parseLong(this.a.a))) != null))
    {
      paramMap = (qwb)paramMap.get(Long.valueOf(Long.parseLong(this.a.a)));
      if (paramMap != null)
      {
        boolean bool = paramMap.a();
        tgs.a(this.a.this$0, bool, this.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgu
 * JD-Core Version:    0.7.0.1
 */