package com.tencent.pts.core;

import com.tencent.pts.utils.PTSLog;
import java.util.List;

final class PTSJNIHandler$1
  implements Runnable
{
  PTSJNIHandler$1(int paramInt, List paramList) {}
  
  public void run()
  {
    PTSAppInstance localPTSAppInstance = PTSJNIHandler.access$000(this.val$appInstanceUniqueID);
    if (localPTSAppInstance != null)
    {
      if (localPTSAppInstance.getRootNode() == null)
      {
        PTSLog.e(PTSJNIHandler.access$100(), "[refreshNodeList], rootNode is null.");
        return;
      }
      localPTSAppInstance.getRootNode().refreshNodeList(this.val$nodeInfoList);
      return;
    }
    PTSLog.e(PTSJNIHandler.access$100(), "refreshNodeList, app not found.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler.1
 * JD-Core Version:    0.7.0.1
 */