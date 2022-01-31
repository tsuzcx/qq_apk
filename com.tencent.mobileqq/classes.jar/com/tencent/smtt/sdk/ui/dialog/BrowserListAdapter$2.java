package com.tencent.smtt.sdk.ui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

class BrowserListAdapter$2
  implements View.OnClickListener
{
  BrowserListAdapter$2(BrowserListAdapter paramBrowserListAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getParent();
    if ((paramView == null) || (!(paramView instanceof View))) {}
    do
    {
      return;
      paramView = (View)paramView;
    } while (paramView.getTag() != BrowserListAdapter.access$000(this.this$0));
    this.this$0.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.BrowserListAdapter.2
 * JD-Core Version:    0.7.0.1
 */