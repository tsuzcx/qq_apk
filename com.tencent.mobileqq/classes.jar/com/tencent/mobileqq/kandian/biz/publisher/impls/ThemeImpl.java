package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.interfaces.ITheme;
import com.tencent.widget.ThemeImageWrapper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ThemeImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/ITheme;", "()V", "isNightMode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ThemeImpl
  implements ITheme
{
  public boolean a()
  {
    return ThemeImageWrapper.isNightMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ThemeImpl
 * JD-Core Version:    0.7.0.1
 */