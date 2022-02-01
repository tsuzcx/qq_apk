package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.IFTSFetcher;

public class FTSFetcherImpl
  implements IFTSFetcher
{
  public void setIntoFTSMessagePage(boolean paramBoolean)
  {
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.FTSFetcherImpl
 * JD-Core Version:    0.7.0.1
 */