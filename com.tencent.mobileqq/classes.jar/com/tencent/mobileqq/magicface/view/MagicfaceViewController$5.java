package com.tencent.mobileqq.magicface.view;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import awsw;
import bhdz;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class MagicfaceViewController$5
  implements Runnable
{
  public MagicfaceViewController$5(awsw paramawsw) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.c.getLayoutParams();
    localLayoutParams.rightMargin = ((int)bhdz.a(this.this$0.a.getActivity(), 10.0F));
    this.this$0.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.5
 * JD-Core Version:    0.7.0.1
 */