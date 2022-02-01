package cooperation.qzone.webviewplugin;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;
import java.util.Date;

class QzoneDynamicAlbumPlugin$6
  implements Runnable
{
  QzoneDynamicAlbumPlugin$6(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.val$selectedLocalImages.size())
    {
      if (this.val$selectedLocalImages.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        String str1 = QzoneDynamicAlbumPlugin.PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM + (new Date().getTime() + i);
        String str2 = (String)this.val$selectedLocalImages.get(i);
        boolean bool = QzoneDynamicAlbumPlugin.compressDynamicAlbumImage(BaseApplicationImpl.getContext(), str2, str1, QzoneDynamicAlbumPlugin.access$000()[0], QzoneDynamicAlbumPlugin.access$000()[1]);
        if ((bool) && (i == 0) && (!QzoneDynamicAlbumPlugin.access$400(this.this$0)))
        {
          QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + str1);
          RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto(str1, this.val$selectedLocalImages.size());
        }
        for (;;)
        {
          if (!bool) {
            break label234;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 2, "pickDynamicAlbumImage sendMsg: MSG_PICK_PHOTO_COMPRESS_FINISH");
          Message localMessage = Message.obtain();
          localMessage.what = 2;
          localMessage.arg1 = this.val$totalGetPhotosNum;
          localMessage.obj = new String[] { str2, str1 };
          this.this$0.handler.sendMessage(localMessage);
          break;
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
        label234:
        QLog.e("QzoneDynamicAlbumPlugin", 2, "compressDynamicAlbumImage failed! skip this photo.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6
 * JD-Core Version:    0.7.0.1
 */