package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserAnimation;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBuilder;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserDecoratorMvpFactory;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.QQBrowserLog;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.List;

public class BrowserManagerImpl
  implements IBrowserManager
{
  private static final String TAG = "BrowserManagerImpl";
  private AIOBrowserPresenter mainBrowserPresenter;
  
  public MainBrowserPresenter getPresenter()
  {
    return this.mainBrowserPresenter;
  }
  
  public IBrowserManager launchRichMediaBrowser(Context paramContext, Intent paramIntent, IProvider paramIProvider, String paramString, List<RichMediaBrowserInfo> paramList, int paramInt)
  {
    ParamsManager.a().a(paramIntent);
    BrowserParamsBuilder localBrowserParamsBuilder = new BrowserParamsBuilder();
    localBrowserParamsBuilder.a(new QQBrowserLog());
    localBrowserParamsBuilder.a(true);
    localBrowserParamsBuilder.c(true);
    localBrowserParamsBuilder.b(true);
    localBrowserParamsBuilder.a(new AIOBrowserDecoratorMvpFactory());
    localBrowserParamsBuilder.a(100, 1);
    localBrowserParamsBuilder.a(102, 1);
    localBrowserParamsBuilder.a(101, 2);
    localBrowserParamsBuilder.a(103, 2);
    AIOBrowserAnimation localAIOBrowserAnimation = new AIOBrowserAnimation();
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramString = (Rect)paramIntent.getExtras().getParcelable(paramString);
      ParamsManager.a().a(paramString);
      localAIOBrowserAnimation.a = paramString;
    }
    localBrowserParamsBuilder.a(localAIOBrowserAnimation);
    localBrowserParamsBuilder.a(paramIProvider);
    paramContext = new AIOBrowserBuilder(paramContext);
    paramContext.a(localBrowserParamsBuilder);
    new RichMediaBrowserManager().a(paramIntent, paramContext, paramList, paramInt);
    this.mainBrowserPresenter = paramContext.a();
    return this;
  }
  
  public void notifyImageListChanged(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    Object localObject = this.mainBrowserPresenter.a;
    if (paramArrayOfAIOBrowserBaseData == null) {}
    try
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserManagerImpl", 4, "imgs is null");
      return;
    }
    catch (Exception paramArrayOfAIOBrowserBaseData)
    {
      localObject = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyImageListChanged exception = ");
      localStringBuilder.append(paramArrayOfAIOBrowserBaseData.getMessage());
      ((IBrowserLog)localObject).d("BrowserManagerImpl", 4, localStringBuilder.toString());
    }
    if (((AIOBrowserModel)localObject).a(paramArrayOfAIOBrowserBaseData, paramInt))
    {
      this.mainBrowserPresenter.a(paramArrayOfAIOBrowserBaseData, paramInt);
      return;
    }
  }
  
  public void notifyImageProgress(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    AIOBrowserPresenter localAIOBrowserPresenter = this.mainBrowserPresenter;
    if (localAIOBrowserPresenter != null) {
      localAIOBrowserPresenter.a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean);
    }
  }
  
  public void notifyImageResult(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (this.mainBrowserPresenter != null)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyImageResult() : id ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramInt3);
      localIBrowserLog.d("BrowserManagerImpl", 4, localStringBuilder.toString());
      this.mainBrowserPresenter.a(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
    }
  }
  
  public void notifyVideoUrl(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    if (this.mainBrowserPresenter != null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserManagerImpl", 4, "notifyVideoUrl");
      this.mainBrowserPresenter.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.BrowserManagerImpl
 * JD-Core Version:    0.7.0.1
 */