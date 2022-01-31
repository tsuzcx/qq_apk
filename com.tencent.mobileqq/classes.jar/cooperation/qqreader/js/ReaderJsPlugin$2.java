package cooperation.qqreader.js;

import android.os.SystemClock;
import bfmb;
import bfne;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import cooperation.qqreader.QRBridgeUtil;
import mqq.os.MqqHandler;

public class ReaderJsPlugin$2
  implements Runnable
{
  public ReaderJsPlugin$2(bfmb parambfmb, long paramLong, JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {}
  
  public void run()
  {
    bfne.c("ReaderJsPlugin", "waitPluginAndHandleJsCall start");
    if (!QRBridgeUtil.isPluginReady()) {
      for (long l = 0L; (!QRBridgeUtil.isPluginReady()) && (l < this.jdField_a_of_type_Long); l += 50L) {
        SystemClock.sleep(50L);
      }
    }
    if (QRBridgeUtil.isPluginReady()) {
      ThreadManager.getUIHandler().post(new ReaderJsPlugin.2.1(this));
    }
    for (;;)
    {
      bfne.c("ReaderJsPlugin", "waitPluginAndHandleJsCall end");
      return;
      ThreadManager.getUIHandler().post(new ReaderJsPlugin.2.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.js.ReaderJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */