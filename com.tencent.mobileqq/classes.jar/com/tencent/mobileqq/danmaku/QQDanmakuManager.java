package com.tencent.mobileqq.danmaku;

import com.tencent.common.danmaku.DanmakuDependImp;

public class QQDanmakuManager
{
  private static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      DanmakuDependImp.a().a(new QQDanmakuDependImp());
    }
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.QQDanmakuManager
 * JD-Core Version:    0.7.0.1
 */