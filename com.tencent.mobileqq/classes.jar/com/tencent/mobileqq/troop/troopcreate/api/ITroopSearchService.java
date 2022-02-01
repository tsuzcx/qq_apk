package com.tencent.mobileqq.troop.troopcreate.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopSearchService
  extends IRuntimeService
{
  public static final int MATCH_TYPE_ALL = 1;
  public static final int MATCH_TYPE_NOT_ALL = 2;
  
  public abstract void search(ArrayList<ResultRecord> paramArrayList, boolean paramBoolean, ITroopSearchService.TroopSearchCallback paramTroopSearchCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService
 * JD-Core Version:    0.7.0.1
 */