package com.tencent.trackrecordlib.core;

import android.view.View;
import android.widget.EditText;
import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.b;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.g.i;

class c$9
  implements Runnable
{
  c$9(c paramc, int paramInt, View paramView, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = f.a(this.a);
    d.a locala = new d.a().a(UiAction.EXPOSE).a((a)localObject).a(this.b.getClass().getName()).b(i.a(this.b));
    if ((RecordManager.getInstance().b) && ((this.b instanceof EditText))) {
      localObject = null;
    } else {
      localObject = i.c(this.b);
    }
    localObject = locala.c((String)localObject).d(i.b(this.b)).e(i.f(this.b)).f(i.d(this.b)).h(this.c).g(this.d).a();
    RecordManager.getInstance().recordEvent((b)localObject);
    c.a(this.e, (b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.9
 * JD-Core Version:    0.7.0.1
 */