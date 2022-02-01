package com.tencent.qav;

import java.util.Arrays;

public final class QavDef$MultiParams
{
  public int a;
  public int b;
  public int c;
  public int d;
  public long e;
  public String f;
  public int g;
  public byte[] h;
  public int i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiParams{mRelationType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mMultiAVType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mMultiAVSubType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mRoomId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mUin=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mOpenId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSourceId=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mSig=");
    localStringBuilder.append(Arrays.toString(this.h));
    localStringBuilder.append(", mSvrRecogFlag=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.QavDef.MultiParams
 * JD-Core Version:    0.7.0.1
 */