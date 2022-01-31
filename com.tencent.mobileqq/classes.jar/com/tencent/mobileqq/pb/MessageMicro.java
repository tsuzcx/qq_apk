package com.tencent.mobileqq.pb;

import java.io.IOException;
import java.lang.reflect.Field;

public abstract class MessageMicro<T extends MessageMicro<T>>
  extends PBPrimitiveField<T>
{
  private MessageMicro.FieldMap _fields = null;
  private int cachedSize = -1;
  
  private final MessageMicro.FieldMap getFieldMap()
  {
    Object localObject;
    if (this._fields == null) {
      localObject = getClass();
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredField("__fieldMap__");
      ((Field)localObject).setAccessible(true);
      this._fields = ((MessageMicro.FieldMap)((Field)localObject).get(this));
      return this._fields;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localSecurityException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public static MessageMicro.FieldMap initFieldMap(int[] paramArrayOfInt, String[] paramArrayOfString, Object[] paramArrayOfObject, Class<?> paramClass)
  {
    return new MessageMicro.FieldMap(paramArrayOfInt, paramArrayOfString, paramArrayOfObject, paramClass);
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  public static final <T extends MessageMicro<T>> T mergeFrom(T paramT, byte[] paramArrayOfByte)
  {
    return paramT.mergeFrom(paramArrayOfByte);
  }
  
  public static final byte[] toByteArray(MessageMicro<?> paramMessageMicro)
  {
    return paramMessageMicro.toByteArray();
  }
  
  public void clear(Object paramObject)
  {
    try
    {
      getFieldMap().clear(this);
      setHasFlag(false);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeMessageSize(paramInt, this);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, T paramT)
  {
    return CodedOutputStreamMicro.computeMessageSize(paramInt, paramT);
  }
  
  protected void copyFrom(PBField<T> paramPBField)
  {
    MessageMicro localMessageMicro = (MessageMicro)paramPBField;
    try
    {
      getFieldMap().copyFields(this, localMessageMicro);
      setHasFlag(((MessageMicro)paramPBField).has());
      return;
    }
    catch (IllegalArgumentException paramPBField)
    {
      paramPBField.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramPBField)
    {
      paramPBField.printStackTrace();
    }
  }
  
  public T get()
  {
    return this;
  }
  
  public final int getCachedSize()
  {
    return getSerializedSize();
  }
  
  public final int getSerializedSize()
  {
    int i = -1;
    try
    {
      int j = getFieldMap().getSerializedSize(this);
      i = j;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    this.cachedSize = i;
    return i;
  }
  
  public final T mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    MessageMicro.FieldMap localFieldMap = getFieldMap();
    setHasFlag(true);
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      try
      {
        if (!localFieldMap.readFieldFrom(paramCodedInputStreamMicro, i, this))
        {
          if (i == 0) {
            return this;
          }
          boolean bool = parseUnknownField(paramCodedInputStreamMicro, i);
          if (!bool) {
            return this;
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
    }
  }
  
  public final T mergeFrom(byte[] paramArrayOfByte)
  {
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final T mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedInputStreamMicro.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      mergeFrom(paramArrayOfByte);
      paramArrayOfByte.checkLastTagWas(0);
      return this;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  protected boolean parseUnknownField(CodedInputStreamMicro paramCodedInputStreamMicro, int paramInt)
  {
    return paramCodedInputStreamMicro.skipField(paramInt);
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    paramCodedInputStreamMicro.readMessage(this);
  }
  
  protected T readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    try
    {
      MessageMicro localMessageMicro = (MessageMicro)getClass().newInstance();
      paramCodedInputStreamMicro.readMessage(localMessageMicro);
      return localMessageMicro;
    }
    catch (InstantiationException paramCodedInputStreamMicro)
    {
      paramCodedInputStreamMicro.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramCodedInputStreamMicro)
    {
      for (;;)
      {
        paramCodedInputStreamMicro.printStackTrace();
      }
    }
  }
  
  public void set(T paramT)
  {
    set(paramT, true);
  }
  
  public void set(T paramT, boolean paramBoolean)
  {
    copyFrom(paramT);
    setHasFlag(paramBoolean);
    this.cachedSize = -1;
  }
  
  public final void toByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedOutputStreamMicro.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      writeTo(paramArrayOfByte);
      paramArrayOfByte.checkNoSpaceLeft();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
    }
  }
  
  public final byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[getSerializedSize()];
    toByteArray(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public final void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
  {
    try
    {
      getFieldMap().writeTo(paramCodedOutputStreamMicro, this);
      return;
    }
    catch (IllegalArgumentException paramCodedOutputStreamMicro)
    {
      paramCodedOutputStreamMicro.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramCodedOutputStreamMicro)
    {
      paramCodedOutputStreamMicro.printStackTrace();
    }
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeMessage(paramInt, this);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, T paramT)
  {
    paramCodedOutputStreamMicro.writeMessage(paramInt, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.MessageMicro
 * JD-Core Version:    0.7.0.1
 */