import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class lat
  implements Runnable
{
  public lat(ReadInJoyNaviController paramReadInJoyNaviController) {}
  
  public void run()
  {
    Object localObject = ReadInJoyNaviController.a(this.a).a();
    ReadInJoyNaviController.a(this.a, 1000L);
    if ((localObject != null) && (ReadInJoyNaviController.a(this.a)))
    {
      ReadInJoyNaviController.a(this.a, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -((View)localObject).getHeight(), this.a.e);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new lau(this, (View)localObject));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (ReadInJoyNaviController.a(this.a) != null)
      {
        localObject = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        ReadInJoyNaviController.a(this.a).startAnimation((Animation)localObject);
      }
      ReadInJoyNaviController.a(0, ReadInJoyNaviController.a(0, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lat
 * JD-Core Version:    0.7.0.1
 */