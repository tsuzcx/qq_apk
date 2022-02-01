package com.tencent.mobileqq.colornote.settings;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.ColorNoteHelper;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.QFileColorNoteHistoryHeaderHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorNoteHistoryManager
{
  public static final int[] a = { 17039360, 17104896, 16908292 };
  
  public static IOnHeaderClickHandler a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16908292: 
      return new HeaderClickHandlerBoodo();
    case 17104896: 
      return new HeaderClickHandlerQFav();
    case 17039360: 
      return new QFileColorNoteHistoryHeaderHandler();
    }
    return new HeaderClickHandlerReader();
  }
  
  public static List<ColorNote> a(int paramInt)
  {
    List localList1 = b(paramInt);
    List localList2 = c(0);
    if (localList1 == null) {
      return null;
    }
    if ((localList2 == null) || (localList2.size() == 0)) {
      return localList1;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      ColorNote localColorNote = (ColorNote)localIterator1.next();
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext()) {
        if (ColorNoteUtils.a(localColorNote, (ColorNote)localIterator2.next())) {
          localArrayList.add(localColorNote);
        }
      }
    }
    localList1.removeAll(localArrayList);
    return localList1;
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
  
  public static void a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (TextUtils.isEmpty(paramColorNote.getMainTitle()))) {
      return;
    }
    paramColorNote = ColorNoteUtils.c(paramColorNote);
    paramColorNote.setType(2);
    ColorNoteCurd localColorNoteCurd = new ColorNoteCurd();
    localColorNoteCurd.a(paramColorNote.getServiceType(), paramColorNote.getSubType(), 2);
    localColorNoteCurd.a(new ColorNoteHistoryManager.1(localColorNoteCurd, paramColorNote));
    a(paramColorNote.getServiceType());
  }
  
  private static void a(List<ColorNote> paramList)
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
  
  public static boolean a(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      List localList = b(paramInt);
      if ((localList != null) && (localList.size() > 20)) {
        a(localList);
      }
      return true;
    }
    ColorNoteHelper.a(paramInt);
    return true;
  }
  
  public static List<ColorNote> b(int paramInt)
  {
    return a(c(2), paramInt);
  }
  
  public static List<ColorNote> c(int paramInt)
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getProxyManager().a().a(false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteHistoryManager
 * JD-Core Version:    0.7.0.1
 */