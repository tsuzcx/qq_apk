package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IFriendExtensionService
  extends IRuntimeService
{
  public abstract List<ExtensionInfo> getAllExtensionInfo();
  
  public abstract ExtensionInfo getExtensionInfo(String paramString);
  
  public abstract ExtensionInfo getExtensionInfo(String paramString, boolean paramBoolean);
  
  public abstract void initCache();
  
  public abstract boolean saveExtensionInfo(ExtensionInfo paramExtensionInfo);
  
  public abstract boolean saveExtensionInfoList(List<ExtensionInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.IFriendExtensionService
 * JD-Core Version:    0.7.0.1
 */