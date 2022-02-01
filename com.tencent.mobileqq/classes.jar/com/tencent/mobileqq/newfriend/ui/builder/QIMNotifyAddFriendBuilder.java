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
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.b = paramContext.getResources().getDimensionPixelSize(2131297481);
  }
  
  protected int a()
  {
    return 1;
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
      localView = a(this.jdField_a_of_type_AndroidContentContext, 2131561509, paramView);
      a(localView, this.b);
      paramView.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.h = ((TextView)localView.findViewById(2131371877));
      paramView.i = ((TextView)localView.findViewById(2131376487));
      paramView.l = ((TextView)localView.findViewById(2131362299));
      paramView.j = ((TextView)localView.findViewById(2131377726));
      paramView.k = ((TextView)localView.findViewById(2131376485));
      paramView.a = ((Button)localView.findViewById(2131376477));
      b(paramView.jdField_f_of_type_AndroidWidgetImageView);
      localView.setTag(paramView);
    }
    paramView.leftView.setTag(paramView);
    paramView.leftView.setClickable(false);
    a(this.jdField_a_of_type_AndroidContentContext, localView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage, paramView, this);
    StringBuilder localStringBuilder = new StringBuilder(256);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    paramView.h.setText(localQIMNotifyAddFriend.nickName);
    if (AppSetting.d) {
      localStringBuilder.append(localQIMNotifyAddFriend.nickName);
    }
    NewFriendUtil.a(paramView.leftView, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a() ^ true);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramView.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
    Object localObject = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQQInfoFromQQUin(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView.i.setVisibility(8);
    }
    else
    {
      paramView.i.setVisibility(0);
      paramView.i.setText((CharSequence)localObject);
      if (AppSetting.d)
      {
        localStringBuilder.append(",");
        localStringBuilder.append((String)localObject);
      }
    }
    String str = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQIMNewFriendSource(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "来自QIM的好友申请";
    }
    localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131707525), new Object[] { localObject });
    paramView.j.setText((CharSequence)localObject);
    paramView.j.setVisibility(0);
    if (AppSetting.d)
    {
      localStringBuilder.append(",");
      localStringBuilder.append((String)localObject);
    }
    paramView.k.setVisibility(8);
    paramView.a.setText(HardCodeUtil.a(2131707521));
    paramView.a.setVisibility(0);
    paramView.a.setOnClickListener(this);
    paramView.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
    paramView.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
    if (AppSetting.d) {
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
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131376644) {
      if (i == 2131376477)
      {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        ((INewFriendService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
        QIMNotifyAddFriend localQIMNotifyAddFriend = ((QIMNotifyAddFriendMsg)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localQIMNotifyAddFriend);
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).addBatchQIMFriends(localArrayList, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder
 * JD-Core Version:    0.7.0.1
 */