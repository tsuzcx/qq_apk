package com.tencent.mobileqq.kandian.biz.video;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.EntranceDownloadInfo;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class EntranceButtonExposureHelper
{
  private static final String a;
  private static final EntranceButtonExposureHelper d = new EntranceButtonExposureHelper();
  private int b = 0;
  private int c = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video");
    localStringBuilder.append(EntranceButtonExposureHelper.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  private EntranceButtonExposureHelper()
  {
    if (d())
    {
      this.b = a("entrance_button_day_display_count");
      this.c = a("entrance_jump_app_display_count");
    }
    else
    {
      this.b = 0;
      this.c = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntranceButtonExposureHelper() mDayDisplayCount:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",mEntranceDownloadInfoDisplayCount:");
    localStringBuilder.append(this.c);
    b(localStringBuilder.toString());
  }
  
  private int a(String paramString)
  {
    return RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true).getInt(paramString, 0);
  }
  
  public static EntranceButtonExposureHelper a()
  {
    return d;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true) == null)
    {
      b("writeToSP() failed");
      return;
    }
    RIJSPUtils.a(paramString, Integer.valueOf(paramInt));
  }
  
  private static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, paramString);
    }
  }
  
  private static boolean d()
  {
    Object localObject1 = Calendar.getInstance();
    int i = ((Calendar)localObject1).get(1);
    int j = ((Calendar)localObject1).get(2);
    int k = ((Calendar)localObject1).get(5);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(k);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true);
    if (localObject2 == null)
    {
      b("checkIsToday() failed");
      return false;
    }
    String str = ((SharedPreferences)localObject2).getString("entrance_button_daily", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsToday localDate = ");
    localStringBuilder.append(str);
    b(localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(str))) {
      return true;
    }
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("entrance_button_daily", (String)localObject1);
    RIJSPUtils.a((SharedPreferences.Editor)localObject2, true);
    return false;
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    try
    {
      boolean bool = d();
      if (bool) {
        this.b += 1;
      } else {
        this.b = 0;
      }
      a("entrance_button_day_display_count", this.b);
      if ((paramIEntranceButtonDataSource instanceof VideoInfo.EntranceDownloadInfo))
      {
        if (bool) {
          this.c += 1;
        } else {
          this.c = 0;
        }
        a("entrance_jump_app_display_count", this.c);
      }
      paramIEntranceButtonDataSource = new StringBuilder();
      paramIEntranceButtonDataSource.append("addToCount() mDayDisplayCount:");
      paramIEntranceButtonDataSource.append(this.b);
      paramIEntranceButtonDataSource.append("，mEntranceDownloadInfoDisplayCount：");
      paramIEntranceButtonDataSource.append(this.c);
      b(paramIEntranceButtonDataSource.toString());
      return;
    }
    finally {}
  }
  
  public int b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDayDisplayCount() mDayDisplayCount:");
      localStringBuilder.append(this.b);
      b(localStringBuilder.toString());
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int c()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.EntranceButtonExposureHelper
 * JD-Core Version:    0.7.0.1
 */