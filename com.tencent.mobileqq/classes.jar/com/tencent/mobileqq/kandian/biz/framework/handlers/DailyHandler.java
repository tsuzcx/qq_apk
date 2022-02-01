package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class DailyHandler
  extends BaseHandler
{
  public void a(@Nullable View paramView, @Nullable ListView paramListView) {}
  
  public void a(View paramView, ListView paramListView, long paramLong) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (AbsBaseArticleInfo)b((int)paramLong);
    if (DailyModeConfigHandler.c(c()))
    {
      if (RIJFeedsType.a(paramAdapterView)) {
        paramInt = 4;
      } else {
        paramInt = 2;
      }
      KandianDailyReportUtils.a(paramInt);
    }
  }
  
  public void a(Map<Long, ? extends BaseReportData> paramMap, boolean paramBoolean)
  {
    super.a(paramMap, paramBoolean);
    if (DailyModeConfigHandler.c(c()))
    {
      paramMap = g();
      if (!RIJShowKanDianTabSp.d())
      {
        QLog.d("DailyHandler", 1, "detachFromViewGroup,now cmd is 0x68b");
        return;
      }
      if (paramMap == null) {
        return;
      }
      ThreadManager.executeOnSubThread(new DailyHandler.1(this, paramMap.z()));
    }
  }
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public int s()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.DailyHandler
 * JD-Core Version:    0.7.0.1
 */