import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;

public class obl
  extends PtvTemplateManager.DoodleInfoLoadObserver
{
  public obl(EditPicActivity paramEditPicActivity) {}
  
  public void a()
  {
    SLog.c("EditPicActivity", "DoodleInfoLoadObserver, onLoadSucc");
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.a.a.a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.J_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obl
 * JD-Core Version:    0.7.0.1
 */