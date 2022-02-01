package com.tencent.mobileqq.emoticon.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.FunnyPicHelper.FunnyPicDownloader;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.util.List;

public class FunnyPicHelperServiceImpl
  implements IFunnyPicHelperService
{
  public void checkLoadEmotionPic(Context paramContext, List<CustomEmotionData> paramList, BaseQQAppInterface paramBaseQQAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    FunnyPicHelper.a(paramContext, paramList, paramBaseQQAppInterface, paramIPicDownloadListener);
  }
  
  public void checkLoadEmotionPic(boolean paramBoolean, Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    FunnyPicHelper.a(paramBoolean, paramContext, paramList, paramAppInterface, paramIPicDownloadListener);
  }
  
  public AbsDownloader createFunnyPicDownloader()
  {
    return new FunnyPicHelper.FunnyPicDownloader();
  }
  
  public void resolveFunnyPicJson(AppInterface paramAppInterface)
  {
    FunnyPicHelper.a(paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.FunnyPicHelperServiceImpl
 * JD-Core Version:    0.7.0.1
 */