package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.graphics.Canvas;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJBlackWhiteModeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/RIJBlackWhiteModeHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJBlackWhiteModeHelper;", "()V", "addBlackWhiteMode", "", "canvas", "Landroid/graphics/Canvas;", "needConfig", "", "drawCanvas", "Lkotlin/Function1;", "getBlackWhiteConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBlackWhiteModeHelperImpl
  implements IRIJBlackWhiteModeHelper
{
  public void addBlackWhiteMode(@NotNull Canvas paramCanvas, boolean paramBoolean, @NotNull Function1<? super Canvas, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "drawCanvas");
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, paramFunction1);
  }
  
  public boolean getBlackWhiteConfig()
  {
    return RIJBlackWhiteModeHelper.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.RIJBlackWhiteModeHelperImpl
 * JD-Core Version:    0.7.0.1
 */