package com.tencent.pts.core;

import com.tencent.pts.utils.PTSLog;
import java.util.List;

final class PTSJNIHandler$2
  implements Runnable
{
  PTSJNIHandler$2(int paramInt, List paramList) {}
  
  public void run()
  {
    PTSAppInstance localPTSAppInstance = PTSJNIHandler.access$000(this.val$appInstanceUniqueID);
    if (localPTSAppInstance != null)
    {
      PTSLayoutTempPatch.applyLayoutTempPatchList(this.val$layoutTempPatchList, localPTSAppInstance);
      return;
    }
    PTSLog.e(PTSJNIHandler.access$100(), "[layoutRefreshCallback], app not found.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler.2
 * JD-Core Version:    0.7.0.1
 */