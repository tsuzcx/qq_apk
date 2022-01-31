package com.tencent.mobileqq.magicface.model;

import aemg;
import com.tencent.qphone.base.util.QLog;

public abstract class MagicfaceDecoder
{
  public int a;
  MagicfaceData a;
  public MagicfaceDecoder.MagicPlayListener a;
  public MagicfaceDecoder.MagicfaceRenderListener a;
  public volatile boolean a;
  public int b = 1000 / this.jdField_a_of_type_Int;
  
  public MagicfaceDecoder()
  {
    this.jdField_a_of_type_Int = 8;
    g();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = (1000 / paramInt);
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData = paramMagicfaceData;
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = paramMagicPlayListener;
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void c() {}
  
  public void d()
  {
    f();
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      new Thread(new aemg(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagicfaceDecoder", 2, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder
 * JD-Core Version:    0.7.0.1
 */