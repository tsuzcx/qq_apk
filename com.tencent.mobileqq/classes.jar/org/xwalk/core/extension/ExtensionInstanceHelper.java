package org.xwalk.core.extension;

public class ExtensionInstanceHelper
{
  XWalkExternalExtension mExtension;
  MessageHandler mHandler;
  int mId;
  private BindingObjectStore mStore;
  
  public ExtensionInstanceHelper(XWalkExternalExtension paramXWalkExternalExtension, int paramInt)
  {
    this.mId = paramInt;
    this.mExtension = paramXWalkExternalExtension;
    this.mHandler = new MessageHandler(this.mExtension.getMessageHandler());
    if (this.mExtension.isAutoJS()) {
      ReflectionHelper.registerHandlers(this.mExtension.getReflection(), this.mHandler, this.mExtension);
    }
    this.mStore = new BindingObjectStore(this.mHandler, this);
  }
  
  public boolean addBindingObject(String paramString, BindingObject paramBindingObject)
  {
    return this.mStore.addBindingObject(paramString, paramBindingObject);
  }
  
  public BindingObject getBindingObject(String paramString)
  {
    return this.mStore.getBindingObject(paramString);
  }
  
  public XWalkExternalExtension getExtension()
  {
    return this.mExtension;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public Object handleMessage(String paramString)
  {
    paramString = new MessageInfo(this.mExtension, this.mId, paramString);
    return this.mHandler.handleMessage(paramString);
  }
  
  public Object handleMessage(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new MessageInfo(this.mExtension, this.mId, paramArrayOfByte);
    return this.mHandler.handleMessage(paramArrayOfByte);
  }
  
  public BindingObject removeBindingObject(String paramString)
  {
    return this.mStore.removeBindingObject(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.ExtensionInstanceHelper
 * JD-Core Version:    0.7.0.1
 */