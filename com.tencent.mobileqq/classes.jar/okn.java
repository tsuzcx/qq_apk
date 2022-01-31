import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class okn
  implements View.OnClickListener
{
  public okn(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.a.b)
      {
        ReadInJoyCommentComponentFragment.a(this.a, false);
        return;
      }
      ReadInJoyCommentComponentFragment.a(this.a, true);
      return;
      ReadInJoyCommentComponentFragment.b(this.a);
      return;
      ReadInJoyCommentComponentFragment.b(this.a);
    } while (ReadInJoyCommentComponentFragment.a(this.a) == null);
    if (ReadInJoyCommentComponentFragment.c(this.a) >= ReadInJoyCommentComponentFragment.a(this.a).length) {
      ReadInJoyCommentComponentFragment.a(this.a, 0);
    }
    this.a.c.setText(ReadInJoyCommentComponentFragment.a(this.a)[ReadInJoyCommentComponentFragment.c(this.a)]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okn
 * JD-Core Version:    0.7.0.1
 */