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
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297483);
  }
  
  protected int a()
  {
    return 1;
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
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561509, localQIMFollowerAddHolder);
      a(paramView, this.b);
      localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
      localQIMFollowerAddHolder.h = ((TextView)paramView.findViewById(2131371877));
      localQIMFollowerAddHolder.i = ((TextView)paramView.findViewById(2131376487));
      localQIMFollowerAddHolder.l = ((TextView)paramView.findViewById(2131362299));
      localQIMFollowerAddHolder.j = ((TextView)paramView.findViewById(2131377726));
      localQIMFollowerAddHolder.k = ((TextView)paramView.findViewById(2131376485));
      localQIMFollowerAddHolder.a = ((Button)paramView.findViewById(2131376477));
      b(localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localQIMFollowerAddHolder);
    }
    localQIMFollowerAddHolder.leftView.setTag(localQIMFollowerAddHolder);
    localQIMFollowerAddHolder.leftView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage, localQIMFollowerAddHolder, this);
    localQIMFollowerAddHolder.leftView.setBackgroundResource(2130839390);
    QIMFollwerAdd localQIMFollwerAdd = ((QIMFollowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    if (!TextUtils.isEmpty(localQIMFollwerAdd.smartRemark))
    {
      localQIMFollowerAddHolder.h.setVisibility(0);
      localQIMFollowerAddHolder.h.setText(localQIMFollwerAdd.smartRemark);
    }
    else
    {
      localQIMFollowerAddHolder.h.setVisibility(8);
    }
    NewFriendUtil.a(localQIMFollowerAddHolder.leftView, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a() ^ true);
    Object localObject = new StringBuilder(256);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(localQIMFollowerAddHolder.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
    if (TextUtils.isEmpty(localQIMFollwerAdd.longNick))
    {
      localQIMFollowerAddHolder.i.setVisibility(8);
    }
    else
    {
      localQIMFollowerAddHolder.i.setVisibility(0);
      localQIMFollowerAddHolder.i.setText(localQIMFollwerAdd.longNick);
      if (AppSetting.d)
      {
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(localQIMFollwerAdd.longNick);
      }
    }
    if (!TextUtils.isEmpty(localQIMFollwerAdd.source))
    {
      localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131707525), new Object[] { localQIMFollwerAdd.source });
      localQIMFollowerAddHolder.j.setText((CharSequence)localObject);
      localQIMFollowerAddHolder.j.setVisibility(0);
    }
    else
    {
      localQIMFollowerAddHolder.j.setVisibility(8);
    }
    localQIMFollowerAddHolder.k.setVisibility(8);
    localQIMFollowerAddHolder.a.setText(HardCodeUtil.a(2131707521));
    localQIMFollowerAddHolder.a.setVisibility(0);
    localQIMFollowerAddHolder.a.setOnClickListener(this);
    localQIMFollowerAddHolder.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
    localQIMFollowerAddHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(1, String.valueOf(localQIMFollwerAdd.uin)));
    return paramView;
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new QIMFollowerAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131376644) {
      if (i == 2131376477) {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      } else {
        a(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder
 * JD-Core Version:    0.7.0.1
 */