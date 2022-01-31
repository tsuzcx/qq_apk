package com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate;

import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;

public class IVec3f
  extends Vec3f
{
  public int a;
  
  public IVec3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public IVec3f(int paramInt, Vec3f paramVec3f)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramVec3f.jdField_a_of_type_Float;
    this.b = paramVec3f.b;
    this.c = paramVec3f.c;
  }
  
  public String toString()
  {
    String str = super.toString();
    return this.jdField_a_of_type_Int + "  : " + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate.IVec3f
 * JD-Core Version:    0.7.0.1
 */