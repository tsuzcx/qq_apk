package cooperation.comic.ui;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.comic.utils.FirstInObservable;
import cooperation.comic.utils.QQComicPluginBridge;
import java.util.Observable;
import java.util.Observer;

class QQComicFragment$1
  implements Observer
{
  QQComicFragment$1(QQComicFragment paramQQComicFragment, WebView paramWebView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QQComicPluginBridge.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "RuntimeCreateObserver update ");
      QQComicPluginBridge.a.a(this.jdField_a_of_type_ComTencentSmttSdkWebView.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicFragment.1
 * JD-Core Version:    0.7.0.1
 */