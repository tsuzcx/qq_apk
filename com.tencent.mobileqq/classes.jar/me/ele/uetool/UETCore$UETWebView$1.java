package me.ele.uetool;

import android.webkit.WebView;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.item.ElementItem.ChangeCallBack;

class UETCore$UETWebView$1
  implements ElementItem.ChangeCallBack
{
  UETCore$UETWebView$1(UETCore.UETWebView paramUETWebView, WebView paramWebView) {}
  
  public void callBack(Element paramElement, Object paramObject)
  {
    this.val$webView.loadUrl("javascript:(function () { var script = document.createElement('script'); script.src=\"https://cdn.jsdelivr.net/npm/eruda\"; document.body.appendChild(script); script.onload = function () { eruda.init() } })();\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETCore.UETWebView.1
 * JD-Core Version:    0.7.0.1
 */