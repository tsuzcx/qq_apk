package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.os.Bundle;

class ErrorAction
  extends BaseAction
{
  public ErrorAction(String paramString)
  {
    super(paramString);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    a(paramActivity, -5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.ErrorAction
 * JD-Core Version:    0.7.0.1
 */