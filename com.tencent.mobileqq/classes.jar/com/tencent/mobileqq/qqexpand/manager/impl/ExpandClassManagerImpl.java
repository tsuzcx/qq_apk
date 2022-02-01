package com.tencent.mobileqq.qqexpand.manager.impl;

import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandClassManager;
import com.tencent.mobileqq.qqexpand.manager.config.LimitChatOnPlusConfProcessor;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;

public class ExpandClassManagerImpl
  implements IExpandClassManager
{
  public String getExpandHandlerClassName()
  {
    return ExpandHandlerImpl.class.getName();
  }
  
  public Class getExpandLimitChatManagerClass()
  {
    return ExtendFriendLimitChatManager.class;
  }
  
  public Class getExpandManagerClass()
  {
    return ExpandManager.class;
  }
  
  public Class getLimitChatOnPlusConfClass()
  {
    return LimitChatOnPlusConfProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.impl.ExpandClassManagerImpl
 * JD-Core Version:    0.7.0.1
 */