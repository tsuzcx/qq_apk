import android.app.Activity;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public final class mvi
  implements BusinessObserver
{
  public mvi(Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new mvj(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvi
 * JD-Core Version:    0.7.0.1
 */