package dov.com.qq.im.ae.gif;

import blwd;
import bmbx;
import bmkn;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class AEGIFStickerListPart$9
  implements Runnable
{
  public AEGIFStickerListPart$9(blwd paramblwd) {}
  
  public void run()
  {
    bmbx.b("AEGIFStickerListPart", "[preDownloadGifFonts] run");
    Iterator localIterator = bmkn.a().a().values().iterator();
    while (localIterator.hasNext())
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean.getPreDownload() == 1) && (!bmkn.a().a(localAEEditorDownloadResBean))) {
        bmkn.a().a(localAEEditorDownloadResBean, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.9
 * JD-Core Version:    0.7.0.1
 */