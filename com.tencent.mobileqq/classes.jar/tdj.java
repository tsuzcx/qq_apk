import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.subscribe.comment.EmoView;

class tdj
  implements View.OnFocusChangeListener
{
  tdj(tdf paramtdf) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (tdf.a(this.a) != null) {
        tdf.a(this.a).setVisibility(8);
      }
      return;
    }
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdj
 * JD-Core Version:    0.7.0.1
 */