import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditJumpToPtu;
import com.tencent.biz.qqstory.takevideo.EditJumpToPtu.UIHandler;
import com.tencent.biz.qqstory.takevideo.EditPicConstants;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class ocv
  implements Runnable
{
  public ocv(EditJumpToPtu paramEditJumpToPtu) {}
  
  public void run()
  {
    EditJumpToPtu.a(this.a, EditPicConstants.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.a.a(EditJumpToPtu.a(this.a)))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditJumpToPtu$UIHandler.sendEmptyMessage(1);
      return;
    }
    EditJumpToPtu.a(this.a, null);
    SLog.e("EditJumpToPtu", "get rawBitmap error!");
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditJumpToPtu$UIHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocv
 * JD-Core Version:    0.7.0.1
 */