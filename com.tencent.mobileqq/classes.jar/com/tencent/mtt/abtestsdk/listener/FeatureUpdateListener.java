package com.tencent.mtt.abtestsdk.listener;

import com.tencent.mtt.abtestsdk.entity.FeatureEntity;
import java.util.Map;

public abstract interface FeatureUpdateListener
{
  public abstract void updateFeatureFailed();
  
  public abstract void updateFeatureSuccess(Map<String, FeatureEntity> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.listener.FeatureUpdateListener
 * JD-Core Version:    0.7.0.1
 */