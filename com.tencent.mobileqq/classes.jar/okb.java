import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator;
import com.tencent.qphone.base.util.QLog;

public class okb
  implements Runnable
{
  public okb(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.g();
      PersonalityOperator localPersonalityOperator = (PersonalityOperator)this.a.a.a(102);
      if (localPersonalityOperator != null) {
        localPersonalityOperator.b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okb
 * JD-Core Version:    0.7.0.1
 */