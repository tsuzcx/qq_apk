import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;

public class oef
  extends PtvTemplateManager.DoodleInfoLoadObserver
{
  public oef(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    SLog.c("Q.qqstory.publish.edit.StoryDoodle", "DoodleInfoLoadObserver, onLoadSucc");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oef
 * JD-Core Version:    0.7.0.1
 */