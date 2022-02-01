package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelMallHelper$3
  implements Runnable
{
  EmoticonPanelMallHelper$3(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess");
    }
    try
    {
      localObject = ((EmoticonPanelController)this.this$0.mPanelController).app;
      Context localContext = ((EmoticonPanelController)this.this$0.mPanelController).context;
      if (localObject != null)
      {
        IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)((QQEmoticonMainPanelApp)localObject).getService(IWebProcessManagerService.class);
        if (localIWebProcessManagerService != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("emoticon_panel_");
          localStringBuilder.append(((QQEmoticonMainPanelApp)localObject).getCurrentAccountUin());
          localObject = localContext.getSharedPreferences(localStringBuilder.toString(), 0);
          long l = ((SharedPreferences)localObject).getLong("sp_key_market_open_time", 0L);
          if (System.currentTimeMillis() - l < 2592000000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess, startWebProcess for market open strategy");
            }
            localIWebProcessManagerService.startWebProcess(-1, new EmoticonPanelMallHelper.3.1(this));
            return;
          }
          l = ((SharedPreferences)localObject).getLong("sp_key_send_h5_magic_face_time", 0L);
          if (System.currentTimeMillis() - l < 2592000000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess, startWebProcess for h5 magic send strategy");
            }
            localIWebProcessManagerService.startWebProcess(-1, new EmoticonPanelMallHelper.3.2(this));
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess, web process alive already");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadWebProcess, exception=");
      ((StringBuilder)localObject).append(MsfSdkUtils.getStackTraceString(localException));
      QLog.e("EmoticonPanelMallHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.3
 * JD-Core Version:    0.7.0.1
 */