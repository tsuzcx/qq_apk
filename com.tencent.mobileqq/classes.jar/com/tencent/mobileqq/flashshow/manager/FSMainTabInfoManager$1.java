package com.tencent.mobileqq.flashshow.manager;

import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class FSMainTabInfoManager$1
  implements OnTaskListener<Object>
{
  FSMainTabInfoManager$1(FSMainTabInfoManager paramFSMainTabInfoManager) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchNewDataFromPreload requestTabData onReceive: dispatch Success:");
      localStringBuilder.append(paramVarArgs[0]);
      localStringBuilder.append(" | retCode:");
      localStringBuilder.append(paramVarArgs[1]);
      localStringBuilder.append(" | retMessage:");
      localStringBuilder.append(paramVarArgs[2]);
      QLog.d("FSMainTabInfoManager", 1, localStringBuilder.toString());
      this.a.a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetBusiInfoRsp)paramVarArgs[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSMainTabInfoManager.1
 * JD-Core Version:    0.7.0.1
 */