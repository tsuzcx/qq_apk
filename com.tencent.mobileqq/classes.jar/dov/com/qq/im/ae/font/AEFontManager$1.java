package dov.com.qq.im.ae.font;

import bnlh;
import bnli;
import bnrh;
import boaf;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class AEFontManager$1
  implements Runnable
{
  public AEFontManager$1(bnlh parambnlh) {}
  
  public void run()
  {
    bnrh.b("AEFontManager", "[preDownloadGifFonts] run");
    Iterator localIterator = boaf.a().a().values().iterator();
    while (localIterator.hasNext())
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if (boaf.a().a(localAEEditorDownloadResBean)) {
        bnlh.a(this.this$0, localAEEditorDownloadResBean.getId());
      } else if (localAEEditorDownloadResBean.getPreDownload() == 1) {
        boaf.a().a(localAEEditorDownloadResBean, new bnli(this, localAEEditorDownloadResBean));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.font.AEFontManager.1
 * JD-Core Version:    0.7.0.1
 */