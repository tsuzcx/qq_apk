package com.tencent.qqmini.sdk.core.plugins;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import bgnk;
import bgnl;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;

class BluetoothJsPlugin$1
  implements bgnl
{
  BluetoothJsPlugin$1(BluetoothJsPlugin paramBluetoothJsPlugin, bgok parambgok) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    QMLog.d("BluetoothJsPlugin", "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 6)
    {
      BluetoothJsPlugin.access$002(this.this$0, false);
      if ((paramInt2 != -1) || (!BluetoothJsPlugin.access$100(this.this$0).isEnabled())) {
        break label99;
      }
      this.val$req.a();
    }
    for (;;)
    {
      bgnk.a().b(this);
      bool = true;
      return bool;
      label99:
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BluetoothJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */