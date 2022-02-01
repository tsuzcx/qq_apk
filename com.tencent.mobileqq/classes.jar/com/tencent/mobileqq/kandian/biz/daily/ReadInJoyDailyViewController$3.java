package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.report.RIJEntryViewReport;
import com.tencent.mobileqq.kandian.biz.xtab.UgcPublishUserGuideController;
import com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class ReadInJoyDailyViewController$3
  implements Function1<String, Unit>
{
  ReadInJoyDailyViewController$3(ReadInJoyDailyViewController paramReadInJoyDailyViewController, BizEntryViewController paramBizEntryViewController, UgcPublishUserGuideController paramUgcPublishUserGuideController) {}
  
  public Unit a(String paramString)
  {
    RIJEntryViewReport.a("0X800BBD1", 9);
    if (RIJEntryViewUtils.b() == 1) {
      RIJEntryViewReport.b("0X800BBD3", 3);
    } else if (RIJEntryViewUtils.b() == 2) {
      RIJEntryViewReport.b("0X800BBCF", 3);
    }
    this.a.a(paramString, null);
    this.b.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController.3
 * JD-Core Version:    0.7.0.1
 */