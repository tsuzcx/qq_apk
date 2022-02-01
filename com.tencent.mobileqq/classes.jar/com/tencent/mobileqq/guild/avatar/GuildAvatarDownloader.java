package com.tencent.mobileqq.guild.avatar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GuildAvatarDownloader
{
  private IAvatarDownloadCallback a;
  private final ArrayList<String> b = new ArrayList();
  private final HashSet<String> c = new HashSet();
  private final AtomicInteger d = new AtomicInteger(0);
  private final AtomicInteger e = new AtomicInteger(0);
  private final Thread[] f = new Thread[6];
  private final GuildAvatarDownloader.DownloadRunnable[] g = new GuildAvatarDownloader.DownloadRunnable[6];
  private int h = 2;
  private int i = 10;
  private AtomicBoolean j = new AtomicBoolean(false);
  
  void a(IAvatarDownloadCallback paramIAvatarDownloadCallback)
  {
    this.a = paramIAvatarDownloadCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.avatar.GuildAvatarDownloader
 * JD-Core Version:    0.7.0.1
 */