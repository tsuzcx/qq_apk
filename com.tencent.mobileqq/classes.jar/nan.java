import android.text.TextUtils;
import com.tencent.avgame.gameresult.GameResultFragment;
import com.tencent.avgame.gameresult.GameResultFragment.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nan
  implements aonu
{
  public nan(GameResultFragment paramGameResultFragment) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("GameResultFragment", 1, "getShareLinkCallback isSuccess: " + paramBoolean + " shareUrl: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      ThreadManager.getUIHandler().post(new GameResultFragment.3.1(this, paramString));
      return;
    }
    QQToast.a(this.a.a(), 1, 2131690382, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nan
 * JD-Core Version:    0.7.0.1
 */