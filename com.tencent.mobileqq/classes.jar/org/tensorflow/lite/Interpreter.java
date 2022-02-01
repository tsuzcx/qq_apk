package org.tensorflow.lite;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class Interpreter
  implements AutoCloseable
{
  NativeInterpreterWrapper wrapper;
  
  public Interpreter(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    this.wrapper = new NativeInterpreterWrapper(paramFile.getAbsolutePath());
  }
  
  public Interpreter(File paramFile, int paramInt)
  {
    if (paramFile == null) {
      return;
    }
    this.wrapper = new NativeInterpreterWrapper(paramFile.getAbsolutePath(), paramInt);
  }
  
  public Interpreter(ByteBuffer paramByteBuffer)
  {
    this.wrapper = new NativeInterpreterWrapper(paramByteBuffer);
  }
  
  public Interpreter(ByteBuffer paramByteBuffer, int paramInt)
  {
    this.wrapper = new NativeInterpreterWrapper(paramByteBuffer, paramInt);
  }
  
  public Interpreter(MappedByteBuffer paramMappedByteBuffer)
  {
    this.wrapper = new NativeInterpreterWrapper(paramMappedByteBuffer);
  }
  
  public Interpreter(MappedByteBuffer paramMappedByteBuffer, int paramInt)
  {
    this.wrapper = new NativeInterpreterWrapper(paramMappedByteBuffer, paramInt);
  }
  
  public void close()
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null)
    {
      localNativeInterpreterWrapper.close();
      this.wrapper = null;
    }
  }
  
  protected void finalize()
  {
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getInputIndex(String paramString)
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null) {
      return localNativeInterpreterWrapper.getInputIndex(paramString);
    }
    throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
  }
  
  public Long getLastNativeInferenceDurationNanoseconds()
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null) {
      return localNativeInterpreterWrapper.getLastNativeInferenceDurationNanoseconds();
    }
    throw new IllegalStateException("Internal error: The interpreter has already been closed.");
  }
  
  public int getOutputIndex(String paramString)
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null) {
      return localNativeInterpreterWrapper.getOutputIndex(paramString);
    }
    throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
  }
  
  public void resizeInput(int paramInt, int[] paramArrayOfInt)
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null)
    {
      localNativeInterpreterWrapper.resizeInput(paramInt, paramArrayOfInt);
      return;
    }
    throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
  }
  
  public void run(Object paramObject1, Object paramObject2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), paramObject2);
    runForMultipleInputsOutputs(new Object[] { paramObject1 }, localHashMap);
  }
  
  public void runForMultipleInputsOutputs(Object[] paramArrayOfObject, Map<Integer, Object> paramMap)
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null)
    {
      localNativeInterpreterWrapper.run(paramArrayOfObject, paramMap);
      return;
    }
    throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
  }
  
  public void setNumThreads(int paramInt)
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null)
    {
      localNativeInterpreterWrapper.setNumThreads(paramInt);
      return;
    }
    throw new IllegalStateException("The interpreter has already been closed.");
  }
  
  public void setUseNNAPI(boolean paramBoolean)
  {
    NativeInterpreterWrapper localNativeInterpreterWrapper = this.wrapper;
    if (localNativeInterpreterWrapper != null)
    {
      localNativeInterpreterWrapper.setUseNNAPI(paramBoolean);
      return;
    }
    throw new IllegalStateException("Internal error: NativeInterpreterWrapper has already been closed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.tensorflow.lite.Interpreter
 * JD-Core Version:    0.7.0.1
 */