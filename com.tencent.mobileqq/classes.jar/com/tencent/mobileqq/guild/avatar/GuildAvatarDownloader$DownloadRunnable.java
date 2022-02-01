package com.tencent.mobileqq.guild.avatar;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

class GuildAvatarDownloader$DownloadRunnable
  implements Runnable
{
  private int a;
  private boolean b;
  
  private void a(String paramString) {}
  
  public void run()
  {
    int j = 0;
    for (;;)
    {
      i = GuildAvatarDownloader.a(this.this$0);
      String str = null;
      if (((j < i) || (GuildAvatarDownloader.b(this.this$0).size() > 0)) && (this.b)) {
        synchronized (GuildAvatarDownloader.b(this.this$0))
        {
          i = GuildAvatarDownloader.b(this.this$0).size();
          if (i == 0) {
            GuildAvatarDownloader.c(this.this$0).incrementAndGet();
          }
          try
          {
            GuildAvatarDownloader.b(this.this$0).wait(30000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              continue;
              i = 0;
            }
          }
          QLog.e("GuildAvatarDownloader", 1, "downloadRunnable interrupted");
          GuildAvatarDownloader.c(this.this$0).decrementAndGet();
          i = j + 1;
          break label166;
          if (i > GuildAvatarDownloader.d(this.this$0))
          {
            str = (String)GuildAvatarDownloader.b(this.this$0).remove(i - 1);
            break label310;
          }
          str = (String)GuildAvatarDownloader.b(this.this$0).remove(0);
          break label310;
          label166:
          j = i;
          if (str != null)
          {
            a(str);
            synchronized (GuildAvatarDownloader.e(this.this$0))
            {
              GuildAvatarDownloader.e(this.this$0).remove(str);
              Thread.yield();
              j = i;
            }
          }
        }
      }
    }
    synchronized (GuildAvatarDownloader.f(this.this$0))
    {
      if (this.a < GuildAvatarDownloader.f(this.this$0).length)
      {
        GuildAvatarDownloader.f(this.this$0)[this.a] = null;
        GuildAvatarDownloader.g(this.this$0)[this.a] = null;
      }
      GuildAvatarDownloader.h(this.this$0).decrementAndGet();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.avatar.GuildAvatarDownloader.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */