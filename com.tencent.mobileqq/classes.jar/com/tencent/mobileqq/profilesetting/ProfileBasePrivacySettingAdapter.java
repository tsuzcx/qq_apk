package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "privacySettingClickListener", "Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$PrivacySettingClickListener;", "(Landroid/content/Context;Lcom/tencent/mobileqq/profilesetting/ProfileBasePrivacySettingAdapter$PrivacySettingClickListener;)V", "mContext", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilesetting/ProfileDisplaySettingItem;", "Lkotlin/collections/ArrayList;", "mInflater", "Landroid/view/LayoutInflater;", "mPrivacySettingClickListener", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "setData", "data", "", "PrivacySettingClickListener", "ProfileBaseHolder", "ProfileBlankHolder", "ProfileOtherHolder", "ProfileOtherWithSecondHolder", "ProfileTitleHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileBasePrivacySettingAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private final ProfileBasePrivacySettingAdapter.PrivacySettingClickListener jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener;
  private final ArrayList<ProfileDisplaySettingItem> jdField_a_of_type_JavaUtilArrayList;
  
  public ProfileBasePrivacySettingAdapter(@NotNull Context paramContext, @Nullable ProfileBasePrivacySettingAdapter.PrivacySettingClickListener paramPrivacySettingClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramContext = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(context)");
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener = paramPrivacySettingClickListener;
  }
  
  public final void a(@Nullable List<ProfileDisplaySettingItem> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    switch (getItemViewType(paramInt))
    {
    }
    do
    {
      ProfileBasePrivacySettingAdapter.PrivacySettingClickListener localPrivacySettingClickListener;
      do
      {
        do
        {
          return;
          paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileBaseHolder)paramViewHolder;
          i = ((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
          if (i != -1) {
            paramViewHolder.a().setLeftText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          }
          switch (((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).g())
          {
          default: 
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131695096));
          }
          for (;;)
          {
            if (((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
              paramViewHolder.a().setBgType(((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
            }
            localPrivacySettingClickListener = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener;
            if (localPrivacySettingClickListener == null) {
              break;
            }
            paramViewHolder.a().setOnClickListener((View.OnClickListener)new ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.1(localPrivacySettingClickListener, this, paramViewHolder, paramInt));
            return;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131695096));
            continue;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131695113));
            continue;
            paramViewHolder.a().setRightText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(2131695114));
          }
          paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileOtherHolder)paramViewHolder;
          i = ((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
          if (i != -1) {
            paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          }
          paramViewHolder.a().setChecked(((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b());
          if (((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
            paramViewHolder.a().setBgType(((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
          }
          localPrivacySettingClickListener = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener;
        } while (localPrivacySettingClickListener == null);
        paramViewHolder.a().a().setOnClickListener((View.OnClickListener)new ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.2(localPrivacySettingClickListener, this, paramViewHolder, paramInt));
        return;
        paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder)paramViewHolder;
        int i = ((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
        int j = ((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d();
        if ((i != -1) && (j != -1))
        {
          paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(i));
          paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(j));
        }
        paramViewHolder.a().setChecked(((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b());
        if (((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f() != -1) {
          paramViewHolder.a().setBgType(((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f());
        }
        localPrivacySettingClickListener = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileBasePrivacySettingAdapter$PrivacySettingClickListener;
      } while (localPrivacySettingClickListener == null);
      paramViewHolder.a().a().setOnClickListener((View.OnClickListener)new ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.3(localPrivacySettingClickListener, this, paramViewHolder, paramInt));
      return;
      paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileTitleHolder)paramViewHolder;
      paramInt = ((ProfileDisplaySettingItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c();
    } while (paramInt == -1);
    paramViewHolder.a().setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getString(paramInt));
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    switch (paramInt)
    {
    default: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561485, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileBlankHolder(paramViewGroup);
    case 1: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561484, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileBaseHolder(paramViewGroup);
    case 2: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561486, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileOtherHolder(paramViewGroup);
    case 3: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561487, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…d_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder(paramViewGroup);
    case 4: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561485, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileBlankHolder(paramViewGroup);
    }
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561488, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileTitleHolder(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter
 * JD-Core Version:    0.7.0.1
 */