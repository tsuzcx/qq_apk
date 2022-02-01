package com.tencent.qqmini.sdk.plugins;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;

class BluetoothJsPlugin$2
  implements IActivityResultListener
{
  BluetoothJsPlugin$2(BluetoothJsPlugin paramBluetoothJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    QMLog.d("BluetoothJsPlugin", "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 6)
    {
      BluetoothJsPlugin.access$402(this.this$0, false);
      if ((paramInt2 != -1) || (!BluetoothJsPlugin.access$000(this.this$0).isEnabled())) {
        break label99;
      }
      this.val$req.ok();
    }
    for (;;)
    {
      ActivityResultManager.g().removeActivityResultListener(this);
      bool = true;
      return bool;
      label99:
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BluetoothJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */