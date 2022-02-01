package com.tencent.mobileqq.vfs;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVFSAssistantApi
  extends QRouteApi
{
  public abstract String getCanonicalPath(String paramString);
  
  public abstract String getSDKPrivatePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.IVFSAssistantApi
 * JD-Core Version:    0.7.0.1
 */