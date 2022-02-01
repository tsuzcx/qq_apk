import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class rks
  implements View.OnClickListener
{
  rks(rkk paramrkk) {}
  
  public final void onClick(View paramView)
  {
    if (rkk.b(this.a))
    {
      localObject1 = rkk.a(this.a);
      if (localObject1 != null) {
        ((rkl)localObject1).a("喂饼中，请稍等～");
      }
    }
    int j = rkk.a(this.a, rkk.a(this.a));
    Object localObject1 = rkk.a(this.a);
    int i;
    if (localObject1 != null)
    {
      Object localObject2 = ((VideoInfo)localObject1).j;
      if (localObject2 == null) {
        break label164;
      }
      if (((CharSequence)localObject2).length() <= 0) {
        break label159;
      }
      i = 1;
      if (i != 1) {
        break label164;
      }
      rkk.a(this.a, true);
      rkk.b(this.a, rkk.a(this.a));
      localObject2 = pvj.a();
      String str = ((VideoInfo)localObject1).j;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.accountUin");
      ((pvj)localObject2).a(Long.parseLong(str), j, ((VideoInfo)localObject1).g);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label159:
      i = 0;
      break;
      label164:
      localObject1 = rkk.a(this.a);
      if (localObject1 != null) {
        ((rkl)localObject1).a(false, "喂饼失败", rkk.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rks
 * JD-Core Version:    0.7.0.1
 */