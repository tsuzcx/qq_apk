package dov.com.qq.im.ae.download.old;

import android.content.Context;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;

final class AEOldShortVideoResManager$8
  implements Runnable
{
  public void run()
  {
    Context localContext = VideoEnvironment.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a);
    QQToast.a(localContext, localStringBuilder.toString(), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.8
 * JD-Core Version:    0.7.0.1
 */