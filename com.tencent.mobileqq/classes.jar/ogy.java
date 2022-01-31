import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.qphone.base.util.QLog;

public class ogy
  implements View.OnClickListener
{
  public ogy(ReadInJoyCommentListView paramReadInJoyCommentListView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyCommentListView", 2, "loadmore comment when network not available");
    ReadInJoyCommentListView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ogy
 * JD-Core Version:    0.7.0.1
 */