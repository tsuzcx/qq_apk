package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.AuthorityActivity;

class PayAction
  extends BaseAction
{
  public PayAction(String paramString)
  {
    super(paramString);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    a(new Intent(paramActivity, AuthorityActivity.class), paramActivity, paramBundle);
    ReportController.b(null, "dc00898", "", "", "0X800BC5D", "0X800BC5D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.PayAction
 * JD-Core Version:    0.7.0.1
 */