import android.app.Notification;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nhv
  implements URLDrawable.URLDrawableListener
{
  public nhv(StoryMsgNotification paramStoryMsgNotification, NotificationCompat.Builder paramBuilder, QQAppInterface paramQQAppInterface, StoryPushMsg paramStoryPushMsg, int paramInt, String paramString1, String paramString2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
    paramThrowable = this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.build();
    this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, paramThrowable);
    StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).remove(paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, mURLDrawableList.size():" + StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).size());
    }
    Bitmap localBitmap = com.tencent.mobileqq.utils.ImageUtil.a(paramURLDrawable.getCurrDrawable(), 200, 200);
    Object localObject = com.tencent.biz.common.util.ImageUtil.b(localBitmap, 1);
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed start, cutBitmap.size():" + ((Bitmap)localObject).getHeight() + ", " + ((Bitmap)localObject).getWidth());
    }
    this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.setLargeIcon((Bitmap)localObject);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppNotificationCompat$Builder.build();
    this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryPushMsg, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, (Notification)localObject);
    localBitmap.recycle();
    StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StoryMsgNotification", 2, "thumbDrawable onLoadSuccessed, mURLDrawableList.size():" + StoryMsgNotification.a(this.jdField_a_of_type_ComTencentBizQqstoryNotificationStoryMsgNotification).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhv
 * JD-Core Version:    0.7.0.1
 */