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
  protected int a;
  private NewFriendServiceImpl a;
  private int c;
  
  public MayKnowRecommendBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage, int paramInt)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Int = 0;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl = ((NewFriendServiceImpl)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297483);
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
  
  protected int a()
  {
    return 1;
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
      localView = a(this.jdField_a_of_type_AndroidContentContext, 2131561511, paramView);
      paramView.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.h = ((TextView)localView.findViewById(2131371877));
      paramView.k = ((TextView)localView.findViewById(2131376485));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376477));
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)localView.findViewById(2131379273));
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramView.m = ((TextView)localView.findViewById(2131370723));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378068));
      b(paramView.jdField_f_of_type_AndroidWidgetImageView);
      localView.setTag(paramView);
    }
    paramView.leftView.setTag(paramView);
    paramView.leftView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidContentContext, localView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage, paramView, this);
    Object localObject1 = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    if (!this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a())
    {
      NewFriendUtil.a(paramView.leftView, true);
      if (Utils.b(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
    }
    else
    {
      NewFriendUtil.a(paramView.leftView, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b() == 23) {
      b();
    }
    StringBuilder localStringBuilder = new StringBuilder(256);
    boolean bool = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramView.h.setVisibility(0);
      paramView.h.setText((CharSequence)localObject2);
      if (AppSetting.d) {
        localStringBuilder.append((String)localObject2);
      }
    }
    else
    {
      paramView.h.setVisibility(8);
    }
    if ((!TextUtils.isEmpty(((MayKnowRecommend)localObject1).uin)) && (Utils.b(((MayKnowRecommend)localObject1).uin)))
    {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841838);
      ((Drawable)localObject2).setBounds(0, 0, ViewUtils.b(15.0F), ViewUtils.b(15.0F));
      paramView.h.setCompoundDrawables(null, null, (Drawable)localObject2, null);
    }
    else
    {
      paramView.h.setCompoundDrawables(null, null, null, null);
    }
    if (TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason))
    {
      paramView.m.setVisibility(8);
    }
    else
    {
      paramView.m.setText(((MayKnowRecommend)localObject1).recommendReason);
      if (AppSetting.d)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(((MayKnowRecommend)localObject1).recommendReason);
      }
    }
    paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(RecommendLabel.convertToRecommendLabel(((MayKnowRecommend)localObject1).msgLabel), ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age);
    if (((MayKnowRecommend)localObject1).friendStatus == 0)
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject1);
      paramView.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",点击添加");
        paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
      }
    }
    else if (((MayKnowRecommend)localObject1).friendStatus == 1)
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.k.setVisibility(0);
      paramView.k.setText(2131718222);
      if (AppSetting.d)
      {
        localStringBuilder.append(",等待验证");
        paramView.k.setContentDescription(HardCodeUtil.a(2131702684));
      }
    }
    else
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.k.setVisibility(0);
      paramView.k.setText(2131689988);
      if (AppSetting.d)
      {
        localStringBuilder.append(",已添加");
        paramView.k.setContentDescription(HardCodeUtil.a(2131689988));
      }
    }
    if (AppSetting.d) {
      localView.setContentDescription(localStringBuilder.toString());
    }
    paramView.jdField_f_of_type_JavaLangString = ((MayKnowRecommend)localObject1).uin;
    paramView.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(1, ((MayKnowRecommend)localObject1).uin));
    a(paramView.jdField_a_of_type_AndroidWidgetTextView, (MayKnowRecommend)localObject1, bool);
    return localView;
  }
  
  public String a()
  {
    return ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.recommendReason;
  }
  
  protected void a()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    String str = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.uin;
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).cancelMayKnowRecommend(str, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(200L);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    MayKnowRecommend localMayKnowRecommend = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    List localList = null;
    if (localMayKnowRecommend != null) {
      localList = localMayKnowRecommend.msgLabel;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b();
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, "frd_list_dlt", i, 0, ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.recommendReason, this.jdField_a_of_type_Int, ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.algBuffer, ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(localList), 0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
  
  public byte[] a()
  {
    return ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.uin;
  }
  
  public void b()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStartExpose(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a, 23, this.c, 1, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void c()
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStopExpose(((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a, 23, this.c, 1, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b();
    int k = paramView.getId();
    int i = 1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (k == 2131376644)
    {
      if ((paramView.getTag() instanceof MayKnowRecommendBuilder.MayKnowRecommendHolder))
      {
        localObject1 = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
        if (localObject1 != null)
        {
          if (!((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(((MayKnowRecommend)localObject1).uin)) {
            i = 110;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onClick rlSystemMsg， friendtype=");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(", gameSourceId=");
            ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).recommendReason);
            QLog.d("MayKnowRecommendBuilder", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i);
          localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
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
          localBundle.putInt("recommend_pos", this.jdField_a_of_type_Int);
          localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
          localBundle.putString("recommend_label", (String)localObject3);
          localBundle.putInt("tabID", j);
          a((Activity)this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject2, 228, localBundle);
          this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.markRecommendReaded();
          if (j == 23) {
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStartExpose((MayKnowRecommend)localObject1, 23, this.c, 2, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          }
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", j, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, (String)localObject3, 0);
        }
      }
    }
    else if (k == 2131376477)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof MayKnowRecommend)) {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 0).b(c());
        }
        else
        {
          localObject1 = (MayKnowRecommend)localObject1;
          localObject2 = (IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "");
          localObject3 = (IAddFriendServiceApi)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IAddFriendServiceApi.class, "");
          if ((!((IFriendDataService)localObject2).isFriend(((MayKnowRecommend)localObject1).uin)) && (!((IAddFriendServiceApi)localObject3).hasSendAddFriendReq(((MayKnowRecommend)localObject1).uin)))
          {
            localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isPhoneContactEnabled(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
            i = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.b();
            localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689589), null);
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, 228);
          }
          else if (((IFriendDataService)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))
          {
            ((MayKnowRecommend)localObject1).friendStatus = 2;
            this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject1).friendStatus = 1;
            this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.notifyDataSetChanged();
          }
          this.jdField_a_of_type_ComTencentMobileqqNewfriendApiImplNewFriendServiceImpl.markRecommendReaded();
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
          if (Utils.b(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
          }
          if (j == 23) {
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).recordStartExpose((MayKnowRecommend)localObject1, 23, this.c, 3, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          }
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).reportRecommend(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", j, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getRecommendLabelString(((MayKnowRecommend)localObject1).msgLabel), 0);
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
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.MayKnowRecommendBuilder
 * JD-Core Version:    0.7.0.1
 */