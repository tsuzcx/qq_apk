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
    if (this.wrapper != null)
    {
      this.wrapper.close();
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
    if (this.wrapper == null) {
      throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
    }
    return this.wrapper.getInputIndex(paramString);
  }
  
  public Long getLastNativeInferenceDurationNanoseconds()
  {
    if (this.wrapper == null) {
      throw new IllegalStateException("Internal error: The interpreter has already been closed.");
    }
    return this.wrapper.getLastNativeInferenceDurationNanoseconds();
  }
  
  public int getOutputIndex(String paramString)
  {
    if (this.wrapper == null) {
      throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
    }
    return this.wrapper.getOutputIndex(paramString);
  }
  
  public void resizeInput(int paramInt, int[] paramArrayOfInt)
  {
    if (this.wrapper == null) {
      throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
    }
    this.wrapper.resizeInput(paramInt, paramArrayOfInt);
  }
  
  public void run(Object paramObject1, Object paramObject2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), paramObject2);
    runForMultipleInputsOutputs(new Object[] { paramObject1 }, localHashMap);
  }
  
  public void runForMultipleInputsOutputs(Object[] paramArrayOfObject, Map<Integer, Object> paramMap)
  {
    if (this.wrapper == null) {
      throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
    }
    this.wrapper.run(paramArrayOfObject, paramMap);
  }
  
  public void setNumThreads(int paramInt)
  {
    if (this.wrapper == null) {
      throw new IllegalStateException("The interpreter has already been closed.");
    }
    this.wrapper.setNumThreads(paramInt);
  }
  
  public void setUseNNAPI(boolean paramBoolean)
  {
    if (this.wrapper != null)
    {
      this.wrapper.setUseNNAPI(paramBoolean);
      return;
    }
    throw new IllegalStateException("Internal error: NativeInterpreterWrapper has already been closed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.tensorflow.lite.Interpreter
 * JD-Core Version:    0.7.0.1
 */