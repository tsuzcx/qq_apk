import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor$fetchFollowStatus$1", "Lcom/tencent/biz/pubaccount/readinjoy/model/FollowListInfoModule$FollowStatusObserver;", "requestFollowStatusBack", "", "result", "", "uinsFollowStatus", "", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/FollowingMember;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class psc
  implements qfs
{
  psc(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(int paramInt, @Nullable Map<Long, rpf> paramMap)
  {
    paramMap = pvj.a();
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "ReadInJoyLogicEngine.getInstance()");
    paramMap = paramMap.a();
    if (paramMap != null) {
      paramMap.b((qfs)this);
    }
    this.a.hasRequestFollowStatus = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psc
 * JD-Core Version:    0.7.0.1
 */