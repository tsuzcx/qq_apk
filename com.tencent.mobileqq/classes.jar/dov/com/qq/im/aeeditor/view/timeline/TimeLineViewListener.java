package dov.com.qq.im.aeeditor.view.timeline;

import dov.com.qq.im.aeeditor.view.dragdrop.IDragView;

public abstract interface TimeLineViewListener
{
  public abstract void a(IDragView paramIDragView, long paramLong1, long paramLong2);
  
  public abstract void a(IDragView paramIDragView, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, EffectTimelineView paramEffectTimelineView);
  
  public abstract void b(IDragView paramIDragView, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timeline.TimeLineViewListener
 * JD-Core Version:    0.7.0.1
 */