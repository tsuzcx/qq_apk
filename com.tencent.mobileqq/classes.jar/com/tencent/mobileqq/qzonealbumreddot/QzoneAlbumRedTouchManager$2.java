package com.tencent.mobileqq.qzonealbumreddot;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import baql;

public class QzoneAlbumRedTouchManager$2
  implements Runnable
{
  public QzoneAlbumRedTouchManager$2(baql parambaql) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = baql.a(this.this$0).edit().putLong("key_photo_guide_has_red_date", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager.2
 * JD-Core Version:    0.7.0.1
 */