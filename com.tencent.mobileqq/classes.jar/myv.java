import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class myv
  implements Runnable
{
  public myv(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = PublicAccountImageCollectionMainActivity.b(this.a);
    if (localTranslateAnimation != null)
    {
      this.a.a.setVisibility(0);
      this.a.a.findViewById(2131365654).setVisibility(0);
      this.a.a.findViewById(2131365588).setVisibility(0);
      this.a.a.findViewById(2131365589).setVisibility(0);
      this.a.a.bringToFront();
      this.a.a.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myv
 * JD-Core Version:    0.7.0.1
 */