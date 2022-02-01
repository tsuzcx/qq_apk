package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import java.util.List;

public abstract interface DanmakuManager$IDanmakuListener
{
  public abstract void a(BaseDanmaku paramBaseDanmaku, TouchPoint paramTouchPoint, ClickResult paramClickResult);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(List<BaseDanmaku> paramList);
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager.IDanmakuListener
 * JD-Core Version:    0.7.0.1
 */