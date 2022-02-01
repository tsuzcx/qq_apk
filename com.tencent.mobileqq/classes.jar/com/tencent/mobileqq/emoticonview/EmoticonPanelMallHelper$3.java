package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
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
      Object localObject = this.this$0.mPanelController.app;
      Context localContext = this.this$0.mPanelController.context;
      if (localObject == null) {
        return;
      }
      WebProcessManager localWebProcessManager = (WebProcessManager)((QQAppInterface)localObject).getManager(13);
      if (localWebProcessManager != null)
      {
        localObject = localContext.getSharedPreferences("emoticon_panel_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0);
        long l = ((SharedPreferences)localObject).getLong("sp_key_market_open_time", 0L);
        if (System.currentTimeMillis() - l < 2592000000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess, startWebProcess for market open strategy");
          }
          localWebProcessManager.a(-1, new EmoticonPanelMallHelper.3.1(this));
          return;
        }
        l = ((SharedPreferences)localObject).getLong("sp_key_send_h5_magic_face_time", 0L);
        if (System.currentTimeMillis() - l >= 2592000000L) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess, startWebProcess for h5 magic send strategy");
        }
        localWebProcessManager.a(-1, new EmoticonPanelMallHelper.3.2(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("EmoticonPanelMallHelper", 1, "preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(localException));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "preloadWebProcess, web process alive already");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.3
 * JD-Core Version:    0.7.0.1
 */