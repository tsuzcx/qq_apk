package com.tencent.mobileqq.sharehelper.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ShareActionHelperImpl$6
  implements Runnable
{
  ShareActionHelperImpl$6(ShareActionHelperImpl paramShareActionHelperImpl, String paramString, Map paramMap, Activity paramActivity, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      QLog.d("ShareActionHelperImpl", 1, "shareToWeChat decodeFile");
      Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilMap.put("image", localBitmap);
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.6
 * JD-Core Version:    0.7.0.1
 */