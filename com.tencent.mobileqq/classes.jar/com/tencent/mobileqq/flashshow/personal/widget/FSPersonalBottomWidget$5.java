package com.tencent.mobileqq.flashshow.personal.widget;

import android.widget.LinearLayout;

class FSPersonalBottomWidget$5
  implements FSPersonalBottomWidget.OnJustSeeListener
{
  FSPersonalBottomWidget$5(FSPersonalBottomWidget paramFSPersonalBottomWidget) {}
  
  public void a(boolean paramBoolean)
  {
    if (FSPersonalBottomWidget.b(this.a) != null)
    {
      int j = FSPersonalBottomWidget.b(this.a).getVisibility();
      int i = 8;
      if ((j == 8) && (paramBoolean)) {
        FSPersonalBottomWidget.c(this.a);
      }
      LinearLayout localLinearLayout = FSPersonalBottomWidget.b(this.a);
      if (paramBoolean) {
        i = 0;
      }
      localLinearLayout.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget.5
 * JD-Core Version:    0.7.0.1
 */