import android.view.View;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;

public class jpd
  implements Runnable
{
  public jpd(SmallScreenVideoLayerUI paramSmallScreenVideoLayerUI) {}
  
  public void run()
  {
    if (SmallScreenVideoLayerUI.a(this.a) != null) {
      SmallScreenVideoLayerUI.b(this.a).findViewById(2131366257).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpd
 * JD-Core Version:    0.7.0.1
 */