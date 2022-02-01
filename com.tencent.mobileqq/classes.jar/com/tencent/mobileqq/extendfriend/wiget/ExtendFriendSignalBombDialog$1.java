package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.Intent;
import aswg;
import aswv;
import atdz;
import awlm;
import axaw;
import bcrg;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendSignalBombDialog$1
  implements Runnable
{
  public ExtendFriendSignalBombDialog$1(atdz paramatdz) {}
  
  public void run()
  {
    Object localObject;
    if (atdz.a(this.this$0) != null)
    {
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog ");
      if (!awlm.a(atdz.a(this.this$0), atdz.a(this.this$0).a, 1044)) {
        break label112;
      }
      localObject = aswg.a(atdz.a(this.this$0));
      ((aswv)localObject).a = bcrg.a();
      awlm.a(atdz.a(this.this$0), (aswv)localObject, ((aswv)localObject).a, 2);
    }
    for (;;)
    {
      localObject = axaw.a(this.this$0.getContext(), atdz.a(this.this$0).a);
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