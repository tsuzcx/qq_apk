package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import java.util.List;

public abstract interface SelectPositionModule$IPositionOrCityListChangedListener
{
  public abstract void a(PositionData paramPositionData);
  
  public abstract void a(List<CityData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule.IPositionOrCityListChangedListener
 * JD-Core Version:    0.7.0.1
 */