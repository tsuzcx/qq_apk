package com.tencent.mobileqq.profilesetting;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$PrivacySettingClickListener;", "", "onPrivacyCheckClick", "", "view", "Landroid/view/View;", "item", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "onPrivacySettingClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ProfileBasePrivacySettingAdapter$PrivacySettingClickListener
{
  public abstract void a(@NotNull View paramView, @Nullable ProfileDisplaySettingItem paramProfileDisplaySettingItem);
  
  public abstract void b(@NotNull View paramView, @NotNull ProfileDisplaySettingItem paramProfileDisplaySettingItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.PrivacySettingClickListener
 * JD-Core Version:    0.7.0.1
 */