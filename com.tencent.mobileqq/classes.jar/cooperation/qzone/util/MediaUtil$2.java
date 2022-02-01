package cooperation.qzone.util;

import android.app.Activity;
import android.graphics.Bitmap;
import bhdj;
import mqq.app.QQPermissionCallback;

final class MediaUtil$2
  implements QQPermissionCallback
{
  MediaUtil$2(Bitmap paramBitmap, int paramInt, String paramString, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(MediaUtil.access$100(this.val$activity));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    MediaUtil.access$200(this.val$srcBitmap, this.val$quality, this.val$outputFileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.MediaUtil.2
 * JD-Core Version:    0.7.0.1
 */