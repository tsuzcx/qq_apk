package cooperation.qzone;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class QZoneHelper$4
  implements Runnable
{
  QZoneHelper$4(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 26)
      {
        QZoneHelper.access$200(QZoneHelper.access$100(this.val$app, this.val$albumId, this.val$ownerUin), this.val$app, this.val$albumId, this.val$albumName, this.val$albumCoverBmp);
        return;
      }
      QZoneHelper.access$300(this.val$albumCoverBmp, this.val$app, this.val$albumId, this.val$ownerUin, this.val$albumName);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QZoneHelper", 2, "updateAlbumShortCut error! exception e = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.4
 * JD-Core Version:    0.7.0.1
 */