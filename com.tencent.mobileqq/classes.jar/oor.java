import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;

public class oor
  implements Runnable
{
  public oor(PersonalityOperator paramPersonalityOperator, QQVideoMaterial paramQQVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.getId());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.a, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodlePersonalityOperator.b, 1.0D);
    long l2 = System.currentTimeMillis();
    SLog.b("PersonalityOperator", "setVideoFilter " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterMaterialQQVideoMaterial.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oor
 * JD-Core Version:    0.7.0.1
 */