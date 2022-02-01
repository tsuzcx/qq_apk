package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.Intent;
import asmp;
import asne;
import asun;
import aweo;
import awui;
import bcrg;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendSignalBombDialog$1
  implements Runnable
{
  public ExtendFriendSignalBombDialog$1(asun paramasun) {}
  
  public void run()
  {
    Object localObject;
    if (asun.a(this.this$0) != null)
    {
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog ");
      if (!aweo.a(asun.a(this.this$0), asun.a(this.this$0).a, 1044)) {
        break label112;
      }
      localObject = asmp.a(asun.a(this.this$0));
      ((asne)localObject).a = bcrg.a();
      aweo.a(asun.a(this.this$0), (asne)localObject, ((asne)localObject).a, 2);
    }
    for (;;)
    {
      localObject = awui.a(this.this$0.getContext(), asun.a(this.this$0).a);
      this.this$0.getContext().startActivity((Intent)localObject);
      return;
      label112:
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog not last topic ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1
 * JD-Core Version:    0.7.0.1
 */