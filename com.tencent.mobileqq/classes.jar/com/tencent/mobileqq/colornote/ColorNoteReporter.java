package com.tencent.mobileqq.colornote;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ColorNoteReporter
{
  public static void a(ArrayList<ColorNote> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ColorNote localColorNote = (ColorNote)paramArrayList.next();
      Integer localInteger = Integer.valueOf(localColorNote.getServiceType());
      if (localHashMap.containsKey(localInteger))
      {
        ((ArrayList)localHashMap.get(localInteger)).add(localColorNote);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localColorNote);
        localHashMap.put(localInteger, localArrayList);
      }
    }
    ReportUtil.a((List)localHashMap.get(Integer.valueOf(16908290)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteReporter
 * JD-Core Version:    0.7.0.1
 */