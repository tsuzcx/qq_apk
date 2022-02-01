package com.tencent.mobileqq.troop.shortcutbar;

import android.text.TextUtils;

class TroopShortcutBarManager$2
  implements Runnable
{
  TroopShortcutBarManager$2(TroopShortcutBarManager paramTroopShortcutBarManager, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    String str = String.valueOf(this.a);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.this$0.a(str, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.2
 * JD-Core Version:    0.7.0.1
 */