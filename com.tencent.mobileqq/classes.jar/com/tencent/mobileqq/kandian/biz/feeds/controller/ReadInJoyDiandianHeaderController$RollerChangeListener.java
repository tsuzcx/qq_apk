package com.tencent.mobileqq.kandian.biz.feeds.controller;

import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDiandianHeaderController$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected ReadInJoyDiandianHeaderController$RollerChangeListener(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    int i = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).getCurrentItem();
    ReadInJoyDiandianHeaderController localReadInJoyDiandianHeaderController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController;
    localReadInJoyDiandianHeaderController.jdField_a_of_type_Int = i;
    paramInt = ReadInJoyDiandianHeaderController.a(localReadInJoyDiandianHeaderController).getCount();
    if (paramInt <= 1) {
      return;
    }
    if (i == 1) {
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).instantiateItem(null, paramInt - 3);
    } else if (i == paramInt - 3) {
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).instantiateItem(null, 1);
    }
    if (i == 0) {
      paramInt -= 3;
    } else if (i == paramInt - 2) {
      paramInt = 1;
    } else {
      paramInt = i;
    }
    if (i != paramInt)
    {
      localReadInJoyDiandianHeaderController = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController;
      localReadInJoyDiandianHeaderController.jdField_a_of_type_Int = paramInt;
      ReadInJoyDiandianHeaderController.a(localReadInJoyDiandianHeaderController).setCurrentItem(paramInt, false);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).a(paramInt);
    if ((this.jdField_a_of_type_Int != i) && (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController))) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009826", "0X8009826", 0, 0, "", "", "", "", false);
    }
    if ((i >= 0) && (this.jdField_a_of_type_Int >= 0)) {
      this.jdField_a_of_type_Int = i;
    }
    if (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).get(i) != null)
    {
      ReadInJoyDiandianHeaderController.HeaderListAdapter localHeaderListAdapter = (ReadInJoyDiandianHeaderController.HeaderListAdapter)((MeasureGridView)ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).get(i)).getAdapter();
      paramInt = 0;
      while (paramInt < localHeaderListAdapter.getCount())
      {
        DiandianTopConfig localDiandianTopConfig = (DiandianTopConfig)localHeaderListAdapter.getItem(paramInt);
        if ((localDiandianTopConfig != null) && (!localDiandianTopConfig.hasExposeReported)) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
            int j = localDiandianTopConfig.type;
            if (j == 5) {
              localJSONObject.put("list_URL", localDiandianTopConfig.jumpUrl);
            } else {
              localJSONObject.put("list_URL", "0");
            }
            localJSONObject.put("type", localDiandianTopConfig.type);
            IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(ReadInJoyDiandianHeaderController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController).size());
            ((StringBuilder)localObject1).append("");
            localObject1 = ((StringBuilder)localObject1).toString();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i + 1);
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localDiandianTopConfig.topicId);
            localStringBuilder.append("");
            localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80092FC", "0X80092FC", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), localJSONObject.toString(), false);
            localDiandianTopConfig.hasExposeReported = true;
            localHeaderListAdapter.a(paramInt, localDiandianTopConfig);
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ReadInJoyDiandianHeaderController", 2, localJSONException.toString());
            }
          }
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */