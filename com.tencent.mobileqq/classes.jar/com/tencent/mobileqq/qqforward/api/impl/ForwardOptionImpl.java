package com.tencent.mobileqq.qqforward.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qqforward.api.IForwardOption;

public class ForwardOptionImpl
  implements IForwardOption
{
  public void startForwardActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    ForwardBaseOption.a(paramActivity, paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqforward.api.impl.ForwardOptionImpl
 * JD-Core Version:    0.7.0.1
 */