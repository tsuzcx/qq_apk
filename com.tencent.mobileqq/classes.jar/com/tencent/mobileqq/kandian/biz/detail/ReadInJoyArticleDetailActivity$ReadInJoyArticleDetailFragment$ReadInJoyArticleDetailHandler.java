package com.tencent.mobileqq.kandian.biz.detail;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$ReadInJoyArticleDetailHandler
  extends SwiftBrowserUIStyleHandler
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$ReadInJoyArticleDetailHandler(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void bI_()
  {
    super.bI_();
    if ((this.b.a() != null) && (this.a.b) && (ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a(this.a) != null) && (this.u != null))
    {
      Object localObject = this.a;
      ((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localObject).c = new ImageView(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.b((ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment)localObject));
      this.a.c.setImageResource(2130842640);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.a.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.u.addView(this.a.c);
      if (IPluginAdapterProxy.getProxy().isNightMode())
      {
        this.u.setBackgroundColor(-6710887);
        this.a.c.setImageResource(2130842641);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.ReadInJoyArticleDetailHandler
 * JD-Core Version:    0.7.0.1
 */