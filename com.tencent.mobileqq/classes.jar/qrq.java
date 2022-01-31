import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.mobileqq.utils.FileUtils;

public class qrq
  implements Runnable
{
  public qrq(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    GdtLog.a("GdtVideoCommonView", "showTisJob " + GdtVideoCommonView.a(this.a));
    if (GdtVideoCommonView.a(this.a)) {
      return;
    }
    GdtVideoCommonView.a(this.a, true);
    GdtVideoCommonView.a(this.a).setVisibility(8);
    GdtVideoCommonView.b(this.a).setVisibility(8);
    GdtVideoCommonView.a(this.a).setVisibility(0);
    if (GdtVideoCommonView.b(this.a) > 0L)
    {
      String str = FileUtils.a(GdtVideoCommonView.b(this.a));
      str = String.format(GdtVideoCommonView.a(this.a).getString(2131438978), new Object[] { str });
      GdtVideoCommonView.b(this.a).setText(str);
      GdtVideoCommonView.b(this.a).setVisibility(0);
      GdtVideoCommonView.b(this.a).setVisibility(8);
      return;
    }
    GdtVideoCommonView.b(this.a).setVisibility(8);
    GdtVideoCommonView.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qrq
 * JD-Core Version:    0.7.0.1
 */