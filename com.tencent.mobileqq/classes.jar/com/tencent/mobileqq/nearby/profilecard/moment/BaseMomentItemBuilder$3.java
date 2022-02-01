package com.tencent.mobileqq.nearby.profilecard.moment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.TextMomentFeedInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil.ReportBundleBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BaseMomentItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  BaseMomentItemBuilder$3(BaseMomentItemBuilder paramBaseMomentItemBuilder, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder, MomentFeedInfo paramMomentFeedInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    NowVideoReporter localNowVideoReporter = new NowVideoReporter().h("data_card").i("feed_inform").d("2").a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c).c(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder$MomentViewHolder)));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_Boolean)
    {
      paramView = "1";
      localNowVideoReporter.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.e)) || (!(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break label341;
      }
      paramView = new ProfileCardUtil.ReportBundleBuilder();
      if (!(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo instanceof ChangMomentFeedInfo)) {
        break label231;
      }
      paramView.b(((ChangMomentFeedInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo).b);
      label172:
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.n);
      paramView = paramView.a();
      ProfileCardUtil.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_AndroidContentContext, 0L, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.e, null, 20006, "", paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = "2";
      break;
      label231:
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo instanceof LiveMomentFeedInfo))
      {
        paramView.d(((LiveMomentFeedInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo).b).b(((LiveMomentFeedInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo).a);
        break label172;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo instanceof PicMomentFeedInfo))
      {
        paramView.b(((PicMomentFeedInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo).a);
        break label172;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo instanceof ShortVideoMomentFeedInfo))
      {
        paramView.b(((ShortVideoMomentFeedInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo).a);
        break label172;
      }
      if (!(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo instanceof TextMomentFeedInfo)) {
        break label172;
      }
      break label172;
      label341:
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_AndroidContentContext, 2, HardCodeUtil.a(2131701111), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */