package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class ContactMatchBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private NewFriendServiceImpl a;
  
  public ContactMatchBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl = ((NewFriendServiceImpl)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297483);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactMatchBuilder.ContactMatchHolder localContactMatchHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof ContactMatchBuilder.ContactMatchHolder)))
    {
      localContactMatchHolder = (ContactMatchBuilder.ContactMatchHolder)paramView.getTag();
    }
    else
    {
      localContactMatchHolder = new ContactMatchBuilder.ContactMatchHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561509, localContactMatchHolder);
      a(paramView, this.b);
      localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
      localContactMatchHolder.h = ((TextView)paramView.findViewById(2131371877));
      localContactMatchHolder.i = ((TextView)paramView.findViewById(2131376487));
      localContactMatchHolder.l = ((TextView)paramView.findViewById(2131362299));
      localContactMatchHolder.j = ((TextView)paramView.findViewById(2131377726));
      localContactMatchHolder.k = ((TextView)paramView.findViewById(2131376485));
      localContactMatchHolder.a = ((Button)paramView.findViewById(2131376477));
      b(localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localContactMatchHolder);
    }
    localContactMatchHolder.leftView.setTag(localContactMatchHolder);
    localContactMatchHolder.leftView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage, localContactMatchHolder, this);
    NewFriendUtil.a(localContactMatchHolder.leftView, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a() ^ true);
    ContactMatch localContactMatch = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!TextUtils.isEmpty(localContactMatch.name))
    {
      localContactMatchHolder.h.setVisibility(0);
      localContactMatchHolder.h.setText(localContactMatch.name);
      if (AppSetting.d) {
        localStringBuilder.append(localContactMatch.name);
      }
    }
    else
    {
      localContactMatchHolder.h.setVisibility(8);
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(localContactMatchHolder.l, localContactMatch.gender, localContactMatch.age, localStringBuilder);
    localContactMatchHolder.i.setVisibility(8);
    localContactMatchHolder.j.setText(HardCodeUtil.a(2131702683));
    localContactMatchHolder.j.setVisibility(0);
    if (AppSetting.d) {
      localStringBuilder.append(",来自手机通讯录");
    }
    if (((IAddFriendServiceApi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(localContactMatch.unifiedCode, true))
    {
      localContactMatchHolder.a.setVisibility(8);
      localContactMatchHolder.k.setVisibility(0);
      localContactMatchHolder.k.setText(HardCodeUtil.a(2131702684));
      if (AppSetting.d)
      {
        localStringBuilder.append(",等待验证");
        localContactMatchHolder.k.setContentDescription(HardCodeUtil.a(2131702684));
      }
    }
    else
    {
      localContactMatchHolder.a.setVisibility(0);
      localContactMatchHolder.a.setText(HardCodeUtil.a(2131689589));
      localContactMatchHolder.a.setTag(localContactMatch);
      localContactMatchHolder.a.setOnClickListener(this);
      localContactMatchHolder.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",添加");
        localContactMatchHolder.a.setContentDescription(HardCodeUtil.a(2131702681));
      }
    }
    if (AppSetting.d) {
      paramView.setContentDescription(localStringBuilder.toString());
    }
    localContactMatchHolder.jdField_f_of_type_JavaLangString = localContactMatch.unifiedCode;
    localContactMatchHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(11, localContactMatch.unifiedCode));
    return paramView;
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131376644)
    {
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactMatchBuilder.ContactMatchHolder)))
      {
        ContactMatch localContactMatch = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
        if (localContactMatch != null)
        {
          if (((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
            localObject = new AllInOne(localContactMatch.unifiedCode, 34);
          } else {
            localObject = new AllInOne(localContactMatch.unifiedCode, 29);
          }
          ((AllInOne)localObject).nickname = localContactMatch.name;
          ProfileUtils.openProfileCardForResult((Activity)this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject, 229);
          this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.markRecommendReaded();
        }
      }
    }
    else if (i == 2131376477)
    {
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactMatch))) {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 0).b(c());
        }
        else
        {
          localObject = (ContactMatch)localObject;
          if (localObject != null)
          {
            int j;
            if (!((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
            {
              i = 3075;
              j = 1;
            }
            else
            {
              i = 3006;
              j = 3;
            }
            localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 2, ((ContactMatch)localObject).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject).name, null, null, HardCodeUtil.a(2131702682), null);
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 229);
          }
          this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.markRecommendReaded();
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder
 * JD-Core Version:    0.7.0.1
 */