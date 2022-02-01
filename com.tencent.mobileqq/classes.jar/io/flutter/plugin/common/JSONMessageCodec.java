package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class JSONMessageCodec
  implements MessageCodec<Object>
{
  public static final JSONMessageCodec INSTANCE = new JSONMessageCodec();
  
  public Object decodeMessage(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return null;
    }
    try
    {
      paramByteBuffer = new JSONTokener(StringCodec.INSTANCE.decodeMessage(paramByteBuffer));
      Object localObject = paramByteBuffer.nextValue();
      if (!paramByteBuffer.more()) {
        return localObject;
      }
      throw new IllegalArgumentException("Invalid JSON");
    }
    catch (JSONException paramByteBuffer)
    {
      throw new IllegalArgumentException("Invalid JSON", paramByteBuffer);
    }
  }
  
  public ByteBuffer encodeMessage(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Object localObject = JSONUtil.wrap(paramObject);
    if ((localObject instanceof String)) {
      paramObject = StringCodec.INSTANCE;
    }
    for (localObject = JSONObject.quote((String)localObject);; localObject = localObject.toString())
    {
      return paramObject.encodeMessage((String)localObject);
      paramObject = StringCodec.INSTANCE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.JSONMessageCodec
 * JD-Core Version:    0.7.0.1
 */