package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.mobileqq.colornote.list.ColorNoteListController;

class ColorNoteSmallScreenService$4
  implements UpcomingNotifyState.OnStateChangeListener
{
  ColorNoteSmallScreenService$4(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((ColorNoteSmallScreenService.e(this.a) != null) && (ColorNoteSmallScreenService.e(this.a).e()))
    {
      ColorNoteSmallScreenService.e(this.a).b();
      ColorNoteSmallScreenService.c(this.a).b();
      return;
    }
    if ((this.a.p != null) && (this.a.p.a)) {
      this.a.p.onClick(this.a.p);
    }
  }
  
  public void b()
  {
    ColorNoteSmallScreenService.f(this.a);
    this.a.m.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService.4
 * JD-Core Version:    0.7.0.1
 */