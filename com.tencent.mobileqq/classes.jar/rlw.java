import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class rlw
  extends DefaultPTSLiteEventListener
{
  rlw(rlv paramrlv) {}
  
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
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
          RIJUGCAddAccountFragment.b(rlv.a(this.a));
          RIJUGCAddAccountFragment.a(RIJUGCAddAccountFragment.c);
          return;
        }
      } while (!TextUtils.equals(paramString, "useOriginalAccount"));
      RIJUGCAddAccountFragment.a(rlv.a(this.a));
      RIJUGCAddAccountFragment.a(RIJUGCAddAccountFragment.b);
    } while (!(rlv.a(this.a) instanceof BaseActivity));
    ((BaseActivity)rlv.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlw
 * JD-Core Version:    0.7.0.1
 */