package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.NearbyRecommendPeopleInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class NearbyHybridFragment$11
  implements View.OnClickListener
{
  NearbyHybridFragment$11(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    double d2 = 0.0D;
    int i = paramView.getId();
    if (i == 2131366393)
    {
      localObject1 = NearbyPublishMenuHelper.a();
      localObject1 = new NearbyPublishMenu(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (ArrayList)localObject1);
      ((NearbyPublishMenu)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener);
      ((NearbyPublishMenu)localObject1).a(DisplayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 18.0F), DisplayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 67.0F) + this.a.b.getHeight(), 0.2F);
      new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app).a("dc00899").b("grp_lbs").c("home").d("pub_download_exp").a();
      NearbyUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_pub", 1);
    }
    while (i != 2131374749)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    NearbyProcManager localNearbyProcManager = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    Object localObject1 = localNearbyProcManager.a(10);
    NearbyRedDotCustomInfo localNearbyRedDotCustomInfo = new NearbyRedDotCustomInfo();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get()).intValue();
      }
      catch (Exception localException1)
      {
        try
        {
          localNearbyRedDotCustomInfo.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          QLog.d("nearby.redpoint", 1, "click red info, isOfficialNotify=" + localNearbyRedDotCustomInfo.jdField_b_of_type_Boolean + " redContentType = " + localNearbyRedDotCustomInfo.jdField_b_of_type_Int + " redTopicId = " + localNearbyRedDotCustomInfo.jdField_b_of_type_JavaLangString);
          localObject1 = localNearbyProcManager.a();
          if ((localObject1 == null) || (((NearbyRedNum)localObject1).jdField_b_of_type_Int != i)) {
            break label640;
          }
          Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
          if (i != 1) {
            break label560;
          }
          if (localNearbyRedDotCustomInfo.jdField_b_of_type_Int != 2) {
            break label531;
          }
          localObject1 = "https://nearby.qq.com/nearby-rcmd-content/people.html?_bid=4227&msg_id=" + NearbyRecommendPeopleInfo.a();
          localIntent.putExtra("url", (String)localObject1);
          QLog.d("nearby.redpoint", 1, "click OfficialNotify, url" + (String)localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
          NearbyOfficalReportHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_click");
          localNearbyProcManager.a(38);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.11.1(this), 500L);
          NearbyUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_msg", 0);
          ReportController.b(null, "dc00899", "grp_lbs", "", "home", "push_red_click", 0, 0, String.valueOf(((Integer)NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            continue;
            double d1 = 0.0D;
          }
        }
        localException1 = localException1;
        i = 0;
      }
      localException1.printStackTrace();
      continue;
      label531:
      localObject2 = "https://nearby.qq.com/nearby-rcmd-content/detail.html?_bid=4227&_wv=16777218&topic_tag=" + localNearbyRedDotCustomInfo.jdField_b_of_type_JavaLangString;
      continue;
      label560:
      localObject2 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("nearby_recommend");
      if ((localObject2 != null) && (((SosoLbsInfo)localObject2).mLocation != null))
      {
        d2 = ((SosoLbsInfo)localObject2).mLocation.mLat02;
        d1 = ((SosoLbsInfo)localObject2).mLocation.mLon02;
        localObject2 = "https://nearby.qq.com/h5/helper/index.html?_wv=3&_bid=4234&latitude=$LATITUDE$&longitude=$LONGITUDE$".replace("$LATITUDE$", String.valueOf(d2)).replace("$LONGITUDE$", String.valueOf(d1));
        continue;
        label640:
        localObject2 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity((Intent)localObject2);
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.11
 * JD-Core Version:    0.7.0.1
 */