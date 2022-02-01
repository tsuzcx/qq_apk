package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendBindContactGuideBuilderV2
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendBindContactGuideMsgV2 a;
  
  public NewFriendBindContactGuideBuilderV2(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2 = ((NewFriendBindContactGuideMsgV2)paramNewFriendMessage);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).checkReadContactPermission(local3, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendBindContactGuideBuilderV2.MyHolder)))
    {
      localObject = (NewFriendBindContactGuideBuilderV2.MyHolder)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561515, null);
      localObject = new NewFriendBindContactGuideBuilderV2.MyHolder(null);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361961));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378114));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364703));
      paramView.setTag(localObject);
    }
    String str1;
    String str2;
    String str3;
    if (!this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_Boolean)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean.a.a;
      str2 = this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean.a.b;
      str3 = this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean.a.c;
    }
    else
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean.b.a;
      str2 = this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean.b.b;
      str3 = this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean.b.c;
    }
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str3);
    paramView.setOnClickListener(this);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    NewFriendUtil.a(paramView, false);
    Object localObject = (NewFriendServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "");
    if (!this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_Boolean)
    {
      if (!((NewFriendServiceImpl)localObject).isGuidePermissionReported())
      {
        ((NewFriendServiceImpl)localObject).setIsGuidePermissionReported(true);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
        return paramView;
      }
    }
    else if (!((NewFriendServiceImpl)localObject).isGuideBindReported())
    {
      ((NewFriendServiceImpl)localObject).setIsGuideBindReported(true);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
    }
    return paramView;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendBindContactGuideBuilderV2", 2, "uploadContact");
    }
    ThreadManager.excute(new NewFriendBindContactGuideBuilderV2.1(this), 16, null, false);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 15, 2, null);
    c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364703)
    {
      ((NewFriendServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "")).setContactGuideCancelByUser();
      c();
    }
    else if ((i == 2131361961) || (i == 2131363593))
    {
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        BaseApplication localBaseApplication = BaseApplication.getContext();
        QQToast.a(localBaseApplication, 1, 2131694475, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299168));
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
        b();
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
        d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2
 * JD-Core Version:    0.7.0.1
 */