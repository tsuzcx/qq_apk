package com.tencent.qg.qq;

import android.os.Bundle;
import bfxp;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;

public class QGameApp$1
  implements Runnable
{
  public QGameApp$1(bfxp parambfxp) {}
  
  public void run()
  {
    GameDemoFragment localGameDemoFragment = new GameDemoFragment();
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("key_run_js", bfxp.a(this.this$0));
    localGameDemoFragment.setArguments(localBundle);
    this.this$0.a.a(localGameDemoFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp.1
 * JD-Core Version:    0.7.0.1
 */