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
    while (i < this.val$selectedLocalImages.size())
    {
      if (this.val$selectedLocalImages.get(i) != null)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(QzoneDynamicAlbumPlugin.PHOTO_TMPFILE_PATH_DYNAMIC_ALBUM);
        ((StringBuilder)localObject1).append(new Date().getTime() + i);
        localObject1 = ((StringBuilder)localObject1).toString();
        String str = (String)this.val$selectedLocalImages.get(i);
        boolean bool = QzoneDynamicAlbumPlugin.compressDynamicAlbumImage(BaseApplicationImpl.getContext(), str, (String)localObject1, QzoneDynamicAlbumPlugin.access$000()[0], QzoneDynamicAlbumPlugin.access$000()[1]);
        Object localObject2;
        if ((bool) && (i == 0) && (!QzoneDynamicAlbumPlugin.access$400(this.this$0)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pickDynamicAlbumImage uploadFirstDynamicPhoto:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("QzoneDynamicAlbumPlugin", 4, ((StringBuilder)localObject2).toString());
          RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto((String)localObject1, this.val$selectedLocalImages.size());
        }
        else
        {
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
        if (bool)
        {
          QLog.d("QzoneDynamicAlbumPlugin", 2, "pickDynamicAlbumImage sendMsg: MSG_PICK_PHOTO_COMPRESS_FINISH");
          localObject2 = Message.obtain();
          ((Message)localObject2).what = 2;
          ((Message)localObject2).arg1 = this.val$totalGetPhotosNum;
          ((Message)localObject2).obj = new String[] { str, localObject1 };
          this.this$0.handler.sendMessage((Message)localObject2);
        }
        else
        {
          QLog.e("QzoneDynamicAlbumPlugin", 2, "compressDynamicAlbumImage failed! skip this photo.");
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6
 * JD-Core Version:    0.7.0.1
 */