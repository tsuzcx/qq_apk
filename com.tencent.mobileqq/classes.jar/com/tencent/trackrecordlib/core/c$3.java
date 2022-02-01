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
    int i = this.a;
    if ((i != 1) && (i != 2) && (i != 8) && ((i == 16) || ((i != 4096) && (i == 8192)))) {
      if (c.a(this.c, this.b))
      {
        Log.w(c.f(), "This event conatain message of password,it will be abandon,record input event intead of.");
      }
      else
      {
        d.a locala = new d.a().a(UiAction.INPUT).a(this.b.getClass().getName()).b(i.a(this.b));
        if ((RecordManager.getInstance().b) && ((this.b instanceof EditText))) {
          localObject = null;
        } else {
          localObject = i.c(this.b);
        }
        Object localObject = locala.c((String)localObject).d(i.b(this.b)).e(i.f(this.b)).f(i.d(this.b)).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
        RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
        c.a(this.c, (com.tencent.trackrecordlib.c.b)localObject);
      }
    }
    Log.d(c.f(), "End record accessibility event.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.3
 * JD-Core Version:    0.7.0.1
 */