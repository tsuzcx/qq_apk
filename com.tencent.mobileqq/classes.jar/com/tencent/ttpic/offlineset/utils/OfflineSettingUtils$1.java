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
    Object localObject;
    if (paramInt2 == 1)
    {
      localObject = new StringBuilder();
      if ((paramObject instanceof String)) {
        paramObject = (String)paramObject;
      } else {
        paramObject = "";
      }
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(" response ERROR:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(paramString);
      LogUtils.e("OfflineSettingUtils", ((StringBuilder)localObject).toString());
      return;
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return;
      }
      if ((paramString != null) && ((paramObject instanceof String)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("zip:");
        ((StringBuilder)localObject).append(paramString);
        LogUtils.i("OfflineSettingUtils", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FileOfflineUtil.getOfflineDirPath());
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramObject);
        localObject = ZipUtils.unZip(paramString, ((StringBuilder)localObject).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unzip:");
        localStringBuilder.append((String)localObject);
        LogUtils.i("OfflineSettingUtils", localStringBuilder.toString());
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
        OfflineSettingUtils.access$200((String)paramObject);
      }
    }
    else if ((paramObject instanceof String))
    {
      try
      {
        paramString = GsonUtils.json2JsonObject(paramString);
        if (OfflineSettingUtils.access$000(paramString))
        {
          OfflineSettingUtils.access$100(paramString, (String)paramObject);
          return;
        }
        paramString = (String)paramObject;
        OfflineSettingUtils.access$200(paramString);
        paramObject = new StringBuilder();
        paramObject.append("暂且不需要进行更新离线配置：");
        paramObject.append(paramString);
        LogUtils.i("OfflineSettingUtils", paramObject.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.utils.OfflineSettingUtils.1
 * JD-Core Version:    0.7.0.1
 */