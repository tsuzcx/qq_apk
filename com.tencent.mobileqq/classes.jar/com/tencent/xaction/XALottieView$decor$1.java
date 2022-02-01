package com.tencent.xaction;

import android.support.v4.util.MQLruCache;
import android.view.ViewGroup;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.view.XAEmptyView;
import com.tencent.xaction.view.XAEmptyView.Companion;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/XALottieView$decor$1", "Lcom/tencent/xaction/api/base/DecorView;", "bindData", "", "init", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "viewLayout", "Landroid/view/ViewGroup;", "XALottie_release"}, k=1, mv={1, 1, 16})
public final class XALottieView$decor$1
  extends DecorView
{
  XALottieView$decor$1(IView paramIView)
  {
    super(localIView);
  }
  
  public void a()
  {
    Object localObject1 = d();
    if (!(localObject1 instanceof XAEngine))
    {
      QLog.a("XALottieView", 1, "xaEngine is error", null);
      return;
    }
    Object localObject2 = e();
    if (localObject2 == null)
    {
      QLog.a("XALottieView", 1, "data is null", null);
      return;
    }
    Object localObject3 = ((ViewData)localObject2).getExts();
    if ((localObject3 != null) && (!((HashMap)localObject3).isEmpty()))
    {
      localObject2 = ((HashMap)localObject3).get("config");
      if (localObject2 != null)
      {
        localObject2 = (String)localObject2;
        Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
        localObjectRef.element = ((String)null);
        localObject3 = ((HashMap)localObject3).get("imagepath");
        if ((localObject3 instanceof String)) {
          localObjectRef.element = FilePathUtil.a.a((String)localObject3, "$PARENT_ROOT", d());
        }
        if ((String)localObjectRef.element != null) {
          this.a.setImageAssetsFolder((String)localObjectRef.element);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("config=");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" imagePath=");
        ((StringBuilder)localObject3).append((String)localObjectRef.element);
        QLog.b("XALottieView", 2, ((StringBuilder)localObject3).toString(), null);
        XAEngine.Companion.a().execute((Runnable)new XALottieView.decor.1.bindData.1(this, (String)localObject2, localObjectRef, (IXAEngine)localObject1));
        this.a.setImageAssetDelegate((ImageAssetDelegate)new XALottieView.AssetDelegate());
        localObject1 = XAEmptyView.a;
        localObject2 = d();
        if (localObject2 != null)
        {
          ((XAEmptyView.Companion)localObject1).b((XAEngine)localObject2, (IView)this.a, e());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    QLog.a("XALottieView", 1, "extsMap is empty", null);
  }
  
  public void a(@NotNull IXAEngine paramIXAEngine, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    super.a(paramIXAEngine, paramViewGroup);
    if (XALottieView.Companion.a() == null) {
      XALottieView.Companion.a(new MQLruCache((int)(Runtime.getRuntime().maxMemory() / 1024) / 8));
    }
    QLog.a("XALottieView", 2, "XALottieView init");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XALottieView.decor.1
 * JD-Core Version:    0.7.0.1
 */