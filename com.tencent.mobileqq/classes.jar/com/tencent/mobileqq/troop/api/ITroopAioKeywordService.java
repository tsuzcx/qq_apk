package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.observer.KeywordTipInfoObserver;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopAioKeywordService
  extends IRuntimeService
{
  public abstract void getTroopAioKeywordTipInfo(List<Integer> paramList, KeywordTipInfoObserver paramKeywordTipInfoObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopAioKeywordService
 * JD-Core Version:    0.7.0.1
 */