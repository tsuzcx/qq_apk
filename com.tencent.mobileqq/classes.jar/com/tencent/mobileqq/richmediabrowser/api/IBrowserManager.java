package com.tencent.mobileqq.richmediabrowser.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.List;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IBrowserManager
  extends QRouteApi
{
  public abstract MainBrowserPresenter getPresenter();
  
  public abstract IBrowserManager launchRichMediaBrowser(Context paramContext, Intent paramIntent, IProvider paramIProvider, String paramString, List<RichMediaBrowserInfo> paramList, int paramInt);
  
  public abstract void notifyImageListChanged(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt);
  
  public abstract void notifyImageProgress(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void notifyImageResult(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void notifyVideoUrl(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
 * JD-Core Version:    0.7.0.1
 */