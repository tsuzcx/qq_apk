package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.ThreadManager;

public class PreInitValues
  extends Step
{
  protected boolean doStep()
  {
    ThreadManager.postImmediately(new InitDPC(), null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.PreInitValues
 * JD-Core Version:    0.7.0.1
 */