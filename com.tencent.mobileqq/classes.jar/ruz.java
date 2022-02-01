import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ruz
  implements View.OnClickListener
{
  public ruz(ReadInJoyPrivacyListView paramReadInJoyPrivacyListView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPrivacyListView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruz
 * JD-Core Version:    0.7.0.1
 */