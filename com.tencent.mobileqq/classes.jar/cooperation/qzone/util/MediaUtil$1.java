package cooperation.qzone.util;

import android.app.Activity;
import bfur;
import mqq.app.QQPermissionCallback;

final class MediaUtil$1
  implements QQPermissionCallback
{
  MediaUtil$1(String paramString1, String paramString2, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(MediaUtil.access$100(this.val$activity));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    MediaUtil.access$000(this.val$srcPath, this.val$outputFileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.MediaUtil.1
 * JD-Core Version:    0.7.0.1
 */