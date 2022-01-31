import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class qdm
  implements rjj
{
  qdm(qdi paramqdi, String paramString) {}
  
  public void a()
  {
    QLog.w("Q.pubaccount.video.feeds.VideoFeedsIPCServer", 1, "loadViolaPageFailed");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if ((SplashActivity.a == null) || (SplashActivity.a.get() == null)) {
        break label53;
      }
    }
    label53:
    for (Object localObject = (ContextWrapper)SplashActivity.a.get();; localObject = BaseApplicationImpl.getContext())
    {
      obz.a((Context)localObject, this.jdField_a_of_type_JavaLangString, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdm
 * JD-Core Version:    0.7.0.1
 */