import com.tencent.biz.qqstory.base.preload.cachecleaner.CapacityCleanStep;
import java.io.File;

public class myy
  implements Comparable
{
  public final long a;
  public final File a;
  
  public myy(CapacityCleanStep paramCapacityCleanStep, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(myy parammyy)
  {
    if (this.jdField_a_of_type_Long < parammyy.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == parammyy.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myy
 * JD-Core Version:    0.7.0.1
 */