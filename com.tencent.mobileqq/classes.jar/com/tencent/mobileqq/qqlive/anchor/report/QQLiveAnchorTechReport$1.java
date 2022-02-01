package com.tencent.mobileqq.qqlive.anchor.report;

import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;

class QQLiveAnchorTechReport$1
  extends QQLiveAnchorRoomThirdPushBaseCallback
{
  QQLiveAnchorTechReport$1(QQLiveAnchorTechReport paramQQLiveAnchorTechReport) {}
  
  public void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    if (paramQQLiveAnchorDataEnter == null)
    {
      this.a.c(false, null);
      return;
    }
    if (paramQQLiveAnchorDataEnter.isSuccess)
    {
      this.a.c(true, null);
      return;
    }
    this.a.c(false, paramQQLiveAnchorDataEnter.errorMsg);
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    if (paramQQLiveAnchorDataPrepare == null)
    {
      this.a.a(false, null);
      return;
    }
    if (paramQQLiveAnchorDataPrepare.isSuccess)
    {
      this.a.a(true, null);
      return;
    }
    this.a.a(false, paramQQLiveAnchorDataPrepare.errorMsg);
  }
  
  public void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    if (paramQQLiveAnchorDataPublishStream == null)
    {
      this.a.d(false, null);
      return;
    }
    if (paramQQLiveAnchorDataPublishStream.isSuccess)
    {
      this.a.d(true, null);
      return;
    }
    this.a.d(false, paramQQLiveAnchorDataPublishStream.errorMsg);
  }
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    if (paramQQLiveAnchorDataSet == null)
    {
      this.a.b(false, null);
      return;
    }
    if (paramQQLiveAnchorDataSet.isSuccess)
    {
      this.a.b(true, null);
      return;
    }
    this.a.b(false, paramQQLiveAnchorDataSet.errorMsg);
  }
  
  public void b()
  {
    this.a.a();
  }
  
  public void c()
  {
    this.a.b();
  }
  
  public void d()
  {
    this.a.c();
  }
  
  public void e()
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport.1
 * JD-Core Version:    0.7.0.1
 */