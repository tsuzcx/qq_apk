package com.tencent.mtt.abtestsdk.listener;

import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import java.util.List;

public abstract interface GetExperimentListener
{
  public abstract void getExperimentFailed(int paramInt, String paramString);
  
  public abstract void getExperimentSucceed(List<ExpEntity> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.listener.GetExperimentListener
 * JD-Core Version:    0.7.0.1
 */