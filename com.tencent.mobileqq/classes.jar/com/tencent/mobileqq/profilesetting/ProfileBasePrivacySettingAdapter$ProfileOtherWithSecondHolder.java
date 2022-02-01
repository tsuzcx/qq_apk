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
  private FormSwitchItem a;
  @NotNull
  private TextView b;
  
  public ProfileBasePrivacySettingAdapter$ProfileOtherWithSecondHolder(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2131432685);
    if (localView != null)
    {
      this.a = ((FormSwitchItem)localView);
      paramView = paramView.findViewById(2131432687);
      if (paramView != null)
      {
        this.b = ((TextView)paramView);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
  }
  
  @NotNull
  public final FormSwitchItem a()
  {
    return this.a;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder
 * JD-Core Version:    0.7.0.1
 */