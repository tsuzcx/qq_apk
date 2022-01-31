package com.tencent.mobileqq.vas.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azmk;
import bdvy;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import fx;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ThemeFontAdapter$2
  implements Runnable
{
  public ThemeFontAdapter$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = fx.a(this.a, this.b);
    if (!new File((String)localObject1).exists())
    {
      QLog.d("ThemeFontAdapter", 1, "switchFont  fontPath not exists:" + this.a);
      bdvy.c(this.a, this.b);
      return;
    }
    Object localObject2;
    if (this.b == 1)
    {
      if (!ETEngine.isSOLoaded.get())
      {
        bdvy.c(this.a, this.b);
        return;
      }
      localObject2 = fx.b(this.a, this.b);
      if (bdvy.a((String)localObject1, (String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeFontAdapter", 2, "switchFont  fontPath:" + (String)localObject1);
      }
      localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
      if (localObject2 == null)
      {
        QLog.e("ThemeFontAdapter", 1, "switchFont  context is null");
        return;
      }
      if (azmk.b())
      {
        bdvy.a((Context)localObject2, (String)localObject1);
        return;
      }
      if (!TextHook.getInstance().switchFont((Context)localObject2, (String)localObject1)) {
        break;
      }
      bdvy.a(this.a);
      if (bdvy.a() != null)
      {
        bdvy.a().c();
        bdvy.a(null);
      }
      QLog.e("ThemeFontAdapter", 2, "switchFont  success:" + this.a + " type:" + this.b);
      TextHook.saveLastPath((Context)localObject2, (String)localObject1);
      ((Context)localObject2).getSharedPreferences("theme", 0).edit().remove("theme_font_root_pre").commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.2
 * JD-Core Version:    0.7.0.1
 */