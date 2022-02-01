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
  static IPCBaseParam cache_baseParam = new IPCBaseParam();
  static Map<String, Long> cache_timePoint = new HashMap();
  public String actionFlag = "";
  public IPCBaseParam baseParam = null;
  public String opList = "";
  public int requestType = 0;
  public Map<String, Long> timePoint = null;
  public String verifyType = "";
  
  static
  {
    cache_timePoint.put("", Long.valueOf(0L));
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
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (OperateDownloadTaskRequest)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.requestType, paramObject.requestType))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.baseParam, paramObject.baseParam))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.opList, paramObject.opList))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.actionFlag, paramObject.actionFlag))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.verifyType, paramObject.verifyType))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.timePoint, paramObject.timePoint)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
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
    Object localObject = this.opList;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.actionFlag;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.verifyType;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.timePoint;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest
 * JD-Core Version:    0.7.0.1
 */