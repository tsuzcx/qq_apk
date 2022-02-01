package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class FullScreenDialog
  extends BaseDialog
{
  public FullScreenDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    if (Build.VERSION.SDK_INT >= 28) {
      localLayoutParams.layoutInDisplayCutoutMode = 1;
    }
    getWindow().setAttributes(localLayoutParams);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.FullScreenDialog
 * JD-Core Version:    0.7.0.1
 */