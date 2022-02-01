package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AppsGridViewBuilder$AppsGridViewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AppsGridViewBuilder jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder;
  private List<TroopAppShortcutContainer.TroopAppInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AppsGridViewBuilder$AppsGridViewAdapter(AppsGridViewBuilder paramAppsGridViewBuilder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder = paramAppsGridViewBuilder;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public TroopAppShortcutContainer.TroopAppInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (TroopAppShortcutContainer.TroopAppInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<TroopAppShortcutContainer.TroopAppInfo> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    TroopAppShortcutContainer.TroopAppInfo localTroopAppInfo = a(paramInt);
    if (localTroopAppInfo != null) {
      return localTroopAppInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      if (i == 0)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559856, paramViewGroup, false);
        localObject1 = new AppsGridViewBuilder.AppsGridViewHolder();
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379161));
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b = ((ImageView)paramView.findViewById(2131379162));
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379163));
        paramView.setTag(localObject1);
      }
      else
      {
        if (i != 1) {
          break label232;
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559857, paramViewGroup, false);
        localObject1 = new AppsGridViewBuilder.AppsGridViewHolder();
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379161));
        paramView.setTag(localObject1);
      }
      localObject2 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int - 6);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.c)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(16.0F);
        ((GradientDrawable)localObject2).setColor(-16777216);
        paramView.setBackgroundDrawable((Drawable)localObject2);
      }
      else
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(16.0F);
        ((GradientDrawable)localObject2).setColor(-1);
        paramView.setBackgroundDrawable((Drawable)localObject2);
        break label253;
        label232:
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
        break label605;
      }
    }
    else
    {
      localObject1 = (AppsGridViewBuilder.AppsGridViewHolder)paramView.getTag();
    }
    label253:
    Object localObject2 = a(paramInt);
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getItem() == null position:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("AppsGridViewBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo = ((TroopAppShortcutContainer.TroopAppInfo)localObject2);
      if (i == 0)
      {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.c) {
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
        }
      }
      Object localObject3;
      if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Int == 1)
      {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851154));
        TroopAppShortcutUtils.a(((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView);
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(8);
      }
      else
      {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext;
        ImageView localImageView = ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
        String str = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_JavaLangString;
        boolean bool;
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).e == 1) {
          bool = true;
        } else {
          bool = false;
        }
        TroopAppShortcutUtils.a((Context)localObject3, localImageView, str, 24.0F, bool);
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).d != 0) {
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(0);
        } else {
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(8);
        }
      }
      i = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Int;
      localObject1 = "";
      if ((i == 0) && (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_Long == 101914115L))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long);
        ((StringBuilder)localObject3).append("");
        QQGameTroopManager.a(1, ((StringBuilder)localObject3).toString(), true);
      }
      if (AppSetting.d)
      {
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString != null) {
          localObject1 = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString;
        }
        paramView.setContentDescription((CharSequence)localObject1);
      }
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
    }
    Object localObject1 = paramView;
    label605:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof AppsGridViewBuilder.AppsGridViewHolder)))
    {
      localObject = (AppsGridViewBuilder.AppsGridViewHolder)localObject;
      if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick appInfo:");
          localStringBuilder.append(((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.toString());
          QLog.d("AppsGridViewBuilder", 2, localStringBuilder.toString());
        }
        if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Int == 1)
        {
          TroopAppShortcutUtils.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        }
        else if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Int == 0)
        {
          TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long), ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.c, 1, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.d);
          long l1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long;
          long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_b_of_type_Long;
          long l3 = ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long;
          int i = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Int;
          if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Long == 0L) {
            localObject = "1";
          } else {
            localObject = "2";
          }
          ReportController.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsGridViewBuilder.AppsGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */