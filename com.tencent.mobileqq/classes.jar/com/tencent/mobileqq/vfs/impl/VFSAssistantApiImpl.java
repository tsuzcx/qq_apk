package com.tencent.mobileqq.vfs.impl;

import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

public class VFSAssistantApiImpl
  implements IVFSAssistantApi
{
  public String getCanonicalPath(String paramString)
  {
    return VFSAssistantUtils.getCanonicalPath(paramString);
  }
  
  public String getSDKPrivatePath(String paramString)
  {
    return VFSAssistantUtils.getSDKPrivatePath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vfs.impl.VFSAssistantApiImpl
 * JD-Core Version:    0.7.0.1
 */