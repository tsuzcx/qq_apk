package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;

public class ShadowWebViewLayoutInflater
  extends FixedContextLayoutInflater
{
  private static final String AndroidWebView = "android.webkit.WebView";
  private static final String ShadowPackagePrefix = "com.tencent.shadow.core.runtime.";
  private static final String ShadowWebView = "ShadowWebView";
  
  public ShadowWebViewLayoutInflater(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
  }
  
  Pair<String, String> changeViewNameAndPrefix(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    if ("android.webkit.WebView".equals(localStringBuilder.toString()))
    {
      paramString1 = "com.tencent.shadow.core.runtime.";
      paramString2 = "ShadowWebView";
    }
    return new Pair(paramString2, paramString1);
  }
  
  LayoutInflater createNewContextLayoutInflater(Context paramContext)
  {
    if ((paramContext instanceof PluginContainerActivity)) {
      return new ShadowWebViewLayoutInflater(this, (Context)((PluginContainerActivity)paramContext).getPluginActivity());
    }
    return new ShadowWebViewLayoutInflater(this, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowWebViewLayoutInflater
 * JD-Core Version:    0.7.0.1
 */