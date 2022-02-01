package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ColorNotePlugin$3$1
  implements DialogInterface.OnClickListener
{
  ColorNotePlugin$3$1(ColorNotePlugin.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.e();
      if (ColorNotePlugin.a(this.a.this$0))
      {
        paramDialogInterface = new ColorNotePlugin.3.1.1(this);
        if ((ColorNotePlugin.b(this.a.this$0).getAttachedActivity() != null) && ((ColorNotePlugin.c(this.a.this$0).getAttachedActivity() instanceof GameActivity1))) {
          ((GameActivity1)ColorNotePlugin.d(this.a.this$0).getAttachedActivity()).setColorSignAddListener(paramDialogInterface);
        }
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ColorNotePlugin", 1, "show modalView error." + paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.3.1
 * JD-Core Version:    0.7.0.1
 */