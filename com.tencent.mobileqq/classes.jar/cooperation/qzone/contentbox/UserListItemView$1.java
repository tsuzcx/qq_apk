package cooperation.qzone.contentbox;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;

class UserListItemView$1
  implements Runnable
{
  UserListItemView$1(UserListItemView paramUserListItemView, String paramString) {}
  
  public void run()
  {
    if ((UserListItemView.access$000(this.this$0) == null) || (UserListItemView.access$100(this.this$0) == null)) {
      return;
    }
    Object localObject = FaceDrawable.getDefaultDrawable(1, 3);
    localObject = FaceDrawable.getFaceDrawable(((BaseActivity)UserListItemView.access$000(this.this$0)).app, 1, this.val$uin, 3, (Drawable)localObject, (Drawable)localObject, null);
    UserListItemView.access$100(this.this$0).post(new UserListItemView.1.1(this, (FaceDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.UserListItemView.1
 * JD-Core Version:    0.7.0.1
 */