import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;

public class nzm
  implements View.OnFocusChangeListener
{
  public nzm(DetailCommentHelper paramDetailCommentHelper) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.b();
    }
    while (DetailCommentHelper.a(this.a)) {
      return;
    }
    new Handler().postDelayed(new nzn(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzm
 * JD-Core Version:    0.7.0.1
 */