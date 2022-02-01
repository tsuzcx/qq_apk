package cooperation.qzone.font;

import cooperation.qzone.cache.FileCacheService;
import java.io.File;

class FontManager$3
  implements Runnable
{
  FontManager$3(FontManager paramFontManager, int paramInt1, int paramInt2, FontInterface.FontResult paramFontResult, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new File(FontManager.access$000(this.this$0, this.val$fontID, this.val$fontType));
    if (((File)localObject).exists())
    {
      if (this.val$result != null)
      {
        FontManager.access$100().updateLruFile(((File)localObject).getAbsolutePath(), true);
        this.val$result.result(this.val$fontID, ((File)localObject).getAbsolutePath(), this.val$extend);
      }
    }
    else if (this.val$fontType == 1)
    {
      localObject = new File(FontManager.access$000(this.this$0, this.val$fontID, 0));
      if (((File)localObject).exists())
      {
        String str = FontManager.access$000(this.this$0, this.val$fontID, 1);
        if (FontManager.access$200(this.this$0, ((File)localObject).getAbsolutePath(), str))
        {
          this.val$result.result(this.val$fontID, str, this.val$extend);
          return;
        }
      }
    }
    if (!FontManager.access$300(this.this$0, this.val$fontID, this.val$fontUrl, this.val$fontType, this.val$extend, this.val$result))
    {
      localObject = this.val$result;
      if (localObject != null) {
        ((FontInterface.FontResult)localObject).result(this.val$fontID, null, this.val$extend);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */