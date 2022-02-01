package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;

public abstract interface IGProNoticeService
{
  public abstract void clearNoticeRedPoint(int paramInt, IResultCallback paramIResultCallback);
  
  public abstract void dealNotice(String paramString1, String paramString2, IDealNoticeCallback paramIDealNoticeCallback);
  
  public abstract void fetchNoticeRedPoint(IFetchNoticeRedPointCallback paramIFetchNoticeRedPointCallback);
  
  public abstract void getMoreNoticeList(int paramInt, IGetMoreNoticeListCallback paramIGetMoreNoticeListCallback);
  
  public abstract void initGetNoticeList(boolean paramBoolean, IInitGetNoticeListCallback paramIInitGetNoticeListCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProNoticeService
 * JD-Core Version:    0.7.0.1
 */