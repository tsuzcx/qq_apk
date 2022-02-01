package com.tencent.mobileqq.emoticonview.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IReportWorkerService
  extends QRouteApi
{
  public abstract Runnable createReportWorker(String paramString, boolean paramBoolean, IEmoticonMainPanel paramIEmoticonMainPanel, BaseQQAppInterface paramBaseQQAppInterface, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IReportWorkerService
 * JD-Core Version:    0.7.0.1
 */