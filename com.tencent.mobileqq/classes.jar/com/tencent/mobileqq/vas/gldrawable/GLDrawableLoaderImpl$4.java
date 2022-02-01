package com.tencent.mobileqq.vas.gldrawable;

import bhbk;
import bhbm;
import bhbr;

public class GLDrawableLoaderImpl$4
  implements Runnable
{
  public GLDrawableLoaderImpl$4(bhbk parambhbk, bhbm parambhbm, bhbr parambhbr) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bhbm.a("gldrawable_main_init", "error", "download fail", -1L);
    if (this.jdField_a_of_type_Bhbr != null) {
      this.jdField_a_of_type_Bhbr.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.4
 * JD-Core Version:    0.7.0.1
 */