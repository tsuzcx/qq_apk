package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/ReadInJoyPTSCostHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyPTSCostHelper;", "()V", "printCost", "", "className", "", "scene", "cost", "", "viewType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyPTSCostHelperImpl
  implements IReadInJoyPTSCostHelper
{
  public void printCost(@Nullable String paramString1, @Nullable String paramString2, double paramDouble)
  {
    ReadInJoyPTSCostHelper.a(paramString1, paramString2, paramDouble);
  }
  
  public void printCost(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, double paramDouble)
  {
    ReadInJoyPTSCostHelper.a(paramString1, paramString2, paramString3, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.ReadInJoyPTSCostHelperImpl
 * JD-Core Version:    0.7.0.1
 */