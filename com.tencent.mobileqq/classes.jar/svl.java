import java.io.File;

class svl
  implements Comparable<svl>
{
  public long a;
  public final File a;
  
  public svl(svk paramsvk, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramsvk = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramsvk);
      return;
    }
    catch (Exception paramFile)
    {
      veg.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramsvk, paramFile.getMessage() });
    }
  }
  
  public int a(svl paramsvl)
  {
    if (this.jdField_a_of_type_Long < paramsvl.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramsvl.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svl
 * JD-Core Version:    0.7.0.1
 */