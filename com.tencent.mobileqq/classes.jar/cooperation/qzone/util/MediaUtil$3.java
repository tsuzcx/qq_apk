package cooperation.qzone.util;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

final class MediaUtil$3
  implements QQPermissionCallback
{
  MediaUtil$3(String paramString1, String paramString2, String paramString3, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(MediaUtil.access$100(this.val$activity));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    MediaUtil.saveFileToQqAlbum(this.val$srcPath, this.val$destPath, this.val$outputFileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.MediaUtil.3
 * JD-Core Version:    0.7.0.1
 */