import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment$handleVideoAddToTopicResult$1$1"}, k=3, mv={1, 1, 16})
public final class rpq
  implements View.OnClickListener
{
  public rpq(FragmentActivity paramFragmentActivity, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    String str = rha.a() + this.jdField_a_of_type_Int;
    tgc.a((Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", str, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpq
 * JD-Core Version:    0.7.0.1
 */