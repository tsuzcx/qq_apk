package cooperation.qzone.font;

import cooperation.qzone.cache.FileCacheService;
import java.io.File;

class FontManager$3
  implements Runnable
{
  FontManager$3(FontManager paramFontManager, int paramInt1, int paramInt2, FontInterface.FontResult paramFontResult, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(FontManager.access$000(this.this$0, this.val$fontID, this.val$fontType));
    if (localFile.exists())
    {
      if (this.val$result == null) {
        break label152;
      }
      FontManager.access$100().updateLruFile(localFile.getAbsolutePath(), true);
      this.val$result.result(this.val$fontID, localFile.getAbsolutePath(), this.val$extend);
    }
    label152:
    while ((FontManager.access$300(this.this$0, this.val$fontID, this.val$fontUrl, this.val$fontType, this.val$extend, this.val$result)) || (this.val$result == null))
    {
      return;
      if (this.val$fontType == 1)
      {
        localFile = new File(FontManager.access$000(this.this$0, this.val$fontID, 0));
        if (localFile.exists())
        {
          String str = FontManager.access$000(this.this$0, this.val$fontID, 1);
          if (FontManager.access$200(this.this$0, localFile.getAbsolutePath(), str))
          {
            this.val$result.result(this.val$fontID, str, this.val$extend);
            return;
          }
        }
      }
    }
    this.val$result.result(this.val$fontID, null, this.val$extend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */