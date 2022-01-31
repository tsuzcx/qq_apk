import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class ppc
  implements View.OnClickListener
{
  public ppc(PTSFragment paramPTSFragment) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppc
 * JD-Core Version:    0.7.0.1
 */