package cooperation.qzone.webviewplugin;

import bfur;
import bgve;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import mqq.app.QQPermissionCallback;

class QzonePhotoWallPlugin$1
  implements QQPermissionCallback
{
  QzonePhotoWallPlugin$1(QzonePhotoWallPlugin paramQzonePhotoWallPlugin) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.this$0.parentPlugin.mRuntime.a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QzonePhotoWallPlugin.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzonePhotoWallPlugin.1
 * JD-Core Version:    0.7.0.1
 */