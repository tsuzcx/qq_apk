package com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate;

import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;

public class IVec3f
  extends Vec3f
{
  public int index;
  
  public IVec3f(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.index = paramInt;
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public IVec3f(int paramInt, Vec3f paramVec3f)
  {
    this.index = paramInt;
    this.x = paramVec3f.x;
    this.y = paramVec3f.y;
    this.z = paramVec3f.z;
  }
  
  public String toString()
  {
    String str = super.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.index);
    localStringBuilder.append("  : ");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.matchTemplate.IVec3f
 * JD-Core Version:    0.7.0.1
 */