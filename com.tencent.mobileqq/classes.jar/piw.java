import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class piw
  implements View.OnClickListener
{
  public piw(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyProteusFamilyFragment.a(this.a) != null) {
      ReadInJoyProteusFamilyFragment.a(this.a).a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     piw
 * JD-Core Version:    0.7.0.1
 */