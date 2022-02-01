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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (TroopAppShortcutContainer.TroopAppInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    Object localObject2;
    if (paramView == null) {
      if (i == 0)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559985, paramViewGroup, false);
        localObject1 = new AppsGridViewBuilder.AppsGridViewHolder();
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379832));
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b = ((ImageView)paramView.findViewById(2131379833));
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379834));
        paramView.setTag(localObject1);
        localObject2 = paramView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = (this.jdField_a_of_type_Int - 6);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.c) {
          break label261;
        }
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(16.0F);
        ((GradientDrawable)localObject2).setColor(-16777216);
        paramView.setBackgroundDrawable((Drawable)localObject2);
      }
    }
    for (;;)
    {
      localObject2 = a(paramInt);
      if (localObject2 != null) {
        break label304;
      }
      QLog.e("AppsGridViewBuilder", 2, "getItem() == null position:" + paramInt);
      for (localObject1 = paramView;; localObject1 = null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        if (i == 1)
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559986, paramViewGroup, false);
          localObject1 = new AppsGridViewBuilder.AppsGridViewHolder();
          ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379832));
          paramView.setTag(localObject1);
          break;
        }
      }
      label261:
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(16.0F);
      ((GradientDrawable)localObject2).setColor(-1);
      paramView.setBackgroundDrawable((Drawable)localObject2);
      continue;
      localObject1 = (AppsGridViewBuilder.AppsGridViewHolder)paramView.getTag();
    }
    label304:
    ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo = ((TroopAppShortcutContainer.TroopAppInfo)localObject2);
    if (i == 0)
    {
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.c) {
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffffff"));
      }
    }
    if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Int == 1)
    {
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851237));
      TroopAppShortcutUtils.a(((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView);
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(8);
      label402:
      if ((((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_Int == 0) && (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_Long == 101914115L)) {
        QQGameTroopManager.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long + "", true);
      }
      if (AppSetting.d) {
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString == null) {
          break label592;
        }
      }
    }
    label579:
    label592:
    for (Object localObject1 = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      paramView.setContentDescription((CharSequence)localObject1);
      paramView.setClickable(true);
      paramView.setOnClickListener(this);
      localObject1 = paramView;
      break;
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext;
      ImageView localImageView = ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      String str = ((TroopAppShortcutContainer.TroopAppInfo)localObject2).jdField_b_of_type_JavaLangString;
      if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        TroopAppShortcutUtils.a(localContext, localImageView, str, 24.0F, bool);
        if (((TroopAppShortcutContainer.TroopAppInfo)localObject2).d == 0) {
          break label579;
        }
        ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(0);
        break;
      }
      ((AppsGridViewBuilder.AppsGridViewHolder)localObject1).b.setVisibility(8);
      break label402;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((localObject instanceof AppsGridViewBuilder.AppsGridViewHolder))
        {
          localObject = (AppsGridViewBuilder.AppsGridViewHolder)localObject;
          if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppsGridViewBuilder", 2, "onItemClick appInfo:" + ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.toString());
            }
            if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Int != 1) {
              break;
            }
            TroopAppShortcutUtils.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          }
        }
      }
    } while (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Int != 0);
    TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.c, 1, ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.d);
    long l1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_b_of_type_Long;
    long l3 = ((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_b_of_type_Long;
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsAppsGridViewBuilder.jdField_a_of_type_Int;
    if (((AppsGridViewBuilder.AppsGridViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopappsTroopAppShortcutContainer$TroopAppInfo.jdField_a_of_type_Long == 0L) {}
    for (localObject = "1";; localObject = "2")
    {
      ReportController.b(null, "dc00898", "", String.valueOf(l1), "0X800AD09", "0X800AD09", 0, 0, String.valueOf(l2), String.valueOf(l3), String.valueOf(i), (String)localObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsGridViewBuilder.AppsGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */