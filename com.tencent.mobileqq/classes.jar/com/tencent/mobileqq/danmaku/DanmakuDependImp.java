package com.tencent.mobileqq.danmaku;

public class DanmakuDependImp
{
  private IDanmakuDepend a;
  
  public static DanmakuDependImp a()
  {
    return DanmakuDependImp.SingletonPatternHolder.a();
  }
  
  public IDanmakuDepend a()
  {
    if (this.a == null) {
      this.a = new QQDanmakuDependImp();
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.DanmakuDependImp
 * JD-Core Version:    0.7.0.1
 */