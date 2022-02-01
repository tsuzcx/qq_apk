package com.tencent.mobileqq.trooponline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TroopOnlineMemberListAdapter
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<TroopOnlineMemberItem> a;
  protected List<String> b = new ArrayList(15);
  
  public TroopOnlineMemberListAdapter(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(TroopOnlineMemberListAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.delete(0, paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    StringBuilder localStringBuilder = paramViewHolder.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.append(paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    localStringBuilder.append(",");
    localStringBuilder.append(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    paramViewHolder.jdField_a_of_type_AndroidViewView.setContentDescription(paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<TroopOnlineMemberItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560689, paramViewGroup, false);
      localObject = new TroopOnlineMemberListAdapter.ViewHolder(this);
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramView;
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369350));
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)paramView.findViewById(2131379918));
      ((TroopOnlineMemberListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379778));
      paramView.setTag(localObject);
      localView = paramView;
      if (AppSetting.d)
      {
        paramView.setFocusable(true);
        ((TroopOnlineMemberListAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    TroopOnlineMemberListAdapter.ViewHolder localViewHolder = (TroopOnlineMemberListAdapter.ViewHolder)localView.getTag();
    TroopOnlineMemberItem localTroopOnlineMemberItem = (TroopOnlineMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberDataTroopOnlineMemberItem = localTroopOnlineMemberItem;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString));
    if ((localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString != null) && (localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString.startsWith("LV")))
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
    }
    else
    {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localTroopOnlineMemberItem.jdField_b_of_type_Int);
    }
    localViewHolder.jdField_a_of_type_JavaLangString = localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString;
    Object localObject = (TroopOnlineMemberListAdapter.TmiCallBackForName)localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTag();
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopOnlineMemberItem.c);
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = new TroopOnlineMemberListAdapter.TmiCallBackForName(this, null);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(paramView);
    }
    if (AppSetting.d) {
      a(localViewHolder);
    }
    paramView.a = localViewHolder;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_JavaLangString, localViewHolder.jdField_a_of_type_JavaLangString, paramView);
    if (!this.b.contains(localViewHolder.jdField_a_of_type_JavaLangString))
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString }).a();
      this.b.add(localViewHolder.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */