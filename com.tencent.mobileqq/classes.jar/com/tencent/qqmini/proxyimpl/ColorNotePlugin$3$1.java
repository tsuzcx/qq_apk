package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
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
      this.a.a.insertColorNote();
      if (ColorNotePlugin.c(this.a.this$0))
      {
        paramDialogInterface = new ColorNotePlugin.3.1.1(this);
        if ((ColorNotePlugin.d(this.a.this$0).getAttachedActivity() != null) && ((ColorNotePlugin.e(this.a.this$0).getAttachedActivity() instanceof GameActivity1))) {
          ((GameActivity1)ColorNotePlugin.f(this.a.this$0).getAttachedActivity()).setColorSignAddListener(paramDialogInterface);
        }
      }
      else
      {
        this.a.b.ok();
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show modalView error.");
      localStringBuilder.append(paramDialogInterface);
      QLog.e("ColorNotePlugin", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.3.1
 * JD-Core Version:    0.7.0.1
 */