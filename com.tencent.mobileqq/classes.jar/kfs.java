import android.graphics.Bitmap;
import android.widget.RelativeLayout;
import com.tencent.av.ui.redbag.GuideTip2;

public class kfs
  implements Runnable
{
  public kfs(GuideTip2 paramGuideTip2, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.b);
    if (this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2.a != null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2.a.recycle();
      this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2.a = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2.b != null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2.b.recycle();
      this.jdField_a_of_type_ComTencentAvUiRedbagGuideTip2.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfs
 * JD-Core Version:    0.7.0.1
 */