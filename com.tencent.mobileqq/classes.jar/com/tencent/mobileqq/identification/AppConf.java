package com.tencent.mobileqq.identification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppConf
  implements Serializable
{
  public int[] actionReq;
  public final List<AppConf.AppWordings> al;
  public final String appName;
  public String colorSequence;
  public String debug;
  public String errMsg;
  public final int mode;
  public int ret;
  public String selectData;
  public final List<AppConf.ServiceProtocolSerializable> serviceProtocols;
  public String session;
  
  public AppConf(String paramString, List<AppConf.AppWordings> paramList, int paramInt)
  {
    this.appName = paramString;
    this.al = new ArrayList(3);
    this.al.addAll(paramList);
    this.mode = paramInt;
    this.serviceProtocols = new ArrayList(3);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("appName=");
    localStringBuilder.append(this.appName);
    localStringBuilder.append(" mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(" colorSe=");
    localStringBuilder.append(this.colorSequence);
    localStringBuilder.append(" session=");
    localStringBuilder.append(this.session);
    localStringBuilder.append(" ret=");
    localStringBuilder.append(this.ret);
    localStringBuilder.append(" errMsg=");
    localStringBuilder.append(this.errMsg);
    localStringBuilder.append(" debug=");
    localStringBuilder.append(this.debug);
    localStringBuilder.append(" selectData=");
    localStringBuilder.append(this.selectData);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.AppConf
 * JD-Core Version:    0.7.0.1
 */