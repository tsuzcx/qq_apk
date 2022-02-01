package com.tencent.robolectric;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class ShadowParcel$ByteBuffer
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private ShadowParcel.ByteBuffer.FakeEncodedItem[] jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem;
  private int b;
  
  ShadowParcel$ByteBuffer()
  {
    a();
  }
  
  private int a(int paramInt)
  {
    return (paramInt + 3) / 4 * 4;
  }
  
  private <T> ShadowParcel.ByteBuffer.FakeEncodedItem a(Class<T> paramClass)
  {
    ShadowParcel.ByteBuffer.FakeEncodedItem localFakeEncodedItem = this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem[this.jdField_a_of_type_Int];
    if (localFakeEncodedItem == null) {
      throw new ShadowParcel.UnreliableBehaviorError("Reading uninitialized data at position " + this.jdField_a_of_type_Int);
    }
    a(paramClass, localFakeEncodedItem);
    return localFakeEncodedItem;
  }
  
  private void a(int paramInt, Object paramObject)
  {
    a(new ShadowParcel.ByteBuffer.FakeEncodedItem(a(paramInt), paramObject));
  }
  
  private void a(ShadowParcel.ByteBuffer.FakeEncodedItem paramFakeEncodedItem)
  {
    int i = this.jdField_a_of_type_Int + paramFakeEncodedItem.sizeBytes;
    if (i > this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem.length) {
      c(i * 3 / 2);
    }
    if (i > this.b)
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = i;
    }
    Arrays.fill(this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem, this.jdField_a_of_type_Int, i, paramFakeEncodedItem);
    this.jdField_a_of_type_Int = i;
  }
  
  private void a(Class<?> paramClass, ShadowParcel.ByteBuffer.FakeEncodedItem paramFakeEncodedItem)
  {
    int j = this.jdField_a_of_type_Int;
    int k = paramFakeEncodedItem.sizeBytes;
    int i = this.jdField_a_of_type_Int;
    while (i < j + k)
    {
      Locale localLocale;
      if (i < this.b)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem[i];
        if (localObject == paramFakeEncodedItem) {
          break label119;
        }
        j = this.jdField_a_of_type_Int;
        localLocale = Locale.US;
        if (localObject != null) {
          break label109;
        }
      }
      label109:
      for (Object localObject = "uninitialized data or the end of the buffer";; localObject = ((ShadowParcel.ByteBuffer.FakeEncodedItem)localObject).value)
      {
        throw new ShadowParcel.UnreliableBehaviorError(paramClass, j, paramFakeEncodedItem, String.format(localLocale, "but [%s] interrupts it at position %d", new Object[] { localObject, Integer.valueOf(i) }));
        localObject = null;
        break;
      }
      label119:
      i += 1;
    }
    this.jdField_a_of_type_Int = Math.min(this.b, this.jdField_a_of_type_Int + paramFakeEncodedItem.sizeBytes);
  }
  
  private static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfByte[paramInt1] != 0) {
        return false;
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  private static boolean b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (!(paramObject instanceof Number)) {
          break;
        }
        paramObject = (Number)paramObject;
      } while ((paramObject.longValue() != 0L) || (paramObject.doubleValue() != 0.0D));
      return true;
    } while (!(paramObject instanceof byte[]));
    paramObject = (byte[])paramObject;
    return a(paramObject, 0, paramObject.length);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem = new ShadowParcel.ByteBuffer.FakeEncodedItem[0];
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(double paramDouble)
  {
    a(8, Double.valueOf(paramDouble));
  }
  
  public void a(float paramFloat)
  {
    a(4, Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt)
  {
    a(4, Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong)
  {
    a(8, Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (int i = paramString.length() + 1;; i = 0)
    {
      a(i * 2 + 4, paramString);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramInt2);
    if (paramInt2 != 0) {
      a(paramInt2, Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2));
    }
  }
  
  public byte[] a()
  {
    int i = this.jdField_a_of_type_Int;
    ObjectOutputStream localObjectOutputStream;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObject2 = new ArrayList();
      this.jdField_a_of_type_Int = 0;
      while (this.jdField_a_of_type_Int < this.b) {
        ((List)localObject2).add(a(Object.class));
      }
      localObjectOutputStream.writeInt(((List)localObject2).size());
    }
    catch (IOException localIOException)
    {
      throw new ShadowParcel.UnreliableBehaviorError("ErrorProne unable to serialize its custom format", localIOException);
    }
    finally
    {
      this.jdField_a_of_type_Int = i;
    }
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ShadowParcel.ByteBuffer.FakeEncodedItem localFakeEncodedItem = (ShadowParcel.ByteBuffer.FakeEncodedItem)((Iterator)localObject2).next();
      localObjectOutputStream.writeInt(localFakeEncodedItem.sizeBytes);
      localObjectOutputStream.writeObject(localFakeEncodedItem.value);
    }
    localObjectOutputStream.flush();
    byte[] arrayOfByte = localObject1.toByteArray();
    this.jdField_a_of_type_Int = i;
    return arrayOfByte;
  }
  
  public void b(int paramInt)
  {
    if (paramInt > this.b) {
      throw new ShadowParcel.UnreliableBehaviorError(paramInt + " greater than dataSize " + this.b);
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem.length)
    {
      ShadowParcel.ByteBuffer.FakeEncodedItem[] arrayOfFakeEncodedItem = new ShadowParcel.ByteBuffer.FakeEncodedItem[paramInt];
      this.b = Math.min(this.b, paramInt);
      this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_Int, this.b);
      System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem, 0, arrayOfFakeEncodedItem, 0, this.b);
      this.jdField_a_of_type_ArrayOfComTencentRobolectricShadowParcel$ByteBuffer$FakeEncodedItem = arrayOfFakeEncodedItem;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.robolectric.ShadowParcel.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */