package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class NativeInterpreterWrapper
  implements AutoCloseable
{
  private static final int ERROR_BUFFER_SIZE = 512;
  private long errorHandle;
  private long inferenceDurationNanoseconds = -1L;
  private final Tensor[] inputTensors;
  private Map<String, Integer> inputsIndexes;
  private long interpreterHandle;
  private boolean isMemoryAllocated = false;
  private ByteBuffer modelByteBuffer;
  private long modelHandle;
  private final Tensor[] outputTensors;
  private Map<String, Integer> outputsIndexes;
  
  static
  {
    TensorFlowLite.init();
  }
  
  NativeInterpreterWrapper(String paramString)
  {
    this(paramString, -1);
  }
  
  NativeInterpreterWrapper(String paramString, int paramInt)
  {
    this.errorHandle = createErrorReporter(512);
    this.modelHandle = createModel(paramString, this.errorHandle);
    this.interpreterHandle = createInterpreter(this.modelHandle, this.errorHandle, paramInt);
    this.isMemoryAllocated = true;
    this.inputTensors = new Tensor[getInputCount(this.interpreterHandle)];
    this.outputTensors = new Tensor[getOutputCount(this.interpreterHandle)];
  }
  
  NativeInterpreterWrapper(ByteBuffer paramByteBuffer)
  {
    this(paramByteBuffer, -1);
  }
  
  NativeInterpreterWrapper(ByteBuffer paramByteBuffer, int paramInt)
  {
    if ((paramByteBuffer == null) || ((!(paramByteBuffer instanceof MappedByteBuffer)) && ((!paramByteBuffer.isDirect()) || (paramByteBuffer.order() != ByteOrder.nativeOrder())))) {
      throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
    }
    this.modelByteBuffer = paramByteBuffer;
    this.errorHandle = createErrorReporter(512);
    this.modelHandle = createModelWithBuffer(this.modelByteBuffer, this.errorHandle);
    this.interpreterHandle = createInterpreter(this.modelHandle, this.errorHandle, paramInt);
    this.isMemoryAllocated = true;
    this.inputTensors = new Tensor[getInputCount(this.interpreterHandle)];
    this.outputTensors = new Tensor[getOutputCount(this.interpreterHandle)];
  }
  
  private static native long allocateTensors(long paramLong1, long paramLong2);
  
  private static native long createErrorReporter(int paramInt);
  
  private static native long createInterpreter(long paramLong1, long paramLong2, int paramInt);
  
  private static native long createModel(String paramString, long paramLong);
  
  private static native long createModelWithBuffer(ByteBuffer paramByteBuffer, long paramLong);
  
  private static native void delete(long paramLong1, long paramLong2, long paramLong3);
  
  private static native int getInputCount(long paramLong);
  
  private static native String[] getInputNames(long paramLong);
  
  private static native long getInputTensor(long paramLong, int paramInt);
  
  private static native int getOutputCount(long paramLong);
  
  private static native int getOutputDataType(long paramLong, int paramInt);
  
  private static native String[] getOutputNames(long paramLong);
  
  private static native float getOutputQuantizationScale(long paramLong, int paramInt);
  
  private static native int getOutputQuantizationZeroPoint(long paramLong, int paramInt);
  
  private static native long getOutputTensor(long paramLong, int paramInt);
  
  private static native void numThreads(long paramLong, int paramInt);
  
  private static native boolean resizeInput(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfInt);
  
  private static native boolean run(long paramLong1, long paramLong2);
  
  private static native void useNNAPI(long paramLong, boolean paramBoolean);
  
  public void close()
  {
    delete(this.errorHandle, this.modelHandle, this.interpreterHandle);
    this.errorHandle = 0L;
    this.modelHandle = 0L;
    this.interpreterHandle = 0L;
    this.modelByteBuffer = null;
    this.inputsIndexes = null;
    this.outputsIndexes = null;
    this.isMemoryAllocated = false;
    Arrays.fill(this.inputTensors, null);
    Arrays.fill(this.outputTensors, null);
  }
  
  int getInputIndex(String paramString)
  {
    if (this.inputsIndexes == null)
    {
      String[] arrayOfString = getInputNames(this.interpreterHandle);
      this.inputsIndexes = new HashMap();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          this.inputsIndexes.put(arrayOfString[i], Integer.valueOf(i));
          i += 1;
        }
      }
    }
    if (this.inputsIndexes.containsKey(paramString)) {
      return ((Integer)this.inputsIndexes.get(paramString)).intValue();
    }
    throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any input. Names of inputs and their indexes are %s", new Object[] { paramString, this.inputsIndexes.toString() }));
  }
  
  Tensor getInputTensor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.inputTensors.length)) {
      throw new IllegalArgumentException("Invalid input Tensor index: " + paramInt);
    }
    Object localObject2 = this.inputTensors[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.inputTensors;
      localObject1 = Tensor.fromHandle(getInputTensor(this.interpreterHandle, paramInt));
      localObject2[paramInt] = localObject1;
    }
    return localObject1;
  }
  
  Long getLastNativeInferenceDurationNanoseconds()
  {
    if (this.inferenceDurationNanoseconds < 0L) {
      return null;
    }
    return Long.valueOf(this.inferenceDurationNanoseconds);
  }
  
  int getOutputIndex(String paramString)
  {
    if (this.outputsIndexes == null)
    {
      String[] arrayOfString = getOutputNames(this.interpreterHandle);
      this.outputsIndexes = new HashMap();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          this.outputsIndexes.put(arrayOfString[i], Integer.valueOf(i));
          i += 1;
        }
      }
    }
    if (this.outputsIndexes.containsKey(paramString)) {
      return ((Integer)this.outputsIndexes.get(paramString)).intValue();
    }
    throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any output. Names of outputs and their indexes are %s", new Object[] { paramString, this.outputsIndexes.toString() }));
  }
  
  float getOutputQuantizationScale(int paramInt)
  {
    return getOutputQuantizationScale(this.interpreterHandle, paramInt);
  }
  
  int getOutputQuantizationZeroPoint(int paramInt)
  {
    return getOutputQuantizationZeroPoint(this.interpreterHandle, paramInt);
  }
  
  Tensor getOutputTensor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.outputTensors.length)) {
      throw new IllegalArgumentException("Invalid output Tensor index: " + paramInt);
    }
    Object localObject2 = this.outputTensors[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.outputTensors;
      localObject1 = Tensor.fromHandle(getOutputTensor(this.interpreterHandle, paramInt));
      localObject2[paramInt] = localObject1;
    }
    return localObject1;
  }
  
  void resizeInput(int paramInt, int[] paramArrayOfInt)
  {
    if (resizeInput(this.interpreterHandle, this.errorHandle, paramInt, paramArrayOfInt))
    {
      this.isMemoryAllocated = false;
      this.inputTensors[paramInt] = null;
    }
  }
  
  void run(Object[] paramArrayOfObject, Map<Integer, Object> paramMap)
  {
    int j = 0;
    this.inferenceDurationNanoseconds = -1L;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
    }
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      int[] arrayOfInt = getInputTensor(i).getInputShapeIfDifferent(paramArrayOfObject[i]);
      if (arrayOfInt != null) {
        resizeInput(i, arrayOfInt);
      }
      i += 1;
    }
    i = j;
    if (!this.isMemoryAllocated)
    {
      allocateTensors(this.interpreterHandle, this.errorHandle);
      this.isMemoryAllocated = true;
      Arrays.fill(this.outputTensors, null);
      i = j;
    }
    while (i < paramArrayOfObject.length)
    {
      getInputTensor(i).setTo(paramArrayOfObject[i]);
      i += 1;
    }
    long l1 = System.nanoTime();
    run(this.interpreterHandle, this.errorHandle);
    long l2 = System.nanoTime();
    paramArrayOfObject = paramMap.entrySet().iterator();
    while (paramArrayOfObject.hasNext())
    {
      paramMap = (Map.Entry)paramArrayOfObject.next();
      getOutputTensor(((Integer)paramMap.getKey()).intValue()).copyTo(paramMap.getValue());
    }
    this.inferenceDurationNanoseconds = (l2 - l1);
  }
  
  void setNumThreads(int paramInt)
  {
    numThreads(this.interpreterHandle, paramInt);
  }
  
  void setUseNNAPI(boolean paramBoolean)
  {
    useNNAPI(this.interpreterHandle, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.tensorflow.lite.NativeInterpreterWrapper
 * JD-Core Version:    0.7.0.1
 */