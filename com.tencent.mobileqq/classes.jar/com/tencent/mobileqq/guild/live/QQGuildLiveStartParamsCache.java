package com.tencent.mobileqq.guild.live;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class QQGuildLiveStartParamsCache
{
  private static QQGuildLiveRoomStartParams a;
  
  @NonNull
  public static QQGuildLiveRoomStartParams a()
  {
    QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams2 = a;
    QQGuildLiveRoomStartParams localQQGuildLiveRoomStartParams1 = localQQGuildLiveRoomStartParams2;
    if (localQQGuildLiveRoomStartParams2 == null)
    {
      QLog.e("QQGuildLiveStartParamsCache", 1, "QQGuildLiveRoomStartParams getCache == null");
      localQQGuildLiveRoomStartParams1 = new QQGuildLiveRoomStartParams();
    }
    return localQQGuildLiveRoomStartParams1;
  }
  
  public static void a(QQGuildLiveRoomStartParams paramQQGuildLiveRoomStartParams)
  {
    QLog.i("QQGuildLiveStartParamsCache", 1, "QQGuildLiveRoomStartParams setCache.");
    a = paramQQGuildLiveRoomStartParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache
 * JD-Core Version:    0.7.0.1
 */