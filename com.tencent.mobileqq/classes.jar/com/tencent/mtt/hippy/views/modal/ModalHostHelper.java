package com.tencent.mtt.hippy.views.modal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

class ModalHostHelper
{
  private static final Point MAX_POINT = new Point();
  private static final Point MIN_POINT = new Point();
  private static final Point SIZE_POINT = new Point();
  
  @TargetApi(16)
  public static Point getModalHostSize(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.getCurrentSizeRange(MIN_POINT, MAX_POINT);
    }
    paramContext.getSize(SIZE_POINT);
    if (SIZE_POINT.x < SIZE_POINT.y) {
      return new Point(MIN_POINT.x, MAX_POINT.y);
    }
    return new Point(MAX_POINT.x, MIN_POINT.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.ModalHostHelper
 * JD-Core Version:    0.7.0.1
 */