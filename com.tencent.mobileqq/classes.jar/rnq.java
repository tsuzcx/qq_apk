import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;

public class rnq
  implements View.OnSystemUiVisibilityChangeListener
{
  public rnq(ViolaLazyFragment paramViolaLazyFragment) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    paramInt = this.a.getActivity().getWindow().getDecorView().getSystemUiVisibility();
    this.a.getActivity().getWindow().getDecorView().setSystemUiVisibility(paramInt | 0x2 | 0x400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnq
 * JD-Core Version:    0.7.0.1
 */