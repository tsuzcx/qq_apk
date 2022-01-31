import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;

public class sgl
  implements Runnable
{
  public sgl(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void run()
  {
    if (this.a.app == null) {
      return;
    }
    Object localObject = this.a.app.getCurrentAccountUin();
    localObject = FaceDrawable.a(this.a.app, 3, (String)localObject);
    this.a.runOnUiThread(new sgm(this, (Drawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgl
 * JD-Core Version:    0.7.0.1
 */