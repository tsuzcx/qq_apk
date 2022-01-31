package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import apon;
import apxf;
import bayx;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VasExtensionDownloader$1
  implements Runnable
{
  public VasExtensionDownloader$1(bayx parambayx, apxf paramapxf) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof AppInterface)) {}
    CustomEmotionData localCustomEmotionData;
    do
    {
      return;
      localObject = (apon)((AppInterface)localObject).getManager(149);
      localCustomEmotionData = (CustomEmotionData)((apon)localObject).a(this.a.f);
    } while ((localCustomEmotionData == null) || (!new File(this.a.e).exists()));
    if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
      localCustomEmotionData.RomaingType = "isUpdate";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasExtensionDownloader", 2, "update CustomEmotionData romaing type  isUpdate, path: " + this.a.e);
      }
      if ((TextUtils.isEmpty(localCustomEmotionData.md5)) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath));
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "update CustomEmotionData md5 , path: " + this.a.e);
        }
      }
      if ("needDel".equals(localCustomEmotionData.RomaingType)) {
        break;
      }
      ((apon)localObject).b(localCustomEmotionData);
      return;
      if ("overflow".equals(localCustomEmotionData.RomaingType)) {
        localCustomEmotionData.RomaingType = "overflow_downloaded";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasExtensionDownloader.1
 * JD-Core Version:    0.7.0.1
 */