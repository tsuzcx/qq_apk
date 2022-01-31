import android.widget.TextView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

public class qkh
  implements Runnable
{
  public qkh(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    GdtVideoCommonView.a(this.a).setText(GdtUIUtils.a(GdtVideoCommonView.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qkh
 * JD-Core Version:    0.7.0.1
 */