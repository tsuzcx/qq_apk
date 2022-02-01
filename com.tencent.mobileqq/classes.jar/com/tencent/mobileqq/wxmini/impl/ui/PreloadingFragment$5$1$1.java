package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.mobileqq.widget.QQToast;

class PreloadingFragment$5$1$1
  implements Runnable
{
  PreloadingFragment$5$1$1(PreloadingFragment.5.1 param1) {}
  
  public void run()
  {
    QQToast.makeText(this.a.b.b, "微信登录失败", 0).show();
    PreloadingFragment.d(this.a.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.5.1.1
 * JD-Core Version:    0.7.0.1
 */