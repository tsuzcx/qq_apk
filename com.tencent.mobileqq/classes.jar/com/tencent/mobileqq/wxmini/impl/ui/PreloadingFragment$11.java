package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

class PreloadingFragment$11
  implements Runnable
{
  PreloadingFragment$11(PreloadingFragment paramPreloadingFragment, Context paramContext) {}
  
  public void run()
  {
    QQToast.makeText(this.a, "微信版本太低", 0).show();
    PreloadingFragment.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.11
 * JD-Core Version:    0.7.0.1
 */