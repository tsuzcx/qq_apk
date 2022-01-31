import java.io.File;

class sin
  implements Comparable<sin>
{
  public final long a;
  public final File a;
  
  public sin(sim paramsim, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(sin paramsin)
  {
    if (this.jdField_a_of_type_Long < paramsin.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramsin.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sin
 * JD-Core Version:    0.7.0.1
 */