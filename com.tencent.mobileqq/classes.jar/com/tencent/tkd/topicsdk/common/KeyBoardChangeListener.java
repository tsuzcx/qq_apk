package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;

public class KeyBoardChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Window jdField_a_of_type_AndroidViewWindow;
  private KeyBoardChangeListener.KeyboardListener jdField_a_of_type_ComTencentTkdTopicsdkCommonKeyBoardChangeListener$KeyboardListener;
  private boolean jdField_a_of_type_Boolean = false;
  
  private KeyBoardChangeListener(Object paramObject)
  {
    if (paramObject == null) {
      Log.d("KeyboardChangeListener", "contextObj is null");
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Activity))
      {
        this.jdField_a_of_type_AndroidViewView = a((Activity)paramObject);
        this.jdField_a_of_type_AndroidViewWindow = ((Activity)paramObject).getWindow();
      }
      while ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewWindow != null))
      {
        a();
        return;
        if ((paramObject instanceof Dialog))
        {
          this.jdField_a_of_type_AndroidViewView = a((Dialog)paramObject);
          this.jdField_a_of_type_AndroidViewWindow = ((Dialog)paramObject).getWindow();
        }
      }
    }
  }
  
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
  
  private View a(Activity paramActivity)
  {
    return paramActivity.findViewById(16908290);
  }
  
  private View a(Dialog paramDialog)
  {
    return paramDialog.findViewById(16908290);
  }
  
  public static KeyBoardChangeListener a(Activity paramActivity)
  {
    return new KeyBoardChangeListener(paramActivity);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public void a(KeyBoardChangeListener.KeyboardListener paramKeyboardListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkCommonKeyBoardChangeListener$KeyboardListener = paramKeyboardListener;
  }
  
  public void onGlobalLayout()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewWindow == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidViewView.getHeight() == 0)
      {
        Log.d("KeyboardChangeListener", "currHeight is 0");
        return;
      }
      int i = a();
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
      int j = localRect.bottom;
      int k = i - j;
      Log.d("KeyboardChangeListener", "onGlobalLayout() called  screenHeight " + i + " VisibleDisplayHeight " + j);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkCommonKeyBoardChangeListener$KeyboardListener != null)
      {
        if (k > 300) {}
        for (boolean bool = true; this.jdField_a_of_type_Boolean != bool; bool = false)
        {
          this.jdField_a_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentTkdTopicsdkCommonKeyBoardChangeListener$KeyboardListener.a(bool, k);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.KeyBoardChangeListener
 * JD-Core Version:    0.7.0.1
 */