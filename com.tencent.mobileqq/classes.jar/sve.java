import android.support.annotation.NonNull;
import java.io.File;

public abstract class sve
{
  protected sve a;
  protected String[] a;
  
  public sve(@NonNull String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public static double a(File paramFile)
  {
    double d1 = 0.0D;
    double d2;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      d2 = d1;
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          d2 = d1;
          if (i >= j) {
            break;
          }
          d2 = a(paramFile[i]);
          i += 1;
          d1 = d2 + d1;
        }
      }
    }
    else
    {
      d2 = paramFile.length() / 1024.0D / 1024.0D;
    }
    return d2;
  }
  
  public sve a(sve paramsve)
  {
    this.jdField_a_of_type_Sve = paramsve;
    return this.jdField_a_of_type_Sve;
  }
  
  public void a(File paramFile)
  {
    try
    {
      vyi.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      veg.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(svf paramsvf)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramsvf);
    if (this.jdField_a_of_type_Sve != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Sve.a(paramsvf);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          veg.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = vyi.a() / 1024L;
      veg.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramsvf.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramsvf.jdField_a_of_type_Int != 0) {
        vel.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramsvf.jdField_a_of_type_Int), String.valueOf(paramsvf.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramsvf.jdField_b_of_type_Int == 0);
    vel.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramsvf.jdField_b_of_type_Int), String.valueOf(paramsvf.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, svf paramsvf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sve
 * JD-Core Version:    0.7.0.1
 */