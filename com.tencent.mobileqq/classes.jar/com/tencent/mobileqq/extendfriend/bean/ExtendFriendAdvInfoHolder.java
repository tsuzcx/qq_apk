package com.tencent.mobileqq.extendfriend.bean;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.SquareItemClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import cooperation.vip.widget.VipGeneralGdtShowView;

public class ExtendFriendAdvInfoHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  SquareItemClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener;
  public ExtendFriendFeedView a;
  public VipGeneralGdtShowView a;
  
  public ExtendFriendAdvInfoHolder(View paramView, Context paramContext, SquareItemClickListener paramSquareItemClickListener, VipGeneralGdtShowView paramVipGeneralGdtShowView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView = paramVipGeneralGdtShowView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener = paramSquareItemClickListener;
    if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView != null) {
      this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView.a(this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView.a(), new ExtendFriendAdvInfoHolder.1(this));
    }
  }
  
  public void a(ExtendFriendAdvInfoHolder paramExtendFriendAdvInfoHolder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramStrangerInfo != null))
    {
      int i = paramExtendFriendAdvInfoHolder.getPosition();
      paramExtendFriendAdvInfoHolder.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramStrangerInfo.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView != null) && (paramStrangerInfo != null) && (paramStrangerInfo.mAlumbasicdata != null)) {
      paramExtendFriendAdvInfoHolder.jdField_a_of_type_CooperationVipWidgetVipGeneralGdtShowView.a(paramStrangerInfo.mAlumbasicdata, paramExtendFriendAdvInfoHolder.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.ExtendFriendAdvInfoHolder
 * JD-Core Version:    0.7.0.1
 */