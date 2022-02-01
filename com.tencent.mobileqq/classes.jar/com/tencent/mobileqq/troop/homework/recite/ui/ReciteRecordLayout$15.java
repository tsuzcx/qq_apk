package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView.SpanClickListener;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;

class ReciteRecordLayout$15
  implements ClickableColorSpanTextView.SpanClickListener
{
  ReciteRecordLayout$15(ReciteRecordLayout paramReciteRecordLayout) {}
  
  public void a(ClickableColorSpanTextView paramClickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan paramStatableForegroundColorSpan)
  {
    paramClickableColorSpanTextView = new Intent(this.a.a, QQBrowserActivity.class);
    paramClickableColorSpanTextView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14");
    this.a.a.startActivity(paramClickableColorSpanTextView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout.15
 * JD-Core Version:    0.7.0.1
 */