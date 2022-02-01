package cooperation.qzone.webviewplugin;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class QzoneDynamicAlbumPlugin$5
  extends Handler
{
  QzoneDynamicAlbumPlugin$5(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String[])));
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = (String[])paramMessage.obj;
    localArrayList.add(QzoneDynamicAlbumPlugin.access$300(this.this$0, arrayOfString));
    this.this$0.sendPhotoData(localArrayList, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.5
 * JD-Core Version:    0.7.0.1
 */