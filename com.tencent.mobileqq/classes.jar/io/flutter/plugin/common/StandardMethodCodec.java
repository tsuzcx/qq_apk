package io.flutter.plugin.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class StandardMethodCodec
  implements MethodCodec
{
  public static final StandardMethodCodec INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
  private final StandardMessageCodec messageCodec;
  
  public StandardMethodCodec(StandardMessageCodec paramStandardMessageCodec)
  {
    this.messageCodec = paramStandardMessageCodec;
  }
  
  private static String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public Object decodeEnvelope(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.order(ByteOrder.nativeOrder());
    switch (paramByteBuffer.get())
    {
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      throw new IllegalArgumentException("Envelope corrupted");
      localObject1 = this.messageCodec.readValue(paramByteBuffer);
      if (!paramByteBuffer.hasRemaining()) {
        return localObject1;
      }
      localObject1 = this.messageCodec.readValue(paramByteBuffer);
      localObject2 = this.messageCodec.readValue(paramByteBuffer);
      localObject3 = this.messageCodec.readValue(paramByteBuffer);
    } while ((!(localObject1 instanceof String)) || ((localObject2 != null) && (!(localObject2 instanceof String))) || (paramByteBuffer.hasRemaining()));
    throw new FlutterException((String)localObject1, (String)localObject2, localObject3);
  }
  
  public MethodCall decodeMethodCall(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject1 = this.messageCodec.readValue(paramByteBuffer);
    Object localObject2 = this.messageCodec.readValue(paramByteBuffer);
    if (((localObject1 instanceof String)) && (!paramByteBuffer.hasRemaining())) {
      return new MethodCall((String)localObject1, localObject2);
    }
    throw new IllegalArgumentException("Method call corrupted");
  }
  
  public ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject)
  {
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    localExposedByteArrayOutputStream.write(1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString2);
    if ((paramObject instanceof Throwable)) {
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, getStackTrace((Throwable)paramObject));
    }
    for (;;)
    {
      paramString1 = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
      paramString1.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
      return paramString1;
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramObject);
    }
  }
  
  public ByteBuffer encodeErrorEnvelopeWithStacktrace(String paramString1, String paramString2, Object paramObject, String paramString3)
  {
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    localExposedByteArrayOutputStream.write(1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString2);
    if ((paramObject instanceof Throwable)) {
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, getStackTrace((Throwable)paramObject));
    }
    for (;;)
    {
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString3);
      paramString1 = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
      paramString1.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
      return paramString1;
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramObject);
    }
  }
  
  public ByteBuffer encodeMethodCall(MethodCall paramMethodCall)
  {
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramMethodCall.method);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramMethodCall.arguments);
    paramMethodCall = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
    paramMethodCall.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
    return paramMethodCall;
  }
  
  public ByteBuffer encodeSuccessEnvelope(Object paramObject)
  {
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    localExposedByteArrayOutputStream.write(0);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramObject);
    paramObject = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
    paramObject.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.common.StandardMethodCodec
 * JD-Core Version:    0.7.0.1
 */