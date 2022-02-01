package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class KDBottomTabThemeManager$enable$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  KDBottomTabThemeManager$enable$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    return Aladdin.getConfig(535).getBooleanFromString("enable_bottom_tab_immersive", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.KDBottomTabThemeManager.enable.2
 * JD-Core Version:    0.7.0.1
 */