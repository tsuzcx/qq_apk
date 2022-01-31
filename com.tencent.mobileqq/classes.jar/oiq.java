import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator;

public class oiq
  implements Runnable
{
  public oiq(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    PersonalityOperator localPersonalityOperator = (PersonalityOperator)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(102);
    if (localPersonalityOperator != null)
    {
      localPersonalityOperator.a();
      localPersonalityOperator.a(this.a.jdField_a_of_type_Int, this.a.b);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.h();
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oiq
 * JD-Core Version:    0.7.0.1
 */