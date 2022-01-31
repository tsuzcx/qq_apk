import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class mxo
  implements Runnable
{
  public mxo(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = PublicAccountImageCollectionMainActivity.b(this.a);
    if (localTranslateAnimation != null)
    {
      this.a.a.setVisibility(0);
      this.a.a.findViewById(2131365627).setVisibility(0);
      this.a.a.findViewById(2131365561).setVisibility(0);
      this.a.a.findViewById(2131365562).setVisibility(0);
      this.a.a.bringToFront();
      this.a.a.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxo
 * JD-Core Version:    0.7.0.1
 */