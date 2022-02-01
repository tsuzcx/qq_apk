package com.tencent.mobileqq.webview.swift.component;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;

class SwiftBrowserUIStyleHandler$1
  implements TouchWebView.OnOverScrollHandler
{
  SwiftBrowserUIStyleHandler$1(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler, TouchWebView paramTouchWebView, RefreshView paramRefreshView) {}
  
  public void onBack()
  {
    this.c.c = false;
    this.b.onBack();
    this.c.b(true);
  }
  
  public void onOverScroll(int paramInt)
  {
    if (!this.c.c)
    {
      this.c.c = true;
      Object localObject = this.a.getUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = Uri.parse((String)localObject);
          if ((localObject != null) && (((Uri)localObject).isHierarchical()))
          {
            localObject = String.format(this.c.z.getResources().getString(2131912001), new Object[] { ((Uri)localObject).getHost() });
            this.c.z.setText((CharSequence)localObject);
          }
          this.c.z.setVisibility(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          this.c.z.setVisibility(8);
        }
      }
    }
    this.b.onOverScroll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.1
 * JD-Core Version:    0.7.0.1
 */