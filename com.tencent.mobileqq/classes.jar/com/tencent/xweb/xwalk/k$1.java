package com.tencent.xweb.xwalk;

import android.os.Bundle;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import org.xwalk.core.XWalkProxyWebViewClientExtension;

class k$1
  extends XWalkProxyWebViewClientExtension
{
  k$1(k paramk) {}
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if (k.a(this.a) != null) {
      return k.a(this.a).onMiscCallBack(paramString, paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.1
 * JD-Core Version:    0.7.0.1
 */