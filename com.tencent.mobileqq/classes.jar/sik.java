import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

@TargetApi(14)
public class sik
{
  public static final String a;
  protected static sik a;
  public static final String[] a;
  public static final String b;
  public static final String[] b;
  public static final String[] c = { sfm.i };
  public static final String[] d = { sfm.e };
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.bl + "qqstory/";
    jdField_b_of_type_JavaLangString = ajed.bl + "qqstory_watermark/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { sfm.h, sfm.k, sfm.u };
  }
  
  public static sik a()
  {
    if (jdField_a_of_type_Sik == null) {
      jdField_a_of_type_Sik = new sik();
    }
    return jdField_a_of_type_Sik;
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.post(new CacheCleaner.2(this, paramBoolean), 2, null, false);
  }
  
  public void a()
  {
    Bosses.get().postJob(new sil(this, "Q.qqstory.cleaner:CacheCleaner"));
  }
  
  protected boolean a(boolean paramBoolean)
  {
    long l1 = 3600L;
    label185:
    for (;;)
    {
      try
      {
        spz localspz = (spz)sqg.a(10);
        long l2 = System.currentTimeMillis();
        long l3 = ((Long)localspz.b("cache_clean_latest_time", Long.valueOf(0L))).longValue();
        String str1;
        if (paramBoolean)
        {
          l3 = Math.abs(l2 - l3);
          if (l3 < l1 * 1000L)
          {
            l1 = l3 / 1000L / 60L / 60L;
            if (!paramBoolean) {
              break label185;
            }
            str1 = "low";
            urk.a("Q.qqstory.cleaner:CacheCleaner", "clean before %d h , no need to clean again , capacity state :%s", Long.valueOf(l1), str1);
            paramBoolean = false;
            return paramBoolean;
          }
        }
        else
        {
          l1 = ((Long)localspz.b("StoryClearRate", Long.valueOf(3600L))).longValue();
          continue;
        }
        if (paramBoolean)
        {
          str1 = "low";
          urk.d("Q.qqstory.cleaner:CacheCleaner", "clean cache , capacity state :%s", new Object[] { str1 });
          localspz.b("cache_clean_latest_time", Long.valueOf(l2));
          paramBoolean = true;
        }
        else
        {
          str1 = "healthy";
          continue;
          String str2 = "healthy";
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sik
 * JD-Core Version:    0.7.0.1
 */