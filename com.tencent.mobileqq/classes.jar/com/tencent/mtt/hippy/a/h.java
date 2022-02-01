package com.tencent.mtt.hippy.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mtt.hippy.utils.ContextHolder;
import java.io.File;

public class h
{
  boolean a = false;
  SharedPreferences b = ContextHolder.getAppContext().getSharedPreferences("hippydebugpref", 0);
  private File c = new File(ContextHolder.getAppContext().getFilesDir(), "HippyDevBundle.js");
  private String d;
  private String e;
  
  public h(String paramString1, String paramString2)
  {
    this.d = paramString2;
    this.e = paramString1;
  }
  
  public String a()
  {
    return this.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.h
 * JD-Core Version:    0.7.0.1
 */