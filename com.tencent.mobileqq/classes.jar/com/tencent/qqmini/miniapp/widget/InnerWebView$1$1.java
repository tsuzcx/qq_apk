package com.tencent.qqmini.miniapp.widget;

import android.view.View;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener;

class InnerWebView$1$1
  implements ActionSheet.OnButtonClickListener
{
  InnerWebView$1$1(InnerWebView.1 param1, ActionSheet paramActionSheet, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    paramView = this.val$actionSheet.getContent(paramInt);
    if ("发送给朋友".equals(paramView))
    {
      InnerWebView.access$200(this.this$1.this$0, this.val$pic);
      return;
    }
    if ("保存到手机".equals(paramView)) {
      InnerWebView.access$300(this.this$1.this$0, this.val$pic);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.1.1
 * JD-Core Version:    0.7.0.1
 */