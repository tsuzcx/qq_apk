package com.tencent.mobileqq.trooponline;

import akeg;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberItem;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.ArrayList;
import java.util.List;

public class TroopOnlineMemberListAdapter
  extends BaseAdapter
{
  public QQAppInterface a;
  protected String a;
  protected List a;
  protected List b = new ArrayList(15);
  
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
    paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    paramViewHolder.jdField_a_of_type_AndroidViewView.setContentDescription(paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a(List paramList)
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969955, paramViewGroup, false);
      paramViewGroup = new TroopOnlineMemberListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368527));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)paramView.findViewById(2131361928));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363568));
      paramView.setTag(paramViewGroup);
      localView = paramView;
      if (AppSetting.b)
      {
        paramView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    paramViewGroup = (TroopOnlineMemberListAdapter.ViewHolder)localView.getTag();
    TroopOnlineMemberItem localTroopOnlineMemberItem = (TroopOnlineMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineDataTroopOnlineMemberItem = localTroopOnlineMemberItem;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localTroopOnlineMemberItem.b);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localTroopOnlineMemberItem.jdField_a_of_type_Int);
    paramViewGroup.jdField_a_of_type_JavaLangString = localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString;
    paramView = (akeg)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopOnlineMemberItem.c);
    if (paramView == null)
    {
      paramView = new akeg(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTag(paramView);
    }
    for (;;)
    {
      if (AppSetting.b) {
        a(paramViewGroup);
      }
      paramView.a = paramViewGroup;
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_JavaLangString, paramView);
      if (!this.b.contains(paramViewGroup.jdField_a_of_type_JavaLangString))
      {
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localTroopOnlineMemberItem.b }).a();
        this.b.add(paramViewGroup.jdField_a_of_type_JavaLangString);
      }
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */