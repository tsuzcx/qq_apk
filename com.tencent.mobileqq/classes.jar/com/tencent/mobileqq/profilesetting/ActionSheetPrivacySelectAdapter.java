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
  private final List<ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean> a;
  private final LayoutInflater b;
  private final ProfileDisplaySettingItem c;
  private ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener d;
  @NotNull
  private Context e;
  @NotNull
  private ProfileDisplaySettingItem f;
  
  public ActionSheetPrivacySelectAdapter(@NotNull Context paramContext, @NotNull ProfileDisplaySettingItem paramProfileDisplaySettingItem)
  {
    this.e = paramContext;
    this.f = paramProfileDisplaySettingItem;
    this.c = this.f;
    this.a = ((List)new ArrayList());
    paramContext = LayoutInflater.from(this.e);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(mContext)");
    this.b = paramContext;
  }
  
  public final void a(@Nullable ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener paramPrivacySelectActionSheetClickListener)
  {
    this.d = paramPrivacySelectActionSheetClickListener;
  }
  
  public final void a(@Nullable List<ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll((Collection)paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    paramViewHolder = (ActionSheetPrivacySelectAdapter.PrivacyHolder)paramViewHolder;
    paramViewHolder.a().setText((CharSequence)((ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean)this.a.get(paramInt)).b());
    if (paramInt == 0) {
      paramViewHolder.itemView.setBackgroundResource(2130837694);
    } else {
      paramViewHolder.itemView.setBackgroundResource(2130837681);
    }
    if (((ActionSheetPrivacySelectAdapter.ActionSheetPrivacySelectBean)this.a.get(paramInt)).a() == this.c.i()) {
      paramViewHolder.b().setVisibility(0);
    } else {
      paramViewHolder.b().setVisibility(8);
    }
    ActionSheetPrivacySelectAdapter.PrivacySelectActionSheetClickListener localPrivacySelectActionSheetClickListener = this.d;
    if (localPrivacySelectActionSheetClickListener != null) {
      paramViewHolder.itemView.setOnClickListener((View.OnClickListener)new ActionSheetPrivacySelectAdapter.onBindViewHolder..inlined.let.lambda.1(localPrivacySelectActionSheetClickListener, this, paramViewHolder, paramInt));
    }
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = this.b.inflate(2131627683, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mInflater.inflate(R.layo…w_item, viewGroup, false)");
    return (RecyclerView.ViewHolder)new ActionSheetPrivacySelectAdapter.PrivacyHolder(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ActionSheetPrivacySelectAdapter
 * JD-Core Version:    0.7.0.1
 */