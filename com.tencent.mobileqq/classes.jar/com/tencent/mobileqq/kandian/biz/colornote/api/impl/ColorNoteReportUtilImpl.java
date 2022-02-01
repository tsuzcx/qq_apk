package com.tencent.mobileqq.kandian.biz.colornote.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import java.util.List;
import kotlin.Metadata;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/colornote/api/impl/ColorNoteReportUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/colornote/api/IColorNoteReportUtil;", "()V", "createRecentColorNoteR5", "", "colorNote", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "queryColorNoteAndReport", "", "cache", "", "reportInsertColorNoteForViola", "reportInsideTabPushRedPnt", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportReadInJoyWeb", "reportRemainTime", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ColorNoteReportUtilImpl
  implements IColorNoteReportUtil
{
  @Nullable
  public String createRecentColorNoteR5(@Nullable ColorNote paramColorNote)
  {
    return ReportUtil.b(paramColorNote);
  }
  
  public void queryColorNoteAndReport(@Nullable List<? extends ColorNote> paramList)
  {
    ReportUtil.a(paramList);
  }
  
  public void reportInsertColorNoteForViola(@Nullable ColorNote paramColorNote)
  {
    ReportUtil.c(paramColorNote);
  }
  
  public void reportInsideTabPushRedPnt(@Nullable MessageRecord paramMessageRecord)
  {
    ThreadManager.getSubThreadHandler().post((Runnable)new ColorNoteReportUtilImpl.reportInsideTabPushRedPnt.1(paramMessageRecord));
  }
  
  public void reportReadInJoyWeb(@Nullable ColorNote paramColorNote)
  {
    ReportUtil.d(paramColorNote);
  }
  
  public void reportRemainTime(@Nullable ColorNote paramColorNote)
  {
    ReportUtil.a(paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.colornote.api.impl.ColorNoteReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */