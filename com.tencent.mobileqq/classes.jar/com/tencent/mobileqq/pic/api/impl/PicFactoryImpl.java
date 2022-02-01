package com.tencent.mobileqq.pic.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.transfile.AIOPhotoImageDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CQzonePicUploadProcessor;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupQzonePicUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TroopEffectsPicUploadProcessor;
import com.tencent.qphone.base.util.BaseApplication;

public class PicFactoryImpl
  implements IPicFactory
{
  public BaseCache getCache(AppInterface paramAppInterface, DBDelayManager paramDBDelayManager)
  {
    return new TroopStatisticsCache(paramAppInterface, paramDBDelayManager);
  }
  
  public ProtocolDownloader getChatImageDownloader(BaseApplication paramBaseApplication, String paramString)
  {
    if ("aiothumb".equals(paramString)) {
      return new AIOPhotoImageDownloader(paramBaseApplication);
    }
    if ((!"chatthumb".equals(paramString)) && (!"chatimg".equals(paramString)) && (!"chatraw".equals(paramString))) {
      return null;
    }
    return new ChatImageDownloader(paramBaseApplication);
  }
  
  public BaseTransProcessor getProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    if ((paramTransferRequest.mUinType != 1) && (paramTransferRequest.mUinType != 3000))
    {
      if (paramTransferRequest.mIsUp)
      {
        if (paramTransferRequest.mBusiType == 1045) {
          return new C2CQzonePicUploadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
        return new C2CPicUploadProcessor(paramBaseTransFileController, paramTransferRequest);
      }
      if ((paramTransferRequest.mFileType == 1) || (paramTransferRequest.mFileType == 65537) || (paramTransferRequest.mFileType == 131075)) {
        return new C2CPicDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
      }
    }
    else
    {
      if (paramTransferRequest.mIsUp)
      {
        if (paramTransferRequest.mFileType == 55) {
          return new TroopEffectsPicUploadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
        if (paramTransferRequest.mBusiType == 1045) {
          return new GroupQzonePicUploadProcessor(paramBaseTransFileController, paramTransferRequest);
        }
        return new GroupPicUploadProcessor(paramBaseTransFileController, paramTransferRequest);
      }
      if ((paramTransferRequest.mFileType == 1) || (paramTransferRequest.mFileType == 65537) || (paramTransferRequest.mFileType == 131075)) {
        break label181;
      }
    }
    return null;
    label181:
    return new GroupPicDownloadProcessor(paramBaseTransFileController, paramTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicFactoryImpl
 * JD-Core Version:    0.7.0.1
 */