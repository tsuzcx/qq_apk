package com.tencent.mobileqq.profilecard.template;

import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/template/ProfileTemplateApi;", "", "()V", "TAG", "", "emptyApi", "Lcom/tencent/mobileqq/profilecard/template/EmptyApi;", "checkNull", "", "block", "Lkotlin/Function0;", "", "getDiyMoreInfoManager", "Lcom/tencent/mobileqq/profilecard/template/IDiyMoreInfoManager;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "getTemplateComponent", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponent;", "getTemplateManager", "Lcom/tencent/mobileqq/profilecard/template/ITemplateManager;", "getTemplateUtils", "Lcom/tencent/mobileqq/profilecard/template/ITemplateUtils;", "isDiyTemplateStyleID", "", "styleId", "", "profilecard-api_release"}, k=1, mv={1, 1, 16})
public final class ProfileTemplateApi
{
  public static final ProfileTemplateApi INSTANCE = new ProfileTemplateApi();
  private static final String TAG = "ProfileTemplateComponentUtils";
  private static final EmptyApi emptyApi = new EmptyApi();
  
  private final void checkNull(Function0<Object[]> paramFunction0) {}
  
  @JvmStatic
  @NotNull
  public static final IDiyMoreInfoManager getDiyMoreInfoManager(@Nullable IComponentCenter paramIComponentCenter)
  {
    paramIComponentCenter = INSTANCE.getTemplateComponent(paramIComponentCenter);
    if ((paramIComponentCenter instanceof IDiyMoreInfoManager)) {
      return (IDiyMoreInfoManager)paramIComponentCenter;
    }
    return (IDiyMoreInfoManager)emptyApi;
  }
  
  private final IComponent<?, ?> getTemplateComponent(IComponentCenter paramIComponentCenter)
  {
    if (paramIComponentCenter != null) {
      return paramIComponentCenter.getComponent(1034);
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final ITemplateManager getTemplateManager(@Nullable IComponentCenter paramIComponentCenter)
  {
    paramIComponentCenter = INSTANCE.getTemplateComponent(paramIComponentCenter);
    if ((paramIComponentCenter instanceof ITemplateManager)) {
      return (ITemplateManager)paramIComponentCenter;
    }
    return (ITemplateManager)emptyApi;
  }
  
  @JvmStatic
  @NotNull
  public static final ITemplateUtils getTemplateUtils(@Nullable IComponentCenter paramIComponentCenter)
  {
    paramIComponentCenter = INSTANCE.getTemplateComponent(paramIComponentCenter);
    if ((paramIComponentCenter instanceof ITemplateUtils)) {
      return (ITemplateUtils)paramIComponentCenter;
    }
    return (ITemplateUtils)emptyApi;
  }
  
  @JvmStatic
  public static final boolean isDiyTemplateStyleID(long paramLong)
  {
    return (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE) || (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY_TEMPLATE_2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.template.ProfileTemplateApi
 * JD-Core Version:    0.7.0.1
 */