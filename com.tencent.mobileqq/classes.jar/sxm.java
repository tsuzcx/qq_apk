import android.text.TextUtils;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class sxm
  extends FriendListObserver
{
  public sxm(Leba paramLeba) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((QZoneManagerImp)this.a.a.getManager(9) == null) {
      return;
    }
    Leba.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxm
 * JD-Core Version:    0.7.0.1
 */