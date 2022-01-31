import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoPermission;

public class oft
  implements Runnable
{
  public oft(EditVideoPermission paramEditVideoPermission) {}
  
  public void run()
  {
    if (EditVideoPermission.a(this.a))
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.a.a.a(0);
      EditVideoPermission.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oft
 * JD-Core Version:    0.7.0.1
 */