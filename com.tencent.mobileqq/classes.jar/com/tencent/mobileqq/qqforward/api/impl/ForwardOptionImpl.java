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
  
  public void startForwardActivityForResult(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt)
  {
    ForwardBaseOption.a(paramActivity, paramIntent, paramClass, paramInt);
  }
  
  public void startForwardActivityForResult(Activity paramActivity, Intent paramIntent, Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    ForwardBaseOption.a(paramActivity, paramIntent, paramClass, paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqforward.api.impl.ForwardOptionImpl
 * JD-Core Version:    0.7.0.1
 */