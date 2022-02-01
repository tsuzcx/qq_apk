package com.tencent.tkd.weibo.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;

public class KeyBoardChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Window jdField_a_of_type_AndroidViewWindow;
  private KeyBoardChangeListener.KeyboardListener jdField_a_of_type_ComTencentTkdWeiboUtilsKeyBoardChangeListener$KeyboardListener;
  private boolean jdField_a_of_type_Boolean;
  
  private int a()
  {
    Display localDisplay = this.jdField_a_of_type_AndroidViewWindow.getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      localDisplay.getRealSize(localPoint);
    }
    for (;;)
    {
      return localPoint.y;
      localDisplay.getSize(localPoint);
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewWindow == null)) {
      break label14;
    }
    for (;;)
    {
      label14:
      return;
      if (this.jdField_a_of_type_AndroidViewView.getHeight() != 0)
      {
        int i = a();
        Rect localRect = new Rect();
        this.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
        i -= localRect.bottom;
        if (this.jdField_a_of_type_ComTencentTkdWeiboUtilsKeyBoardChangeListener$KeyboardListener == null) {
          break;
        }
        if (i > 300) {}
        for (boolean bool = true; this.jdField_a_of_type_Boolean != bool; bool = false)
        {
          this.jdField_a_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentTkdWeiboUtilsKeyBoardChangeListener$KeyboardListener.a(bool, i);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.KeyBoardChangeListener
 * JD-Core Version:    0.7.0.1
 */