package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class NewFriendTabGuideBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendTabGuideBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendTabGuideBuilder.NewFriendTabInfoHolder localNewFriendTabInfoHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendTabGuideBuilder.NewFriendTabInfoHolder)))
    {
      localNewFriendTabInfoHolder = (NewFriendTabGuideBuilder.NewFriendTabInfoHolder)paramView.getTag();
    }
    else
    {
      localNewFriendTabInfoHolder = new NewFriendTabGuideBuilder.NewFriendTabInfoHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561249, null);
      Object localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      a(paramView, ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168) - ViewUtils.a(80.0F));
      localNewFriendTabInfoHolder.a = ((Button)paramView.findViewById(2131367892));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false, null)) {
        localNewFriendTabInfoHolder.a.setBackgroundResource(2130839302);
      }
      localObject = (ThemeImageView)paramView.findViewById(2131367889);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_SQURE);
      paramView.setTag(localNewFriendTabInfoHolder);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
    }
    localNewFriendTabInfoHolder.a.setOnClickListener(this);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).setConnectionsSwitch(true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    } else {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 0).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabGuideBuilder
 * JD-Core Version:    0.7.0.1
 */