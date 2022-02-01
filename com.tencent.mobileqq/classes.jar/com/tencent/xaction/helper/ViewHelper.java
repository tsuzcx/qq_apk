package com.tencent.xaction.helper;

import android.view.View;
import androidx.annotation.RequiresApi;

public class ViewHelper
{
  @RequiresApi(api=21)
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.setOutlineProvider(new ViewHelper.1(paramInt2, paramInt1));
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setClipToOutline(bool);
    paramView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.helper.ViewHelper
 * JD-Core Version:    0.7.0.1
 */