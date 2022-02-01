package com.tencent.xaction.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.impl.XAEngine;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/view/XAScratchView$decor$1", "Lcom/tencent/xaction/api/base/DecorView;", "bindData", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XAScratchView$decor$1
  extends DecorView
{
  XAScratchView$decor$1(IView paramIView)
  {
    super(localIView);
  }
  
  public void a()
  {
    super.a();
    if (e() != null)
    {
      if (d() == null) {
        return;
      }
      Object localObject1 = e();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((ViewData)localObject1).getExts() != null)
      {
        localObject1 = this.a;
        Object localObject2 = e();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((ViewData)localObject2).getExts();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((HashMap)localObject2).get("progress");
        if (localObject2 != null)
        {
          XAScratchView.a((XAScratchView)localObject1, (float)((Double)localObject2).doubleValue());
          localObject1 = e();
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((ViewData)localObject1).getExts();
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((HashMap)localObject1).get("cover");
          if (localObject1 != null)
          {
            localObject1 = (String)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              return;
            }
            localObject2 = XAEmptyView.a;
            Object localObject3 = d();
            if (localObject3 != null)
            {
              localObject3 = (XAEngine)localObject3;
              Object localObject4 = e();
              if (localObject4 == null) {
                Intrinsics.throwNpe();
              }
              int i = ((ViewData)localObject4).getSt().getHierarchy();
              localObject4 = (View)this.a;
              ViewData localViewData = e();
              if (localViewData == null) {
                Intrinsics.throwNpe();
              }
              ((XAEmptyView.Companion)localObject2).a((XAEngine)localObject3, (String)localObject1, i, (View)localObject4, localViewData);
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.XAScratchView.decor.1
 * JD-Core Version:    0.7.0.1
 */