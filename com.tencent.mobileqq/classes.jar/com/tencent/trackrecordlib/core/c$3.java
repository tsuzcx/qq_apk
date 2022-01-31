package com.tencent.trackrecordlib.core;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.g.i;

class c$3
  implements Runnable
{
  c$3(c paramc, int paramInt, View paramView) {}
  
  public void run()
  {
    switch (this.a)
    {
    }
    for (;;)
    {
      Log.d(c.f(), "End record accessibility event.");
      return;
      if (!c.a(this.c, this.b)) {
        break;
      }
      Log.w(c.f(), "This event conatain message of password,it will be abandon,record input event intead of.");
    }
    d.a locala = new d.a().a(UiAction.INPUT).a(this.b.getClass().getName()).b(i.a(this.b));
    if ((RecordManager.getInstance().b) && ((this.b instanceof EditText))) {}
    for (Object localObject = null;; localObject = i.c(this.b))
    {
      localObject = locala.c((String)localObject).d(i.b(this.b)).e(i.f(this.b)).f(i.d(this.b)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
      RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
      c.a(this.c, (com.tencent.trackrecordlib.c.b)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.3
 * JD-Core Version:    0.7.0.1
 */