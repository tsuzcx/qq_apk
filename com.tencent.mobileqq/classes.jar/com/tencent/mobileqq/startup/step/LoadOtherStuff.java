package com.tencent.mobileqq.startup.step;

import bdmc;
import com.tencent.common.app.BaseApplicationImpl;

public class LoadOtherStuff
  extends Step
{
  protected boolean doStep()
  {
    bdmc.a(BaseApplicationImpl.getContext());
    BaseApplicationImpl.getApplication().getSharedPreferences("UserGuide", 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadOtherStuff
 * JD-Core Version:    0.7.0.1
 */