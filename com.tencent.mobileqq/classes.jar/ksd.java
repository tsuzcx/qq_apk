import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ksd
  implements Runnable
{
  public ksd(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    Object localObject = this.a.a.a(1, this.a.d, (byte)1, true, 0);
    if (localObject != null)
    {
      localObject = this.a.a((Bitmap)localObject);
      if (localObject != null) {
        AccountDetailActivity.c(this.a, new kse(this, (Drawable)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksd
 * JD-Core Version:    0.7.0.1
 */