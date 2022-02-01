package com.tencent.mobileqq.emoticon.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IFunnyPicHelperService
  extends QRouteApi
{
  public abstract void checkLoadEmotionPic(Context paramContext, List<CustomEmotionData> paramList, BaseQQAppInterface paramBaseQQAppInterface, IPicDownloadListener paramIPicDownloadListener);
  
  public abstract void checkLoadEmotionPic(boolean paramBoolean, Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener);
  
  public abstract AbsDownloader createFunnyPicDownloader();
  
  public abstract void resolveFunnyPicJson(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService
 * JD-Core Version:    0.7.0.1
 */