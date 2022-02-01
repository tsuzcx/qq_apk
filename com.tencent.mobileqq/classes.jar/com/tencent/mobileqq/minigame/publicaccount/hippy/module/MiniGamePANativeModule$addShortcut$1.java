package com.tencent.mobileqq.minigame.publicaccount.hippy.module;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniGamePANativeModule$addShortcut$1
  implements Runnable
{
  MiniGamePANativeModule$addShortcut$1(MiniGamePANativeModule paramMiniGamePANativeModule, Context paramContext, String paramString1, String paramString2, String paramString3, Promise paramPromise) {}
  
  public final void run()
  {
    Object localObject = UiApiPlugin.a(this.$context, null, this.$url, "qqbrowser_float_shortcut");
    boolean bool = UiApiPlugin.a(this.$context, (Intent)localObject, this.$title, this.$icon);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addShortcut isSuccess=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("MiniGamePANativeModule", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new MiniGamePANativeModule.addShortcut.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule.addShortcut.1
 * JD-Core Version:    0.7.0.1
 */