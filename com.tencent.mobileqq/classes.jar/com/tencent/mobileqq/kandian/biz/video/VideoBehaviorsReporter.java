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
  private static VideoBehaviorsReporter n = new VideoBehaviorsReporter();
  private int a;
  private int b = -100;
  private long c = -1L;
  private int d = -100;
  private long e = -1L;
  private int f = -100;
  private boolean g = false;
  private boolean h = false;
  private List<?> i;
  private long j = -1L;
  private boolean k = false;
  private VideoBehaviorsReportData l;
  private VideoBehaviorsSeqReportData m;
  
  public static VideoBehaviorsReporter a()
  {
    return n;
  }
  
  private void c()
  {
    VideoBehaviorsSeqReportData localVideoBehaviorsSeqReportData = this.m;
    if (localVideoBehaviorsSeqReportData != null)
    {
      if (localVideoBehaviorsSeqReportData.a()) {
        return;
      }
      localVideoBehaviorsSeqReportData.a = this.a;
      localVideoBehaviorsSeqReportData.b = this.g;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doReportVideoBehaviorsSeq(): ");
        localStringBuilder.append(localVideoBehaviorsSeqReportData.toString());
        QLog.d("VideoBehaviorsReporter", 2, localStringBuilder.toString());
      }
      RIJStatisticCollectorReport.e(BaseApplication.getContext(), RIJQQAppInterfaceUtil.d(), true, localVideoBehaviorsSeqReportData.c());
      this.m.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.k) {
      return;
    }
    this.a = paramInt;
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, List<?> paramList)
  {
    if (!this.k) {
      return;
    }
    if (this.i == null)
    {
      this.i = paramList;
      if (this.j == -1L)
      {
        paramReadInJoyBaseAdapter = this.i;
        if ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.size() > 0))
        {
          this.j = ((AbsBaseArticleInfo)this.i.get(0)).mRecommendSeq;
          if (QLog.isColorLevel())
          {
            paramReadInJoyBaseAdapter = new StringBuilder();
            paramReadInJoyBaseAdapter.append("bindVideoChannel(): 2,  mFirstVideoSeq = ");
            paramReadInJoyBaseAdapter.append(this.j);
            QLog.d("VideoBehaviorsReporter", 2, paramReadInJoyBaseAdapter.toString());
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramReadInJoyBaseAdapter = new StringBuilder();
      paramReadInJoyBaseAdapter.append("bindVideoChannel(): 1, mFirstVideoSeq = ");
      paramReadInJoyBaseAdapter.append(this.j);
      QLog.d("VideoBehaviorsReporter", 2, paramReadInJoyBaseAdapter.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void b()
  {
    c();
    this.k = false;
    this.g = false;
    this.b = -100;
    this.d = -100;
    this.f = -100;
    this.j = -1L;
    this.i = null;
    this.l = null;
    this.m = null;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.k) {
      return;
    }
    if (this.g == paramBoolean) {
      return;
    }
    this.g = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.k) {
      return;
    }
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter
 * JD-Core Version:    0.7.0.1
 */