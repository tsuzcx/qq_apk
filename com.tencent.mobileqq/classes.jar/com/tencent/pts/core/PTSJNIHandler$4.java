package com.tencent.pts.core;

import com.tencent.pts.utils.PTSLog;
import java.util.List;

final class PTSJNIHandler$4
  implements Runnable
{
  PTSJNIHandler$4(int paramInt, List paramList) {}
  
  public void run()
  {
    PTSAppInstance localPTSAppInstance = PTSJNIHandler.access$200(this.val$appInstanceUniqueID);
    if (localPTSAppInstance != null)
    {
      PTSLayoutTempPatch.applyLayoutTempPatchList(this.val$layoutTempPatchList, localPTSAppInstance);
      return;
    }
    PTSLog.e(PTSJNIHandler.access$300(), "[layoutRefreshCallback], app not found.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler.4
 * JD-Core Version:    0.7.0.1
 */