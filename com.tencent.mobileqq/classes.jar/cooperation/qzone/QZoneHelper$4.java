package cooperation.qzone;

import android.graphics.Bitmap;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class QZoneHelper$4
  implements Runnable
{
  QZoneHelper$4(Bitmap paramBitmap, AppRuntime paramAppRuntime, String paramString1, long paramLong, String paramString2) {}
  
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createAlbumShortCut error! exception e = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QZoneHelper", 2, localStringBuilder.toString());
      ToastUtil.a().a(2131690057);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.4
 * JD-Core Version:    0.7.0.1
 */