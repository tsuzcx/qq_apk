package com.tencent.xaction;

import android.text.TextUtils;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.view.XAEmptyView;
import com.tencent.xaction.view.XAEmptyView.Companion;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/XAPagView$decor$1", "Lcom/tencent/xaction/api/base/DecorView;", "bindData", "", "XAPag_release"}, k=1, mv={1, 1, 16})
public final class XAPagView$decor$1
  extends DecorView
{
  XAPagView$decor$1(IView paramIView)
  {
    super(localIView);
  }
  
  public void a()
  {
    if (a() != null)
    {
      if (a() == null) {
        return;
      }
      Object localObject = a();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((ViewData)localObject).getExts() != null)
      {
        localObject = a();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((ViewData)localObject).getExts();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((HashMap)localObject).get("pagfile");
        if (localObject != null)
        {
          localObject = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return;
          }
          XAEngine.Companion.a().execute((Runnable)new XAPagView.decor.1.bindData.1(this, (String)localObject));
          localObject = XAEmptyView.a;
          IXAEngine localIXAEngine = a();
          if (localIXAEngine != null)
          {
            ((XAEmptyView.Companion)localObject).b((XAEngine)localIXAEngine, (IView)this.a, a());
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.XAPagView.decor.1
 * JD-Core Version:    0.7.0.1
 */