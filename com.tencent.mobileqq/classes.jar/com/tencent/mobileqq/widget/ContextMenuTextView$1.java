package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContextMenuTextView$1
  implements View.OnClickListener
{
  ContextMenuTextView$1(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365448)
    {
      Context localContext = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)localContext.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContextMenuTextView.1
 * JD-Core Version:    0.7.0.1
 */