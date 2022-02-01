package com.tencent.mobileqq.magicface.view;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.DisplayUtils;

class MagicfaceViewController$5
  implements Runnable
{
  MagicfaceViewController$5(MagicfaceViewController paramMagicfaceViewController) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.n.getLayoutParams();
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(this.this$0.b.aX(), 10.0F));
    this.this$0.n.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.5
 * JD-Core Version:    0.7.0.1
 */