package com.tencent.ttpic.offlineset.utils;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.zip.ZipUtils;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;

final class OfflineSettingUtils$1
  implements IResponseListener
{
  public void response(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    if (paramInt2 == 1)
    {
      localObject = new StringBuilder();
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        LogUtils.e("OfflineSettingUtils", paramObject + " response ERROR:" + paramInt1 + "->" + paramString);
      }
    }
    do
    {
      do
      {
        return;
        paramObject = "";
        break;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (!(paramObject instanceof String));
      try
      {
        paramString = GsonUtils.json2JsonObject(paramString);
        if (OfflineSettingUtils.access$000(paramString))
        {
          OfflineSettingUtils.access$100(paramString, (String)paramObject);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      OfflineSettingUtils.access$200((String)paramObject);
      LogUtils.i("OfflineSettingUtils", "暂且不需要进行更新离线配置：" + (String)paramObject);
      return;
    } while ((paramString == null) || (!(paramObject instanceof String)));
    LogUtils.i("OfflineSettingUtils", "zip:" + paramString);
    Object localObject = ZipUtils.unZip(paramString, FileOfflineUtil.getOfflineDirPath() + File.separator + paramObject);
    LogUtils.i("OfflineSettingUtils", "unzip:" + (String)localObject);
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    OfflineSettingUtils.access$200((String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.utils.OfflineSettingUtils.1
 * JD-Core Version:    0.7.0.1
 */