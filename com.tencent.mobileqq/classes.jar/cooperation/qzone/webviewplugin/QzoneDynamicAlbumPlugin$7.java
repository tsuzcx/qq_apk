package cooperation.qzone.webviewplugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.List;

class QzoneDynamicAlbumPlugin$7
  implements Runnable
{
  QzoneDynamicAlbumPlugin$7(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin, List paramList, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$selectedLocalImages.size())
    {
      if (this.val$selectedLocalImages.get(i) != null)
      {
        boolean bool = QzoneDynamicAlbumPlugin.compressDynamicAlbumImage(BaseApplicationImpl.getContext(), (String)this.val$selectedLocalImages.get(i), this.val$destFilePaths[i], QzoneDynamicAlbumPlugin.access$000()[0], QzoneDynamicAlbumPlugin.access$000()[1]);
        if ((bool) && (i == 0) && (!QzoneDynamicAlbumPlugin.access$400(this.this$0)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pickDynamicAlbumImage uploadFirstDynamicPhoto:");
          localStringBuilder.append(this.val$destFilePaths[0]);
          QLog.d("QzoneDynamicAlbumPlugin", 1, localStringBuilder.toString());
          RemoteHandleManager.getInstance().getSender().uploadFirstDynamicPhoto(this.val$destFilePaths[0], this.val$selectedLocalImages.size());
        }
        else
        {
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
        if (!bool) {
          QLog.e("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress failed! ");
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress all done  ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.7
 * JD-Core Version:    0.7.0.1
 */