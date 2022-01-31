import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.notification.StoryMsgNotification;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;

public class ngk
  implements Runnable
{
  public ngk(StoryMsgNotification paramStoryMsgNotification, Context paramContext) {}
  
  public void run()
  {
    StoryMsgNotification.jdField_a_of_type_AndroidUtilSparseArray.clear();
    QNotificationManager localQNotificationManager = new QNotificationManager(this.jdField_a_of_type_AndroidContentContext);
    int j = StoryMsgNotification.jdField_a_of_type_AndroidUtilSparseIntArray.size();
    int i = 0;
    while (i < j)
    {
      localQNotificationManager.cancel("StoryMsgNotification", StoryMsgNotification.jdField_a_of_type_AndroidUtilSparseIntArray.get(StoryMsgNotification.jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngk
 * JD-Core Version:    0.7.0.1
 */