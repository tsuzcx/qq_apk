package com.tencent.xweb;

import android.text.TextUtils;
import org.json.JSONStringer;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class ac
{
  private final String a = "XWebScript";
  private JSONStringer b = new JSONStringer();
  private int c = 0;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j = 0;
  private long k;
  private int l;
  private WebView m;
  
  public ac(int paramInt1, int paramInt2, WebView paramWebView)
  {
    a(paramInt1);
    this.j = paramInt2;
    this.m = paramWebView;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, "path");
    this.g = paramString2;
  }
  
  public boolean a()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (!((WebView)localObject).supportFeature(2002)) {
        return false;
      }
      if (TextUtils.isEmpty(this.e))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkValid failed jsSrcValue invalid = ");
        ((StringBuilder)localObject).append(this.e);
        Log.e("XWebScript", ((StringBuilder)localObject).toString());
        return false;
      }
      if (TextUtils.isEmpty(this.d))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkValid failed jsSrcKind invalid = ");
        ((StringBuilder)localObject).append(this.d);
        Log.e("XWebScript", ((StringBuilder)localObject).toString());
        return false;
      }
      if (this.c >= 0)
      {
        if ((this.k != 0L) && (this.l <= 0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkValid failed bufferSize invalid = ");
          ((StringBuilder)localObject).append(this.l);
          Log.e("XWebScript", ((StringBuilder)localObject).toString());
          return false;
        }
        if ((this.l != 0) && (this.k == 0L))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkValid failed bufferAddr invalid = ");
          ((StringBuilder)localObject).append(this.k);
          Log.e("XWebScript", ((StringBuilder)localObject).toString());
          return false;
        }
        if ((!TextUtils.isEmpty(this.i)) && (!this.m.supportFeature(2008)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("not support jsparam as file path , apk ver = ");
          ((StringBuilder)localObject).append(XWalkEnvironment.getAvailableVersion());
          Log.e("XWebScript", ((StringBuilder)localObject).toString());
          return false;
        }
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkValid failed compile mode invalid = ");
      ((StringBuilder)localObject).append(this.c);
      Log.e("XWebScript", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  void b(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.d = paramString2;
  }
  
  public String toString()
  {
    if (!a()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("//XWEB_SCRIPT:");
    Object localObject1 = new JSONStringer();
    try
    {
      localObject2 = ((JSONStringer)localObject1).object().key("compile_mode").value(this.c).key("cache_option").value(this.j).key("js_src_kind").value(this.d).key("js_src").value(this.e);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.f)) {
        localObject1 = ((JSONStringer)localObject2).key("cache_key").value(this.f);
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.g)) {
        localObject2 = ((JSONStringer)localObject1).key("append_script").value(this.g);
      }
      boolean bool = TextUtils.isEmpty(this.i);
      if (!bool)
      {
        localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("path").key("js_param").value(this.i);
      }
      else
      {
        localObject1 = localObject2;
        if (this.k != 0L)
        {
          localObject1 = localObject2;
          if (this.l != 0) {
            localObject1 = ((JSONStringer)localObject2).key("js_param_kind").value("buffer").key("js_param").value(Long.toHexString(this.k)).key("js_param_length").value(this.l);
          }
        }
      }
      ((JSONStringer)localObject1).endObject();
      localStringBuilder.append(((JSONStringer)localObject1).toString());
      if ((this.m != null) && (this.m.supportFeature(2004)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("XWEB_SCRIPT_END\n\r");
        ((StringBuilder)localObject1).append(this.h);
        localStringBuilder.append(((StringBuilder)localObject1).toString());
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("xweb script create failed ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("XWebScript", ((StringBuilder)localObject2).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.ac
 * JD-Core Version:    0.7.0.1
 */