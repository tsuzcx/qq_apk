package com.tencent.mobileqq.vas.hippy.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

public class VasViewCreator
  implements HippyCustomViewCreator
{
  public View createCustomView(String paramString, Context paramContext, HippyMap paramHippyMap)
  {
    if (TextUtils.equals("WebView", paramString)) {
      return new TouchWebView(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.impl.VasViewCreator
 * JD-Core Version:    0.7.0.1
 */