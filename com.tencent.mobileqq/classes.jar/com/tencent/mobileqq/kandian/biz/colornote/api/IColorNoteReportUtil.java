package com.tencent.mobileqq.kandian.biz.colornote.api;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/colornote/api/IColorNoteReportUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createRecentColorNoteR5", "", "colorNote", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "queryColorNoteAndReport", "", "cache", "", "reportInsertColorNoteForViola", "reportInsideTabPushRedPnt", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportReadInJoyWeb", "reportRemainTime", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IColorNoteReportUtil
  extends QRouteApi
{
  @Nullable
  public abstract String createRecentColorNoteR5(@Nullable ColorNote paramColorNote);
  
  public abstract void queryColorNoteAndReport(@Nullable List<? extends ColorNote> paramList);
  
  public abstract void reportInsertColorNoteForViola(@Nullable ColorNote paramColorNote);
  
  public abstract void reportInsideTabPushRedPnt(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void reportReadInJoyWeb(@Nullable ColorNote paramColorNote);
  
  public abstract void reportRemainTime(@Nullable ColorNote paramColorNote);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil
 * JD-Core Version:    0.7.0.1
 */