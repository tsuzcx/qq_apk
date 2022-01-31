import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.viola.core.ViolaInstance;

public class sab
  implements View.OnLayoutChangeListener
{
  public sab(ViolaBaseView paramViolaBaseView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (ViolaBaseView.a(this.a) != null) {
      ViolaBaseView.a(this.a).setSize(paramView.getWidth(), paramView.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sab
 * JD-Core Version:    0.7.0.1
 */