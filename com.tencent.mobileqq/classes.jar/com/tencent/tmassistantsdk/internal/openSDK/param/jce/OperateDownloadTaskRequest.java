package com.tencent.tmassistantsdk.internal.openSDK.param.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class OperateDownloadTaskRequest
  extends JceStruct
  implements Cloneable
{
  static IPCBaseParam cache_baseParam;
  static Map<String, Long> cache_timePoint;
  public String actionFlag = "";
  public IPCBaseParam baseParam = null;
  public String opList = "";
  public int requestType = 0;
  public Map<String, Long> timePoint = null;
  public String verifyType = "";
  
  static
  {
    if (!OperateDownloadTaskRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_baseParam = new IPCBaseParam();
      cache_timePoint = new HashMap();
      cache_timePoint.put("", Long.valueOf(0L));
      return;
    }
  }
  
  public OperateDownloadTaskRequest() {}
  
  public OperateDownloadTaskRequest(int paramInt, IPCBaseParam paramIPCBaseParam, String paramString1, String paramString2, String paramString3, Map<String, Long> paramMap)
  {
    this.requestType = paramInt;
    this.baseParam = paramIPCBaseParam;
    this.opList = paramString1;
    this.actionFlag = paramString2;
    this.verifyType = paramString3;
    this.timePoint = paramMap;
  }
  
  public String className()
  {
    return "jce.OperateDownloadTaskRequest";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.requestType, "requestType");
    paramStringBuilder.display(this.baseParam, "baseParam");
    paramStringBuilder.display(this.opList, "opList");
    paramStringBuilder.display(this.actionFlag, "actionFlag");
    paramStringBuilder.display(this.verifyType, "verifyType");
    paramStringBuilder.display(this.timePoint, "timePoint");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.requestType, true);
    paramStringBuilder.displaySimple(this.baseParam, true);
    paramStringBuilder.displaySimple(this.opList, true);
    paramStringBuilder.displaySimple(this.actionFlag, true);
    paramStringBuilder.displaySimple(this.verifyType, true);
    paramStringBuilder.displaySimple(this.timePoint, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (OperateDownloadTaskRequest)paramObject;
    } while ((!JceUtil.equals(this.requestType, paramObject.requestType)) || (!JceUtil.equals(this.baseParam, paramObject.baseParam)) || (!JceUtil.equals(this.opList, paramObject.opList)) || (!JceUtil.equals(this.actionFlag, paramObject.actionFlag)) || (!JceUtil.equals(this.verifyType, paramObject.verifyType)) || (!JceUtil.equals(this.timePoint, paramObject.timePoint)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest";
  }
  
  public String getActionFlag()
  {
    return this.actionFlag;
  }
  
  public IPCBaseParam getBaseParam()
  {
    return this.baseParam;
  }
  
  public String getOpList()
  {
    return this.opList;
  }
  
  public int getRequestType()
  {
    return this.requestType;
  }
  
  public Map<String, Long> getTimePoint()
  {
    return this.timePoint;
  }
  
  public String getVerifyType()
  {
    return this.verifyType;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestType = paramJceInputStream.read(this.requestType, 0, true);
    this.baseParam = ((IPCBaseParam)paramJceInputStream.read(cache_baseParam, 1, true));
    this.opList = paramJceInputStream.readString(2, false);
    this.actionFlag = paramJceInputStream.readString(3, false);
    this.verifyType = paramJceInputStream.readString(4, false);
    this.timePoint = ((Map)paramJceInputStream.read(cache_timePoint, 5, false));
  }
  
  public void setActionFlag(String paramString)
  {
    this.actionFlag = paramString;
  }
  
  public void setBaseParam(IPCBaseParam paramIPCBaseParam)
  {
    this.baseParam = paramIPCBaseParam;
  }
  
  public void setOpList(String paramString)
  {
    this.opList = paramString;
  }
  
  public void setRequestType(int paramInt)
  {
    this.requestType = paramInt;
  }
  
  public void setTimePoint(Map<String, Long> paramMap)
  {
    this.timePoint = paramMap;
  }
  
  public void setVerifyType(String paramString)
  {
    this.verifyType = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestType, 0);
    paramJceOutputStream.write(this.baseParam, 1);
    if (this.opList != null) {
      paramJceOutputStream.write(this.opList, 2);
    }
    if (this.actionFlag != null) {
      paramJceOutputStream.write(this.actionFlag, 3);
    }
    if (this.verifyType != null) {
      paramJceOutputStream.write(this.verifyType, 4);
    }
    if (this.timePoint != null) {
      paramJceOutputStream.write(this.timePoint, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */