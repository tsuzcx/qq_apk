package com.tencent.xaction.rule;

import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/rule/LastMsgRule;", "Lcom/tencent/xaction/api/base/BaseRule;", "()V", "ruleAnimParse", "", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "", "value", "ruleParse", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class LastMsgRule
  extends BaseRule
{
  public boolean ruleAnimParse(@NotNull BaseAnim paramBaseAnim, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    if (Intrinsics.areEqual(paramString2, "$LAST_MSG"))
    {
      setAnimValue(paramBaseAnim, paramString1, new float[] { (float)(Math.random() * 800), 600.0F });
      return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.rule.LastMsgRule
 * JD-Core Version:    0.7.0.1
 */