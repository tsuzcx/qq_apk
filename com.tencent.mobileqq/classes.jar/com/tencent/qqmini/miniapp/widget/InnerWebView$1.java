package com.tencent.qqmini.miniapp.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;

class InnerWebView$1
  implements View.OnLongClickListener
{
  InnerWebView$1(InnerWebView paramInnerWebView) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = InnerWebView.access$100(this.this$0).getHitTestResult();
    if ((paramView.getType() == 5) || (paramView.getType() == 8))
    {
      paramView = paramView.getExtra();
      if (QMLog.isColorLevel()) {
        QMLog.e("InnerWebView", "onLongClick : " + paramView);
      }
      ActionSheet localActionSheet = ActionSheet.create(InnerWebView.access$100(this.this$0).getContext());
      localActionSheet.addButton("发送给朋友", 7);
      localActionSheet.addButton("保存到手机", 7);
      localActionSheet.addCancelButton("取消");
      localActionSheet.setOutsideDismissEnableCompat(true);
      localActionSheet.setOnButtonClickListener(new InnerWebView.1.1(this, localActionSheet, paramView));
      localActionSheet.show();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.1
 * JD-Core Version:    0.7.0.1
 */