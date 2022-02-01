package com.tencent.mobileqq.ecshop.view.hippy.api;

import android.content.Intent;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/hippy/api/IQQShopHippyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createHippyProvider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getQQShopHippyFragmentClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "isQQShopModule", "", "moduleName", "", "rebuildHippyIntent", "Landroid/content/Intent;", "intent", "qqshop-feature-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IQQShopHippyApi
  extends QRouteApi
{
  @NotNull
  public abstract HippyAPIProvider createHippyProvider();
  
  @NotNull
  public abstract Class<? extends QPublicBaseFragment> getQQShopHippyFragmentClass();
  
  public abstract boolean isQQShopModule(@Nullable String paramString);
  
  @NotNull
  public abstract Intent rebuildHippyIntent(@NotNull Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.hippy.api.IQQShopHippyApi
 * JD-Core Version:    0.7.0.1
 */