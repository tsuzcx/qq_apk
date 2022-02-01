package cooperation.qzone;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;

final class QZoneHelper$4
  implements Runnable
{
  QZoneHelper$4(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2) {}
  
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
      ToastUtil.a().a(2131690140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.4
 * JD-Core Version:    0.7.0.1
 */