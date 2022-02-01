package cooperation.qqreader.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.net.ReaderCgiNetThreadCallback;
import cooperation.qqreader.net.ReaderCgiResponse;

final class Utility$1
  extends ReaderCgiNetThreadCallback
{
  Utility$1(Context paramContext) {}
  
  public void b(@NonNull ReaderCgiResponse paramReaderCgiResponse)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.e("Utility", 2, "-->getEntryControl:connection recv data!");
    }
    paramReaderCgiResponse = paramReaderCgiResponse.a();
    boolean bool1 = bool2;
    if (paramReaderCgiResponse != null)
    {
      paramReaderCgiResponse = Utility.a("on_off", paramReaderCgiResponse);
      if (paramReaderCgiResponse == null) {
        bool1 = bool2;
      }
    }
    else
    {
      SharedPrefrenceForQQ.a(this.a, bool1);
      return;
    }
    if (((Integer)paramReaderCgiResponse).intValue() == 1) {}
    for (bool1 = true;; bool1 = false) {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.utils.Utility.1
 * JD-Core Version:    0.7.0.1
 */