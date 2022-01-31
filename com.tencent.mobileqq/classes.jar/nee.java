import com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep;
import java.io.File;

public class nee
  implements Comparable
{
  public final long a;
  public final File a;
  
  public nee(CapacityCleanStep paramCapacityCleanStep, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(nee paramnee)
  {
    if (this.jdField_a_of_type_Long < paramnee.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramnee.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nee
 * JD-Core Version:    0.7.0.1
 */