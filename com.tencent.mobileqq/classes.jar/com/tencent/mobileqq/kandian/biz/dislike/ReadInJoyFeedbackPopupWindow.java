package com.tencent.mobileqq.kandian.biz.dislike;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyFeedbackPopupWindow
  extends ReadInJoyBasePopupWindow
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private FastWebShareUtils jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private FeedbackCallback jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback = new ReadInJoyFeedbackPopupWindow.1(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  
  public ReadInJoyFeedbackPopupWindow(Activity paramActivity, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils = new FastWebShareUtils();
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return 2;
          }
          return 10;
        }
        return 9;
      }
      return 3;
    }
    return 2;
  }
  
  private void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (b("reportData"))
    {
      Object localObject = RIJTransMergeKanDianReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      try
      {
        localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addShareOption(paramInt).addTopicId(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.businessId).build();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.publishUin), paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), (String)localObject, false);
        return;
      }
      catch (JSONException paramString)
      {
        QLog.d("ReadInJoyBasePopupWindow", 1, "reportData json exception.");
        paramString.printStackTrace();
      }
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131717855, 0).a();
      return false;
    }
    return true;
  }
  
  private boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.publishUin > 0L) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin() == paramAbsBaseArticleInfo.publishUin);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
    {
      QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mArticleInfo is null." });
      return false;
    }
    return true;
  }
  
  private boolean b(String paramString)
  {
    if ((a(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null)) {
      return true;
    }
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mSocialFeedInfo is null" });
    return false;
  }
  
  private void c()
  {
    if (a("reportFeeds")) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyFeedbackPopupWindow.3(this));
    }
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidAppActivity);
    localActionSheet.setMainTitle(2131717908);
    localActionSheet.addButton(2131717907, 0);
    localActionSheet.addCancelButton(2131690728);
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
    localActionSheet.setOnButtonClickListener(new ReadInJoyFeedbackPopupWindow.4(this, localActionSheet));
  }
  
  private void e()
  {
    if (!a()) {
      return;
    }
    if (a("shieldFeeds")) {
      FastWebRequestUtil.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560088, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131377436));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131376438));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131365494));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131377229));
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131375079));
    this.e = ((ImageView)paramLayoutInflater.findViewById(2131381087));
    this.f = ((ImageView)paramLayoutInflater.findViewById(2131371433));
    return paramLayoutInflater;
  }
  
  public final void a(View paramView1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, View paramView2)
  {
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "show, articleInfo = ", paramAbsBaseArticleInfo });
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Int = paramInt;
    a(paramAbsBaseArticleInfo);
    a(paramView1);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (a(paramAbsBaseArticleInfo))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842984));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842983));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842984));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    setOnDismissListener(new ReadInJoyFeedbackPopupWindow.2(this));
  }
  
  public void onClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
    dismiss();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131381087: 
      a(2);
      a("0X80095D4", 3);
      return;
    case 2131377436: 
      e();
      a("0X80095D4", 5);
      return;
    case 2131377229: 
      a(0);
      a("0X80095D4", 1);
      return;
    case 2131376438: 
      c();
      a("0X80095D4", 7);
      return;
    case 2131375079: 
      a(1);
      a("0X80095D4", 2);
      return;
    case 2131371433: 
      a(3);
      a("0X80095D4", 4);
      return;
    }
    d();
    a("0X80095D4", 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow
 * JD-Core Version:    0.7.0.1
 */