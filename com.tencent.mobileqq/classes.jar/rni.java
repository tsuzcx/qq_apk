import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoLoadingFooter;

public class rni
  implements View.OnLayoutChangeListener
{
  public rni(MultiVideoLoadingFooter paramMultiVideoLoadingFooter) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.removeOnLayoutChangeListener(this);
    this.a.getLayoutParams().height = (((View)this.a.getParent()).getHeight() * 2 / 3);
    this.a.setLayoutParams(this.a.getLayoutParams());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rni
 * JD-Core Version:    0.7.0.1
 */