package com.tencent.mobileqq.magicface.view;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import atzj;
import bdgz;
import com.tencent.mobileqq.activity.BaseChatPie;

public class MagicfaceViewController$5
  implements Runnable
{
  public MagicfaceViewController$5(atzj paramatzj) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.c.getLayoutParams();
    localLayoutParams.rightMargin = ((int)bdgz.a(this.this$0.a.a(), 10.0F));
    this.this$0.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.5
 * JD-Core Version:    0.7.0.1
 */