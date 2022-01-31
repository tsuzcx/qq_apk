import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.qphone.base.util.QLog;

public class nvq
  implements View.OnClickListener
{
  public nvq(ReadInJoyCommentListView paramReadInJoyCommentListView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyCommentListView", 2, "loadmore comment when network not available");
    ReadInJoyCommentListView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nvq
 * JD-Core Version:    0.7.0.1
 */