import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lsv
  implements ActionSheet.OnButtonClickListener
{
  public lsv(OnTopicRecommendHeaderFollowClickListener paramOnTopicRecommendHeaderFollowClickListener) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      OnTopicRecommendHeaderFollowClickListener.a(this.a).dismiss();
      return;
      OnTopicRecommendHeaderFollowClickListener.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsv
 * JD-Core Version:    0.7.0.1
 */