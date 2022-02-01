package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Typeface;
import bhql;
import bhsz;
import com.etrump.mixlayout.ETEngine;
import com.tencent.TMG.utils.QLog;
import gb;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopNickFontAdapter$1
  implements Runnable
{
  public TroopNickFontAdapter$1(bhsz parambhsz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = bhsz.a(this.a, this.b);
    if (bhsz.a(this.this$0, (Typeface)localObject)) {}
    do
    {
      do
      {
        return;
        localObject = gb.a(this.a, this.b);
        if (new File((String)localObject).exists()) {
          break;
        }
        this.this$0.c(this.a, this.b);
      } while (!QLog.isColorLevel());
      QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_file_error");
      return;
      if (this.b != 1) {
        break label208;
      }
      if ((ETEngine.isSOLoaded.get()) || (bhsz.a() >= 5)) {
        break;
      }
      this.this$0.c(this.a, this.b);
    } while (!QLog.isColorLevel());
    QLog.d("TroopNickFontAdapter", 1, "troop_nick_font_so_error");
    return;
    String str = gb.b(this.a, this.b);
    if (bhql.a((String)localObject, str)) {
      localObject = str;
    }
    label208:
    for (;;)
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        break;
      }
      localObject = Typeface.createFromFile((File)localObject);
      bhsz.a(this.this$0, (Typeface)localObject);
      bhsz.a.put(bhsz.a(this.a, this.b), localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */