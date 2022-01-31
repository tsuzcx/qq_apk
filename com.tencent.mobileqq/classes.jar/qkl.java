import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class qkl
  implements Runnable
{
  public qkl(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    if (GdtVideoCommonView.b(this.a) == 5)
    {
      GdtVideoCommonView.a(this.a).setVisibility(8);
      GdtVideoCommonView.b(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qkl
 * JD-Core Version:    0.7.0.1
 */