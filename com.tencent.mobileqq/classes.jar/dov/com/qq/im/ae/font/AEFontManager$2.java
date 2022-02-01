package dov.com.qq.im.ae.font;

import android.text.TextUtils;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import org.light.FontAsset;
import org.light.LightEngine;

class AEFontManager$2
  implements Runnable
{
  AEFontManager$2(AEFontManager paramAEFontManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = AEEditorResourceManager.a().a(this.a, 1);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    LightEngine.RegisterFont(new FontAsset(this.b, "Regular"), str);
    AEFontManager.a().a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.font.AEFontManager.2
 * JD-Core Version:    0.7.0.1
 */