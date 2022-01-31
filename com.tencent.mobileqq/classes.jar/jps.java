import android.view.View;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;

public class jps
  implements Runnable
{
  public jps(SmallScreenVideoLayerUI paramSmallScreenVideoLayerUI) {}
  
  public void run()
  {
    if (SmallScreenVideoLayerUI.a(this.a) != null) {
      SmallScreenVideoLayerUI.b(this.a).findViewById(2131366230).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jps
 * JD-Core Version:    0.7.0.1
 */