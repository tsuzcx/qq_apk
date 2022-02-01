package com.tencent.qidian;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;

class QidianProfileCardActivity$ForwardRunnable
  implements Runnable
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private WeakReference<QidianProfileCardActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  QidianProfileCardActivity$ForwardRunnable(QidianProfileCardActivity paramQidianProfileCardActivity, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQidianProfileCardActivity);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
  }
  
  public void run()
  {
    QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQidianProfileCardActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    Object localObject = new File(AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE);
    ((StringBuilder)localObject).append(Utils.Crc64String(localQidianProfileCardActivity.a.allInOne.uin));
    ((StringBuilder)localObject).append(Utils.Crc64String(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString()));
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (!new File(str).exists()) {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianProfileCardActivity", 2, "IOException", localIOException);
        }
        localQidianProfileCardActivity.runOnUiThread(new QidianProfileCardActivity.ForwardRunnable.1(this, localQidianProfileCardActivity));
        return;
      }
    }
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    localBundle.putString("forward_filepath", localIOException);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    localBundle.putString("forward_extra", localIOException);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(localQidianProfileCardActivity, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.ForwardRunnable
 * JD-Core Version:    0.7.0.1
 */