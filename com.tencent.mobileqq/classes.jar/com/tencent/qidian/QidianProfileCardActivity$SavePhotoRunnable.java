package com.tencent.qidian;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;

class QidianProfileCardActivity$SavePhotoRunnable
  implements Runnable
{
  private WeakReference<QidianProfileCardActivity> a;
  private URLDrawable b;
  private String c;
  
  QidianProfileCardActivity$SavePhotoRunnable(QidianProfileCardActivity paramQidianProfileCardActivity, URLDrawable paramURLDrawable, String paramString)
  {
    this.a = new WeakReference(paramQidianProfileCardActivity);
    this.b = paramURLDrawable;
    this.c = paramString;
  }
  
  public void run()
  {
    QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.a.get();
    if (localQidianProfileCardActivity == null) {
      return;
    }
    try
    {
      str = this.b.saveTo(this.c);
      if (str != null)
      {
        ImageUtil.b(localQidianProfileCardActivity, str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQidianProfileCardActivity.getString(2131892639));
        localStringBuilder.append(" ");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
      }
      else
      {
        str = localQidianProfileCardActivity.getString(2131892637);
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
    str = localQidianProfileCardActivity.getString(2131892637);
    break label104;
    label97:
    str = localQidianProfileCardActivity.getString(2131892637);
    label104:
    localQidianProfileCardActivity.runOnUiThread(new QidianProfileCardActivity.SavePhotoRunnable.1(this, localQidianProfileCardActivity, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.SavePhotoRunnable
 * JD-Core Version:    0.7.0.1
 */