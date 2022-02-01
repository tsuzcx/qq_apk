package com.tencent.xweb.xwalk;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.wxa.sr.a;
import com.tencent.xweb.WebResourceRequest;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkWebResourceRequest;

public class g$i
  implements WebResourceRequest
{
  private Uri a;
  private boolean b;
  private boolean c;
  private boolean d;
  private String e;
  private Map<String, String> f;
  private a g;
  
  public g$i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      this.a = Uri.parse(paramString1);
    }
    catch (Exception localException)
    {
      label15:
      StringBuilder localStringBuilder;
      break label15;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("parse url failed , url = ");
    localStringBuilder.append(paramString1);
    Log.e("WebResourceRequestImpl", localStringBuilder.toString());
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.e = paramString2;
    this.d = paramBoolean3;
  }
  
  public g$i(XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    this.a = paramXWalkWebResourceRequest.getUrl();
    this.b = paramXWalkWebResourceRequest.isForMainFrame();
    this.c = paramXWalkWebResourceRequest.hasGesture();
    this.e = paramXWalkWebResourceRequest.getMethod();
    this.f = paramXWalkWebResourceRequest.getRequestHeaders();
    this.g = new a(this);
  }
  
  public Uri a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public Map<String, String> d()
  {
    return this.f;
  }
  
  public Bundle e()
  {
    a locala = this.g;
    if (locala == null) {
      return null;
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.i
 * JD-Core Version:    0.7.0.1
 */