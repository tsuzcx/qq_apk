package com.tencent.mobileqq.colornotebiz.list;

import android.support.v4.util.ArrayMap;
import android.view.View;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.IColorNoteListListener;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RecentViewColorNoteListener
  implements IColorNoteListListener
{
  public void a() {}
  
  public void a(View paramView, ColorNote paramColorNote)
  {
    if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isRecentColorNote(paramColorNote))
    {
      paramView = ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).createRecentColorNoteR5(paramColorNote);
      ReportController.b(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", ColorNoteConstants.b(((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).getOriginType(paramColorNote.getServiceType())), 0, "", "", "", paramView);
    }
  }
  
  public void a(List<ColorNote> paramList)
  {
    int i = paramList.size();
    int k = 0;
    if (i > 0)
    {
      localObject1 = (ColorNote)paramList.get(0);
      if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isRecentColorNote((ColorNote)localObject1))
      {
        i = ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).getOriginType(((ColorNote)localObject1).getServiceType());
        localObject1 = ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).createRecentColorNoteR5((ColorNote)localObject1);
        ReportController.b(null, "dc00898", "", "", "0X800A8AA", "0X800A8AA", ColorNoteConstants.b(i), 0, "", "", "", (String)localObject1);
      }
    }
    Object localObject1 = new ArrayMap();
    Object localObject2 = paramList.iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      i = 1;
      if (!bool) {
        break;
      }
      j = ((ColorNote)((Iterator)localObject2).next()).getServiceType();
      if (((ArrayMap)localObject1).containsValue(Integer.valueOf(j))) {
        i = 1 + ((Integer)((ArrayMap)localObject1).valueAt(j)).intValue();
      }
      ((ArrayMap)localObject1).put(Integer.valueOf(j), Integer.valueOf(i));
    }
    localObject2 = ((ArrayMap)localObject1).keySet().iterator();
    int j = 0;
    i = k;
    while (((Iterator)localObject2).hasNext())
    {
      k = ((Integer)((Iterator)localObject2).next()).intValue();
      if (((Integer)((ArrayMap)localObject1).get(Integer.valueOf(k))).intValue() > j)
      {
        j = ((Integer)((ArrayMap)localObject1).get(Integer.valueOf(k))).intValue();
        i = k;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramList.size());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ColorNoteConstants.a(i));
    ((StringBuilder)localObject2).append("");
    ReportController.b(null, "dc00898", "", "", "0X800A6CD", "0X800A6CD", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ColorNote)paramList.next();
      if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote((ColorNote)localObject1))
      {
        localObject2 = UpComingMsgUtil.b((ColorNote)localObject1);
        if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isNeedNowNotify((ColorNote)localObject1)) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AE8E", "0X800AE8E", i, ((UpComingMsgModel)localObject2).reportType, "", "", "", "");
      }
    }
  }
  
  public void b(View paramView, ColorNote paramColorNote)
  {
    if (((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).isRecentColorNote(paramColorNote))
    {
      paramView = ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).createRecentColorNoteR5(paramColorNote);
      ReportController.b(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", ColorNoteConstants.b(((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).getOriginType(paramColorNote.getServiceType())), 0, "", "", "", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornotebiz.list.RecentViewColorNoteListener
 * JD-Core Version:    0.7.0.1
 */