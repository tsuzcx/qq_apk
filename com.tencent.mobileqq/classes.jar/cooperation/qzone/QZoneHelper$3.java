package cooperation.qzone;

import android.graphics.Bitmap;
import bhzt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class QZoneHelper$3
  implements Runnable
{
  QZoneHelper$3(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    try
    {
      QZoneHelper.access$000(this.val$albumCoverBmp, this.val$app, this.val$albumId, this.val$ownerUin, this.val$albumName);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QZoneHelper", 2, "createAlbumShortCut error! exception e = " + localException.getMessage());
      bhzt.a().a(2131690052);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.3
 * JD-Core Version:    0.7.0.1
 */