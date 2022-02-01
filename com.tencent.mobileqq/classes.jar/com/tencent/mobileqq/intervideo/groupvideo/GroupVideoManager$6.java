package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

class GroupVideoManager$6
  implements INetEventHandler
{
  GroupVideoManager$6(GroupVideoManager paramGroupVideoManager) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (GroupVideoManager.a(this.a) == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetChangeEvent connect:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" isMSFConnect:");
      localStringBuilder.append(GroupVideoManager.a(this.a).isMSFConnect);
      QLog.d("GroupVideoManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.6
 * JD-Core Version:    0.7.0.1
 */