package com.tencent.mobileqq.pb;

import java.io.IOException;

public abstract class PBField<T>
{
  public static PBBoolField initBool(boolean paramBoolean)
  {
    return new PBBoolField(paramBoolean, false);
  }
  
  public static PBBytesField initBytes(ByteStringMicro paramByteStringMicro)
  {
    return new PBBytesField(paramByteStringMicro, false);
  }
  
  public static PBBytesField initBytes(byte[] paramArrayOfByte)
  {
    return new PBBytesField(ByteStringMicro.copyFrom(paramArrayOfByte), false);
  }
  
  public static PBDoubleField initDouble(double paramDouble)
  {
    return new PBDoubleField(paramDouble, false);
  }
  
  public static PBEnumField initEnum(int paramInt)
  {
    return new PBEnumField(paramInt, false);
  }
  
  public static PBFixed32Field initFixed32(int paramInt)
  {
    return new PBFixed32Field(paramInt, false);
  }
  
  public static PBFixed64Field initFixed64(long paramLong)
  {
    return new PBFixed64Field(paramLong, false);
  }
  
  public static PBFloatField initFloat(float paramFloat)
  {
    return new PBFloatField(paramFloat, false);
  }
  
  public static PBInt32Field initInt32(int paramInt)
  {
    return new PBInt32Field(paramInt, false);
  }
  
  public static PBInt64Field initInt64(long paramLong)
  {
    return new PBInt64Field(paramLong, false);
  }
  
  public static <T> PBRepeatField<T> initRepeat(PBField<T> paramPBField)
  {
    return new PBRepeatField(paramPBField);
  }
  
  public static <T extends MessageMicro<T>> PBRepeatMessageField<T> initRepeatMessage(Class<T> paramClass)
  {
    return new PBRepeatMessageField(paramClass);
  }
  
  public static PBSFixed32Field initSFixed32(int paramInt)
  {
    return new PBSFixed32Field(paramInt, false);
  }
  
  public static PBSFixed64Field initSFixed64(long paramLong)
  {
    return new PBSFixed64Field(paramLong, false);
  }
  
  public static PBSInt32Field initSInt32(int paramInt)
  {
    return new PBSInt32Field(paramInt, false);
  }
  
  public static PBSInt64Field initSInt64(long paramLong)
  {
    return new PBSInt64Field(paramLong, false);
  }
  
  public static PBStringField initString(String paramString)
  {
    return new PBStringField(paramString, false);
  }
  
  public static PBUInt32Field initUInt32(int paramInt)
  {
    return new PBUInt32Field(paramInt, false);
  }
  
  public static PBUInt64Field initUInt64(long paramLong)
  {
    return new PBUInt64Field(paramLong, false);
  }
  
  public final void clear()
  {
    clear(null);
  }
  
  public abstract void clear(Object paramObject);
  
  public abstract int computeSize(int paramInt);
  
  protected abstract int computeSizeDirectly(int paramInt, T paramT);
  
  protected abstract void copyFrom(PBField<T> paramPBField);
  
  public abstract void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException;
  
  protected abstract T readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException;
  
  public abstract void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
    throws IOException;
  
  protected abstract void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, T paramT)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBField
 * JD-Core Version:    0.7.0.1
 */