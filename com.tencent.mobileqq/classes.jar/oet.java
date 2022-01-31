import com.tencent.biz.qqstory.takevideo.EditVideoSave;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.mobileqq.widget.QQToast;

public class oet
  implements Runnable
{
  public oet(EditVideoSave paramEditVideoSave) {}
  
  public void run()
  {
    this.a.h();
    QQToast.a(this.a.a.a(), 2, "已保存到系统相册", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oet
 * JD-Core Version:    0.7.0.1
 */