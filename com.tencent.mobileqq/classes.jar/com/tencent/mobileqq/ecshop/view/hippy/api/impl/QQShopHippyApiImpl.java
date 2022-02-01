package com.tencent.mobileqq.ecshop.view.hippy.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.ecshop.view.hippy.QQShopApiProvider;
import com.tencent.mobileqq.ecshop.view.hippy.api.IQQShopHippyApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/hippy/api/impl/QQShopHippyApiImpl;", "Lcom/tencent/mobileqq/ecshop/view/hippy/api/IQQShopHippyApi;", "()V", "createHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "isQQShopModule", "", "moduleName", "", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopHippyApiImpl
  implements IQQShopHippyApi
{
  @NotNull
  public HippyAPIProvider createHippyProvider()
  {
    return (HippyAPIProvider)new QQShopApiProvider();
  }
  
  public boolean isQQShopModule(@Nullable String paramString)
  {
    return TextUtils.equals((CharSequence)paramString, (CharSequence)"qqshop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.api.impl.QQShopHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */