package com.tencent.mobileqq.flashshow.report.dc;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FSLpReportDc11002
{
  public static final Map<Integer, Set<Integer>> a = new HashMap();
  
  static
  {
    b(1, 1);
    b(2, 7);
    b(4, 2);
    b(5, 2);
    b(11, 3);
    b(12, 3);
    b(25, 2);
    b(26, 2);
    b(27, 2);
    b(28, 2);
    b(36, 3);
    b(50, 2);
    b(51, 2);
    b(60, 3);
    b(69, 2);
    b(80, 2);
    b(130, 2);
    b(135, 3);
  }
  
  public static void a(FSLpReportDc11002.DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null)
    {
      QLog.e("FSLpReportDc11002", 1, "report invalid builder is null!");
      return;
    }
    b(paramDataBuilder);
    FSReporter.a().c().post(new FSLpReportDc11002.1(paramDataBuilder));
  }
  
  private static int b()
  {
    return 11002;
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    if (!a.containsKey(Integer.valueOf(paramInt1))) {
      a.put(Integer.valueOf(paramInt1), new HashSet());
    }
    ((Set)a.get(Integer.valueOf(paramInt1))).add(Integer.valueOf(paramInt2));
  }
  
  static void b(FSLpReportDc11002.DataBuilder paramDataBuilder)
  {
    if (TextUtils.isEmpty(FSLpReportDc11002.DataBuilder.T(paramDataBuilder)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report invalid pageId,");
      localStringBuilder.append(FSLpReportDc11002.DataBuilder.T(paramDataBuilder));
      localStringBuilder.append(",actionType:");
      localStringBuilder.append(FSLpReportDc11002.DataBuilder.c(paramDataBuilder));
      localStringBuilder.append(",subActionType:");
      localStringBuilder.append(FSLpReportDc11002.DataBuilder.d(paramDataBuilder));
      QLog.e("FSLpReportDc11002", 1, localStringBuilder.toString());
      d(FSLpReportDc11002.DataBuilder.c(paramDataBuilder), FSLpReportDc11002.DataBuilder.d(paramDataBuilder));
    }
  }
  
  private static boolean c(int paramInt1, int paramInt2)
  {
    if (!a.containsKey(Integer.valueOf(paramInt1))) {
      return false;
    }
    return ((Set)a.get(Integer.valueOf(paramInt1))).contains(Integer.valueOf(paramInt2));
  }
  
  private static void d(int paramInt1, int paramInt2)
  {
    if (RFApplication.isDebug()) {
      FSThreadUtils.a(new FSLpReportDc11002.2(paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002
 * JD-Core Version:    0.7.0.1
 */