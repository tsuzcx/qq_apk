package com.tencent.mobileqq.mediafocus;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;

public class MediaFocusIpcServer
  extends QIPCModule
{
  private MediaFocusIpcServer()
  {
    super("MediaFocusModuleServer");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("MediaFocusModuleServer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    if ("actionCheckItemExist".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)paramBundle.getParcelable("focusItem");
      paramString = (String)localObject;
      if (localMediaFocusStackItem != null)
      {
        boolean bool = QIPCServerHelper.getInstance().isProcessRunning(localMediaFocusStackItem.b());
        paramString = (String)localObject;
        if (bool)
        {
          paramBundle = QIPCServerHelper.getInstance().getServer().callClient(localMediaFocusStackItem.b(), 1, "MediaFocusModuleClient", "actionCheckItemExist", paramBundle);
          paramString = (String)localObject;
          if (paramBundle != null)
          {
            paramString = (String)localObject;
            if (paramBundle.data != null) {
              paramString = paramBundle.data;
            }
          }
        }
        paramString.putBoolean("isProcessRunning", bool);
      }
      callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusIpcServer
 * JD-Core Version:    0.7.0.1
 */