package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.MayKnowMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class MayKnowRecommendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  protected int a = 0;
  private NewFriendServiceImpl b;
  private int i;
  
  public MayKnowRecommendBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.i = paramInt;
    this.f = a(paramContext);
    this.b = ((NewFriendServiceImpl)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    this.h = this.c.getResources().getDimensionPixelSize(2131298134);
  }
  
  public static void a(Activity paramActivity, AllInOne paramAllInOne, int paramInt, Bundle paramBundle)
  {
    if (paramActivity != null) {
      try
      {
        paramAllInOne = ProfileUtils.getIntent(paramActivity, paramAllInOne);
        paramAllInOne.addFlags(536870912);
        if (paramBundle != null) {
          paramAllInOne.putExtra("profile_extra", paramBundle);
        }
        paramActivity.startActivityForResult(paramAllInOne, paramInt);
        return;
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MayKnowRecommendBuilder", 2, paramActivity.toString());
        }
      }
    }
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    if ((paramView != null) && ((paramView.getTag() instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder)))
    {
      localObject1 = (MayKnowRecommendBuilder.MayKnowRecommendHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    else
    {
      paramView = new MayKnowRecommendBuilder.MayKnowRecommendHolder();
      localView = a(this.c, 2131627872, paramView);
      paramView.w = ((ImageView)localView.findViewById(2131427337));
      paramView.x = ((TextView)localView.findViewById(2131439320));
      paramView.B = ((TextView)localView.findViewById(2131444726));
      paramView.A = ((Button)localView.findViewById(2131444718));
      paramView.F = ((TroopLabelLayout)localView.findViewById(2131448010));
      paramView.F.setLabelType(1);
      paramView.G = ((TextView)localView.findViewById(2131438023));
      paramView.a = ((TextView)localView.findViewById(2131446568));
      b(paramView.w);
      localView.setTag(paramView);
    }
    paramView.leftView.setTag(paramView);
    paramView.leftView.setOnClickListener(this);
    a(this.c, localView, paramInt, this.g, paramView, this);
    Object localObject1 = ((MayKnowMessage)this.g).a;
    if (!this.g.b())
    {
      NewFriendUtil.a(paramView.leftView, true);
      if (Utils.c(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
        ReportController.b(this.d, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
    }
    else
    {
      NewFriendUtil.a(paramView.leftView, false);
    }
    if (this.e.m() == 23) {
      c();
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    boolean bool = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled(this.d);
    Object localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramView.x.setVisibility(0);
      paramView.x.setText((CharSequence)localObject2);
      if (AppSetting.e) {
        localStringBuilder.append((String)localObject2);
      }
    }
    else
    {
      paramView.x.setVisibility(8);
    }
    if ((!TextUtils.isEmpty(((MayKnowRecommend)localObject1).uin)) && (Utils.c(((MayKnowRecommend)localObject1).uin)))
    {
      localObject2 = this.c.getResources().getDrawable(2130842755);
      ((Drawable)localObject2).setBounds(0, 0, ViewUtils.dpToPx(15.0F), ViewUtils.dpToPx(15.0F));
      paramView.x.setCompoundDrawables(null, null, (Drawable)localObject2, null);
    }
    else
    {
      paramView.x.setCompoundDrawables(null, null, null, null);
    }
    if (TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason))
    {
      paramView.G.setVisibility(8);
    }
    else
    {
      paramView.G.setText(((MayKnowRecommend)localObject1).recommendReason);
      if (AppSetting.e)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(((MayKnowRecommend)localObject1).recommendReason);
      }
    }
    paramView.F.a(RecommendLabel.convertToRecommendLabel(((MayKnowRecommend)localObject1).msgLabel), ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age);
    if (((MayKnowRecommend)localObject1).friendStatus == 0)
    {
      paramView.A.setOnClickListener(this);
      paramView.A.setVisibility(0);
      paramView.A.setText(HardCodeUtil.a(2131886199));
      paramView.A.setTag(localObject1);
      paramView.B.setVisibility(8);
      if (AppSetting.e)
      {
        localStringBuilder.append(",点击添加");
        paramView.A.setContentDescription(HardCodeUtil.a(2131886199));
      }
    }
    else if (((MayKnowRecommend)localObject1).friendStatus == 1)
    {
      paramView.A.setVisibility(8);
      paramView.B.setVisibility(0);
      paramView.B.setText(2131915704);
      if (AppSetting.e)
      {
        localStringBuilder.append(",等待验证");
        paramView.B.setContentDescription(HardCodeUtil.a(2131900674));
      }
    }
    else
    {
      paramView.A.setVisibility(8);
      paramView.B.setVisibility(0);
      paramView.B.setText(2131886630);
      if (AppSetting.e)
      {
        localStringBuilder.append(",已添加");
        paramView.B.setContentDescription(HardCodeUtil.a(2131886630));
      }
    }
    if (AppSetting.e) {
      localView.setContentDescription(localStringBuilder.toString());
    }
    paramView.D = ((MayKnowRecommend)localObject1).uin;
    paramView.w.setImageBitmap(this.e.a(1, ((MayKnowRecommend)localObject1).uin));
    a(paramView.a, (MayKnowRecommend)localObject1, bool);
    return localView;
  }
  
  protected void a()
  {
    if (!NetworkUtil.isNetworkAvailable(this.c))
    {
      QQToast.makeText(this.c, this.c.getResources().getString(2131889169), 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    String str = ((MayKnowMessage)this.g).a.uin;
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).cancelMayKnowRecommend(str, this.d);
    this.e.a(this);
    this.e.a(200L);
    ReportController.b(this.d, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    MayKnowRecommend localMayKnowRecommend = ((MayKnowMessage)this.g).a;
    List localList = null;
    if (localMayKnowRecommend != null) {
      localList = localMayKnowRecommend.msgLabel;
    }
    int j = this.e.m();
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.d, str, "frd_list_dlt", j, 0, ((MayKnowMessage)this.g).a.recommendReason, this.a, ((MayKnowMessage)this.g).a.algBuffer, ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(localList), 0);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend, boolean paramBoolean)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    Object localObject = paramMayKnowRecommend.getDisplayName(paramBoolean);
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!((String)localObject).equals(paramMayKnowRecommend.mobile_name)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramMayKnowRecommend.mobile_name);
      ((StringBuilder)localObject).append(")");
      paramTextView.setText(((StringBuilder)localObject).toString());
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  protected int b()
  {
    return 1;
  }
  
  public void c()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStartExpose(((MayKnowMessage)this.g).a, 23, this.i, 1, this.d);
  }
  
  public void d()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStopExpose(((MayKnowMessage)this.g).a, 23, this.i, 1, this.d);
  }
  
  public String e()
  {
    return ((MayKnowMessage)this.g).a.recommendReason;
  }
  
  public String f()
  {
    return ((MayKnowMessage)this.g).a.uin;
  }
  
  public int g()
  {
    return this.a;
  }
  
  public byte[] h()
  {
    return ((MayKnowMessage)this.g).a.algBuffer;
  }
  
  public void onClick(View paramView)
  {
    int k = this.e.m();
    int m = paramView.getId();
    int j = 1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (m == 2131444905)
    {
      if ((paramView.getTag() instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder))
      {
        localObject1 = ((MayKnowMessage)this.g).a;
        if (localObject1 != null)
        {
          if (!((IFriendDataService)this.d.getRuntimeService(IFriendDataService.class, "")).isFriend(((MayKnowRecommend)localObject1).uin)) {
            j = 110;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onClick rlSystemMsg， friendtype=");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(", gameSourceId=");
            ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).recommendReason);
            QLog.d("MayKnowRecommendBuilder", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, j);
          localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled(this.d));
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((AllInOne)localObject2).recommendName = ((String)localObject3);
          }
          if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
            ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
          }
          localObject3 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(((MayKnowRecommend)localObject1).msgLabel);
          ((AllInOne)localObject2).profileEntryType = 88;
          Bundle localBundle = new Bundle();
          localBundle.putString("recommend_entry_type", "3");
          localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
          localBundle.putInt("recommend_pos", this.a);
          localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
          localBundle.putString("recommend_label", (String)localObject3);
          localBundle.putInt("tabID", k);
          a((Activity)this.c, (AllInOne)localObject2, 228, localBundle);
          this.b.markRecommendReaded();
          if (k == 23) {
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStartExpose((MayKnowRecommend)localObject1, 23, this.i, 2, this.d);
          }
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.d, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", k, 0, ((MayKnowRecommend)localObject1).recommendReason, this.a, ((MayKnowRecommend)localObject1).algBuffer, (String)localObject3, 0);
        }
      }
    }
    else if (m == 2131444718)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof MayKnowRecommend)) {
        if (!NetworkUtil.isNetworkAvailable(this.c))
        {
          QQToast.makeText(this.c, this.c.getResources().getString(2131889169), 0).show(i());
        }
        else
        {
          localObject1 = (MayKnowRecommend)localObject1;
          localObject2 = (IFriendDataService)this.d.getRuntimeService(IFriendDataService.class, "");
          localObject3 = (IAddFriendServiceApi)this.d.getRuntimeService(IAddFriendServiceApi.class, "");
          if ((!((IFriendDataService)localObject2).isFriend(((MayKnowRecommend)localObject1).uin)) && (!((IAddFriendServiceApi)localObject3).hasSendAddFriendReq(((MayKnowRecommend)localObject1).uin)))
          {
            localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled(this.d));
            j = this.e.m();
            localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.c, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, j, (String)localObject2, null, null, this.c.getString(2131886199), null);
            ReportController.b(this.d, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(j), "", "", "");
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)this.c, (Intent)localObject2, 228);
          }
          else if (((IFriendDataService)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))
          {
            ((MayKnowRecommend)localObject1).friendStatus = 2;
            this.e.notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject1).friendStatus = 1;
            this.e.notifyDataSetChanged();
          }
          this.b.markRecommendReaded();
          ReportController.b(this.d, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
          if (Utils.c(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
            ReportController.b(this.d, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
          }
          if (k == 23) {
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStartExpose((MayKnowRecommend)localObject1, 23, this.i, 3, this.d);
          }
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.d, ((MayKnowRecommend)localObject1).uin, "frd_list_add", k, 1, ((MayKnowRecommend)localObject1).recommendReason, this.a, ((MayKnowRecommend)localObject1).algBuffer, ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(((MayKnowRecommend)localObject1).msgLabel), 0);
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
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder
 * JD-Core Version:    0.7.0.1
 */