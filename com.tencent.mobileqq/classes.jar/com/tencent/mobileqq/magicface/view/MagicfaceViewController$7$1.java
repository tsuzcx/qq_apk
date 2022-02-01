package com.tencent.mobileqq.magicface.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;

class MagicfaceViewController$7$1
  implements Runnable
{
  MagicfaceViewController$7$1(MagicfaceViewController.7 param7, ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    
    if (this.b.b == 0)
    {
      this.b.c.d();
    }
    else
    {
      ((View)this.b.c.g).setBackgroundColor(this.a.g);
      this.b.c.e();
    }
    this.b.c.h.setText("");
    this.b.c.i.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.1
 * JD-Core Version:    0.7.0.1
 */