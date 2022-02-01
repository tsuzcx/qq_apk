package com.tencent.mobileqq.profilesetting;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.widget.FormSwitchItem;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$ProfileOtherWithSecondHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "profileExtendFriendSettingItem", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "getProfileExtendFriendSettingItem", "()Lcom/tencent/mobileqq/widget/FormSwitchItem;", "setProfileExtendFriendSettingItem", "(Lcom/tencent/mobileqq/widget/FormSwitchItem;)V", "profileExtendFriendTv", "Landroid/widget/TextView;", "getProfileExtendFriendTv", "()Landroid/widget/TextView;", "setProfileExtendFriendTv", "(Landroid/widget/TextView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileBasePrivacySettingAdapter$ProfileOtherWithSecondHolder
  extends RecyclerView.ViewHolder
{
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  public ProfileBasePrivacySettingAdapter$ProfileOtherWithSecondHolder(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2131366375);
    if (localView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)localView);
      paramView = paramView.findViewById(2131366377);
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final FormSwitchItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder
 * JD-Core Version:    0.7.0.1
 */