package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSerializer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class BaseWriteTogetherMsg<H extends BaseHeader, B>
  implements IWriteTogetherMsg
{
  static final int CODE_VERSION = 0;
  static final String DOC_VERSION = "2.1.0";
  public static final String HEADER_BODY_SEPARATOR = "\n";
  public static final String KEY_TYPE = "type";
  private static final String TAG = "BaseWriteTogetherMsg";
  public B body;
  public H header;
  protected Type type;
  
  public BaseWriteTogetherMsg() {}
  
  public BaseWriteTogetherMsg(String paramString)
  {
    this();
    fromJson(paramString);
  }
  
  public static Type optTypeFromJson(String paramString)
  {
    Type localType = Type.UNKNOWN;
    try
    {
      paramString = (Type)Enum.valueOf(Type.class, new JSONObject(paramString.split("\n", 2)[0]).optString("type"));
      return paramString;
    }
    catch (Exception paramString)
    {
      label36:
      break label36;
    }
    return localType;
  }
  
  public void fromJson(String paramString)
  {
    paramString = paramString.split("\n", 2);
    String str = paramString[0];
    if (paramString.length > 1) {
      paramString = paramString[1];
    } else {
      paramString = null;
    }
    fromJson(str, paramString);
  }
  
  public void fromJson(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new GsonBuilder();
      JsonDeserializer localJsonDeserializer = getJsonDeserializer();
      if (localJsonDeserializer != null) {
        ((GsonBuilder)localObject).registerTypeAdapter(getDeserializeType(), localJsonDeserializer);
      }
      localObject = ((GsonBuilder)localObject).disableHtmlEscaping().create();
      this.header = ((BaseHeader)((Gson)localObject).fromJson(paramString1, getHeaderType()));
      if (paramString2 != null)
      {
        this.body = ((Gson)localObject).fromJson(paramString2, getBodyType());
        return;
      }
    }
    catch (JsonIOException paramString1)
    {
      QLog.e("BaseWriteTogetherMsg", 1, paramString1, new Object[0]);
    }
  }
  
  abstract java.lang.reflect.Type getBodyType();
  
  protected java.lang.reflect.Type getDeserializeType()
  {
    return null;
  }
  
  abstract java.lang.reflect.Type getHeaderType();
  
  protected JsonDeserializer getJsonDeserializer()
  {
    return null;
  }
  
  protected JsonSerializer getJsonSerializer()
  {
    return null;
  }
  
  protected java.lang.reflect.Type getSerializeType()
  {
    return null;
  }
  
  public Type getType()
  {
    return this.header.type;
  }
  
  public String toJson()
  {
    try
    {
      Object localObject1 = new GsonBuilder();
      Object localObject2 = getJsonSerializer();
      if (localObject2 != null) {
        ((GsonBuilder)localObject1).registerTypeAdapter(getSerializeType(), localObject2);
      }
      localObject1 = ((GsonBuilder)localObject1).disableHtmlEscaping().create();
      localObject2 = ((Gson)localObject1).toJson(this.header, getHeaderType());
      if (this.body == null) {
        localObject1 = "";
      } else {
        localObject1 = ((Gson)localObject1).toJson(this.body, getBodyType());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("\n");
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
      return localObject1;
    }
    catch (JsonIOException localJsonIOException)
    {
      QLog.e("BaseWriteTogetherMsg", 1, localJsonIOException, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.BaseWriteTogetherMsg
 * JD-Core Version:    0.7.0.1
 */