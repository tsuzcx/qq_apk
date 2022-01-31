import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class pxp
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + pxp.class.getSimpleName();
  private static final pxp jdField_a_of_type_Pxp = new pxp();
  private int jdField_a_of_type_Int;
  private int b;
  
  private pxp()
  {
    if (a()) {
      this.jdField_a_of_type_Int = a("entrance_button_day_display_count");
    }
    for (this.b = a("entrance_jump_app_display_count");; this.b = 0)
    {
      a("EntranceButtonExposureHelper() mDayDisplayCount:" + this.jdField_a_of_type_Int + ",mEntranceDownloadInfoDisplayCount:" + this.b);
      return;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private int a(String paramString)
  {
    return bgmq.a(obz.a(), true, true).getInt(paramString, 0);
  }
  
  public static pxp a()
  {
    return jdField_a_of_type_Pxp;
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (bgmq.a(obz.a(), true, true) == null)
    {
      a("writeToSP() failed");
      return;
    }
    bgmq.a(paramString, Integer.valueOf(paramInt));
  }
  
  private static boolean a()
  {
    Object localObject1 = Calendar.getInstance();
    int i = ((Calendar)localObject1).get(1);
    int j = ((Calendar)localObject1).get(2);
    int k = ((Calendar)localObject1).get(5);
    localObject1 = i + j + k;
    Object localObject2 = bgmq.a(obz.a(), true, true);
    if (localObject2 == null)
    {
      a("checkIsToday() failed");
      return false;
    }
    String str = ((SharedPreferences)localObject2).getString("entrance_button_daily", null);
    a("checkIsToday localDate = " + str);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(str))) {
      return true;
    }
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putString("entrance_button_daily", (String)localObject1);
    bgmq.a((SharedPreferences.Editor)localObject2, true);
    return false;
  }
  
  public int a()
  {
    try
    {
      a("getDayDisplayCount() mDayDisplayCount:" + this.jdField_a_of_type_Int);
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(rik paramrik)
  {
    for (;;)
    {
      try
      {
        boolean bool = a();
        if (bool)
        {
          this.jdField_a_of_type_Int += 1;
          a("entrance_button_day_display_count", this.jdField_a_of_type_Int);
          if ((paramrik instanceof VideoInfo.EntranceDownloadInfo))
          {
            if (bool)
            {
              this.b += 1;
              a("entrance_jump_app_display_count", this.b);
            }
          }
          else {
            a("addToCount() mDayDisplayCount:" + this.jdField_a_of_type_Int + "，mEntranceDownloadInfoDisplayCount：" + this.b);
          }
        }
        else
        {
          this.jdField_a_of_type_Int = 0;
          continue;
        }
        this.b = 0;
      }
      finally {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxp
 * JD-Core Version:    0.7.0.1
 */