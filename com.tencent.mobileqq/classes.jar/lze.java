import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class lze
  implements View.OnClickListener
{
  public lze(TopicShareHelper paramTopicShareHelper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    if (TopicShareHelper.a(this.a).isShowing()) {
      TopicShareHelper.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lze
 * JD-Core Version:    0.7.0.1
 */