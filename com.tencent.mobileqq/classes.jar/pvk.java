import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class pvk
  implements View.OnClickListener
{
  public pvk(PTSFragment paramPTSFragment) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvk
 * JD-Core Version:    0.7.0.1
 */