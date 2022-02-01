package com.tencent.open.agent.entity;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.appType.AndroidInfo;
import com.tencent.qconn.protofile.appType.MsgIconsurl;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppInfoResponse
{
  private String a;
  private List<IconUrlSize> b;
  
  public AppInfoResponse(String paramString, List<IconUrlSize> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public static AppInfoResponse a(preAuth.PreAuthResponse paramPreAuthResponse, appType.AndroidInfo paramAndroidInfo)
  {
    if (paramAndroidInfo.message_tail.has()) {
      paramAndroidInfo = paramAndroidInfo.message_tail.get();
    } else {
      paramAndroidInfo = "";
    }
    return new AppInfoResponse(paramAndroidInfo, a(paramPreAuthResponse.icons_url));
  }
  
  public static List<IconUrlSize> a(PBRepeatMessageField<appType.MsgIconsurl> paramPBRepeatMessageField)
  {
    if ((paramPBRepeatMessageField != null) && (!paramPBRepeatMessageField.isEmpty()))
    {
      Object localObject = paramPBRepeatMessageField.get();
      paramPBRepeatMessageField = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        appType.MsgIconsurl localMsgIconsurl = (appType.MsgIconsurl)((Iterator)localObject).next();
        paramPBRepeatMessageField.add(new IconUrlSize(localMsgIconsurl.url, localMsgIconsurl.size));
      }
      return paramPBRepeatMessageField;
    }
    return new ArrayList();
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List<IconUrlSize> b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appName=");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.entity.AppInfoResponse
 * JD-Core Version:    0.7.0.1
 */