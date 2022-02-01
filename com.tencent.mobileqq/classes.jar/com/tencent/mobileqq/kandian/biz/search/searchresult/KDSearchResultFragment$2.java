package com.tencent.mobileqq.kandian.biz.search.searchresult;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

class KDSearchResultFragment$2
  extends KDSearchResultWebviewBuilder
{
  KDSearchResultFragment$2(KDSearchResultFragment paramKDSearchResultFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface, paramTouchWebView);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    KDSearchResultFragment.a(this.a, true);
    if ((KDSearchResultFragment.a(this.a) != null) && (KDSearchResultFragment.a(this.a).b() != 2)) {
      KDSearchResultFragment.a(this.a).a((byte)2);
    }
    this.a.a.setVisibility(8);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    KDSearchResultFragment.a(this.a).setText(SearchUtils.a(paramString));
    if ((KDSearchResultFragment.a(this.a) != null) && (KDSearchResultFragment.a(this.a).b() != 0)) {
      KDSearchResultFragment.a(this.a).a((byte)0);
    }
    this.a.a.setVisibility(0);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = paramString.split("\\?");
      if ((localObject1.length == 2) && (!TextUtils.isEmpty(localObject1[1])))
      {
        localObject1 = localObject1[1].split("#");
        if (localObject1.length == 2)
        {
          int i = 0;
          if (!TextUtils.isEmpty(localObject1[0]))
          {
            localObject1 = localObject1[0].split("=");
            if (localObject1.length % 2 == 0) {
              for (;;)
              {
                int j = i + 1;
                if (j >= localObject1.length) {
                  break;
                }
                if (("p".equals(localObject1[i])) && (!TextUtils.isEmpty(localObject1[j]))) {
                  try
                  {
                    Object localObject2 = new JSONObject(URLDecoder.decode(localObject1[j]));
                    if (((JSONObject)localObject2).has("url"))
                    {
                      String str = ((JSONObject)localObject2).getString("url");
                      if (SearchUtils.a(str))
                      {
                        localObject2 = SearchUtils.a(str);
                        if (!TextUtils.isEmpty((CharSequence)localObject2))
                        {
                          localObject1 = URLUtil.a(str, "searchbox", "native");
                          KDSearchResultFragment.a(this.a).setText((CharSequence)localObject2);
                          KDSearchResultFragment.a(this.a, (String)localObject2);
                          if (KDSearchResultFragment.a(this.a) != null)
                          {
                            this.mWebview.loadUrl((String)localObject1, KDSearchResultFragment.a(this.a));
                            return true;
                          }
                          KDSearchResultFragment.a(this.a).loadUrl((String)localObject1);
                          return true;
                        }
                      }
                    }
                  }
                  catch (JSONException localJSONException)
                  {
                    localJSONException.printStackTrace();
                  }
                }
                i += 2;
              }
            }
          }
        }
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment.2
 * JD-Core Version:    0.7.0.1
 */