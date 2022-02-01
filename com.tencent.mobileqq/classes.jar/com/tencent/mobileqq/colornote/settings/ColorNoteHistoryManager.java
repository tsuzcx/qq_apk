package com.tencent.mobileqq.colornote.settings;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorNoteHistoryManager
{
  public static final int[] a = { 17039360, 17104896, 16908292 };
  private static final List<IOnHeaderClickHandler> b = new ArrayList();
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteHistoryInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        b.add(localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteHistoryManager", 1, "[static] ", localException);
    }
  }
  
  public static List<IOnHeaderClickHandler> a()
  {
    return b;
  }
  
  public static List<ColorNote> a(List<ColorNote> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 3) {
        localObject = paramList.subList(0, 3);
      }
    }
    return localObject;
  }
  
  static List<ColorNote> a(List<ColorNote> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramList.next();
      if (localColorNote.getServiceType() == paramInt) {
        localArrayList.add(0, localColorNote);
      }
    }
    return localArrayList;
  }
  
  public static List<ColorNote> a(AppRuntime paramAppRuntime, int paramInt)
  {
    List localList = b(paramAppRuntime, paramInt);
    paramAppRuntime = c(paramAppRuntime, 0);
    if (localList == null) {
      return null;
    }
    if (paramAppRuntime != null)
    {
      if (paramAppRuntime.size() == 0) {
        return localList;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator1.next();
        Iterator localIterator2 = paramAppRuntime.iterator();
        while (localIterator2.hasNext()) {
          if (ColorNoteUtils.a(localColorNote, (ColorNote)localIterator2.next())) {
            localArrayList.add(localColorNote);
          }
        }
      }
      localList.removeAll(localArrayList);
    }
    return localList;
  }
  
  public static void a(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (TextUtils.isEmpty(paramColorNote.getMainTitle())) {
        return;
      }
      paramColorNote = ColorNoteUtils.g(paramColorNote);
      paramColorNote.setType(2);
      ColorNoteCurd localColorNoteCurd = new ColorNoteCurd();
      localColorNoteCurd.a(paramColorNote.getServiceType(), paramColorNote.getSubType(), 2);
      localColorNoteCurd.a(new ColorNoteHistoryManager.1(localColorNoteCurd, paramColorNote));
      d(MobileQQ.getMobileQQ().waitAppRuntime(null), paramColorNote.getServiceType());
    }
  }
  
  public static List<ColorNote> b(AppRuntime paramAppRuntime, int paramInt)
  {
    return a(c(paramAppRuntime, 2), paramInt);
  }
  
  private static void b(List<ColorNote> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 20))
    {
      ColorNoteCurd localColorNoteCurd = new ColorNoteCurd();
      int i = 9;
      while (i < paramList.size())
      {
        ColorNote localColorNote = (ColorNote)paramList.get(i);
        localColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), 2);
        i += 1;
      }
    }
  }
  
  public static List<ColorNote> c(AppRuntime paramAppRuntime, int paramInt)
  {
    return ((IColorNoteDataService)paramAppRuntime.getRuntimeService(IColorNoteDataService.class, "all")).getColorNotes(false, paramInt);
  }
  
  public static boolean d(AppRuntime paramAppRuntime, int paramInt)
  {
    if (MobileQQ.sProcessId == 1)
    {
      paramAppRuntime = b(paramAppRuntime, paramInt);
      if ((paramAppRuntime != null) && (paramAppRuntime.size() > 20))
      {
        b(paramAppRuntime);
        return true;
      }
    }
    else
    {
      ((IColorNoteHelper)paramAppRuntime.getRuntimeService(IColorNoteHelper.class, "all")).clearHistoryNote(paramInt);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteHistoryManager
 * JD-Core Version:    0.7.0.1
 */