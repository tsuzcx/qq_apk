package com.tencent.mobileqq.richmediabrowser.report;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class FileCheckReport
{
  public static void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith(AppConstants.SDCARD_IMG_SAVE)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_file_path", paramString1);
      localHashMap.put("des_file_path", paramString2);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qq_images_file_delete", true, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.report.FileCheckReport
 * JD-Core Version:    0.7.0.1
 */