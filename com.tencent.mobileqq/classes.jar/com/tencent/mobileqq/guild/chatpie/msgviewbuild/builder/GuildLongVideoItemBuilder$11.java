package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class GuildLongVideoItemBuilder$11
  implements Runnable
{
  GuildLongVideoItemBuilder$11(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder) {}
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    boolean bool = false;
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(14, 0);
    SharedPreferences localSharedPreferences = this.this$0.g.getPreferences();
    long l1 = localSharedPreferences.getLong("key_check_temp", 0L);
    long l2 = ((Calendar)localObject).getTimeInMillis();
    if (l1 < l2) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TempCleanTask, lastCheck=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", today:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", needClean : ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localSharedPreferences.edit().putLong("key_check_temp", l2).commit();
      ShortVideoUtils.deleteDownloadTempFile("", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */