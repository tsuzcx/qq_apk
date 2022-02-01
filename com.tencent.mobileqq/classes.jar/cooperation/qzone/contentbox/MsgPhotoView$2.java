package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import cooperation.qzone.contentbox.model.MQMsg;

class MsgPhotoView$2
  implements Runnable
{
  MsgPhotoView$2(MsgPhotoView paramMsgPhotoView, MQMsg paramMQMsg) {}
  
  public void run()
  {
    if (this.this$0.mContext != null)
    {
      if (this.this$0.mUiHandler == null) {
        return;
      }
      Object localObject = FaceDrawable.getDefaultDrawable(1, 3);
      localObject = FaceDrawable.getFaceDrawable(((BaseActivity)this.this$0.mContext).app, 1, this.val$data.user_avatar, 3, (Drawable)localObject, (Drawable)localObject, null);
      if (this.this$0.mUiHandler != null) {
        this.this$0.mUiHandler.obtainMessage(10001, localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgPhotoView.2
 * JD-Core Version:    0.7.0.1
 */