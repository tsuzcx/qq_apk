package com.tencent.mobileqq.pttlogic.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class PttUtilsImpl$1
  implements ClickableColorSpanTextView.SpanClickListener
{
  PttUtilsImpl$1(PttUtilsImpl paramPttUtilsImpl, Context paramContext) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new ActivityURIRequest(this.a, "/base/browser");
    paramClickableColorSpanTextView.extra().putString("url", "https://kf.qq.com/touch/sappfaq/210331qMJbAf210331RZBBba.html");
    QRoute.startUri(paramClickableColorSpanTextView, new PttUtilsImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */