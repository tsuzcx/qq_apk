package cooperation.qzone.thread;

import android.os.Looper;
import android.util.Printer;
import com.tencent.qphone.base.util.QLog;

class BaseHandler$1
  implements Printer
{
  BaseHandler$1(BaseHandler paramBaseHandler) {}
  
  public void println(String paramString)
  {
    if ((!BaseHandler.isBusy) && (!((Boolean)BaseHandler.isRegulated.get()).booleanValue())) {}
    do
    {
      return;
      if (!BaseHandler.access$000())
      {
        Looper.myLooper().setMessageLogging(null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseHandler", 2, paramString);
      }
      if ((paramString != null) && (paramString.contains(">>>>> Dispatching to"))) {
        BaseHandler.access$100(this.this$0);
      }
    } while ((paramString == null) || (!paramString.contains("<<<<< Finished to")));
    BaseHandler.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.thread.BaseHandler.1
 * JD-Core Version:    0.7.0.1
 */