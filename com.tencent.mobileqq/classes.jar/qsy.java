import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;

public class qsy
  implements View.OnClickListener
{
  public qsy(EditVideoFragment paramEditVideoFragment) {}
  
  public void onClick(View paramView)
  {
    if ((EditVideoFragment.a(this.a) != null) && (EditVideoFragment.a(this.a).isShowing())) {
      EditVideoFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsy
 * JD-Core Version:    0.7.0.1
 */