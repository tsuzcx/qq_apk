package com.tencent.mobileqq.weiyun.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IWeiyunGrayTipHelper
  extends QRouteApi
{
  public abstract void insertAIOGrayTips(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiyunGrayTipHelper
 * JD-Core Version:    0.7.0.1
 */