package cooperation.qzone.video;

import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;

final class QzoneLiveVideoInterface$2
  implements Runnable
{
  QzoneLiveVideoInterface$2(IWebviewOnClassLoaded paramIWebviewOnClassLoaded) {}
  
  public void run()
  {
    try
    {
      if (1 != QzoneLiveVideoInterface.getIntConfig("LiveSetting", "qzone_webview_need_preload_dex_classes", 1)) {
        return;
      }
      if (!QzoneLiveVideoInterface.isBestPerformanceDevice()) {
        return;
      }
      if (!SwiftWebAccelerator.TbsAccelerator.a())
      {
        long l = System.currentTimeMillis();
        SwiftWebAccelerator.TbsAccelerator.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saxon@ 预加载 TbsAccelerator init cost ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.i("QzoneLiveVideoInterface", 2, localStringBuilder.toString());
      }
      else
      {
        QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator is inited");
      }
      if (this.val$listener != null)
      {
        this.val$listener.onLoadClassFinish();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QzoneLiveVideoInterface", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.2
 * JD-Core Version:    0.7.0.1
 */