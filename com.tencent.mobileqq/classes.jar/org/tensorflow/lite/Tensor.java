package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class Tensor
{
  private final DataType dtype;
  private final long nativeHandle;
  private final int[] shapeCopy;
  
  static
  {
    TensorFlowLite.init();
  }
  
  private Tensor(long paramLong)
  {
    this.nativeHandle = paramLong;
    this.dtype = DataType.fromNumber(dtype(paramLong));
    this.shapeCopy = shape(paramLong);
  }
  
  private ByteBuffer buffer()
  {
    return buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
  }
  
  private static native ByteBuffer buffer(long paramLong);
  
  static DataType dataTypeOf(Object paramObject)
  {
    if (paramObject != null)
    {
      for (Class localClass = paramObject.getClass(); localClass.isArray(); localClass = localClass.getComponentType()) {}
      if (Float.TYPE.equals(localClass)) {
        return DataType.FLOAT32;
      }
      if (Integer.TYPE.equals(localClass)) {
        return DataType.INT32;
      }
      if (Byte.TYPE.equals(localClass)) {
        return DataType.UINT8;
      }
      if (Long.TYPE.equals(localClass)) {
        return DataType.INT64;
      }
    }
    throw new IllegalArgumentException("DataType error: cannot resolve DataType of " + paramObject.getClass().getName());
  }
  
  private static native int dtype(long paramLong);
  
  static void fillShape(Object paramObject, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if ((paramArrayOfInt == null) || (paramInt == paramArrayOfInt.length)) {}
    int j;
    do
    {
      return;
      for (;;)
      {
        j = Array.getLength(paramObject);
        if (paramArrayOfInt[paramInt] != 0) {
          break;
        }
        paramArrayOfInt[paramInt] = j;
        while (i < j)
        {
          fillShape(Array.get(paramObject, i), paramInt + 1, paramArrayOfInt);
          i += 1;
        }
      }
    } while (paramArrayOfInt[paramInt] == j);
    throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[] { Integer.valueOf(paramArrayOfInt[paramInt]), Integer.valueOf(j), Integer.valueOf(paramInt) }));
  }
  
  static Tensor fromHandle(long paramLong)
  {
    return new Tensor(paramLong);
  }
  
  private static boolean isByteBuffer(Object paramObject)
  {
    return paramObject instanceof ByteBuffer;
  }
  
  private static native int numBytes(long paramLong);
  
  static int numDimensions(Object paramObject)
  {
    if ((paramObject == null) || (!paramObject.getClass().isArray())) {
      return 0;
    }
    if (Array.getLength(paramObject) == 0) {
      throw new IllegalArgumentException("Array lengths cannot be 0.");
    }
    return numDimensions(Array.get(paramObject, 0)) + 1;
  }
  
  private static native void readMultiDimensionalArray(long paramLong, Object paramObject);
  
  private static native int[] shape(long paramLong);
  
  static int[] shapeOf(Object paramObject)
  {
    int[] arrayOfInt = new int[numDimensions(paramObject)];
    fillShape(paramObject, 0, arrayOfInt);
    return arrayOfInt;
  }
  
  private void throwExceptionIfTypeIsIncompatible(Object paramObject)
  {
    if (isByteBuffer(paramObject))
    {
      paramObject = (ByteBuffer)paramObject;
      if (paramObject.capacity() != numBytes()) {
        throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a ByteBuffer with %d bytes.", new Object[] { Integer.valueOf(numBytes()), Integer.valueOf(paramObject.capacity()) }));
      }
    }
    else
    {
      DataType localDataType = dataTypeOf(paramObject);
      if (localDataType != this.dtype) {
        throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[] { this.dtype, paramObject.getClass().getName(), localDataType }));
      }
      paramObject = shapeOf(paramObject);
      if (!Arrays.equals(paramObject, this.shapeCopy)) {
        throw new IllegalArgumentException(String.format("Cannot copy between a TensorFlowLite tensor with shape %s and a Java object with shape %s.", new Object[] { Arrays.toString(this.shapeCopy), Arrays.toString(paramObject) }));
      }
    }
  }
  
  private static native void writeDirectBuffer(long paramLong, ByteBuffer paramByteBuffer);
  
  private static native void writeMultiDimensionalArray(long paramLong, Object paramObject);
  
  Object copyTo(Object paramObject)
  {
    throwExceptionIfTypeIsIncompatible(paramObject);
    if ((paramObject instanceof ByteBuffer))
    {
      ((ByteBuffer)paramObject).put(buffer());
      return paramObject;
    }
    readMultiDimensionalArray(this.nativeHandle, paramObject);
    return paramObject;
  }
  
  public DataType dataType()
  {
    return this.dtype;
  }
  
  int[] getInputShapeIfDifferent(Object paramObject)
  {
    if (isByteBuffer(paramObject)) {}
    do
    {
      return null;
      paramObject = shapeOf(paramObject);
    } while (Arrays.equals(this.shapeCopy, paramObject));
    return paramObject;
  }
  
  public int numBytes()
  {
    return numBytes(this.nativeHandle);
  }
  
  void setTo(Object paramObject)
  {
    throwExceptionIfTypeIsIncompatible(paramObject);
    if (isByteBuffer(paramObject))
    {
      paramObject = (ByteBuffer)paramObject;
      if ((paramObject.isDirect()) && (paramObject.order() == ByteOrder.nativeOrder()))
      {
        writeDirectBuffer(this.nativeHandle, paramObject);
        return;
      }
      buffer().put(paramObject);
      return;
    }
    writeMultiDimensionalArray(this.nativeHandle, paramObject);
  }
  
  public int[] shape()
  {
    return this.shapeCopy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     org.tensorflow.lite.Tensor
 * JD-Core Version:    0.7.0.1
 */