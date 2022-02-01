package com.tencent.mtt.hippy.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mtt.hippy.utils.ContextHolder;

public class h
{
  boolean a = false;
  final SharedPreferences b = ContextHolder.getAppContext().getSharedPreferences("hippydebugpref", 0);
  private final String c;
  
  public h(String paramString1, String paramString2)
  {
    this.c = paramString1;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b.getBoolean("js_remote_debug", false);
  }
  
  public boolean c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.h
 * JD-Core Version:    0.7.0.1
 */