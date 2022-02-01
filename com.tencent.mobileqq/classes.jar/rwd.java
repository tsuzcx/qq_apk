import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class rwd
  extends DefaultPTSLiteEventListener
{
  rwd(rwc paramrwc) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer)
  {
    qyl.a.a(paramPTSComposer, paramHashMap);
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("RIJUGCPopupPtsLiteBuilder", 1, "[onTapEventTriggered], identifier is empty.");
    }
    do
    {
      do
      {
        return;
        if (TextUtils.equals(paramString, "editPersonalProfile"))
        {
          RIJUGCAddAccountFragment.b(rwc.a(this.a));
          RIJUGCAddAccountFragment.a(RIJUGCAddAccountFragment.c);
          return;
        }
      } while (!TextUtils.equals(paramString, "useOriginalAccount"));
      RIJUGCAddAccountFragment.a(rwc.a(this.a));
      RIJUGCAddAccountFragment.a(RIJUGCAddAccountFragment.b);
    } while (!(rwc.a(this.a) instanceof BaseActivity));
    ((BaseActivity)rwc.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwd
 * JD-Core Version:    0.7.0.1
 */