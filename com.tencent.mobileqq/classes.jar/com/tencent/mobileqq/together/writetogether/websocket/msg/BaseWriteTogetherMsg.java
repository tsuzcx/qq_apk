package com.tencent.mobileqq.together.writetogether.websocket.msg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSerializer;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
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
  protected BaseWriteTogetherMsg.Type type;
  
  public BaseWriteTogetherMsg() {}
  
  public BaseWriteTogetherMsg(String paramString)
  {
    this();
    fromJson(paramString);
  }
  
  public static BaseWriteTogetherMsg.Type optTypeFromJson(String paramString)
  {
    BaseWriteTogetherMsg.Type localType = BaseWriteTogetherMsg.Type.UNKNOWN;
    try
    {
      paramString = (BaseWriteTogetherMsg.Type)Enum.valueOf(BaseWriteTogetherMsg.Type.class, new JSONObject(paramString.split("\n", 2)[0]).optString("type"));
      return paramString;
    }
    catch (Exception paramString) {}
    return localType;
  }
  
  public void fromJson(String paramString)
  {
    paramString = paramString.split("\n", 2);
    String str = paramString[0];
    if (paramString.length > 1) {}
    for (paramString = paramString[1];; paramString = null)
    {
      fromJson(str, paramString);
      return;
    }
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
      if (paramString2 != null) {
        this.body = ((Gson)localObject).fromJson(paramString2, getBodyType());
      }
      return;
    }
    catch (JsonIOException paramString1)
    {
      QLog.e("BaseWriteTogetherMsg", 1, paramString1, new Object[0]);
    }
  }
  
  abstract Type getBodyType();
  
  protected Type getDeserializeType()
  {
    return null;
  }
  
  abstract Type getHeaderType();
  
  protected JsonDeserializer getJsonDeserializer()
  {
    return null;
  }
  
  protected JsonSerializer getJsonSerializer()
  {
    return null;
  }
  
  protected Type getSerializeType()
  {
    return null;
  }
  
  public BaseWriteTogetherMsg.Type getType()
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
      if (this.body == null) {}
      for (localObject1 = "";; localObject1 = ((Gson)localObject1).toJson(this.body, getBodyType())) {
        return (String)localObject2 + "\n" + (String)localObject1;
      }
      return null;
    }
    catch (JsonIOException localJsonIOException)
    {
      QLog.e("BaseWriteTogetherMsg", 1, localJsonIOException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg
 * JD-Core Version:    0.7.0.1
 */