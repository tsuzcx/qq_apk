import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class qym
  implements View.OnClickListener
{
  qym(qye paramqye) {}
  
  public final void onClick(View paramView)
  {
    if (qye.b(this.a))
    {
      localObject1 = qye.a(this.a);
      if (localObject1 != null) {
        ((qyf)localObject1).a("喂饼中，请稍等～");
      }
    }
    int j = qye.a(this.a, qye.a(this.a));
    Object localObject1 = qye.a(this.a);
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
      qye.a(this.a, true);
      qye.b(this.a, qye.a(this.a));
      localObject2 = pkm.a();
      String str = ((VideoInfo)localObject1).j;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.accountUin");
      ((pkm)localObject2).a(Long.parseLong(str), j, ((VideoInfo)localObject1).g);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label159:
      i = 0;
      break;
      label164:
      localObject1 = qye.a(this.a);
      if (localObject1 != null) {
        ((qyf)localObject1).a(false, "喂饼失败", qye.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qym
 * JD-Core Version:    0.7.0.1
 */