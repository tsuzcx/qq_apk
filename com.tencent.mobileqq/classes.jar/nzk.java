import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;

public class nzk
  implements TextView.OnEditorActionListener
{
  public nzk(DetailCommentHelper paramDetailCommentHelper) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.d();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzk
 * JD-Core Version:    0.7.0.1
 */