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
    this.f = a(paramContext);
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
      paramView = a(this.c, 2131627870, localPhoneContactAddHolder);
      localPhoneContactAddHolder.w = ((ImageView)paramView.findViewById(2131427337));
      localPhoneContactAddHolder.x = ((TextView)paramView.findViewById(2131439320));
      localPhoneContactAddHolder.y = ((TextView)paramView.findViewById(2131444728));
      localPhoneContactAddHolder.C = ((TextView)paramView.findViewById(2131427898));
      localPhoneContactAddHolder.z = ((TextView)paramView.findViewById(2131446184));
      localPhoneContactAddHolder.B = ((TextView)paramView.findViewById(2131444726));
      localPhoneContactAddHolder.A = ((Button)paramView.findViewById(2131444718));
      b(localPhoneContactAddHolder.w);
      paramView.setTag(localPhoneContactAddHolder);
    }
    localPhoneContactAddHolder.leftView.setTag(localPhoneContactAddHolder);
    localPhoneContactAddHolder.leftView.setOnClickListener(this);
    a(this.c, paramView, paramInt, this.g, localPhoneContactAddHolder, this);
    NewFriendUtil.a(localPhoneContactAddHolder.leftView, false);
    PhoneContactAdd localPhoneContactAdd = ((PhoneContactAddMessage)this.g).a;
    if (!TextUtils.isEmpty(localPhoneContactAdd.name))
    {
      localPhoneContactAddHolder.x.setVisibility(0);
      localPhoneContactAddHolder.x.setText(localPhoneContactAdd.name);
    }
    else
    {
      localPhoneContactAddHolder.x.setVisibility(8);
    }
    localPhoneContactAddHolder.C.setVisibility(8);
    localPhoneContactAddHolder.z.setVisibility(8);
    if (!TextUtils.isEmpty(localPhoneContactAdd.remindInfo))
    {
      localPhoneContactAddHolder.y.setVisibility(0);
      localPhoneContactAddHolder.y.setText(localPhoneContactAdd.remindInfo);
    }
    else
    {
      localPhoneContactAddHolder.y.setVisibility(8);
    }
    localPhoneContactAddHolder.B.setVisibility(0);
    localPhoneContactAddHolder.A.setVisibility(8);
    localPhoneContactAddHolder.B.setText(this.c.getString(2131915704));
    localPhoneContactAddHolder.D = localPhoneContactAdd.unifiedCode;
    localPhoneContactAddHolder.w.setImageBitmap(this.e.a(11, localPhoneContactAdd.unifiedCode));
    return paramView;
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new PhoneContactAddBuilder.1(this), null, true);
  }
  
  protected int b()
  {
    return 1;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131444905)
    {
      if ((paramView.getTag() instanceof PhoneContactAddBuilder.PhoneContactAddHolder))
      {
        PhoneContactAdd localPhoneContactAdd = ((PhoneContactAddMessage)this.g).a;
        if (localPhoneContactAdd != null)
        {
          Object localObject = (IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "");
          if (((IPhoneContactService)localObject).queryContactByCodeNumber(localPhoneContactAdd.unifiedCode) == null) {
            localObject = new AllInOne(localPhoneContactAdd.unifiedCode, 29);
          } else if (((IPhoneContactService)localObject).isBindedIgnoreUpload()) {
            localObject = new AllInOne(localPhoneContactAdd.unifiedCode, 34);
          } else {
            localObject = new AllInOne(localPhoneContactAdd.unifiedCode, 29);
          }
          ((AllInOne)localObject).nickname = localPhoneContactAdd.name;
          ProfileUtils.openProfileCardForResult((Activity)this.c, (AllInOne)localObject, 227);
          ((INewFriendService)this.d.getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
        }
      }
    }
    else {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder
 * JD-Core Version:    0.7.0.1
 */