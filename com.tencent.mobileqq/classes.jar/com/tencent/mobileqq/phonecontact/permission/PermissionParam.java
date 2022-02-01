package com.tencent.mobileqq.phonecontact.permission;

import java.util.List;

public class PermissionParam
{
  public List<String> a;
  public Runnable b;
  public Runnable c;
  public int d;
  public int e;
  
  public void a(boolean paramBoolean)
  {
    Runnable localRunnable;
    if (a())
    {
      localRunnable = this.b;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
    else
    {
      localRunnable = this.c;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
  
  public boolean a()
  {
    int i = this.e;
    int j = this.d;
    return (i & j) == j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.permission.PermissionParam
 * JD-Core Version:    0.7.0.1
 */