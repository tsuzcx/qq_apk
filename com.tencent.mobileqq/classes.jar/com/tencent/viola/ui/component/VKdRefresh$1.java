package com.tencent.viola.ui.component;

import com.tencent.viola.ui.view.VRefreshLayout;

class VKdRefresh$1
  implements Runnable
{
  VKdRefresh$1(VKdRefresh paramVKdRefresh, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getHostView() != null)
    {
      VRefreshLayout localVRefreshLayout = (VRefreshLayout)this.this$0.getHostView();
      int i = this.val$type;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localVRefreshLayout.setStateFinish(bool, this.val$text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VKdRefresh.1
 * JD-Core Version:    0.7.0.1
 */