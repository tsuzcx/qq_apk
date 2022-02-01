import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ori
  implements View.OnClickListener
{
  public ori(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.b)
      {
        ReadInJoyCommentComponentFragment.a(this.a, false);
      }
      else
      {
        ReadInJoyCommentComponentFragment.a(this.a, true);
        continue;
        ReadInJoyCommentComponentFragment.b(this.a);
        continue;
        ReadInJoyCommentComponentFragment.b(this.a);
        if (ReadInJoyCommentComponentFragment.a(this.a) != null)
        {
          if (ReadInJoyCommentComponentFragment.c(this.a) >= ReadInJoyCommentComponentFragment.a(this.a).length) {
            ReadInJoyCommentComponentFragment.a(this.a, 0);
          }
          this.a.c.setText(ReadInJoyCommentComponentFragment.a(this.a)[ReadInJoyCommentComponentFragment.c(this.a)]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ori
 * JD-Core Version:    0.7.0.1
 */