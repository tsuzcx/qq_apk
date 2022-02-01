package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public abstract interface MethodCodec
{
  public abstract Object decodeEnvelope(ByteBuffer paramByteBuffer);
  
  public abstract MethodCall decodeMethodCall(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject);
  
  public abstract ByteBuffer encodeErrorEnvelopeWithStacktrace(String paramString1, String paramString2, Object paramObject, String paramString3);
  
  public abstract ByteBuffer encodeMethodCall(MethodCall paramMethodCall);
  
  public abstract ByteBuffer encodeSuccessEnvelope(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.common.MethodCodec
 * JD-Core Version:    0.7.0.1
 */