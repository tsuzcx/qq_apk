package com.tencent.mobileqq.profilesetting;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$ProfileTitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "profileTitleItem", "Landroid/widget/TextView;", "getProfileTitleItem", "()Landroid/widget/TextView;", "setProfileTitleItem", "(Landroid/widget/TextView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileBasePrivacySettingAdapter$ProfileTitleHolder
  extends RecyclerView.ViewHolder
{
  @NotNull
  private TextView a;
  
  public ProfileBasePrivacySettingAdapter$ProfileTitleHolder(@NotNull View paramView)
  {
    super(paramView);
    paramView = paramView.findViewById(2131440721);
    if (paramView != null)
    {
      this.a = ((TextView)paramView);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
  }
  
  @NotNull
  public final TextView a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileTitleHolder
 * JD-Core Version:    0.7.0.1
 */