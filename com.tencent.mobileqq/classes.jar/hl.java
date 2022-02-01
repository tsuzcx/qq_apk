import android.text.TextUtils;
import com.immersion.touchsensesdk.AsyncConnectionProxy;
import com.immersion.touchsensesdk.IConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class hl
  extends AsyncConnectionProxy
{
  private WeakReference<QQAppInterface> a;
  
  public hl()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      this.a = new WeakReference((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
  }
  
  public void connect(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    hm localhm = (hm)((QQAppInterface)this.a.get()).getBusinessHandler(BusinessHandlerFactory.IMMERSION_HANDLER);
    localhm.a(this);
    localhm.a(paramString);
  }
  
  public void setConnection(IConnection paramIConnection)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("HapticMediaPlayer connection == NULL -->");
      if (paramIConnection != null) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ImmerIConnectionProxy", 2, bool);
      super.setConnection(paramIConnection);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     hl
 * JD-Core Version:    0.7.0.1
 */