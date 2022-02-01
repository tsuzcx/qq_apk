package com.tencent.mobileqq.magicface.view;

import android.widget.ImageView;
import android.widget.TextView;

class MagicfaceViewController$6$1
  implements Runnable
{
  MagicfaceViewController$6$1(MagicfaceViewController.6 param6, String paramString) {}
  
  public void run()
  {
    if (this.b.a == 1) {
      if (this.a == null) {
        this.b.c.p.setVisibility(8);
      } else {
        this.b.c.p.setVisibility(0);
      }
    }
    this.b.b.setText(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.6.1
 * JD-Core Version:    0.7.0.1
 */