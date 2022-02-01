package com.tencent.securemodule;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.ui.TransparentActivity;

public class aq
  implements DialogInterface.OnClickListener
{
  public aq(TransparentActivity paramTransparentActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a) {}
    for (;;)
    {
      try
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.addFlags(268435456);
        paramDialogInterface.setAction("com.tencent.action.virus_scan");
        this.b.startActivity(paramDialogInterface);
        this.b.finish();
        return;
      }
      catch (Throwable paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        continue;
      }
      SecureService.a(TransparentActivity.b(this.b).getApplicationContext(), "1000011");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.aq
 * JD-Core Version:    0.7.0.1
 */