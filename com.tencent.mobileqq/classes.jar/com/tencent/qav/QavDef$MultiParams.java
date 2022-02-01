package com.tencent.qav;

import java.util.Arrays;

public final class QavDef$MultiParams
{
  public int a;
  public long a;
  public String a;
  public byte[] a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiParams{mRelationType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mMultiAVType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mMultiAVSubType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mRoomId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mUin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mOpenId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSourceId=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mSig=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", mSvrRecogFlag=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.QavDef.MultiParams
 * JD-Core Version:    0.7.0.1
 */