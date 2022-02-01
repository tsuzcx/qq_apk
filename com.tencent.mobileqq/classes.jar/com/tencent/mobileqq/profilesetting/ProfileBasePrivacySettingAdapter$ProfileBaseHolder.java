package com.tencent.mobileqq.profilesetting;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.widget.FormSimpleItem;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$ProfileBaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "profileBaseSettingItem", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "getProfileBaseSettingItem", "()Lcom/tencent/mobileqq/widget/FormSimpleItem;", "setProfileBaseSettingItem", "(Lcom/tencent/mobileqq/widget/FormSimpleItem;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileBasePrivacySettingAdapter$ProfileBaseHolder
  extends RecyclerView.ViewHolder
{
  @NotNull
  private FormSimpleItem a;
  
  public ProfileBasePrivacySettingAdapter$ProfileBaseHolder(@NotNull View paramView)
  {
    super(paramView);
    paramView = paramView.findViewById(2131369385);
    if (paramView == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSimpleItem");
    }
    this.a = ((FormSimpleItem)paramView);
  }
  
  @NotNull
  public final FormSimpleItem a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileBaseHolder
 * JD-Core Version:    0.7.0.1
 */