package me.ele.uetool;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;

class UETCore$UETWebView
  implements IAttrs
{
  final String toolUrl = "javascript:(function () { var script = document.createElement('script'); script.src=\"https://cdn.jsdelivr.net/npm/eruda\"; document.body.appendChild(script); script.onload = function () { eruda.init() } })();\n";
  
  public List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    WebView localWebView = (WebView)paramElement.getView();
    paramElement = new SwitchItem("WebView调试", paramElement, 0);
    paramElement.setCallBack(new UETCore.UETWebView.1(this, localWebView));
    localArrayList.add(paramElement);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.UETCore.UETWebView
 * JD-Core Version:    0.7.0.1
 */