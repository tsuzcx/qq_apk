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
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberItem;
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
    paramViewHolder.jdField_a_of_type_JavaLangStringBuilder.append(paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
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
    Object localObject;
    TroopOnlineMemberListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560816, paramViewGroup, false);
      localViewHolder = new TroopOnlineMemberListAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369650));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)((View)localObject).findViewById(2131380636));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380475));
      ((View)localObject).setTag(localViewHolder);
      paramView = (View)localObject;
      if (AppSetting.d)
      {
        ((View)localObject).setFocusable(true);
        localViewHolder.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      localViewHolder = (TroopOnlineMemberListAdapter.ViewHolder)paramView.getTag();
      TroopOnlineMemberItem localTroopOnlineMemberItem = (TroopOnlineMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineDataTroopOnlineMemberItem = localTroopOnlineMemberItem;
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString));
      if ((localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString != null) && (localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString.startsWith("LV")))
      {
        localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
        localViewHolder.jdField_a_of_type_JavaLangString = localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString;
        localObject = (TroopOnlineMemberListAdapter.TmiCallBackForName)localViewHolder.jdField_a_of_type_AndroidWidgetTextView.getTag();
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopOnlineMemberItem.c);
        if (localObject != null) {
          break label452;
        }
        localObject = new TroopOnlineMemberListAdapter.TmiCallBackForName(this, null);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
      }
      label452:
      for (;;)
      {
        if (AppSetting.d) {
          a(localViewHolder);
        }
        ((TroopOnlineMemberListAdapter.TmiCallBackForName)localObject).a = localViewHolder;
        ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_JavaLangString, localViewHolder.jdField_a_of_type_JavaLangString, (TroopManager.ITroopMemberInfoCallBack)localObject);
        if (!this.b.contains(localViewHolder.jdField_a_of_type_JavaLangString))
        {
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString }).a();
          this.b.add(localViewHolder.jdField_a_of_type_JavaLangString);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localTroopOnlineMemberItem.jdField_b_of_type_Int);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */