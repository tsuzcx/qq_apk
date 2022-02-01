package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.mobileqq.widget.QQToast;

class PreloadingFragment$3$1$1
  implements Runnable
{
  PreloadingFragment$3$1$1(PreloadingFragment.3.1 param1, TdiAuthErrCode paramTdiAuthErrCode, String paramString) {}
  
  public void run()
  {
    Context localContext = this.c.b.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("微信登录失败 errCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    QQToast.makeText(localContext, localStringBuilder.toString(), 0).show();
    PreloadingFragment.d(this.c.b.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.3.1.1
 * JD-Core Version:    0.7.0.1
 */