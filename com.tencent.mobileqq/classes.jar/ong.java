import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.POIPostersRequestCallback;

public class ong
  implements LbsManager.LbsUpdateListener
{
  public ong(DoodleEmojiManager paramDoodleEmojiManager, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b("DoodleEmojiManager", "requestPoiFaces onLbsUpdate.");
    if ((paramBoolean) && (paramBasicLocation != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager.a(paramBasicLocation.b, paramBasicLocation.a, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback);
      return;
    }
    SLog.e("DoodleEmojiManager", "onLbsUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ong
 * JD-Core Version:    0.7.0.1
 */