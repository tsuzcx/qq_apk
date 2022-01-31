package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import bjxe;
import bjyz;
import java.util.List;
import veg;

public class EditVideoPlayer$1
  implements Runnable
{
  public EditVideoPlayer$1(bjxe parambjxe, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (this.a < localList.size())) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setCurrentVideoFragment((bjyz)localList.get(this.a));
      if (this.a > this.b) {
        this.this$0.b.post(new EditVideoPlayer.1.1(this));
      }
      if ((localList != null) && (this.b < localList.size())) {
        this.this$0.a((bjyz)localList.get(this.b));
      }
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        veg.c("Q.qqstory.record.EditVideoPlayer", "setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */