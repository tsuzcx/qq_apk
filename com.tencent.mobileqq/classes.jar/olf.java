import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoSave;

public class olf
  implements Runnable
{
  public olf(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      SLog.b("EditVideoSave", "[updateProgress]stopUpdateProgress = " + this.a.jdField_a_of_type_Boolean);
      return;
    }
    EditVideoSave localEditVideoSave = this.a;
    localEditVideoSave.jdField_a_of_type_Int += this.a.b;
    if (this.a.jdField_a_of_type_Int > 99)
    {
      this.a.jdField_a_of_type_Int = 99;
      this.a.a(this.a.jdField_a_of_type_Int);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_Int);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olf
 * JD-Core Version:    0.7.0.1
 */