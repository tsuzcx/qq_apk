package com.tencent.viola.ui.component;

import com.tencent.viola.ui.view.VRefreshLayout;

class VKdRefresh$1
  implements Runnable
{
  VKdRefresh$1(VKdRefresh paramVKdRefresh, int paramInt, String paramString) {}
  
  public void run()
  {
    boolean bool = true;
    VRefreshLayout localVRefreshLayout;
    if (this.this$0.getHostView() != null)
    {
      localVRefreshLayout = (VRefreshLayout)this.this$0.getHostView();
      if (this.val$type != 1) {
        break label41;
      }
    }
    for (;;)
    {
      localVRefreshLayout.setStateFinish(bool, this.val$text);
      return;
      label41:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.VKdRefresh.1
 * JD-Core Version:    0.7.0.1
 */