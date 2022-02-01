package com.tencent.mobileqq.extendfriend.wiget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.limitchat.CompletePesonalDataTask;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$TaskAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/extendfriend/wiget/CompletePersonalDataDialog$TaskAdapter$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onClickListener", "Landroid/view/View$OnClickListener;", "taskList", "", "Lcom/tencent/mobileqq/extendfriend/limitchat/CompletePesonalDataTask;", "getItemCount", "", "jumpToTask", "", "task", "onBindViewHolder", "viewHolder", "i", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateTasks", "tasks", "", "ViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CompletePersonalDataDialog$TaskAdapter
  extends RecyclerView.Adapter<CompletePersonalDataDialog.TaskAdapter.ViewHolder>
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final List<CompletePesonalDataTask> jdField_a_of_type_JavaUtilList;
  
  public CompletePersonalDataDialog$TaskAdapter(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = ((View.OnClickListener)new CompletePersonalDataDialog.TaskAdapter.onClickListener.1(this));
  }
  
  private final void a(CompletePesonalDataTask paramCompletePesonalDataTask)
  {
    switch (paramCompletePesonalDataTask.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B08A", "0X800B08A", paramCompletePesonalDataTask.jdField_a_of_type_Int, 0, "", "", "", "");
      return;
      Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      CampusHelper.a((Activity)localObject1, "");
      continue;
      localObject1 = new Intent();
      Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      PublicFragmentActivity.a((Activity)localObject2, (Intent)localObject1, ExtendFriendEditFragment.class, 4097);
      continue;
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject2 = ((FragmentActivity)localObject2).app;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(context as FragmentActivity).app");
      ((Intent)localObject1).putExtra("uin", ((QQAppInterface)localObject2).getCurrentUin());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject1 = ((FragmentActivity)localObject1).app;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(context as FragmentActivity).app");
      localObject1 = ((QQAppInterface)localObject1).getCurrentUin();
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      PhotoWallView.a((Activity)localObject2, (String)localObject1, true);
    }
  }
  
  @NotNull
  public CompletePersonalDataDialog.TaskAdapter.ViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561208, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "convertView");
    paramViewGroup = new CompletePersonalDataDialog.TaskAdapter.ViewHolder(paramViewGroup);
    paramViewGroup.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramViewGroup;
  }
  
  public void a(@NotNull CompletePersonalDataDialog.TaskAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    Object localObject = (CompletePesonalDataTask)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    String str = ((CompletePesonalDataTask)localObject).jdField_a_of_type_JavaLangString + " +" + ((CompletePesonalDataTask)localObject).b;
    Intrinsics.checkExpressionValueIsNotNull(str, "StringBuilder(task.taskD…k.rewardCount).toString()");
    paramViewHolder.a().setText((CharSequence)str);
    boolean bool;
    switch (((CompletePesonalDataTask)localObject).c)
    {
    default: 
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698728);
      bool = true;
      label140:
      if (bool)
      {
        paramViewHolder.a().setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845225));
        paramViewHolder.a().setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167374));
      }
      break;
    }
    for (;;)
    {
      paramViewHolder.a().setEnabled(bool);
      paramViewHolder.a().setText((CharSequence)localObject);
      paramViewHolder.a().setTag(Integer.valueOf(paramInt));
      break;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698728);
      bool = true;
      break label140;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698729);
      bool = false;
      break label140;
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698730);
      bool = false;
      break label140;
      paramViewHolder.a().setBackgroundDrawable(null);
      paramViewHolder.a().setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165586));
    }
  }
  
  public final void a(@Nullable List<? extends CompletePesonalDataTask> paramList)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      if (paramList == null) {
        Intrinsics.throwNpe();
      }
      localList.addAll((Collection)paramList);
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.CompletePersonalDataDialog.TaskAdapter
 * JD-Core Version:    0.7.0.1
 */