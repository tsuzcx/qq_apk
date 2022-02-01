package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneContactAddBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public PhoneContactAddBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    PhoneContactAddBuilder.PhoneContactAddHolder localPhoneContactAddHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof PhoneContactAddBuilder.PhoneContactAddHolder)))
    {
      localPhoneContactAddHolder = (PhoneContactAddBuilder.PhoneContactAddHolder)paramView.getTag();
    }
    else
    {
      localPhoneContactAddHolder = new PhoneContactAddBuilder.PhoneContactAddHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561509, localPhoneContactAddHolder);
      localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
      localPhoneContactAddHolder.h = ((TextView)paramView.findViewById(2131371877));
      localPhoneContactAddHolder.i = ((TextView)paramView.findViewById(2131376487));
      localPhoneContactAddHolder.l = ((TextView)paramView.findViewById(2131362299));
      localPhoneContactAddHolder.j = ((TextView)paramView.findViewById(2131377726));
      localPhoneContactAddHolder.k = ((TextView)paramView.findViewById(2131376485));
      localPhoneContactAddHolder.a = ((Button)paramView.findViewById(2131376477));
      b(localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localPhoneContactAddHolder);
    }
    localPhoneContactAddHolder.leftView.setTag(localPhoneContactAddHolder);
    localPhoneContactAddHolder.leftView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage, localPhoneContactAddHolder, this);
    NewFriendUtil.a(localPhoneContactAddHolder.leftView, false);
    PhoneContactAdd localPhoneContactAdd = ((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    if (!TextUtils.isEmpty(localPhoneContactAdd.name))
    {
      localPhoneContactAddHolder.h.setVisibility(0);
      localPhoneContactAddHolder.h.setText(localPhoneContactAdd.name);
    }
    else
    {
      localPhoneContactAddHolder.h.setVisibility(8);
    }
    localPhoneContactAddHolder.l.setVisibility(8);
    localPhoneContactAddHolder.j.setVisibility(8);
    if (!TextUtils.isEmpty(localPhoneContactAdd.remindInfo))
    {
      localPhoneContactAddHolder.i.setVisibility(0);
      localPhoneContactAddHolder.i.setText(localPhoneContactAdd.remindInfo);
    }
    else
    {
      localPhoneContactAddHolder.i.setVisibility(8);
    }
    localPhoneContactAddHolder.k.setVisibility(0);
    localPhoneContactAddHolder.a.setVisibility(8);
    localPhoneContactAddHolder.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718222));
    localPhoneContactAddHolder.jdField_f_of_type_JavaLangString = localPhoneContactAdd.unifiedCode;
    localPhoneContactAddHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localPhoneContactAdd.unifiedCode));
    return paramView;
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new PhoneContactAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376644)
    {
      if ((paramView.getTag() instanceof PhoneContactAddBuilder.PhoneContactAddHolder))
      {
        PhoneContactAdd localPhoneContactAdd = ((PhoneContactAddMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
        if (localPhoneContactAdd != null)
        {
          Object localObject = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
          if (((IPhoneContactService)localObject).queryContactByCodeNumber(localPhoneContactAdd.unifiedCode) == null) {
            localObject = new AllInOne(localPhoneContactAdd.unifiedCode, 29);
          } else if (((IPhoneContactService)localObject).isBindedIgnoreUpload()) {
            localObject = new AllInOne(localPhoneContactAdd.unifiedCode, 34);
          } else {
            localObject = new AllInOne(localPhoneContactAdd.unifiedCode, 29);
          }
          ((AllInOne)localObject).nickname = localPhoneContactAdd.name;
          ProfileUtils.openProfileCardForResult((Activity)this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject, 227);
          ((INewFriendService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
        }
      }
    }
    else {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder
 * JD-Core Version:    0.7.0.1
 */