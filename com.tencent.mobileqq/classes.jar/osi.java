import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class osi
  implements View.OnClickListener
{
  public osi(ReadInJoyCommentListView paramReadInJoyCommentListView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyCommentListView", 2, "loadmore comment when network not available");
    ReadInJoyCommentListView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osi
 * JD-Core Version:    0.7.0.1
 */