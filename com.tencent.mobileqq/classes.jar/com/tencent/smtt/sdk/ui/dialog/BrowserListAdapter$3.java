package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

class BrowserListAdapter$3
  implements View.OnClickListener
{
  BrowserListAdapter$3(BrowserListAdapter paramBrowserListAdapter) {}
  
  public void onClick(View paramView)
  {
    if ("com.tencent.mobileqq".equals(this.this$0.getContext().getApplicationContext().getPackageName()))
    {
      if (BrowserListAdapter.access$100(this.this$0) != null) {
        BrowserListAdapter.access$100(this.this$0).onReceiveValue("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
      }
      ((TBSActivityPicker)BrowserListAdapter.access$200(this.this$0).get()).dismiss();
      return;
    }
    paramView = new Intent("android.intent.action.VIEW", Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041"));
    paramView.addFlags(268435456);
    this.this$0.getContext().startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.BrowserListAdapter.3
 * JD-Core Version:    0.7.0.1
 */