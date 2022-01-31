import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;

public class ocn
  extends PtvTemplateManager.DoodleInfoLoadObserver
{
  public ocn(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "DoodleInfoLoadObserver, onLoadSucc");
    this.a.J_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocn
 * JD-Core Version:    0.7.0.1
 */