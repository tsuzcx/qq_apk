package com.tencent.mobileqq.qqgift.api.service;

import com.tencent.mobileqq.qqgift.api.IQQGiftModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftBalanceCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftSendCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import java.util.List;

public abstract interface IQQGiftServiceModule
  extends IQQGiftModule
{
  public abstract List<GiftServiceData> a(GiftListData paramGiftListData);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, IQQGiftSendCallback paramIQQGiftSendCallback);
  
  public abstract void a(int paramInt1, int paramInt2, IQQGiftSendCallback paramIQQGiftSendCallback);
  
  public abstract void a(IQQGiftBalanceCallback paramIQQGiftBalanceCallback);
  
  public abstract void a(IQQGiftListCallback paramIQQGiftListCallback);
  
  public abstract void a(GiftListData paramGiftListData, IQQGiftListCallback paramIQQGiftListCallback);
  
  public abstract void a(GiftSendReqData paramGiftSendReqData);
  
  public abstract GiftSendReqData c();
  
  @Deprecated
  public abstract List<GiftServiceData> d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule
 * JD-Core Version:    0.7.0.1
 */