package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.Intent;
import arij;
import ariy;
import arqh;
import auyo;
import avod;
import bbko;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendSignalBombDialog$1
  implements Runnable
{
  public ExtendFriendSignalBombDialog$1(arqh paramarqh) {}
  
  public void run()
  {
    Object localObject;
    if (arqh.a(this.this$0) != null)
    {
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog ");
      if (!auyo.a(arqh.a(this.this$0), arqh.a(this.this$0).a, 1044)) {
        break label112;
      }
      localObject = arij.a(arqh.a(this.this$0));
      ((ariy)localObject).a = bbko.a();
      auyo.a(arqh.a(this.this$0), (ariy)localObject, ((ariy)localObject).a, 2);
    }
    for (;;)
    {
      localObject = avod.a(this.this$0.getContext(), arqh.a(this.this$0).a);
      this.this$0.getContext().startActivity((Intent)localObject);
      return;
      label112:
      QLog.d("ExtendFriendSignalBombDialog", 2, " handle data signal bomb dialog not last topic ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSignalBombDialog.1
 * JD-Core Version:    0.7.0.1
 */