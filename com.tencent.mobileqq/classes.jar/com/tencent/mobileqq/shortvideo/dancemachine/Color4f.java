package com.tencent.mobileqq.shortvideo.dancemachine;

import java.nio.FloatBuffer;

public class Color4f
{
  public static final Color4f a;
  public static final Color4f b;
  private float a;
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineColor4f = new Color4f(0.0F, 0.0F, 0.0F, 1.0F);
    jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineColor4f = new Color4f(1.0F, 1.0F, 1.0F, 1.0F);
  }
  
  public Color4f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(FloatBuffer paramFloatBuffer)
  {
    paramFloatBuffer.put(this.jdField_a_of_type_Float);
    paramFloatBuffer.put(this.jdField_b_of_type_Float);
    paramFloatBuffer.put(this.c);
    paramFloatBuffer.put(this.d);
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.Color4f
 * JD-Core Version:    0.7.0.1
 */