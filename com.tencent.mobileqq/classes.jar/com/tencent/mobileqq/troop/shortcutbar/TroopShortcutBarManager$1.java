package com.tencent.mobileqq.troop.shortcutbar;

import android.text.TextUtils;
import bfkr;

public class TroopShortcutBarManager$1
  implements Runnable
{
  public TroopShortcutBarManager$1(bfkr parambfkr, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    String str = String.valueOf(this.a);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.this$0.a(str, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.1
 * JD-Core Version:    0.7.0.1
 */