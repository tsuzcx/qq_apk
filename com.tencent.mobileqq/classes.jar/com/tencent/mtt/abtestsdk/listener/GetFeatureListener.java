package com.tencent.mtt.abtestsdk.listener;

import com.tencent.mtt.abtestsdk.entity.FeatureEntity;

public abstract interface GetFeatureListener
{
  public abstract void getFeatureFailed(int paramInt, String paramString);
  
  public abstract void getFeatureSucceed(FeatureEntity paramFeatureEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.listener.GetFeatureListener
 * JD-Core Version:    0.7.0.1
 */