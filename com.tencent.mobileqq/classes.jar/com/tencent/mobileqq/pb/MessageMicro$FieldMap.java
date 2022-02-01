package com.tencent.mobileqq.pb;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class MessageMicro$FieldMap
{
  private Object[] defaultValues;
  private Field[] fields;
  private int[] tags;
  
  MessageMicro$FieldMap(int[] paramArrayOfInt, String[] paramArrayOfString, Object[] paramArrayOfObject, Class<?> paramClass)
  {
    this.tags = paramArrayOfInt;
    this.defaultValues = paramArrayOfObject;
    this.fields = new Field[paramArrayOfInt.length];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        return;
      }
      try
      {
        this.fields[i] = paramClass.getField(paramArrayOfString[i]);
      }
      catch (Exception paramArrayOfObject)
      {
        paramArrayOfObject.printStackTrace();
      }
      i += 1;
    }
  }
  
  void clear(MessageMicro<?> paramMessageMicro)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.tags.length) {
        return;
      }
      ((PBField)this.fields[i].get(paramMessageMicro)).clear(this.defaultValues[i]);
      i += 1;
    }
  }
  
  <U extends MessageMicro<U>> void copyFields(U paramU1, U paramU2)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.tags.length) {
        return;
      }
      Field localField = this.fields[i];
      ((PBField)localField.get(paramU1)).copyFrom((PBField)localField.get(paramU2));
      i += 1;
    }
  }
  
  Field get(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.tags, paramInt);
    if (paramInt < 0) {
      return null;
    }
    return this.fields[paramInt];
  }
  
  int getSerializedSize(MessageMicro<?> paramMessageMicro)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = this.tags;
      if (i >= arrayOfInt.length) {
        return j;
      }
      int k = WireFormatMicro.getTagFieldNumber(arrayOfInt[i]);
      j += ((PBField)this.fields[i].get(paramMessageMicro)).computeSize(k);
      i += 1;
    }
  }
  
  public boolean readFieldFrom(CodedInputStreamMicro paramCodedInputStreamMicro, int paramInt, MessageMicro<?> paramMessageMicro)
  {
    paramInt = Arrays.binarySearch(this.tags, paramInt);
    if (paramInt < 0) {
      return false;
    }
    ((PBField)this.fields[paramInt].get(paramMessageMicro)).readFrom(paramCodedInputStreamMicro);
    return true;
  }
  
  void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, MessageMicro<?> paramMessageMicro)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.tags;
      if (i >= arrayOfInt.length) {
        return;
      }
      int j = WireFormatMicro.getTagFieldNumber(arrayOfInt[i]);
      ((PBField)this.fields[i].get(paramMessageMicro)).writeTo(paramCodedOutputStreamMicro, j);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.MessageMicro.FieldMap
 * JD-Core Version:    0.7.0.1
 */