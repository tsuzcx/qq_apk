package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ForwardCompositeOption
  extends ForwardBaseOption
{
  public ForwardCompositeOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean f()
  {
    Intent localIntent = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
    localIntent.putExtras(this.t);
    this.s.setResult(-1, localIntent);
    this.s.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardCompositeOption
 * JD-Core Version:    0.7.0.1
 */