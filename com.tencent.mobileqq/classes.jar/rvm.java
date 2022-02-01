import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rvm
  implements View.OnClickListener
{
  public rvm(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvm
 * JD-Core Version:    0.7.0.1
 */