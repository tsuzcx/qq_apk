package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.ReportWorker;
import com.tencent.mobileqq.emoticonview.api.IReportWorkerService;

public class ReportWorkerServiceImpl
  implements IReportWorkerService
{
  public Runnable createReportWorker(String paramString, boolean paramBoolean, IEmoticonMainPanel paramIEmoticonMainPanel, BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    return new ReportWorker(paramString, paramBoolean, paramIEmoticonMainPanel, paramBaseQQAppInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.ReportWorkerServiceImpl
 * JD-Core Version:    0.7.0.1
 */