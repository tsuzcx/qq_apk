package com.tencent.qg.qq;

import android.os.Bundle;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;

class QGameApp$1
  implements Runnable
{
  QGameApp$1(QGameApp paramQGameApp) {}
  
  public void run()
  {
    GameDemoFragment localGameDemoFragment = new GameDemoFragment();
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("key_run_js", QGameApp.a(this.this$0));
    localGameDemoFragment.setArguments(localBundle);
    this.this$0.a.a(localGameDemoFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp.1
 * JD-Core Version:    0.7.0.1
 */