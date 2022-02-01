package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Typeface;
import com.etrump.mixlayout.ETEngine;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class TroopNickFontAdapter$1
  implements Runnable
{
  TroopNickFontAdapter$1(TroopNickFontAdapter paramTroopNickFontAdapter, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = TroopNickFontAdapter.c(this.a, this.b);
    if (TroopNickFontAdapter.a(this.this$0, (Typeface)localObject)) {
      return;
    }
    String str1 = FontManagerConstants.getTTFPath(this.a, this.b);
    if (!new File(str1).exists())
    {
      this.this$0.a();
      if (QLog.isColorLevel()) {
        QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_file_error");
      }
      return;
    }
    localObject = str1;
    if (this.b == 1)
    {
      if ((!ETEngine.isSOLoaded.get()) && (TroopNickFontAdapter.c() < 5))
      {
        this.this$0.a();
        if (QLog.isColorLevel()) {
          QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_so_error");
        }
        return;
      }
      String str2 = FontManagerConstants.getStaticTTFPath(this.a, this.b);
      localObject = str1;
      if (ThemeFontAdapter.a(str1, str2)) {
        localObject = str2;
      }
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists())
    {
      localObject = Typeface.createFromFile((File)localObject);
      TroopNickFontAdapter.a(this.this$0, (Typeface)localObject);
      TroopNickFontAdapter.f.put(TroopNickFontAdapter.e(this.a, this.b), localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */