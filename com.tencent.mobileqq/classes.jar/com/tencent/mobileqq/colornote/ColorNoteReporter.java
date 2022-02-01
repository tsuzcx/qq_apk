package com.tencent.mobileqq.colornote;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ColorNoteReporter
{
  public static void a(List<ColorNote> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ColorNote localColorNote = (ColorNote)paramList.next();
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
      ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).queryColorNoteAndReport((List)localHashMap.get(Integer.valueOf(16908290)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteReporter
 * JD-Core Version:    0.7.0.1
 */