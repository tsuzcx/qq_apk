package dov.com.qq.im.ae.album.logic;

import android.os.Handler;
import android.os.Message;
import bdar;
import bkml;
import bknd;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import java.util.Map;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault$7
  implements Runnable
{
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = ((bkml)this.this$0.a.get()).a(this.a);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    bdar.a(localLocalMediaInfo, str);
    PhotoListBaseData.newCaptureMediaInfo.put(str, localLocalMediaInfo);
    ((bkml)this.this$0.a.get()).a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.7
 * JD-Core Version:    0.7.0.1
 */