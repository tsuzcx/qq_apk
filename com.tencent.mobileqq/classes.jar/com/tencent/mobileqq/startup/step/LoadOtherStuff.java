package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class LoadOtherStuff
  extends Step
{
  protected boolean doStep()
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    BaseApplicationImpl.getApplication().getSharedPreferences("UserGuide", 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadOtherStuff
 * JD-Core Version:    0.7.0.1
 */