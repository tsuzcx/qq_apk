package com.tencent.qqmini.sdk.widget;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AuthDialog$8
  implements SpecialProxy.EventCallback
{
  AuthDialog$8(AuthDialog paramAuthDialog) {}
  
  public void onResult(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramBoolean) {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("key_bundle_data");
        localObject1 = localObject3;
        if (arrayOfByte != null)
        {
          localObject1 = localObject3;
          if (arrayOfByte.length > 0)
          {
            paramBundle = new INTERFACE.StSubscribeMessage();
            try
            {
              paramBundle.mergeFrom(arrayOfByte);
              localObject1 = paramBundle;
            }
            catch (Exception localException)
            {
              localObject1 = paramBundle;
              paramBundle = localException;
            }
            QMLog.e("AuthDialog", "[insertMiniGamePA2Dialog] error!", paramBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        localObject1 = localException;
      }
    }
    ThreadManager.getUIHandler().post(new AuthDialog.8.1(this, (INTERFACE.StSubscribeMessage)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDialog.8
 * JD-Core Version:    0.7.0.1
 */