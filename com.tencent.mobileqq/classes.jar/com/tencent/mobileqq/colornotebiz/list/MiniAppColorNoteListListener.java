package com.tencent.mobileqq.colornotebiz.list;

import android.view.View;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.IColorNoteListListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MiniAppColorNoteListListener
  implements IColorNoteListListener
{
  private void b(List<ColorNote> paramList)
  {
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        ColorNote localColorNote = (ColorNote)paramList.get(i);
        if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).getOriginType(localColorNote.getServiceType()) == 16842752)
        {
          boolean bool = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isRecentColorNote(localColorNote);
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportColorNoteExpoForMiniApp(localColorNote.getSubType(), bool);
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramList)
    {
      QLog.e("MiniAppColorNoteListLis", 1, "reportColorNoteShow get a throwable", paramList);
    }
  }
  
  public void a() {}
  
  public void a(View paramView, ColorNote paramColorNote) {}
  
  public void a(List<ColorNote> paramList)
  {
    b(paramList);
  }
  
  public void b(View paramView, ColorNote paramColorNote) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornotebiz.list.MiniAppColorNoteListListener
 * JD-Core Version:    0.7.0.1
 */