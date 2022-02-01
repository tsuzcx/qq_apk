package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tkd.topicsdk.interfaces.IToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ToastImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IToast;", "()V", "showRichToast", "", "msg", "", "linkMsg", "link", "isLong", "", "showToast", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ToastImpl
  implements IToast
{
  public void a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    Object localObject = BaseActivity.sTopActivity;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = (Context)localObject;
    paramString = (CharSequence)paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      QQToast.a((Context)localObject, -1, paramString, i).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ToastImpl
 * JD-Core Version:    0.7.0.1
 */