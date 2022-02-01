package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.utils.FileUtils;
import org.jetbrains.annotations.NotNull;

public class AniStickerLottieResDownloader
  extends BaseLottieResDownloader<AniStickerInfo>
{
  @NotNull
  protected AniStickerInfo mAniStickerInfo;
  
  public void addReloadDrawable()
  {
    AniStickerResReloaderMgr.getInstance().addReloadDrawable(1, getCacheKey());
  }
  
  public boolean checkFileExists()
  {
    return FileUtils.fileExists(getFilePath());
  }
  
  public void downloadSvgRes()
  {
    AniStickerResReloaderMgr.getInstance().triggerDownloadRes();
  }
  
  public String getCacheKey()
  {
    AniStickerInfo localAniStickerInfo = this.mAniStickerInfo;
    if (localAniStickerInfo == null) {
      return "";
    }
    return localAniStickerInfo.getCacheKey();
  }
  
  public String getFilePath()
  {
    AniStickerInfo localAniStickerInfo = this.mAniStickerInfo;
    if (localAniStickerInfo == null) {
      return null;
    }
    return localAniStickerInfo.getFilePath();
  }
  
  public void setOptions(AniStickerInfo paramAniStickerInfo)
  {
    this.mAniStickerInfo = paramAniStickerInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.download.AniStickerLottieResDownloader
 * JD-Core Version:    0.7.0.1
 */