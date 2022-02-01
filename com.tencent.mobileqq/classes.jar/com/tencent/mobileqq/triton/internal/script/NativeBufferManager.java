package com.tencent.mobileqq.triton.internal.script;

import io.github.landerlyoung.jenny.NativeClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/NativeBufferManager;", "", "scriptRuntimeHandle", "", "(J)V", "createBuffer", "", "buffer", "", "offset", "length", "createNativeBuffer", "getBuffer", "bufferHandle", "getNativeBuffer", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeClass(namespace="triton::jni")
public final class NativeBufferManager
{
  private final long scriptRuntimeHandle;
  
  public NativeBufferManager(long paramLong)
  {
    this.scriptRuntimeHandle = paramLong;
  }
  
  private final native int createNativeBuffer(long paramLong1, byte[] paramArrayOfByte, long paramLong2, long paramLong3);
  
  private final native byte[] getNativeBuffer(long paramLong, int paramInt);
  
  public final int createBuffer(@NotNull byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "buffer");
    try
    {
      int i = createNativeBuffer(this.scriptRuntimeHandle, paramArrayOfByte, paramLong1, paramLong2);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return createNativeBuffer(this.scriptRuntimeHandle, paramArrayOfByte, paramLong1, paramLong2);
  }
  
  @NotNull
  public final byte[] getBuffer(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = getNativeBuffer(this.scriptRuntimeHandle, paramInt);
      return arrayOfByte;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return getNativeBuffer(this.scriptRuntimeHandle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.NativeBufferManager
 * JD-Core Version:    0.7.0.1
 */