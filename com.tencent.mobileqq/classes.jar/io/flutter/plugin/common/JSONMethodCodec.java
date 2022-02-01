package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONMethodCodec
  implements MethodCodec
{
  public static final JSONMethodCodec INSTANCE = new JSONMethodCodec();
  
  public Object decodeEnvelope(ByteBuffer paramByteBuffer)
  {
    try
    {
      paramByteBuffer = JSONMessageCodec.INSTANCE.decodeMessage(paramByteBuffer);
      if ((paramByteBuffer instanceof JSONArray))
      {
        Object localObject3 = (JSONArray)paramByteBuffer;
        if (((JSONArray)localObject3).length() == 1) {
          return unwrapNull(((JSONArray)localObject3).opt(0));
        }
        if (((JSONArray)localObject3).length() == 3)
        {
          localObject1 = ((JSONArray)localObject3).get(0);
          Object localObject2 = unwrapNull(((JSONArray)localObject3).opt(1));
          localObject3 = unwrapNull(((JSONArray)localObject3).opt(2));
          if (((localObject1 instanceof String)) && ((localObject2 == null) || ((localObject2 instanceof String)))) {
            throw new FlutterException((String)localObject1, (String)localObject2, localObject3);
          }
        }
      }
    }
    catch (JSONException paramByteBuffer)
    {
      throw new IllegalArgumentException("Invalid JSON", paramByteBuffer);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid envelope: ");
    ((StringBuilder)localObject1).append(paramByteBuffer);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public MethodCall decodeMethodCall(ByteBuffer paramByteBuffer)
  {
    try
    {
      paramByteBuffer = JSONMessageCodec.INSTANCE.decodeMessage(paramByteBuffer);
      if ((paramByteBuffer instanceof JSONObject))
      {
        Object localObject2 = (JSONObject)paramByteBuffer;
        localObject1 = ((JSONObject)localObject2).get("method");
        localObject2 = unwrapNull(((JSONObject)localObject2).opt("args"));
        if ((localObject1 instanceof String)) {
          return new MethodCall((String)localObject1, localObject2);
        }
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid method call: ");
      ((StringBuilder)localObject1).append(paramByteBuffer);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    catch (JSONException paramByteBuffer)
    {
      throw new IllegalArgumentException("Invalid JSON", paramByteBuffer);
    }
  }
  
  public ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject)
  {
    return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(paramString1).put(JSONUtil.wrap(paramString2)).put(JSONUtil.wrap(paramObject)));
  }
  
  public ByteBuffer encodeErrorEnvelopeWithStacktrace(String paramString1, String paramString2, Object paramObject, String paramString3)
  {
    return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(paramString1).put(JSONUtil.wrap(paramString2)).put(JSONUtil.wrap(paramObject)).put(JSONUtil.wrap(paramString3)));
  }
  
  public ByteBuffer encodeMethodCall(MethodCall paramMethodCall)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("method", paramMethodCall.method);
      localJSONObject.put("args", JSONUtil.wrap(paramMethodCall.arguments));
      paramMethodCall = JSONMessageCodec.INSTANCE.encodeMessage(localJSONObject);
      return paramMethodCall;
    }
    catch (JSONException paramMethodCall)
    {
      throw new IllegalArgumentException("Invalid JSON", paramMethodCall);
    }
  }
  
  public ByteBuffer encodeSuccessEnvelope(Object paramObject)
  {
    return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(paramObject)));
  }
  
  Object unwrapNull(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == JSONObject.NULL) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.common.JSONMethodCodec
 * JD-Core Version:    0.7.0.1
 */