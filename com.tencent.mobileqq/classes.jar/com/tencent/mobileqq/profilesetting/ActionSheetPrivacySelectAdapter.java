package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "profileDisplaySettingItem", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "(Landroid/content/Context;Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "", "Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$ActionSheetPrivacySelectBean;", "mInflater", "Landroid/view/LayoutInflater;", "mPrivacySelectActionSheetClickListener", "Lcom/tencent/mobileqq/profilesetting/ActionSheetPrivacySelectAdapter$PrivacySelectActionSheetClickListener;", "mProfileDisplaySettingItem", "getProfileDisplaySettingItem", "()Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "setProfileDisplaySettingItem", "(Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "", "setOnPrivacySelectActionSheetClickListener", "listener", "ActionSheetPrivacySelectBean", "PrivacyHolder", "PrivacySelectActionSheetClickListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ActionSheetPrivacySelectAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  @NotNull
  private Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener jdField_a_of_type_ComTencentMobileqqProfilesettingActionSheetPrivacySelectAdapter$PrivacySelectActionSheetClickListener;
  private final ProfileDisplaySettingItem jdField_a_of_type_ComTencentMobileqqProfilesettingProfileDisplaySettingItem;
  private final List<ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean> jdField_a_of_type_JavaUtilList;
  @NotNull
  private ProfileDisplaySettingItem b;
  
  public ActionSheetPrivacySelectAdapter(@NotNull Context paramContext, @NotNull ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramProfileDisplaySettingItem;
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileDisplaySettingItem = this.b;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(mContext)");
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramContext;
  }
  
  public final void a(@Nullable ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener paramPrivacySelectActionSheetClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingActionSheetPrivacySelectAdapter$PrivacySelectActionSheetClickListener = paramPrivacySelectActionSheetClickListener;
  }
  
  public final void a(@Nullable List<ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    paramViewHolder = (ActionSheetPrivacySelectAdapter.PrivacyHolder)paramViewHolder;
    paramViewHolder.a().setText((CharSequence)((ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a());
    if (paramInt == 0) {
      paramViewHolder.itemView.setBackgroundResource(2130837670);
    } else {
      paramViewHolder.itemView.setBackgroundResource(2130837658);
    }
    if (((ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a() == this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileDisplaySettingItem.g()) {
      paramViewHolder.a().setVisibility(0);
    } else {
      paramViewHolder.a().setVisibility(8);
    }
    ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener localPrivacySelectActionSheetClickListener = this.jdField_a_of_type_ComTencentMobileqqProfilesettingActionSheetPrivacySelectAdapter$PrivacySelectActionSheetClickListener;
    if (localPrivacySelectActionSheetClickListener != null) {
      paramViewHolder.itemView.setOnClickListener((View.OnClickListener)new ActionSheetPrivacySelectAdapter.onBindViewHolder..inlined.let.lambda.1(localPrivacySelectActionSheetClickListener, this, paramViewHolder, paramInt));
    }
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561327, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…w_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new ActionSheetPrivacySelectAdapter.PrivacyHolder(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ActionSheetPrivacySelectAdapter
 * JD-Core Version:    0.7.0.1
 */