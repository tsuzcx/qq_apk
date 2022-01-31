import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class oax
  implements Runnable
{
  public oax(MessageNotifySegment paramMessageNotifySegment, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    String str = localUserManager.b(Long.toString(MessageNotifySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMessageNotifySegment)), true);
    ThreadManager.getUIHandler().post(new oay(this, str, localUserManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oax
 * JD-Core Version:    0.7.0.1
 */