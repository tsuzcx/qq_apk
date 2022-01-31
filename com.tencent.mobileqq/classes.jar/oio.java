import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.troop.data.TroopBarPOI;

public class oio
  implements EditVideoPoiPickerCallback
{
  public oio(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocationCancel");
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "onSelectLocation " + paramTroopBarPOI);
    if (paramTroopBarPOI != null)
    {
      this.a.a.setLocation(paramTroopBarPOI.a());
      return;
    }
    this.a.a.setLocation("None for test!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oio
 * JD-Core Version:    0.7.0.1
 */