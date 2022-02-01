package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VideoBehaviorsReporter
{
  private static VideoBehaviorsReporter jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsReporter = new VideoBehaviorsReporter();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private VideoBehaviorsReportData jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsReportData;
  private VideoBehaviorsSeqReportData jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsSeqReportData;
  private List<?> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -100;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -100;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -100;
  
  public static VideoBehaviorsReporter a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsReporter;
  }
  
  private void b()
  {
    VideoBehaviorsSeqReportData localVideoBehaviorsSeqReportData = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsSeqReportData;
    if (localVideoBehaviorsSeqReportData != null)
    {
      if (localVideoBehaviorsSeqReportData.a()) {
        return;
      }
      localVideoBehaviorsSeqReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localVideoBehaviorsSeqReportData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doReportVideoBehaviorsSeq(): ");
        localStringBuilder.append(localVideoBehaviorsSeqReportData.toString());
        QLog.d("VideoBehaviorsReporter", 2, localStringBuilder.toString());
      }
      RIJStatisticCollectorReport.e(BaseApplication.getContext(), RIJQQAppInterfaceUtil.a(), true, localVideoBehaviorsSeqReportData.a());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsSeqReportData.a();
    }
  }
  
  public void a()
  {
    b();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.d = -100;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsReportData = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoBehaviorsSeqReportData = null;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, List<?> paramList)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (this.jdField_c_of_type_Long == -1L)
      {
        paramReadInJoyBaseAdapter = this.jdField_a_of_type_JavaUtilList;
        if ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.size() > 0))
        {
          this.jdField_c_of_type_Long = ((AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(0)).mRecommendSeq;
          if (QLog.isColorLevel())
          {
            paramReadInJoyBaseAdapter = new StringBuilder();
            paramReadInJoyBaseAdapter.append("bindVideoChannel(): 2,  mFirstVideoSeq = ");
            paramReadInJoyBaseAdapter.append(this.jdField_c_of_type_Long);
            QLog.d("VideoBehaviorsReporter", 2, paramReadInJoyBaseAdapter.toString());
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramReadInJoyBaseAdapter = new StringBuilder();
      paramReadInJoyBaseAdapter.append("bindVideoChannel(): 1, mFirstVideoSeq = ");
      paramReadInJoyBaseAdapter.append(this.jdField_c_of_type_Long);
      QLog.d("VideoBehaviorsReporter", 2, paramReadInJoyBaseAdapter.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter
 * JD-Core Version:    0.7.0.1
 */