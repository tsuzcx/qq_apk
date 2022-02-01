package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Typeface;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontManager;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class TroopNickFontAdapter$1
  implements Runnable
{
  TroopNickFontAdapter$1(TroopNickFontAdapter paramTroopNickFontAdapter, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = TroopNickFontAdapter.a(this.a, this.b);
    if (TroopNickFontAdapter.a(this.this$0, (Typeface)localObject)) {}
    do
    {
      do
      {
        return;
        localObject = FontManager.a(this.a, this.b);
        if (new File((String)localObject).exists()) {
          break;
        }
        this.this$0.b();
      } while (!QLog.isColorLevel());
      QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_file_error");
      return;
      if (this.b != 1) {
        break label192;
      }
      if ((ETEngine.isSOLoaded.get()) || (TroopNickFontAdapter.a() >= 5)) {
        break;
      }
      this.this$0.b();
    } while (!QLog.isColorLevel());
    QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_so_error");
    return;
    String str = FontManager.b(this.a, this.b);
    if (ThemeFontAdapter.a((String)localObject, str)) {
      localObject = str;
    }
    label192:
    for (;;)
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      localObject = Typeface.createFromFile((File)localObject);
      TroopNickFontAdapter.a(this.this$0, (Typeface)localObject);
      TroopNickFontAdapter.a.put(TroopNickFontAdapter.a(this.a, this.b), localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */