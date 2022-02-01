import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.adapter.VerticleViewPager;

public class ogw
  implements ViewPager.PageTransformer
{
  private ogw(VerticleViewPager paramVerticleViewPager) {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      paramView.setAlpha(1.0F);
      paramView.setTranslationX(paramView.getWidth() * -paramFloat);
      paramView.setTranslationY(paramView.getHeight() * paramFloat);
      return;
    }
    paramView.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogw
 * JD-Core Version:    0.7.0.1
 */