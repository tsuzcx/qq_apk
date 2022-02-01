package com.tencent.mobileqq.colornote.list;

import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public abstract interface IColorNoteListListener
{
  public abstract void a();
  
  public abstract void a(View paramView, ColorNote paramColorNote);
  
  public abstract void a(List<ColorNote> paramList);
  
  public abstract void b(View paramView, ColorNote paramColorNote);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.IColorNoteListListener
 * JD-Core Version:    0.7.0.1
 */