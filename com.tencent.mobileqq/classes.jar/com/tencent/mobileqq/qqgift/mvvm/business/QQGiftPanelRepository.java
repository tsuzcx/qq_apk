package com.tencent.mobileqq.qqgift.mvvm.business;

import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;

public class QQGiftPanelRepository
  extends BaseRepository
{
  public void a(IQQGiftSDK paramIQQGiftSDK, IQQGiftListCallback paramIQQGiftListCallback)
  {
    if (paramIQQGiftSDK != null) {
      paramIQQGiftSDK.d().a(paramIQQGiftListCallback);
    }
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK, GiftListData paramGiftListData, IQQGiftListCallback paramIQQGiftListCallback)
  {
    if (paramIQQGiftSDK != null)
    {
      if (paramGiftListData != null)
      {
        paramIQQGiftSDK.d().a(paramGiftListData, paramIQQGiftListCallback);
        return;
      }
      paramIQQGiftSDK.d().a(paramIQQGiftListCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelRepository
 * JD-Core Version:    0.7.0.1
 */