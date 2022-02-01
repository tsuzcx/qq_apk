package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ProfileNameView$TroopRankClick
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<ProfileCardInfo> b;
  
  public ProfileNameView$TroopRankClick(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramProfileCardInfo);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.b.get();
    if ((localQQAppInterface == null) || (localProfileCardInfo == null) || (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((ITroopHonorService)localQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).isSupportTroopHonor(localProfileCardInfo.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = TroopLinkManager.a().a(localProfileCardInfo.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject = TroopLinkManager.a().a(localProfileCardInfo.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, TroopMemberCardUtils.a(localQQAppInterface, localProfileCardInfo.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.getContext().startActivity(localIntent);
      if (TroopRankConfig.a().a(localProfileCardInfo.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        localObject = paramView.findViewById(2131376828);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        TroopRankConfig.a().a(localProfileCardInfo.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      TroopRankConfig.a("grp_data", "clk_medal");
      new ReportTask(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localProfileCardInfo.jdField_a_of_type_JavaLangString }).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView.TroopRankClick
 * JD-Core Version:    0.7.0.1
 */