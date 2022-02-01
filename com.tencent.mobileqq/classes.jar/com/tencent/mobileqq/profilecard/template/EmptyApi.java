package com.tencent.mobileqq.profilecard.template;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/template/EmptyApi;", "Lcom/tencent/mobileqq/profilecard/template/IDiyMoreInfoManager;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateManager;", "Lcom/tencent/mobileqq/profilecard/template/ITemplateUtils;", "()V", "deleteOldCardTemplateDir", "", "name", "", "currentVersion", "getDiyTemplateVersion", "", "card", "Lcom/tencent/mobileqq/data/Card;", "getPhotoWallDiyView", "V", "Landroid/view/View;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)Landroid/view/View;", "getQZoneDiyView", "T", "key", "(Ljava/lang/String;)Landroid/view/View;", "getTemplateDrawable", "Landroid/graphics/drawable/Drawable;", "cardTemplate", "Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "isSaveCache", "", "isFullPath", "fileName", "initDiyTemplate", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "initTemplateConfig", "backgroundColor", "styleId", "isDiy", "preNotifyOnCardUpdate", "updateAccountInfoForDeepDiy", "accountInfoView", "updateBaseInfoForDeepDiy", "baseInfoView", "updateItemThemeForDIYTemplate", "title", "Landroid/widget/TextView;", "content", "arrow", "Landroid/widget/ImageView;", "icon", "titleBg", "contentContainer", "updateLevelForDeepDiy", "levelView", "updateMetalForDeepDiy", "metalView", "updatePhotoWallForDeepDiy", "view", "updateQzoneForDeepDiy", "qZoneView", "updateSignForDeepDiy", "signView", "updateTroopMemInfoForDeepDiy", "troopMemInfoView", "updateViewAttr", "attr", "currentTemplate", "attrKey", "updateViewAttrForTemplate", "profilecard-api_release"}, k=1, mv={1, 1, 16})
public final class EmptyApi
  implements IDiyMoreInfoManager, ITemplateManager, ITemplateUtils
{
  public void deleteOldCardTemplateDir(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "currentVersion");
  }
  
  public long getDiyTemplateVersion(@NotNull Card paramCard)
  {
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    return 0L;
  }
  
  @Nullable
  public <V extends View> V getPhotoWallDiyView(@Nullable ProfileCardInfo paramProfileCardInfo)
  {
    return null;
  }
  
  @Nullable
  public <T extends View> T getQZoneDiyView(@Nullable String paramString)
  {
    return null;
  }
  
  @Nullable
  public Drawable getTemplateDrawable(@Nullable ProfileCardTemplate paramProfileCardTemplate, boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString)
  {
    return null;
  }
  
  public void initDiyTemplate(@Nullable QBaseActivity paramQBaseActivity, @Nullable ProfileCardInfo paramProfileCardInfo) {}
  
  public boolean initTemplateConfig(@Nullable ProfileCardTemplate paramProfileCardTemplate, long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public boolean isDiy()
  {
    return false;
  }
  
  public boolean preNotifyOnCardUpdate(@Nullable QBaseActivity paramQBaseActivity, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    return false;
  }
  
  public void updateAccountInfoForDeepDiy(@Nullable View paramView) {}
  
  public void updateBaseInfoForDeepDiy(@Nullable View paramView) {}
  
  public void updateItemThemeForDIYTemplate(@Nullable TextView paramTextView, @Nullable View paramView1, @Nullable ImageView paramImageView, @Nullable View paramView2, @Nullable View paramView3, @Nullable View paramView4) {}
  
  public void updateLevelForDeepDiy(@Nullable View paramView) {}
  
  public void updateMetalForDeepDiy(@Nullable View paramView) {}
  
  public void updatePhotoWallForDeepDiy(@Nullable View paramView) {}
  
  public void updateQzoneForDeepDiy(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "qZoneView");
  }
  
  public void updateSignForDeepDiy(@Nullable View paramView) {}
  
  public void updateTroopMemInfoForDeepDiy(@Nullable View paramView) {}
  
  public void updateViewAttr(@Nullable View paramView, @Nullable String paramString1, @Nullable ProfileCardTemplate paramProfileCardTemplate, @Nullable String paramString2) {}
  
  public void updateViewAttrForTemplate(@Nullable View paramView, @Nullable String paramString1, @Nullable ProfileCardTemplate paramProfileCardTemplate, @Nullable String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.template.EmptyApi
 * JD-Core Version:    0.7.0.1
 */