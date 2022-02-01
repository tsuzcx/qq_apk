package cooperation.qqreader;

import android.app.Activity;
import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;

class ReaderSplashImpl$3
  implements EnterCallback
{
  ReaderSplashImpl$3(ReaderSplashImpl paramReaderSplashImpl) {}
  
  public void onCloseLoadingView() {}
  
  public void onEnterComplete() {}
  
  public void onShowLoadingView(View paramView)
  {
    ReaderSplashImpl.a(this.a).runOnUiThread(new ReaderSplashImpl.3.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ReaderSplashImpl.3
 * JD-Core Version:    0.7.0.1
 */