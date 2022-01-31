package com.tencent.mobileqq.filemanager.activity.fileassistant;

import amxd;
import amxe;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;

class FileAssistantActivity$CheckAlbumRunnable
  implements Runnable
{
  private FileAssistantActivity$CheckAlbumRunnable(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void run()
  {
    int i = 7;
    amxd localamxd = amxe.a();
    if (!localamxd.a()) {
      QLog.w("FileAssistantActivity", 2, "no config, exit");
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          Object localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTime(new Date());
          int k = ((Calendar)localObject1).get(7);
          int j = ((Calendar)localObject1).get(11);
          if (k == 1) {}
          while ((localamxd.a() != i) || (localamxd.b() > j))
          {
            QLog.w("FileAssistantActivity", 2, i + "-" + localamxd.a() + ", " + j + "-" + localamxd.b() + ", not correct time, exit");
            return;
            i = k - 1;
          }
          Object localObject4 = this.this$0.app.getPreferences().getString("check_album_day", "");
          String str = FileAssistantActivity.a(this.this$0);
          if (TextUtils.equals((CharSequence)localObject4, str))
          {
            QLog.w("FileAssistantActivity", 2, str + "-" + (String)localObject4 + ", showed, exit");
            return;
          }
          ((Calendar)localObject1).add(5, -localamxd.c());
          ((Calendar)localObject1).set(11, 0);
          ((Calendar)localObject1).set(12, 0);
          ((Calendar)localObject1).set(13, 0);
          ((Calendar)localObject1).set(14, 0);
          localObject4 = this.this$0.getContentResolver();
          long l = ((Calendar)localObject1).getTimeInMillis();
          try
          {
            localObject1 = ((ContentResolver)localObject4).query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "datetaken> ? ", new String[] { String.valueOf(l) }, null);
            if (localObject1 != null) {}
          }
          finally
          {
            localObject1 = null;
          }
          try
          {
            QLog.w("FileAssistantActivity", 2, "cursor is null, exit");
            if (localObject1 != null)
            {
              ((Cursor)localObject1).close();
              return;
            }
          }
          finally
          {
            break label450;
          }
        }
        i = ((Cursor)localObject1).getCount();
        if (i >= localamxd.d()) {
          break;
        }
        QLog.w("FileAssistantActivity", 2, i + "-" + localamxd.d() + ", limit not achieved, exit");
      } while (localObject1 == null);
      ((Cursor)localObject1).close();
      return;
      this.this$0.runOnUiThread(new FileAssistantActivity.CheckAlbumRunnable.1(this, localamxd, i));
    } while (localObject1 == null);
    ((Cursor)localObject1).close();
    return;
    label450:
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.CheckAlbumRunnable
 * JD-Core Version:    0.7.0.1
 */