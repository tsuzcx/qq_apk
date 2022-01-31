import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;

public class nux
  implements View.OnFocusChangeListener
{
  public nux(DetailCommentHelper paramDetailCommentHelper) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.b();
    }
    while (DetailCommentHelper.a(this.a)) {
      return;
    }
    new Handler().postDelayed(new nuy(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nux
 * JD-Core Version:    0.7.0.1
 */