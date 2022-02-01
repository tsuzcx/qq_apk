package com.tencent.mobileqq.dov.story.api.impl;

import NS_COMM.COMM.Entry;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.dov.story.api.IVSReporter;
import java.util.List;

public class VSReporterImpl
  implements IVSReporter
{
  public List<COMM.Entry> newPerfEntries(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    return VSReporter.a(paramInt, paramLong1, paramString, paramLong2);
  }
  
  public void reportPerfEvent(String paramString, List<COMM.Entry> paramList)
  {
    VSReporter.a(paramString, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dov.story.api.impl.VSReporterImpl
 * JD-Core Version:    0.7.0.1
 */