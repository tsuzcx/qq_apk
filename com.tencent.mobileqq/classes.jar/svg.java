import java.io.File;

class svg
  implements Comparable<svg>
{
  public final long a;
  public final File a;
  
  public svg(svf paramsvf, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(svg paramsvg)
  {
    if (this.jdField_a_of_type_Long < paramsvg.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramsvg.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svg
 * JD-Core Version:    0.7.0.1
 */