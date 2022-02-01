package com.tencent.xaction.apng;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.view.XAEmptyView;
import com.tencent.xaction.view.XAEmptyView.Companion;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/apng/XAApngView$decor$1", "Lcom/tencent/xaction/api/base/DecorView;", "bindData", "", "XAApng_release"}, k=1, mv={1, 1, 16})
public final class XAApngView$decor$1
  extends DecorView
{
  XAApngView$decor$1(IView paramIView)
  {
    super(localIView);
  }
  
  public void a()
  {
    if (e() == null) {
      return;
    }
    Object localObject1 = e();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    if (((ViewData)localObject1).getExts() != null)
    {
      localObject1 = FilePathUtil.a;
      Object localObject2 = e();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      Object localObject3 = d();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((FilePathUtil.Companion)localObject1).a((ViewData)localObject2, (IXAEngine)localObject3);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      localObject2 = XAApngView.a;
      localObject3 = this.a.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "resources");
      ViewData localViewData = e();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((XAApngView.Companion)localObject2).a((Resources)localObject3, localViewData, (String)localObject1, (Function1)new XAApngView.decor.1.bindData.1(this));
      localObject1 = XAEmptyView.a;
      localObject2 = d();
      if (localObject2 != null)
      {
        ((XAEmptyView.Companion)localObject1).b((XAEngine)localObject2, (IView)this.a, e());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.XAApngView.decor.1
 * JD-Core Version:    0.7.0.1
 */