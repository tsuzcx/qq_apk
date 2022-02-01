package com.tencent.mobileqq.profilecard.template;

import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import org.jetbrains.annotations.NotNull;

public abstract interface ITemplateManager
{
  public abstract void deleteOldCardTemplateDir(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract long getDiyTemplateVersion(@NotNull Card paramCard);
  
  public abstract boolean preNotifyOnCardUpdate(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo);
  
  public abstract void updateViewAttrForTemplate(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.template.ITemplateManager
 * JD-Core Version:    0.7.0.1
 */