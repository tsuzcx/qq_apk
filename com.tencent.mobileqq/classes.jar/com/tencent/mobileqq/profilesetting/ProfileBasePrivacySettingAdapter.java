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
  private final Context a;
  private final ArrayList<ProfileDisplaySettingItem> b;
  private final LayoutInflater c;
  private final ProfileBasePrivacySettingAdapter.PrivacySettingClickListener d;
  
  public ProfileBasePrivacySettingAdapter(@NotNull Context paramContext, @Nullable ProfileBasePrivacySettingAdapter.PrivacySettingClickListener paramPrivacySettingClickListener)
  {
    this.a = paramContext;
    this.b = new ArrayList();
    paramContext = LayoutInflater.from(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(context)");
    this.c = paramContext;
    this.d = paramPrivacySettingClickListener;
  }
  
  public final void a(@Nullable List<ProfileDisplaySettingItem> paramList)
  {
    if (paramList != null)
    {
      this.b.clear();
      this.b.addAll((Collection)paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ProfileDisplaySettingItem)this.b.get(paramInt)).a();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    int i = getItemViewType(paramInt);
    ProfileBasePrivacySettingAdapter.PrivacySettingClickListener localPrivacySettingClickListener;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileTitleHolder)paramViewHolder;
            paramInt = ((ProfileDisplaySettingItem)this.b.get(paramInt)).c();
            if (paramInt != -1) {
              paramViewHolder.a().setText((CharSequence)this.a.getString(paramInt));
            }
          }
        }
        else
        {
          paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder)paramViewHolder;
          i = ((ProfileDisplaySettingItem)this.b.get(paramInt)).c();
          int j = ((ProfileDisplaySettingItem)this.b.get(paramInt)).d();
          if ((i != -1) && (j != -1))
          {
            paramViewHolder.a().setText((CharSequence)this.a.getString(i));
            paramViewHolder.b().setText((CharSequence)this.a.getString(j));
          }
          paramViewHolder.a().setChecked(((ProfileDisplaySettingItem)this.b.get(paramInt)).h());
          if (((ProfileDisplaySettingItem)this.b.get(paramInt)).g() != -1) {
            paramViewHolder.a().setBgType(((ProfileDisplaySettingItem)this.b.get(paramInt)).g());
          }
          localPrivacySettingClickListener = this.d;
          if (localPrivacySettingClickListener != null) {
            paramViewHolder.a().getSwitch().setOnClickListener((View.OnClickListener)new ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.3(localPrivacySettingClickListener, this, paramViewHolder, paramInt));
          }
        }
      }
      else
      {
        paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileOtherHolder)paramViewHolder;
        i = ((ProfileDisplaySettingItem)this.b.get(paramInt)).c();
        if (i != -1) {
          paramViewHolder.a().setText((CharSequence)this.a.getString(i));
        }
        paramViewHolder.a().setChecked(((ProfileDisplaySettingItem)this.b.get(paramInt)).h());
        if (((ProfileDisplaySettingItem)this.b.get(paramInt)).g() != -1) {
          paramViewHolder.a().setBgType(((ProfileDisplaySettingItem)this.b.get(paramInt)).g());
        }
        localPrivacySettingClickListener = this.d;
        if (localPrivacySettingClickListener != null) {
          paramViewHolder.a().getSwitch().setOnClickListener((View.OnClickListener)new ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.2(localPrivacySettingClickListener, this, paramViewHolder, paramInt));
        }
      }
    }
    else
    {
      paramViewHolder = (ProfileBasePrivacySettingAdapter.ProfileBaseHolder)paramViewHolder;
      i = ((ProfileDisplaySettingItem)this.b.get(paramInt)).c();
      if (i != -1) {
        paramViewHolder.a().setLeftText((CharSequence)this.a.getString(i));
      }
      i = ((ProfileDisplaySettingItem)this.b.get(paramInt)).i();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            paramViewHolder.a().setRightText((CharSequence)this.a.getString(2131892814));
          } else {
            paramViewHolder.a().setRightText((CharSequence)this.a.getString(2131892832));
          }
        }
        else {
          paramViewHolder.a().setRightText((CharSequence)this.a.getString(2131892831));
        }
      }
      else {
        paramViewHolder.a().setRightText((CharSequence)this.a.getString(2131892814));
      }
      if (((ProfileDisplaySettingItem)this.b.get(paramInt)).g() != -1) {
        paramViewHolder.a().setBgType(((ProfileDisplaySettingItem)this.b.get(paramInt)).g());
      }
      localPrivacySettingClickListener = this.d;
      if (localPrivacySettingClickListener != null) {
        paramViewHolder.a().setOnClickListener((View.OnClickListener)new ProfileBasePrivacySettingAdapter.onBindViewHolder..inlined.let.lambda.1(localPrivacySettingClickListener, this, paramViewHolder, paramInt));
      }
    }
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              paramViewGroup = this.c.inflate(2131627685, paramViewGroup, false);
              Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
              return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileBlankHolder(paramViewGroup);
            }
            paramViewGroup = this.c.inflate(2131627688, paramViewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
            return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileTitleHolder(paramViewGroup);
          }
          paramViewGroup = this.c.inflate(2131627685, paramViewGroup, false);
          Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…k_item, viewGroup, false)");
          return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileBlankHolder(paramViewGroup);
        }
        paramViewGroup = this.c.inflate(2131627687, paramViewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…d_item, viewGroup, false)");
        return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileOtherWithSecondHolder(paramViewGroup);
      }
      paramViewGroup = this.c.inflate(2131627686, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
      return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileOtherHolder(paramViewGroup);
    }
    paramViewGroup = this.c.inflate(2131627684, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…e_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new ProfileBasePrivacySettingAdapter.ProfileBaseHolder(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileBasePrivacySettingAdapter
 * JD-Core Version:    0.7.0.1
 */