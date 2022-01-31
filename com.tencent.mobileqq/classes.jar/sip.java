import java.io.File;

class sip
  implements Comparable<sip>
{
  public long a;
  public final File a;
  
  public sip(sio paramsio, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramsio = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramsio);
      return;
    }
    catch (Exception paramFile)
    {
      urk.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramsio, paramFile.getMessage() });
    }
  }
  
  public int a(sip paramsip)
  {
    if (this.jdField_a_of_type_Long < paramsip.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramsip.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sip
 * JD-Core Version:    0.7.0.1
 */