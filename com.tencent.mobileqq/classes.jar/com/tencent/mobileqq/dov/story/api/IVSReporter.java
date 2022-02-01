package com.tencent.mobileqq.dov.story.api;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IVSReporter
  extends QRouteApi
{
  public static final String REPORT_SMART_MUSIC_DOWNLOAD = "edit_music_download";
  
  public abstract List<COMM.Entry> newPerfEntries(int paramInt, long paramLong1, String paramString, long paramLong2);
  
  public abstract void reportPerfEvent(String paramString, List<COMM.Entry> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.IVSReporter
 * JD-Core Version:    0.7.0.1
 */