package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProteusCDNUtils$2
  implements Runnable
{
  ProteusCDNUtils$2(String paramString) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER);
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(".7z");
    Object localObject2 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    if (!new File((String)localObject2).exists())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[unCompressOfflineFile], bid = ");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(", file does not exist.");
      QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject1 = BidDownloader.d((String)localObject2);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[unCompressOfflineFile], fileFormat = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject3).toString());
    Object localObject4 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER);
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(".zip");
    localObject3 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    localObject1 = new File((String)localObject3);
    if (((File)localObject1).exists())
    {
      FileUtils.deleteFile((String)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[unCompressOfflineFile], delete file = ");
      localStringBuilder.append((String)localObject3);
      QLog.i("ProteusCDNUtils", 1, localStringBuilder.toString());
    }
    int j = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), (String)localObject2, (String)localObject4);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[unCompressOfflineFile], firstUnCompressCode = ");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(", outputFilePath = ");
    ((StringBuilder)localObject2).append((String)localObject4);
    QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject2).toString());
    int i = -1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER);
    ((StringBuilder)localObject2).append(this.a);
    localObject2 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject2).toString());
    if (j == 0)
    {
      Util.a((String)localObject2);
      if (!new File((String)localObject2).mkdirs())
      {
        QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], mkdirs error.");
        return;
      }
      i = ZipUtils.unZipFolder((String)localObject3, (String)localObject2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[unCompressOfflineFile], secondUnCompressCode = ");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(", folderPathNew = ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject3).toString());
    }
    if (i == 0)
    {
      localObject3 = OfflineEnvHelper.b(this.a);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(this.a);
      localObject3 = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append("/b.zip");
      ((File)localObject1).renameTo(new File(((StringBuilder)localObject4).toString()));
      if (OfflineSecurity.a((String)localObject2, this.a))
      {
        Util.a((String)localObject3);
        boolean bool = new File((String)localObject2).renameTo(new File((String)localObject3));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[unCompressOfflineFile], isRenameSuccess = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", folderPathNew = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", targetFolderPath = ");
        ((StringBuilder)localObject1).append((String)localObject3);
        QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject1).toString());
        if (bool) {
          ProteusCDNUtils.a("0X800ABFF", this.a);
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[unCompressOfflineFile], bid = ");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(", folderPathNew = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", folder may have changed.");
        QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusCDNUtils.2
 * JD-Core Version:    0.7.0.1
 */