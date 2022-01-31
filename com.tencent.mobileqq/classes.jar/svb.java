import android.support.annotation.NonNull;
import java.io.File;

public abstract class svb
{
  protected svb a;
  protected String[] a;
  
  public svb(@NonNull String[] paramArrayOfString)
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
  
  public svb a(svb paramsvb)
  {
    this.jdField_a_of_type_Svb = paramsvb;
    return this.jdField_a_of_type_Svb;
  }
  
  public void a(File paramFile)
  {
    try
    {
      vyf.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      ved.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(svc paramsvc)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramsvc);
    if (this.jdField_a_of_type_Svb != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Svb.a(paramsvc);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ved.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = vyf.a() / 1024L;
      ved.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramsvc.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramsvc.jdField_a_of_type_Int != 0) {
        vei.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramsvc.jdField_a_of_type_Int), String.valueOf(paramsvc.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramsvc.jdField_b_of_type_Int == 0);
    vei.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramsvc.jdField_b_of_type_Int), String.valueOf(paramsvc.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, svc paramsvc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svb
 * JD-Core Version:    0.7.0.1
 */