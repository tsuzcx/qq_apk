package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.Intent;
import asgs;
import ashh;
import asnv;
import avsr;
import awie;
import bbyp;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendSignalBombDialog$1
  implements Runnable
{
  public ExtendFriendSignalBombDialog$1(asnv paramasnv) {}
  
  public void run()
  {
    Object localObject;
    if (asnv.a(this.this$0) != null)
    {
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog ");
      if (!avsr.a(asnv.a(this.this$0), asnv.a(this.this$0).a, 1044)) {
        break label112;
      }
      localObject = asgs.a(asnv.a(this.this$0));
      ((ashh)localObject).a = bbyp.a();
      avsr.a(asnv.a(this.this$0), (ashh)localObject, ((ashh)localObject).a, 2);
    }
    for (;;)
    {
      localObject = awie.a(this.this$0.getContext(), asnv.a(this.this$0).a);
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