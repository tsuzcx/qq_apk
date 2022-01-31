import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class ncp
  implements Runnable
{
  public ncp(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = PublicAccountImageCollectionMainActivity.b(this.a);
    if (localTranslateAnimation != null)
    {
      this.a.a.setVisibility(0);
      this.a.a.findViewById(2131365659).setVisibility(0);
      this.a.a.findViewById(2131365593).setVisibility(0);
      this.a.a.findViewById(2131365594).setVisibility(0);
      this.a.a.bringToFront();
      this.a.a.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncp
 * JD-Core Version:    0.7.0.1
 */