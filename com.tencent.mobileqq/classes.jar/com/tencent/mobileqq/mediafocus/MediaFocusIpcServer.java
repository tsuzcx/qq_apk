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
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusModuleServer", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("actionCheckItemExist".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = (MediaFocusStackItem)paramBundle.getParcelable("focusItem");
      if (paramString == null) {
        break label161;
      }
      boolean bool = QIPCServerHelper.getInstance().isProcessRunning(paramString.b());
      if (!bool) {
        break label155;
      }
      paramString = QIPCServerHelper.getInstance().getServer().callClient(paramString.b(), 1, "MediaFocusModuleClient", "actionCheckItemExist", paramBundle);
      if ((paramString == null) || (paramString.data == null)) {
        break label155;
      }
      paramString = paramString.data;
      paramString.putBoolean("isProcessRunning", bool);
    }
    for (;;)
    {
      callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
      return null;
      label155:
      paramString = localBundle;
      break;
      label161:
      paramString = localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusIpcServer
 * JD-Core Version:    0.7.0.1
 */