package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Message;
import bdbk;
import bjik;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.contentbox.model.MQMsg;

class MsgPhotoView$2
  implements Runnable
{
  MsgPhotoView$2(MsgPhotoView paramMsgPhotoView, MQMsg paramMQMsg) {}
  
  public void run()
  {
    Object localObject = bdbk.a(1, 3);
    localObject = bdbk.a(((BaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext).app, 1, this.a.user_avatar, 3, (Drawable)localObject, (Drawable)localObject, null);
    if (this.this$0.jdField_a_of_type_Bjik != null) {
      this.this$0.jdField_a_of_type_Bjik.obtainMessage(10001, localObject).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.2
 * JD-Core Version:    0.7.0.1
 */