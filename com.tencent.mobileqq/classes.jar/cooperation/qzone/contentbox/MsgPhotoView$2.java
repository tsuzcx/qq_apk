package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aoch;
import blws;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.contentbox.model.MQMsg;

class MsgPhotoView$2
  implements Runnable
{
  MsgPhotoView$2(MsgPhotoView paramMsgPhotoView, MQMsg paramMQMsg) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidContentContext == null) || (this.this$0.jdField_a_of_type_Blws == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = aoch.a(1, 3);
      localObject = aoch.a(((BaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext).app, 1, this.a.user_avatar, 3, (Drawable)localObject, (Drawable)localObject, null);
    } while (this.this$0.jdField_a_of_type_Blws == null);
    this.this$0.jdField_a_of_type_Blws.obtainMessage(10001, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.2
 * JD-Core Version:    0.7.0.1
 */