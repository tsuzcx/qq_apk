package com.tencent.util;

import com.dataline.util.file.FileUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class AutoSaveUtils$1
  implements Runnable
{
  AutoSaveUtils$1(String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    Object localObject3 = localFile.getAbsolutePath();
    String str = AppConstants.SDCARD_IMG_CAMERA;
    new File(str).mkdirs();
    Object localObject2 = Utils.Crc64String((String)localObject3);
    Object localObject1 = localObject2;
    if (!((String)localObject2).contains("."))
    {
      if (this.b) {
        localObject1 = com.tencent.mobileqq.utils.FileUtils.estimateFileType((String)localObject3);
      } else {
        localObject1 = com.tencent.mobileqq.utils.FileUtils.estimateVideoType((String)localObject3);
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(".");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    localObject1 = new File(str, (String)localObject1);
    if ((!((File)localObject1).exists()) && (FileUtil.a(localFile, (File)localObject1)))
    {
      if (this.b)
      {
        ImageUtil.a(BaseApplicationImpl.getApplication(), (File)localObject1);
        FileProvider7Helper.savePhotoToSysAlbum(BaseApplicationImpl.getApplication(), (File)localObject1);
      }
      else
      {
        com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplicationImpl.getApplication(), (File)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("autoSavePic success:");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        QLog.d("AutoSaveUtils", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.AutoSaveUtils.1
 * JD-Core Version:    0.7.0.1
 */