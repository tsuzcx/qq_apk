package dov.com.qq.im.ae;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import dov.com.qq.im.ae.util.AEPreviewSizeUtil;
import dov.com.qq.im.ae.util.AEQLog;

class AEPituCameraUnit$45
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int = 0;
  
  AEPituCameraUnit$45(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    ViewTreeObserver localViewTreeObserver;
    if (i > 1)
    {
      localViewTreeObserver = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.jdField_b_of_type_AndroidViewView.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label110;
        }
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      AEPreviewSizeUtil.a(new Size(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.jdField_b_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.jdField_b_of_type_AndroidViewView.getMeasuredHeight()));
      AEQLog.b(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.jdField_b_of_type_JavaLangString, "mMaxPreviewSize set: " + AEPreviewSizeUtil.a());
      return;
      label110:
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.45
 * JD-Core Version:    0.7.0.1
 */