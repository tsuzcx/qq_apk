package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;

class WebIPCOperator$RequestItem
{
  int a;
  Bundle b;
  Runnable c;
  
  public WebIPCOperator$RequestItem(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    paramBundle.putInt("seq", paramInt);
    this.b = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator.RequestItem
 * JD-Core Version:    0.7.0.1
 */