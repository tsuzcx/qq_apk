import java.io.File;

class svi
  implements Comparable<svi>
{
  public long a;
  public final File a;
  
  public svi(svh paramsvh, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramsvh = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramsvh);
      return;
    }
    catch (Exception paramFile)
    {
      ved.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramsvh, paramFile.getMessage() });
    }
  }
  
  public int a(svi paramsvi)
  {
    if (this.jdField_a_of_type_Long < paramsvi.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramsvi.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svi
 * JD-Core Version:    0.7.0.1
 */