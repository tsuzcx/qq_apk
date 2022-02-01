package com.tencent.mobileqq.ecshop.view.hippy.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.ecshop.view.hippy.QQShopApiProvider;
import com.tencent.mobileqq.ecshop.view.hippy.api.IQQShopHippyApi;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mtt.hippy.HippyAPIProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/hippy/api/impl/QQShopHippyApiImpl;", "Lcom/tencent/mobileqq/ecshop/view/hippy/api/IQQShopHippyApi;", "()V", "createHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getQQShopHippyFragmentClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "isQQShopModule", "", "moduleName", "", "rebuildHippyIntent", "Landroid/content/Intent;", "intent", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopHippyApiImpl
  implements IQQShopHippyApi
{
  @NotNull
  public HippyAPIProvider createHippyProvider()
  {
    return (HippyAPIProvider)new QQShopApiProvider();
  }
  
  @NotNull
  public Class<? extends QPublicBaseFragment> getQQShopHippyFragmentClass()
  {
    return QQShopPAHippyFragment2.class;
  }
  
  public boolean isQQShopModule(@Nullable String paramString)
  {
    return TextUtils.equals((CharSequence)paramString, (CharSequence)"qqshop");
  }
  
  @NotNull
  public Intent rebuildHippyIntent(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramIntent = JumpUtil.a(paramIntent, "", 0);
    Intrinsics.checkExpressionValueIsNotNull(paramIntent, "JumpUtil.rebuildIntent(intent, \"\", 0)");
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.api.impl.QQShopHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */