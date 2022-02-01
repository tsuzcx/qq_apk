package cooperation.qzone.webviewplugin.personalize;

import bfur;
import bgve;
import mqq.app.QQPermissionCallback;

class QZoneCoverStoreJsPlugin$2
  implements QQPermissionCallback
{
  QZoneCoverStoreJsPlugin$2(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(this.this$0.mRuntime.a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QZoneCoverStoreJsPlugin.access$000(this.this$0, this.val$offset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */