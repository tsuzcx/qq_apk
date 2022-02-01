package com.tencent.qidian;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
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
    QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQidianProfileCardActivity == null) {
      return;
    }
    try
    {
      str = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (str != null)
      {
        ImageUtil.a(localQidianProfileCardActivity, str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQidianProfileCardActivity.getString(2131694913));
        localStringBuilder.append(" ");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
      }
      else
      {
        str = localQidianProfileCardActivity.getString(2131694911);
      }
    }
    catch (IOException localIOException)
    {
      String str;
      break label97;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label87:
      break label87;
    }
    str = localQidianProfileCardActivity.getString(2131694911);
    break label104;
    label97:
    str = localQidianProfileCardActivity.getString(2131694911);
    label104:
    localQidianProfileCardActivity.runOnUiThread(new QidianProfileCardActivity.SavePhotoRunnable.1(this, localQidianProfileCardActivity, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.SavePhotoRunnable
 * JD-Core Version:    0.7.0.1
 */