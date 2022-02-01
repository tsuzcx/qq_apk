package com.tencent.mobileqq.vas.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

final class ThemeFontAdapter$2
  implements Runnable
{
  ThemeFontAdapter$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject2 = FontManagerConstants.getTTFPath(this.a, this.b);
    if (!new File((String)localObject2).exists())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchFont  fontPath not exists:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("ThemeFontAdapter", 1, ((StringBuilder)localObject1).toString());
      ThemeFontAdapter.c(this.a, this.b);
      return;
    }
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.b == 1)
    {
      if ((!ETEngine.isSOLoaded.get()) && (ThemeFontAdapter.a() < ThemeFontAdapter.b()))
      {
        ThemeFontAdapter.c(this.a, this.b);
        return;
      }
      localObject3 = FontManagerConstants.getStaticTTFPath(this.a, this.b);
      localObject1 = localObject2;
      if (ThemeFontAdapter.a((String)localObject2, (String)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("switchFont  fontPath:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("ThemeFontAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = BaseApplicationImpl.getApplication().getApplicationContext();
    if (localObject2 == null)
    {
      QLog.e("ThemeFontAdapter", 1, "switchFont  context is null");
      return;
    }
    if (SimpleUIUtil.a())
    {
      ThemeFontAdapter.a((Context)localObject2, (String)localObject1);
      return;
    }
    if (TextHook.getInstance().switchFont((Context)localObject2, (String)localObject1))
    {
      ThemeFontAdapter.a(0);
      ThemeFontAdapter.b(this.a);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("switchFont  success:");
      ((StringBuilder)localObject3).append(this.a);
      ((StringBuilder)localObject3).append(" type:");
      ((StringBuilder)localObject3).append(this.b);
      QLog.e("ThemeFontAdapter", 2, ((StringBuilder)localObject3).toString());
      TextHook.saveLastPath((Context)localObject2, (String)localObject1);
      ((Context)localObject2).getSharedPreferences("theme", 0).edit().remove("theme_font_root_pre").commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.2
 * JD-Core Version:    0.7.0.1
 */