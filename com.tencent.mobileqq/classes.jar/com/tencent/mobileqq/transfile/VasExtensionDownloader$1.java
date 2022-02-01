package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class VasExtensionDownloader$1
  implements Runnable
{
  VasExtensionDownloader$1(VasExtensionDownloader paramVasExtensionDownloader, FavoriteEmoticonInfo paramFavoriteEmoticonInfo) {}
  
  public void run()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject instanceof AppInterface)) {
      return;
    }
    localObject = (IFavroamingDBManagerService)((AppRuntime)localObject).getRuntimeService(IFavroamingDBManagerService.class, "");
    CustomEmotionData localCustomEmotionData = ((IFavroamingDBManagerService)localObject).getEmotionDataByUrl(this.val$info.url);
    if (localCustomEmotionData == null) {
      return;
    }
    if (new File(this.val$info.path).exists())
    {
      if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
        localCustomEmotionData.RomaingType = "isUpdate";
      } else if ("overflow".equals(localCustomEmotionData.RomaingType)) {
        localCustomEmotionData.RomaingType = "overflow_downloaded";
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update CustomEmotionData romaing type  isUpdate, path: ");
        localStringBuilder.append(this.val$info.path);
        QLog.i("VasExtensionDownloader", 2, localStringBuilder.toString());
      }
      if ((TextUtils.isEmpty(localCustomEmotionData.md5)) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("update CustomEmotionData md5 , path: ");
          localStringBuilder.append(this.val$info.path);
          QLog.i("VasExtensionDownloader", 2, localStringBuilder.toString());
        }
      }
      if (!"needDel".equals(localCustomEmotionData.RomaingType)) {
        ((IFavroamingDBManagerService)localObject).updateCustomEmotion(localCustomEmotionData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasExtensionDownloader.1
 * JD-Core Version:    0.7.0.1
 */