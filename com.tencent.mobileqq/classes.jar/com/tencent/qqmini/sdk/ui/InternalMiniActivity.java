package com.tencent.qqmini.sdk.ui;

import android.os.Bundle;
import bffu;

public class InternalMiniActivity
  extends MiniActivity
{
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    bffu.b(this);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.InternalMiniActivity
 * JD-Core Version:    0.7.0.1
 */