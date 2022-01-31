import android.support.annotation.NonNull;
import java.io.File;

public abstract class sii
{
  protected sii a;
  protected String[] a;
  
  public sii(@NonNull String[] paramArrayOfString)
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
  
  public sii a(sii paramsii)
  {
    this.jdField_a_of_type_Sii = paramsii;
    return this.jdField_a_of_type_Sii;
  }
  
  public void a(File paramFile)
  {
    try
    {
      vlm.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      urk.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(sij paramsij)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramsij);
    if (this.jdField_a_of_type_Sii != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Sii.a(paramsij);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          urk.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = vlm.a() / 1024L;
      urk.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramsij.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramsij.jdField_a_of_type_Int != 0) {
        urp.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramsij.jdField_a_of_type_Int), String.valueOf(paramsij.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramsij.jdField_b_of_type_Int == 0);
    urp.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramsij.jdField_b_of_type_Int), String.valueOf(paramsij.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, sij paramsij);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sii
 * JD-Core Version:    0.7.0.1
 */