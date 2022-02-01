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
    this.a = ((NewFriendServiceImpl)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    this.f = a(paramContext);
    this.h = this.c.getResources().getDimensionPixelSize(2131298134);
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
      paramView = a(this.c, 2131627870, localContactMatchHolder);
      a(paramView, this.h);
      localContactMatchHolder.w = ((ImageView)paramView.findViewById(2131427337));
      localContactMatchHolder.x = ((TextView)paramView.findViewById(2131439320));
      localContactMatchHolder.y = ((TextView)paramView.findViewById(2131444728));
      localContactMatchHolder.C = ((TextView)paramView.findViewById(2131427898));
      localContactMatchHolder.z = ((TextView)paramView.findViewById(2131446184));
      localContactMatchHolder.B = ((TextView)paramView.findViewById(2131444726));
      localContactMatchHolder.A = ((Button)paramView.findViewById(2131444718));
      b(localContactMatchHolder.w);
      paramView.setTag(localContactMatchHolder);
    }
    localContactMatchHolder.leftView.setTag(localContactMatchHolder);
    localContactMatchHolder.leftView.setOnClickListener(this);
    a(this.c, paramView, paramInt, this.g, localContactMatchHolder, this);
    NewFriendUtil.a(localContactMatchHolder.leftView, this.g.b() ^ true);
    ContactMatch localContactMatch = ((ContactMatchMessage)this.g).a;
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!TextUtils.isEmpty(localContactMatch.name))
    {
      localContactMatchHolder.x.setVisibility(0);
      localContactMatchHolder.x.setText(localContactMatch.name);
      if (AppSetting.e) {
        localStringBuilder.append(localContactMatch.name);
      }
    }
    else
    {
      localContactMatchHolder.x.setVisibility(8);
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(localContactMatchHolder.C, localContactMatch.gender, localContactMatch.age, localStringBuilder);
    localContactMatchHolder.y.setVisibility(8);
    localContactMatchHolder.z.setText(HardCodeUtil.a(2131900673));
    localContactMatchHolder.z.setVisibility(0);
    if (AppSetting.e) {
      localStringBuilder.append(",来自手机通讯录");
    }
    if (((IAddFriendServiceApi)this.d.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(localContactMatch.unifiedCode, true))
    {
      localContactMatchHolder.A.setVisibility(8);
      localContactMatchHolder.B.setVisibility(0);
      localContactMatchHolder.B.setText(HardCodeUtil.a(2131900674));
      if (AppSetting.e)
      {
        localStringBuilder.append(",等待验证");
        localContactMatchHolder.B.setContentDescription(HardCodeUtil.a(2131900674));
      }
    }
    else
    {
      localContactMatchHolder.A.setVisibility(0);
      localContactMatchHolder.A.setText(HardCodeUtil.a(2131886199));
      localContactMatchHolder.A.setTag(localContactMatch);
      localContactMatchHolder.A.setOnClickListener(this);
      localContactMatchHolder.B.setVisibility(8);
      if (AppSetting.e)
      {
        localStringBuilder.append(",添加");
        localContactMatchHolder.A.setContentDescription(HardCodeUtil.a(2131900671));
      }
    }
    if (AppSetting.e) {
      paramView.setContentDescription(localStringBuilder.toString());
    }
    localContactMatchHolder.D = localContactMatch.unifiedCode;
    localContactMatchHolder.w.setImageBitmap(this.e.a(11, localContactMatch.unifiedCode));
    return paramView;
  }
  
  protected void a()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    ReportController.b(this.d, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131444905)
    {
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactMatchBuilder.ContactMatchHolder)))
      {
        ContactMatch localContactMatch = ((ContactMatchMessage)this.g).a;
        if (localContactMatch != null)
        {
          if (((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
            localObject = new AllInOne(localContactMatch.unifiedCode, 34);
          } else {
            localObject = new AllInOne(localContactMatch.unifiedCode, 29);
          }
          ((AllInOne)localObject).nickname = localContactMatch.name;
          ProfileUtils.openProfileCardForResult((Activity)this.c, (AllInOne)localObject, 229);
          this.a.markRecommendReaded();
        }
      }
    }
    else if (i == 2131444718)
    {
      localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactMatch))) {
        if (!NetworkUtil.isNetworkAvailable(this.c))
        {
          QQToast.makeText(this.c, this.c.getResources().getString(2131889169), 0).show(i());
        }
        else
        {
          localObject = (ContactMatch)localObject;
          if (localObject != null)
          {
            int j;
            if (!((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
            {
              i = 3075;
              j = 1;
            }
            else
            {
              i = 3006;
              j = 3;
            }
            localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.c, 2, ((ContactMatch)localObject).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject).name, null, null, HardCodeUtil.a(2131900672), null);
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)this.c, (Intent)localObject, 229);
          }
          this.a.markRecommendReaded();
          ReportController.b(this.d, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder
 * JD-Core Version:    0.7.0.1
 */