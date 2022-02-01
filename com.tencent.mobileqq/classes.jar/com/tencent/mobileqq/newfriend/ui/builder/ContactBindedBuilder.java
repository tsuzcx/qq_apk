package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ContactBindedBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private NewFriendServiceImpl jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  ArrayList<PhoneContact> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  
  public ContactBindedBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl = ((NewFriendServiceImpl)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    paramContext = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
    paramContext.asyncInitContactBindedData(paramContext.getBindAllFriendList());
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels >= 1080) {
      i = 5;
    } else {
      i = 4;
    }
    this.jdField_a_of_type_Int = i;
    this.b = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.generateRandomList();
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.b.clone());
    int j = this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.fillToMaxCountIfNeeded(this.jdField_a_of_type_JavaUtilArrayList, i);
  }
  
  private void a(ContactBindedBuilder.ContactBindedHolder paramContactBindedHolder)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getRecommendUnreadCount();
    if ((i != 0) && (!this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a()))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).updateCustomNoteTxt(paramContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView, i, 0);
      return;
    }
    paramContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactBindedBuilder.ContactBindedHolder localContactBindedHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof ContactBindedBuilder.ContactBindedHolder)))
    {
      localContactBindedHolder = (ContactBindedBuilder.ContactBindedHolder)paramView.getTag();
    }
    else
    {
      localContactBindedHolder = new ContactBindedBuilder.ContactBindedHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561241, null);
      localContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380207));
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372537));
      localContactBindedHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372540);
      localContactBindedHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372541);
      localContactBindedHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372542);
      localContactBindedHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372543);
      localContactBindedHolder.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131372544);
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368059));
      localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368060));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368061));
      localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368062));
      localContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368063));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371863));
      localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371864));
      localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371865));
      localContactBindedHolder.f = ((TextView)paramView.findViewById(2131371866));
      localContactBindedHolder.g = ((TextView)paramView.findViewById(2131371867));
      b(localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView);
      b(localContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView);
      paramView.setTag(localContactBindedHolder);
    }
    Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getBindAllFriendList();
    int j = ((ArrayList)localObject1).size();
    localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131702624), new Object[] { Integer.valueOf(j) }));
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.queryPhoneContactByMobile(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
        ((Iterator)localObject2).remove();
      }
    }
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = paramInt;
    if (paramInt < this.jdField_a_of_type_Int)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      do
      {
        i = paramInt;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (PhoneContact)((Iterator)localObject1).next();
        i = paramInt;
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject2))
        {
          i = paramInt;
          if (((PhoneContact)localObject2).uin.equals("0"))
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            i = paramInt + 1;
          }
        }
        paramInt = i;
      } while (i != this.jdField_a_of_type_Int);
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5)
            {
              localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
              localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
              localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
              localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
              localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
              localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
              localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
              localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
              localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
              localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
              localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
              localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
              localContactBindedHolder.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_d_of_type_JavaLangString));
              localContactBindedHolder.f.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(4);
              localContactBindedHolder.jdField_e_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_e_of_type_JavaLangString));
              localContactBindedHolder.g.setText(((PhoneContact)localObject1).name);
            }
          }
          else
          {
            localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
            localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
            localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
            localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
            if (this.jdField_a_of_type_Int == 4) {
              localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
            } else {
              localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
            }
            localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
            localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
            localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
            localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
            localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
            localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
            localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
            localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
            localContactBindedHolder.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_d_of_type_JavaLangString));
            localContactBindedHolder.f.setText(((PhoneContact)localObject1).name);
          }
        }
        else
        {
          localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
          localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
          if (this.jdField_a_of_type_Int == 4) {
            localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
          } else {
            localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
          }
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
          localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
          localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
          localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
          localContactBindedHolder.jdField_e_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        }
      }
      else
      {
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        if (this.jdField_a_of_type_Int == 4) {
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        } else {
          localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
        }
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
        localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
      }
    }
    else
    {
      localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(4);
      localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
      localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
      if (this.jdField_a_of_type_Int == 4) {
        localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
      } else {
        localContactBindedHolder.jdField_e_of_type_AndroidViewView.setVisibility(4);
      }
      localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
    }
    if (AppSetting.d) {
      paramView.setContentDescription(String.format(HardCodeUtil.a(2131702632), new Object[] { Integer.valueOf(j) }));
    }
    NewFriendUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a() ^ true);
    a(localContactBindedHolder);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372538)
    {
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactBindedBuilder.ContactBindedHolder)))
      {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 222, this.b);
        this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.markRecommendReaded();
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.ContactBindedBuilder
 * JD-Core Version:    0.7.0.1
 */