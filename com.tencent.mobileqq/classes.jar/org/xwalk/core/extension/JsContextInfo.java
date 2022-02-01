package org.xwalk.core.extension;

import org.json.JSONObject;

public class JsContextInfo
{
  private int extInstanceId;
  private XWalkExternalExtension extensionClient;
  private String objectId;
  private Class<?> targetClass;
  
  JsContextInfo(int paramInt, XWalkExternalExtension paramXWalkExternalExtension, Class<?> paramClass, String paramString)
  {
    this.extensionClient = paramXWalkExternalExtension;
    this.extInstanceId = paramInt;
    this.objectId = paramString;
    this.targetClass = paramClass;
  }
  
  public String getConstructorName()
  {
    return this.targetClass.getSimpleName();
  }
  
  public XWalkExternalExtension getExtensionClient()
  {
    return this.extensionClient;
  }
  
  public String getObjectId()
  {
    return this.objectId;
  }
  
  public String getTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Extension-");
    localStringBuilder.append(this.extensionClient.getExtensionName());
    return localStringBuilder.toString();
  }
  
  public ReflectionHelper getTargetReflect()
  {
    return this.extensionClient.getTargetReflect(this.targetClass.getSimpleName());
  }
  
  public void postMessage(JSONObject paramJSONObject)
  {
    this.extensionClient.postMessage(this.extInstanceId, paramJSONObject.toString());
  }
  
  public void postMessage(byte[] paramArrayOfByte)
  {
    this.extensionClient.postBinaryMessage(this.extInstanceId, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.JsContextInfo
 * JD-Core Version:    0.7.0.1
 */