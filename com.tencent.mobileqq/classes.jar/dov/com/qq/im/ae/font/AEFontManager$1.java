package dov.com.qq.im.ae.font;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class AEFontManager$1
  implements Runnable
{
  AEFontManager$1(AEFontManager paramAEFontManager) {}
  
  public void run()
  {
    AEQLog.b("AEFontManager", "[preDownloadAndRegisterGifFonts] run");
    Iterator localIterator = AEEditorResourceManager.a().a().values().iterator();
    while (localIterator.hasNext())
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if (AEEditorResourceManager.a().a(localAEEditorDownloadResBean)) {
        AEFontManager.a(this.this$0, localAEEditorDownloadResBean);
      } else if (localAEEditorDownloadResBean.getPreDownload() == 1) {
        AEEditorResourceManager.a().a(localAEEditorDownloadResBean, new AEFontManager.1.1(this, localAEEditorDownloadResBean));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.font.AEFontManager.1
 * JD-Core Version:    0.7.0.1
 */