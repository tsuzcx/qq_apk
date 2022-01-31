import android.text.TextUtils;
import com.tencent.gdtad.qqproxy.GdtBrowserUtil;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;

public class qjo
  implements Runnable
{
  public qjo(GdtCanvasPictureComponentView paramGdtCanvasPictureComponentView, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData.actionUrl)) {
      GdtBrowserUtil.a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentView.getContext(), this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData.actionUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qjo
 * JD-Core Version:    0.7.0.1
 */