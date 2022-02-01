package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SpriteAioPlugin$showAudioTips$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    Context localContext = (Context)BaseApplicationImpl.getContext();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.getContext()");
    QQToast.a(localContext, (CharSequence)localBaseApplication.getResources().getString(2131690075), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.SpriteAioPlugin.showAudioTips.1
 * JD-Core Version:    0.7.0.1
 */