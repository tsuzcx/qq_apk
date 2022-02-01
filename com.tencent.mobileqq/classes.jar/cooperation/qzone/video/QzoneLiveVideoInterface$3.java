package cooperation.qzone.video;

import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;

final class QzoneLiveVideoInterface$3
  implements Runnable
{
  QzoneLiveVideoInterface$3(IWebviewOnClassLoaded paramIWebviewOnClassLoaded) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (1 != QzoneLiveVideoInterface.getIntConfig("LiveSetting", "qzone_webview_need_preload_dex_classes", 1)) {
          return;
        }
        if (!QzoneLiveVideoInterface.isBestPerformanceDevice()) {
          break;
        }
        if (!SwiftWebAccelerator.TbsAccelerator.a())
        {
          long l = System.currentTimeMillis();
          SwiftWebAccelerator.TbsAccelerator.b();
          QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator init cost " + (System.currentTimeMillis() - l));
          if (this.val$listener == null) {
            break;
          }
          this.val$listener.onLoadClassFinish();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QzoneLiveVideoInterface", 1, localException, new Object[0]);
        return;
      }
      QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator is inited");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.3
 * JD-Core Version:    0.7.0.1
 */