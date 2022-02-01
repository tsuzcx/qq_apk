package com.tencent.mobileqq.kandian.biz.detail;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$3
  implements Runnable
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$3(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void run()
  {
    if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.this$0.getUIStyleHandler().u != null)) {
      this.this$0.getUIStyleHandler().u.setBackgroundColor(-1);
    }
    if (this.this$0.c != null)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.this$0.c.animate().alpha(0.0F).setDuration(200L).setListener(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.3.1(this));
        this.this$0.c.animate().start();
        return;
      }
      this.this$0.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */