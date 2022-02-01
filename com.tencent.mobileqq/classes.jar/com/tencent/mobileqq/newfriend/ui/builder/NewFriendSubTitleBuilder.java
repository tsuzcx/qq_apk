package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.data.NewFriendSubTitle;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendSubTitleBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  NewFriendSubTitleBuilder.NewFriendSubTitleHolder a;
  
  public NewFriendSubTitleBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder = ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)paramView.getTag());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder = new NewFriendSubTitleBuilder.NewFriendSubTitleHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561253, null);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366277);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369344));
      paramView.setTag(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder);
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((NewFriendSubTitleMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidViewView;
    boolean bool = ((NewFriendSubTitleMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.jdField_a_of_type_Boolean;
    int i = 0;
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((View)localObject).setVisibility(paramInt);
    localObject = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidWidgetImageView;
    if (((NewFriendSubTitleMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.b) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    ((ImageView)localObject).setVisibility(paramInt);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366277)
    {
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity)this.jdField_a_of_type_AndroidContentContext);
      ((INewFriendVerificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendVerificationService.class, "")).clearRedPointAtNewFriendBanner();
      NewFriendSubTitleBuilder.NewFriendSubTitleHolder localNewFriendSubTitleHolder = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder;
      if ((localNewFriendSubTitleHolder != null) && (localNewFriendSubTitleHolder.jdField_a_of_type_AndroidWidgetImageView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNewfriendUiBuilderNewFriendSubTitleBuilder$NewFriendSubTitleHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder
 * JD-Core Version:    0.7.0.1
 */