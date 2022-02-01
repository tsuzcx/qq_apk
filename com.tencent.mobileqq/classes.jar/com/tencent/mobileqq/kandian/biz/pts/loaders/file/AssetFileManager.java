package com.tencent.mobileqq.kandian.biz.pts.loaders.file;

import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

public class AssetFileManager
{
  private static String a;
  private static boolean b = a();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getDataDirectory());
    localStringBuilder.append("/data/");
    localStringBuilder.append(BaseApplicationImpl.sApplication.getBaseContext().getPackageName());
    a = localStringBuilder.toString();
  }
  
  private static boolean a()
  {
    return AppSetting.b.equals(RIJSPUtils.d("COPY_ASSET_VERSION", "", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.file.AssetFileManager
 * JD-Core Version:    0.7.0.1
 */