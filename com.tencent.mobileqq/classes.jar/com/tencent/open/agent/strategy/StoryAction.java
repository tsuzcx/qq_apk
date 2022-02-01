package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.SendStoryActivity;

class StoryAction
  extends WithTokenAction
{
  public StoryAction(String paramString)
  {
    super(paramString);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    a(new Intent(paramActivity, SendStoryActivity.class), paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.StoryAction
 * JD-Core Version:    0.7.0.1
 */