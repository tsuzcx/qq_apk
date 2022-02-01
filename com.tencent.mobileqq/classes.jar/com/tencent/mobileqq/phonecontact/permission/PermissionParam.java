package com.tencent.mobileqq.phonecontact.permission;

import java.util.List;

public class PermissionParam
{
  public int a;
  public Runnable a;
  public List<String> a;
  public int b;
  public Runnable b;
  
  public void a(boolean paramBoolean)
  {
    Runnable localRunnable;
    if (a())
    {
      localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
    else
    {
      localRunnable = this.jdField_b_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
  
  public boolean a()
  {
    int i = this.jdField_b_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    return (i & j) == j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.permission.PermissionParam
 * JD-Core Version:    0.7.0.1
 */