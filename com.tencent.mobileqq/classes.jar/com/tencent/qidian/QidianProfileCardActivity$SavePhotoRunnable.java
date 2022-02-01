package com.tencent.qidian;

import bheg;
import com.tencent.image.URLDrawable;
import java.io.IOException;
import java.lang.ref.WeakReference;

class QidianProfileCardActivity$SavePhotoRunnable
  implements Runnable
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QidianProfileCardActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  QidianProfileCardActivity$SavePhotoRunnable(QidianProfileCardActivity paramQidianProfileCardActivity, URLDrawable paramURLDrawable, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQidianProfileCardActivity);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    localQidianProfileCardActivity = (QidianProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQidianProfileCardActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        str1 = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
        if (str1 == null) {
          continue;
        }
        bheg.a(localQidianProfileCardActivity, str1);
        str1 = localQidianProfileCardActivity.getString(2131694686) + " " + str1;
      }
      catch (IOException localIOException)
      {
        String str1;
        String str2 = localQidianProfileCardActivity.getString(2131694684);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        String str3 = localQidianProfileCardActivity.getString(2131694684);
        continue;
      }
      localQidianProfileCardActivity.runOnUiThread(new QidianProfileCardActivity.SavePhotoRunnable.1(this, localQidianProfileCardActivity, str1));
      return;
      str1 = localQidianProfileCardActivity.getString(2131694684);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.SavePhotoRunnable
 * JD-Core Version:    0.7.0.1
 */