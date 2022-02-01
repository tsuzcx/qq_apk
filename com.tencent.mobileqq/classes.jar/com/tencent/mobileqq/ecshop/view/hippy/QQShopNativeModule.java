package com.tencent.mobileqq.ecshop.view.hippy;

import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment2;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@HippyNativeModule(name="QQShoppingModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/hippy/QQShopNativeModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "setNavigationStyle", "", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopNativeModule
  extends QQBaseModule
{
  @NotNull
  public static final String CLASSNAME = "QQShoppingModule";
  public static final QQShopNativeModule.Companion Companion = new QQShopNativeModule.Companion(null);
  private static final String TAG = "QQShopNativeModule";
  
  public QQShopNativeModule(@NotNull HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="setNavigationStyle")
  public final void setNavigationStyle(@Nullable HippyMap paramHippyMap)
  {
    QLog.d("QQShopNativeModule", 1, "hippy call setNavigationStyle");
    QBaseFragment localQBaseFragment = getFragment();
    if (((localQBaseFragment instanceof QQShopPAHippyFragment2)) && (paramHippyMap != null)) {
      ((QQShopPAHippyFragment2)localQBaseFragment).a(paramHippyMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.QQShopNativeModule
 * JD-Core Version:    0.7.0.1
 */