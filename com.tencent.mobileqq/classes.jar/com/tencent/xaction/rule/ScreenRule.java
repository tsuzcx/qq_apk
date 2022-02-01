package com.tencent.xaction.rule;

import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/rule/ScreenRule;", "Lcom/tencent/xaction/api/base/BaseRule;", "()V", "ruleAnimParse", "", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "", "value", "ruleParse", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ScreenRule
  extends BaseRule
{
  public boolean ruleAnimParse(@NotNull BaseAnim paramBaseAnim, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    if (Intrinsics.areEqual(paramString2, "SCREEN_WIDTH"))
    {
      setAnimValue(paramBaseAnim, paramString1, new float[] { ScreenUnit.a.b() });
      return true;
    }
    if (Intrinsics.areEqual(paramString2, "SCREEN_HEIGHT"))
    {
      setAnimValue(paramBaseAnim, paramString1, new float[] { ScreenUnit.a.c() });
      return true;
    }
    if (Intrinsics.areEqual(paramString2, "SCREEN_CENTER"))
    {
      float f1 = ScreenUnit.a.b();
      float f2 = 2;
      setAnimValue(paramBaseAnim, paramString1, new float[] { f1 / f2, ScreenUnit.a.c() / f2 });
      return true;
    }
    if (Intrinsics.areEqual(paramString2, "SCREEN_HEIGHT_CENTER"))
    {
      setAnimValue(paramBaseAnim, paramString1, new float[] { ScreenUnit.a.c() / 2 });
      return false;
    }
    if (Intrinsics.areEqual(paramString2, "SCREEN_WIDTH_CENTER")) {
      setAnimValue(paramBaseAnim, paramString1, new float[] { ScreenUnit.a.b() / 2 });
    }
    return false;
  }
  
  public boolean ruleParse(@NotNull ViewData paramViewData, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.rule.ScreenRule
 * JD-Core Version:    0.7.0.1
 */