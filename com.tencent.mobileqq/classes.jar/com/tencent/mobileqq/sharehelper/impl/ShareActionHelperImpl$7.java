package com.tencent.mobileqq.sharehelper.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ShareActionHelperImpl$7
  implements Runnable
{
  ShareActionHelperImpl$7(ShareActionHelperImpl paramShareActionHelperImpl, String paramString, Map paramMap, Activity paramActivity, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      QLog.d("ShareActionHelperImpl", 1, "shareToWeChat decodeFile");
      Bitmap localBitmap = BitmapFactory.decodeFile(this.a);
      this.b.put("image", localBitmap);
      if (this.c == null) {
        return;
      }
      this.c.runOnUiThread(this.d);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}catch (Exception localException)
    {
      break label91;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareToWeChat  OutOfMemoryError : ");
    localStringBuilder.append(localException.getMessage());
    QLog.e("ShareActionHelperImpl", 1, localStringBuilder.toString());
    return;
    label91:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareToWeChat  Exception : ");
    localStringBuilder.append(localException.getMessage());
    QLog.e("ShareActionHelperImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.7
 * JD-Core Version:    0.7.0.1
 */