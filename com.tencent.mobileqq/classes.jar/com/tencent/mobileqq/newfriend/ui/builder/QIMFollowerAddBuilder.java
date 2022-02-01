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
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

public class QIMFollowerAddBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public QIMFollowerAddBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.f = a(paramContext);
    this.h = this.c.getResources().getDimensionPixelSize(2131298134);
  }
  
  public View a(int paramInt, View paramView)
  {
    QIMFollowerAddBuilder.QIMFollowerAddHolder localQIMFollowerAddHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof QIMFollowerAddBuilder.QIMFollowerAddHolder)))
    {
      localQIMFollowerAddHolder = (QIMFollowerAddBuilder.QIMFollowerAddHolder)paramView.getTag();
    }
    else
    {
      localQIMFollowerAddHolder = new QIMFollowerAddBuilder.QIMFollowerAddHolder();
      paramView = a(this.c, 2131627870, localQIMFollowerAddHolder);
      a(paramView, this.h);
      localQIMFollowerAddHolder.w = ((ImageView)paramView.findViewById(2131427337));
      localQIMFollowerAddHolder.x = ((TextView)paramView.findViewById(2131439320));
      localQIMFollowerAddHolder.y = ((TextView)paramView.findViewById(2131444728));
      localQIMFollowerAddHolder.C = ((TextView)paramView.findViewById(2131427898));
      localQIMFollowerAddHolder.z = ((TextView)paramView.findViewById(2131446184));
      localQIMFollowerAddHolder.B = ((TextView)paramView.findViewById(2131444726));
      localQIMFollowerAddHolder.A = ((Button)paramView.findViewById(2131444718));
      b(localQIMFollowerAddHolder.w);
      paramView.setTag(localQIMFollowerAddHolder);
    }
    localQIMFollowerAddHolder.leftView.setTag(localQIMFollowerAddHolder);
    localQIMFollowerAddHolder.leftView.setOnClickListener(this);
    a(this.c, paramView, paramInt, this.g, localQIMFollowerAddHolder, this);
    localQIMFollowerAddHolder.leftView.setBackgroundResource(2130839574);
    QIMFollwerAdd localQIMFollwerAdd = ((QIMFollowMessage)this.g).a;
    if (!TextUtils.isEmpty(localQIMFollwerAdd.smartRemark))
    {
      localQIMFollowerAddHolder.x.setVisibility(0);
      localQIMFollowerAddHolder.x.setText(localQIMFollwerAdd.smartRemark);
    }
    else
    {
      localQIMFollowerAddHolder.x.setVisibility(8);
    }
    NewFriendUtil.a(localQIMFollowerAddHolder.leftView, this.g.b() ^ true);
    Object localObject = new StringBuilder(256);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(localQIMFollowerAddHolder.C, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
    if (TextUtils.isEmpty(localQIMFollwerAdd.longNick))
    {
      localQIMFollowerAddHolder.y.setVisibility(8);
    }
    else
    {
      localQIMFollowerAddHolder.y.setVisibility(0);
      localQIMFollowerAddHolder.y.setText(localQIMFollwerAdd.longNick);
      if (AppSetting.e)
      {
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(localQIMFollwerAdd.longNick);
      }
    }
    if (!TextUtils.isEmpty(localQIMFollwerAdd.source))
    {
      localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131905340), new Object[] { localQIMFollwerAdd.source });
      localQIMFollowerAddHolder.z.setText((CharSequence)localObject);
      localQIMFollowerAddHolder.z.setVisibility(0);
    }
    else
    {
      localQIMFollowerAddHolder.z.setVisibility(8);
    }
    localQIMFollowerAddHolder.B.setVisibility(8);
    localQIMFollowerAddHolder.A.setText(HardCodeUtil.a(2131905336));
    localQIMFollowerAddHolder.A.setVisibility(0);
    localQIMFollowerAddHolder.A.setOnClickListener(this);
    localQIMFollowerAddHolder.D = String.valueOf(localQIMFollwerAdd.uin);
    localQIMFollowerAddHolder.w.setImageBitmap(this.e.a(1, String.valueOf(localQIMFollwerAdd.uin)));
    return paramView;
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new QIMFollowerAddBuilder.1(this), null, true);
  }
  
  protected int b()
  {
    return 1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131444905) {
      if (i == 2131444718) {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.c, null, this.d);
      } else {
        a(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder
 * JD-Core Version:    0.7.0.1
 */