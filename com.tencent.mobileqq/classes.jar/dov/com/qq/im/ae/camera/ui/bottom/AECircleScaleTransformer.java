package dov.com.qq.im.ae.camera.ui.bottom;

import android.view.View;
import com.tencent.biz.videostory.capture.widgets.Pivot;
import com.tencent.biz.videostory.capture.widgets.VideoStoryScrollItemTransformer;
import dov.com.qq.im.ae.util.AEQLog;

public class AECircleScaleTransformer
  implements VideoStoryScrollItemTransformer
{
  private float jdField_a_of_type_Float = 0.8F;
  private Pivot jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsPivot = Pivot.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private Pivot jdField_b_of_type_ComTencentBizVideostoryCaptureWidgetsPivot = Pivot.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsPivot.a(paramView);
    this.jdField_b_of_type_ComTencentBizVideostoryCaptureWidgetsPivot.a(paramView);
    float f1 = Math.abs(paramFloat);
    float f2 = this.jdField_a_of_type_Float;
    f1 = (1.0F - f1) * this.jdField_b_of_type_Float + f2;
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    View localView1 = paramView.findViewById(2131381505);
    View localView2 = paramView.findViewById(2131381519);
    if (localView1 != null) {
      localView1.setAlpha(Math.abs(paramFloat));
    }
    if (localView2 != null) {
      localView2.setAlpha(Math.abs(paramFloat));
    }
    AEQLog.a("AECircleScaleTransformer", "position: " + paramFloat + " view: " + paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AECircleScaleTransformer
 * JD-Core Version:    0.7.0.1
 */