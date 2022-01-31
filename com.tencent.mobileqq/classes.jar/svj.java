import java.io.File;

class svj
  implements Comparable<svj>
{
  public final long a;
  public final File a;
  
  public svj(svi paramsvi, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(svj paramsvj)
  {
    if (this.jdField_a_of_type_Long < paramsvj.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramsvj.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svj
 * JD-Core Version:    0.7.0.1
 */