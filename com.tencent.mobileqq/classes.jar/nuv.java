import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nuv
{
  private static nuv jdField_a_of_type_Nuv = new nuv();
  private long jdField_a_of_type_Long;
  private nux jdField_a_of_type_Nux = new nux(null);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static nuv a()
  {
    try
    {
      if (jdField_a_of_type_Nuv == null) {
        jdField_a_of_type_Nuv = new nuv();
      }
      nuv localnuv = jdField_a_of_type_Nuv;
      return localnuv;
    }
    finally {}
  }
  
  public static void b(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoId", paramString2);
    localHashMap.put("uin", paramString1);
    bctj.a(BaseApplicationImpl.getContext()).a("", "IMAX_Ad_VIDEO_PRELOADED_RATE", true, 0L, 0L, localHashMap, "", false);
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, "reportImaxVideoCoverRate:" + paramString2);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Nux.jdField_c_of_type_Long == -1L) {
      this.jdField_a_of_type_Nux.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Nux.a();
    this.jdField_a_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, "mClickTime:" + this.jdField_a_of_type_Long + " sToolShowTime:" + BaseApplicationImpl.sToolShowTime);
    }
    if ((BaseApplicationImpl.sToolShowTime == 0L) || (BaseApplicationImpl.sToolShowTime > paramLong)) {
      this.jdField_a_of_type_Nux.jdField_a_of_type_Int = 0;
    }
    for (this.jdField_a_of_type_Nux.jdField_b_of_type_Long = (BaseApplicationImpl.sToolShowTime - paramLong);; this.jdField_a_of_type_Nux.jdField_b_of_type_Long = 0L)
    {
      long l = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Nux.jdField_a_of_type_Long = (l - paramLong);
      this.jdField_a_of_type_Nux.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Nux.jdField_a_of_type_Boolean = paramBoolean;
      return;
      this.jdField_a_of_type_Nux.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Nux.jdField_a_of_type_JavaLangString = "IMAX_Ad_videoLoadErr";
    HashMap localHashMap = new HashMap();
    localHashMap.put("adId", paramString1);
    localHashMap.put("vid", paramString2);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, this.jdField_a_of_type_Nux.toString());
    }
    bctj.a(BaseApplicationImpl.getContext()).a("", "IMAX_Ad_videoLoadErr", true, l1 - l2, 0L, localHashMap, "", false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_Nux.jdField_a_of_type_JavaLangString = "IMAX_Ad_Remind_Dialog_Click";
    this.jdField_a_of_type_Nux.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Nux.jdField_c_of_type_JavaLangString = paramString2;
    paramString1 = this.jdField_a_of_type_Nux.a();
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, this.jdField_a_of_type_Nux.toString() + " ok " + paramBoolean);
    }
    bctj.a(BaseApplicationImpl.getContext()).a("", this.jdField_a_of_type_Nux.jdField_a_of_type_JavaLangString, paramBoolean, this.jdField_a_of_type_Nux.jdField_c_of_type_Long, 0L, paramString1, "", false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nux.jdField_b_of_type_Int == -1)
    {
      this.jdField_a_of_type_Nux.jdField_c_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_Nux;
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      paramString.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    HashMap localHashMap = this.jdField_a_of_type_Nux.a();
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Nux.jdField_a_of_type_JavaLangString = "IMAX_Ad_StartCost_ByUsr";; this.jdField_a_of_type_Nux.jdField_a_of_type_JavaLangString = "IMAX_Ad_StartCost")
    {
      bctj.a(BaseApplicationImpl.getContext()).a("", this.jdField_a_of_type_Nux.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_Nux.d, 0L, localHashMap, "", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AdvertisementStatistics", 2, "remindUsr:" + paramBoolean + this.jdField_a_of_type_Nux.toString());
      return;
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nux.d == -1L)
    {
      this.jdField_a_of_type_Nux.jdField_c_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Nux.d = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nuv
 * JD-Core Version:    0.7.0.1
 */