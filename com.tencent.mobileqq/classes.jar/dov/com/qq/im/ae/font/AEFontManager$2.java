package dov.com.qq.im.ae.font;

import android.graphics.Typeface;
import android.text.TextUtils;
import bnlh;
import bnrh;
import boaf;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;

public class AEFontManager$2
  implements Runnable
{
  public AEFontManager$2(bnlh parambnlh, String paramString) {}
  
  public void run()
  {
    Object localObject = boaf.a().a(this.a, 1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return;
      bnlh.a().a(this.a, (String)localObject);
      localObject = bnlh.a().a(this.a);
    } while (localObject == Typeface.DEFAULT);
    bnrh.b("AEFontManager", "LogicDataManager putTypeface--by load: " + this.a);
    LogicDataManager.getInstance().putTypeface(this.a, (Typeface)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.font.AEFontManager.2
 * JD-Core Version:    0.7.0.1
 */