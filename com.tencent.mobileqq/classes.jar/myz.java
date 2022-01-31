import com.tencent.biz.qqstory.base.preload.cachecleaner.MyVideoCleanStep;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

public class myz
  implements Comparable
{
  public long a;
  public final File a;
  
  public myz(MyVideoCleanStep paramMyVideoCleanStep, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramMyVideoCleanStep = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramMyVideoCleanStep);
      return;
    }
    catch (Exception paramFile)
    {
      SLog.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramMyVideoCleanStep, paramFile.getMessage() });
    }
  }
  
  public int a(myz parammyz)
  {
    if (this.jdField_a_of_type_Long < parammyz.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == parammyz.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myz
 * JD-Core Version:    0.7.0.1
 */