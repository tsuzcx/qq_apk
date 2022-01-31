package com.tencent.mobileqq.widget.navbar;

import android.widget.LinearLayout;

class NavBarAIO$4
  implements Runnable
{
  NavBarAIO$4(NavBarAIO paramNavBarAIO) {}
  
  public void run()
  {
    if (NavBarAIO.a(this.this$0) != null)
    {
      int i = NavBarAIO.a(this.this$0).getMeasuredWidth();
      if (i > 0) {
        this.this$0.b(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO.4
 * JD-Core Version:    0.7.0.1
 */