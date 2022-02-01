package com.tencent.mobileqq.colornotebiz.list;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.list.IColorNoteListListener;
import java.util.List;
import mqq.app.AppRuntime;

public class ColorNoteListDataListener
  implements IColorNoteListListener
{
  public void a() {}
  
  public void a(View paramView, ColorNote paramColorNote) {}
  
  public void a(List<ColorNote> paramList) {}
  
  public void b(View paramView, ColorNote paramColorNote)
  {
    ((IColorNoteHelper)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all")).deleteColorNote(paramColorNote.mServiceType, paramColorNote.mSubType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornotebiz.list.ColorNoteListDataListener
 * JD-Core Version:    0.7.0.1
 */