package dov.com.tencent.mobileqq.shortvideo.util;

import android.graphics.Rect;
import android.view.View;

public class AndroidBug5497Workaround
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private final AndroidBug5497Workaround.SoftKeyboardVisibilityListener jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAndroidBug5497Workaround$SoftKeyboardVisibilityListener;
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    if (i != this.jdField_a_of_type_Int)
    {
      int j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAndroidBug5497Workaround$SoftKeyboardVisibilityListener != null)
      {
        if (j - i <= j / 4) {
          break label56;
        }
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAndroidBug5497Workaround$SoftKeyboardVisibilityListener.a(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label56:
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAndroidBug5497Workaround$SoftKeyboardVisibilityListener.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.AndroidBug5497Workaround
 * JD-Core Version:    0.7.0.1
 */