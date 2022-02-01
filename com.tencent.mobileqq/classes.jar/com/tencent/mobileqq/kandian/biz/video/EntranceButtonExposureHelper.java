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
  private static final EntranceButtonExposureHelper jdField_a_of_type_ComTencentMobileqqKandianBizVideoEntranceButtonExposureHelper = new EntranceButtonExposureHelper();
  private static final String jdField_a_of_type_JavaLangString;
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video");
    localStringBuilder.append(EntranceButtonExposureHelper.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  private EntranceButtonExposureHelper()
  {
    if (a())
    {
      this.jdField_a_of_type_Int = a("entrance_button_day_display_count");
      this.b = a("entrance_jump_app_display_count");
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntranceButtonExposureHelper() mDayDisplayCount:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",mEntranceDownloadInfoDisplayCount:");
    localStringBuilder.append(this.b);
    a(localStringBuilder.toString());
  }
  
  private int a(String paramString)
  {
    return RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true).getInt(paramString, 0);
  }
  
  public static EntranceButtonExposureHelper a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizVideoEntranceButtonExposureHelper;
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (RIJSPUtils.a(RIJQQAppInterfaceUtil.a(), true, true) == null)
    {
      a("writeToSP() failed");
      return;
    }
    RIJSPUtils.a(paramString, Integer.valueOf(paramInt));
  }
  
  private static boolean a()
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
      a("checkIsToday() failed");
      return false;
    }
    String str = ((SharedPreferences)localObject2).getString("entrance_button_daily", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsToday localDate = ");
    localStringBuilder.append(str);
    a(localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(str))) {
      return true;
    }
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("entrance_button_daily", (String)localObject1);
    RIJSPUtils.a((SharedPreferences.Editor)localObject2, true);
    return false;
  }
  
  public int a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDayDisplayCount() mDayDisplayCount:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      a(localStringBuilder.toString());
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    try
    {
      boolean bool = a();
      if (bool) {
        this.jdField_a_of_type_Int += 1;
      } else {
        this.jdField_a_of_type_Int = 0;
      }
      a("entrance_button_day_display_count", this.jdField_a_of_type_Int);
      if ((paramIEntranceButtonDataSource instanceof VideoInfo.EntranceDownloadInfo))
      {
        if (bool) {
          this.b += 1;
        } else {
          this.b = 0;
        }
        a("entrance_jump_app_display_count", this.b);
      }
      paramIEntranceButtonDataSource = new StringBuilder();
      paramIEntranceButtonDataSource.append("addToCount() mDayDisplayCount:");
      paramIEntranceButtonDataSource.append(this.jdField_a_of_type_Int);
      paramIEntranceButtonDataSource.append("，mEntranceDownloadInfoDisplayCount：");
      paramIEntranceButtonDataSource.append(this.b);
      a(paramIEntranceButtonDataSource.toString());
      return;
    }
    finally {}
  }
  
  public int b()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.EntranceButtonExposureHelper
 * JD-Core Version:    0.7.0.1
 */