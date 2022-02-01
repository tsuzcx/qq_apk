package com.tencent.mobileqq.troop.troopnotification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.troopnotification.adapter.DelMenuBuilder;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ApplicantHolder;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousHolder;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

class TroopNotificationFragment$24
  extends SuspiciousAdapter<MessageRecord>
{
  TroopNotificationFragment$24(TroopNotificationFragment paramTroopNotificationFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = new SwipRightMenuBuilder.SwipItemBaseHolder();
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterDelMenuBuilder.a(paramContext, paramInt, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject);
    paramContext = new SuspiciousHolder(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder$SwipItemBaseHolder = ((SwipRightMenuBuilder.SwipItemBaseHolder)localObject);
    localObject = new NotifyAndRecAdapter.ApplicantHolder();
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131373673);
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373686));
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373687));
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373683));
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).c = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131373682));
    paramContext.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter$ApplicantHolder = ((NotifyAndRecAdapter.ApplicantHolder)localObject);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373689));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373672));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373680));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373693));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373678));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131373690));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131373692));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131373679));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131373688));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131379327));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131379326);
    NotifyAndRecAdapter.a(paramContext.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    if (!(paramViewHolder instanceof SuspiciousHolder)) {
      return;
    }
    SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)paramViewHolder;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterDelMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramViewHolder.itemView, paramInt, paramMessageRecord, localSuspiciousHolder.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder$SwipItemBaseHolder, new TroopNotificationFragment.24.1(this), this.d);
    TroopNotificationFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationTroopNotificationFragment, paramViewHolder, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.24
 * JD-Core Version:    0.7.0.1
 */