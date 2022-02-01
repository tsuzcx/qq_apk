package com.tencent.xaction.apng;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.image.GiftDiyDrawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/GiftDiyDecorDrawable;", "Lcom/tencent/xaction/apng/ApngDecorDrawable;", "()V", "preStart", "", "view", "Landroid/view/View;", "GiftDiyDecorDrawableState", "XAApng_release"}, k=1, mv={1, 1, 16})
@Keep
public final class GiftDiyDecorDrawable
  extends ApngDecorDrawable
{
  public GiftDiyDecorDrawable()
  {
    setDrawable((IDrawable)new GiftDiyDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    Object localObject1 = getStyle();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((ViewData)localObject1).getDrawable();
    if (localObject1 != null)
    {
      localObject1 = (GiftDiyDecorDrawable.GiftDiyDecorDrawableState)localObject1;
      Object localObject2 = ((GiftDiyDecorDrawable.GiftDiyDecorDrawableState)localObject1).getCoords();
      Function3 localFunction3 = (Function3)new GiftDiyDecorDrawable.preStart.stateNotify.1(this, paramView);
      paramView = getEngine();
      if (paramView != null)
      {
        paramView = paramView.getRuleManager();
        if (paramView != null)
        {
          paramView = paramView.getRuleValue((String)localObject2);
          break label90;
        }
      }
      paramView = null;
      label90:
      if (paramView != null)
      {
        paramView = (ArrayList)paramView;
        localObject2 = getDrawable();
        if (localObject2 != null)
        {
          ((GiftDiyDrawable)localObject2).preStart((GiftDiyDecorDrawable.GiftDiyDecorDrawableState)localObject1, paramView, localFunction3);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.image.GiftDiyDrawable");
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.collections.List<kotlin.Int>> /* = java.util.ArrayList<kotlin.collections.List<kotlin.Int>> */");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.apng.GiftDiyDecorDrawable.GiftDiyDecorDrawableState");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.GiftDiyDecorDrawable
 * JD-Core Version:    0.7.0.1
 */