package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.widget.ListAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;

public class ReadinjoySPEventReport$ScrollReport
{
  static long a = 0L;
  static long b = 0L;
  static int c = -1;
  static int d = -1;
  static int e;
  
  public static int a()
  {
    return e;
  }
  
  static void a(AbsListView paramAbsListView)
  {
    ReadinjoySPEventReport.ScrollStep localScrollStep = new ReadinjoySPEventReport.ScrollStep();
    int i = paramAbsListView.getLastVisiblePosition();
    int j = ((ListAdapter)paramAbsListView.getAdapter()).getCount();
    localScrollStep.a = b();
    localScrollStep.d = Math.abs(d - c);
    long l = b;
    localScrollStep.b = (l - a);
    localScrollStep.e = (j - i);
    localScrollStep.c = l;
    localScrollStep.f = j;
    ReadinjoySPEventReport.ScrollReportUtil.a(localScrollStep);
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView != null) && (paramAbsListView.getChildCount() != 0))
    {
      if (paramAbsListView.getAdapter() == null) {
        return;
      }
      b(paramAbsListView, paramInt);
      if (ReadinjoySPEventReport.ScrollReportUtil.a >= 0L)
      {
        if (ReadinjoySPEventReport.ScrollReportUtil.b < 0L) {
          return;
        }
        if (paramInt != 0)
        {
          if (paramInt != 1) {
            return;
          }
          c = paramAbsListView.getFirstVisiblePosition();
          a = NetConnInfoCenter.getServerTimeMillis();
          d = -1;
          b = -1L;
          return;
        }
        if ((d < 0) && (b < 0L))
        {
          d = paramAbsListView.getFirstVisiblePosition();
          b = NetConnInfoCenter.getServerTimeMillis();
          a(paramAbsListView);
        }
      }
    }
  }
  
  static int b()
  {
    if (c > d) {
      return 0;
    }
    return 1;
  }
  
  private static void b(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    e = paramAbsListView.getFirstVisiblePosition() - ((ListView)paramAbsListView).getHeaderViewsCount();
    if (e < 0) {
      e = 0;
    }
    QLog.d("ReadinjoySPEventReport", 2, new Object[] { "[onScrollStateChanged] record firstItemPos : ", Integer.valueOf(e) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScrollReport
 * JD-Core Version:    0.7.0.1
 */