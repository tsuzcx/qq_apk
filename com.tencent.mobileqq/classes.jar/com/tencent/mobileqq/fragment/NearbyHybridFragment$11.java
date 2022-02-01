package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.INearbyRecommendPeopleInfo;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
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

class NearbyHybridFragment$11
  implements View.OnClickListener
{
  NearbyHybridFragment$11(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131366275)
    {
      paramView = NearbyPublishMenuHelper.a();
      paramView = new NearbyPublishMenu(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, paramView);
      paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener);
      paramView.a(DisplayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 18.0F), DisplayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 67.0F) + this.a.jdField_a_of_type_AndroidViewView.getHeight(), 0.2F);
      new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app).a("dc00899").b("grp_lbs").c("home").d("pub_download_exp").a();
      NearbyUtils.b((AppInterface)this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "clk_pub", 1);
      return;
    }
    if (i == 2131374285)
    {
      INearbyProcManager localINearbyProcManager = this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getNearbyProcManager();
      paramView = localINearbyProcManager.a(10);
      Object localObject = (INearbyRedDotCustomInfo)QRoute.api(INearbyRedDotCustomInfo.class);
      if (paramView != null) {
        try
        {
          i = Integer.valueOf(paramView.red_content.get()).intValue();
          try
          {
            ((INearbyRedDotCustomInfo)localObject).parse(paramView);
          }
          catch (Exception paramView) {}
          paramView.printStackTrace();
        }
        catch (Exception paramView)
        {
          i = 0;
        }
      } else {
        i = 0;
      }
      paramView = new StringBuilder();
      paramView.append("click red info, isOfficialNotify=");
      paramView.append(((INearbyRedDotCustomInfo)localObject).getIsOfficialNotify());
      paramView.append(" redContentType = ");
      paramView.append(((INearbyRedDotCustomInfo)localObject).getContentType());
      paramView.append(" redTopicId = ");
      paramView.append(((INearbyRedDotCustomInfo)localObject).getTopicId());
      QLog.d("nearby.redpoint", 1, paramView.toString());
      paramView = localINearbyProcManager.a();
      if ((paramView != null) && (paramView.b == i))
      {
        Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
        if (i == 1)
        {
          if (((INearbyRedDotCustomInfo)localObject).getContentType() == 2)
          {
            paramView = new StringBuilder();
            paramView.append("https://nearby.qq.com/nearby-rcmd-content/people.html?_bid=4227&msg_id=");
            paramView.append(((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendMsgid());
            paramView = paramView.toString();
          }
          else
          {
            paramView = new StringBuilder();
            paramView.append("https://nearby.qq.com/nearby-rcmd-content/detail.html?_bid=4227&_wv=16777218&topic_tag=");
            paramView.append(((INearbyRedDotCustomInfo)localObject).getTopicId());
            paramView = paramView.toString();
          }
        }
        else
        {
          paramView = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("nearby_recommend");
          double d1 = 0.0D;
          double d2;
          if ((paramView != null) && (paramView.mLocation != null))
          {
            d1 = paramView.mLocation.mLat02;
            d2 = paramView.mLocation.mLon02;
          }
          else
          {
            d2 = 0.0D;
          }
          paramView = "https://nearby.qq.com/h5/helper/index.html?_wv=3&_bid=4234&latitude=$LATITUDE$&longitude=$LONGITUDE$".replace("$LATITUDE$", String.valueOf(d1)).replace("$LONGITUDE$", String.valueOf(d2));
        }
        localIntent.putExtra("url", paramView);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click OfficialNotify, url");
        ((StringBuilder)localObject).append(paramView);
        QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject).toString());
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
      }
      else
      {
        paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(paramView);
      }
      ((INearbyOfficalReportHelper)QRoute.api(INearbyOfficalReportHelper.class)).reportNearByRedDotEvent(this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "home", "news_slip_click");
      localINearbyProcManager.a(38);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.11.1(this), 500L);
      NearbyUtils.b((AppInterface)this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface, "clk_msg", 0);
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "push_red_click", 0, 0, String.valueOf(((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.11
 * JD-Core Version:    0.7.0.1
 */