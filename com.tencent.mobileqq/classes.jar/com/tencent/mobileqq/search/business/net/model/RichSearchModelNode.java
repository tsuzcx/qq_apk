package com.tencent.mobileqq.search.business.net.model;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class RichSearchModelNode
  extends NetSearchTemplateBaseItem
{
  private String a;
  private String b;
  private String c;
  private int d;
  private boolean e = false;
  private int f;
  private int t;
  private String u;
  
  public RichSearchModelNode(String paramString1, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt, String paramString2)
  {
    super(paramString1, paramLong, paramList, paramResultItem, paramInt);
    this.u = paramString2;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    a(this.e);
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public CharSequence d()
  {
    return this.u;
  }
  
  public boolean i()
  {
    return true;
  }
  
  public void o_(String paramString)
  {
    this.a = paramString;
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    try
    {
      this.t = new JSONObject(this.a).getInt("appid");
      return;
    }
    catch (JSONException paramString)
    {
      String str = g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseLayoutExtensions exception:");
      localStringBuilder.append(paramString);
      QLog.e(str, 2, localStringBuilder.toString());
    }
  }
  
  public int r()
  {
    return this.d;
  }
  
  public String s()
  {
    return this.a;
  }
  
  public String t()
  {
    return this.c;
  }
  
  public int u()
  {
    return this.t;
  }
  
  public String v()
  {
    return this.b;
  }
  
  public int w()
  {
    return this.f;
  }
  
  public boolean x()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.RichSearchModelNode
 * JD-Core Version:    0.7.0.1
 */