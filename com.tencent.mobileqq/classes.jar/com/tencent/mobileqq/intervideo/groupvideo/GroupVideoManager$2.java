package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.IVPluginManager;
import com.tencent.mobileqq.intervideo.impl.Shadow;
import java.util.concurrent.Callable;

class GroupVideoManager$2
  implements Callable<IVPluginManager>
{
  GroupVideoManager$2(GroupVideoManager paramGroupVideoManager) {}
  
  public IVPluginManager a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    return Shadow.b(GroupVideoManager.a(this.a).getApplication(), "GVideo", localQQAppInterface.getCurrentUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.2
 * JD-Core Version:    0.7.0.1
 */