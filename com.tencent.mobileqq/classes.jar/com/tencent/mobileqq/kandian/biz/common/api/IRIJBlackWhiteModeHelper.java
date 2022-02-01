package com.tencent.mobileqq.kandian.biz.common.api;

import android.graphics.Canvas;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJBlackWhiteModeHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addBlackWhiteMode", "", "canvas", "Landroid/graphics/Canvas;", "needConfig", "", "drawCanvas", "Lkotlin/Function1;", "getBlackWhiteConfig", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJBlackWhiteModeHelper
  extends QRouteApi
{
  public abstract void addBlackWhiteMode(@NotNull Canvas paramCanvas, boolean paramBoolean, @NotNull Function1<? super Canvas, Unit> paramFunction1);
  
  public abstract boolean getBlackWhiteConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IRIJBlackWhiteModeHelper
 * JD-Core Version:    0.7.0.1
 */