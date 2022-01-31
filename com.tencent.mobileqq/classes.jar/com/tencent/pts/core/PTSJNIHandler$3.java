package com.tencent.pts.core;

import com.tencent.pts.utils.PTSLog;
import java.util.List;

final class PTSJNIHandler$3
  implements Runnable
{
  PTSJNIHandler$3(int paramInt, List paramList) {}
  
  public void run()
  {
    PTSAppInstance localPTSAppInstance = PTSJNIHandler.access$200(this.val$appInstanceUniqueID);
    if (localPTSAppInstance != null)
    {
      localPTSAppInstance.getRootNode().refreshNodeList(this.val$nodeInfoList);
      return;
    }
    PTSLog.e(PTSJNIHandler.access$300(), "refreshNodeList, app not found.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler.3
 * JD-Core Version:    0.7.0.1
 */