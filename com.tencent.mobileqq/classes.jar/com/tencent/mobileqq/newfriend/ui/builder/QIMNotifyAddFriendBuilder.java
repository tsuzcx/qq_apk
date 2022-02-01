package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class QIMNotifyAddFriendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public QIMNotifyAddFriendBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.f = a(paramContext);
    this.h = paramContext.getResources().getDimensionPixelSize(2131298132);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    if ((paramView != null) && ((paramView.getTag() instanceof QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder)))
    {
      localObject = (QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    else
    {
      paramView = new QIMNotifyAddFriendBuilder.QIMNotifyAddFriendHolder();
      localView = a(this.c, 2131627870, paramView);
      a(localView, this.h);
      paramView.w = ((ImageView)localView.findViewById(2131427337));
      paramView.x = ((TextView)localView.findViewById(2131439320));
      paramView.y = ((TextView)localView.findViewById(2131444728));
      paramView.C = ((TextView)localView.findViewById(2131427898));
      paramView.z = ((TextView)localView.findViewById(2131446184));
      paramView.B = ((TextView)localView.findViewById(2131444726));
      paramView.A = ((Button)localView.findViewById(2131444718));
      b(paramView.w);
      localView.setTag(paramView);
    }
    paramView.leftView.setTag(paramView);
    paramView.leftView.setClickable(false);
    a(this.c, localView, paramInt, this.g, paramView, this);
    StringBuilder localStringBuilder = new StringBuilder(256);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.g).a;
    paramView.x.setText(localQIMNotifyAddFriend.nickName);
    if (AppSetting.e) {
      localStringBuilder.append(localQIMNotifyAddFriend.nickName);
    }
    NewFriendUtil.a(paramView.leftView, this.g.b() ^ true);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramView.C, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
    Object localObject = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQQInfoFromQQUin(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin, this.d);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView.y.setVisibility(8);
    }
    else
    {
      paramView.y.setVisibility(0);
      paramView.y.setText((CharSequence)localObject);
      if (AppSetting.e)
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
      }
    }
    String str = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQIMNewFriendSource(this.d);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "来自QIM的好友申请";
    }
    localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131905340), new Object[] { localObject });
    paramView.z.setText((CharSequence)localObject);
    paramView.z.setVisibility(0);
    if (AppSetting.e)
    {
      localStringBuilder.append(",");
      localStringBuilder.append((String)localObject);
    }
    paramView.B.setVisibility(8);
    paramView.A.setText(HardCodeUtil.a(2131905336));
    paramView.A.setVisibility(0);
    paramView.A.setOnClickListener(this);
    paramView.D = String.valueOf(localQIMNotifyAddFriend.uin);
    paramView.w.setImageBitmap(this.e.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
    if (AppSetting.e) {
      localView.setContentDescription(localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
    return localView;
  }
  
  protected void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
  }
  
  protected int b()
  {
    return 1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131444905) {
      if (i == 2131444718)
      {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.c, null, this.d);
        ((INewFriendService)this.d.getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
        QIMNotifyAddFriend localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.g).a;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localQIMNotifyAddFriend);
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).addBatchQIMFriends(localArrayList, this.d);
        ReportController.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
      }
      else
      {
        a(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder
 * JD-Core Version:    0.7.0.1
 */