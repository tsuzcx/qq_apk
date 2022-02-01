package com.tencent.mobileqq.mini.appbrand.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import java.util.ArrayList;
import java.util.Iterator;

public class MiniAppWebviewFragment
  extends WebViewFragment
{
  public static final String KEY_HEADER = "key_header";
  public static final String KEY_URL_BLACK_LIST = "key_url_black_list";
  private final String TAG = "MiniAppWebviewFragment";
  
  private boolean isBlackPrefixUrl(String paramString, ArrayList<String> paramArrayList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (paramString.toLowerCase().startsWith(str.toLowerCase())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new MiniAppWebviewFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment
 * JD-Core Version:    0.7.0.1
 */