package com.tencent.mobileqq.cmshow.engine.script.task;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;

public abstract class AbsScriptTask
{
  private int a;
  private String b;
  private String c;
  private boolean d;
  private int e;
  private AbsScriptTask.RoleInfo f;
  private boolean g;
  private IApolloResManager h;
  
  public AbsScriptTask(@NonNull IApolloResManager paramIApolloResManager)
  {
    this.h = paramIApolloResManager;
  }
  
  public abstract Script a();
  
  public AbsScriptTask a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public AbsScriptTask a(AbsScriptTask.RoleInfo paramRoleInfo)
  {
    this.f = paramRoleInfo;
    return this;
  }
  
  public AbsScriptTask a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public AbsScriptTask a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public AbsScriptTask b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public AbsScriptTask b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public AbsScriptTask b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  @NonNull
  public IApolloResManager d()
  {
    return this.h;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.e;
  }
  
  public AbsScriptTask.RoleInfo j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.AbsScriptTask
 * JD-Core Version:    0.7.0.1
 */