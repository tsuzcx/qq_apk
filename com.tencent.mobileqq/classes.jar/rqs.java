import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rqs
  implements View.OnClickListener
{
  public rqs(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqs
 * JD-Core Version:    0.7.0.1
 */