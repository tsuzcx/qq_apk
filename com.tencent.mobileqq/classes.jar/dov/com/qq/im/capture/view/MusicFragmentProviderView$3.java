package dov.com.qq.im.capture.view;

import android.os.Message;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.GetMusicInfoCallback;

class MusicFragmentProviderView$3
  implements GetSingleFullMusicInfoTask.GetMusicInfoCallback
{
  MusicFragmentProviderView$3(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    Message localMessage;
    if (this.a.a != null)
    {
      localMessage = this.a.a.obtainMessage();
      if (!paramBoolean) {
        break label61;
      }
    }
    label61:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.obj = paramObject;
      localMessage.what = 7;
      this.a.a.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicFragmentProviderView.3
 * JD-Core Version:    0.7.0.1
 */