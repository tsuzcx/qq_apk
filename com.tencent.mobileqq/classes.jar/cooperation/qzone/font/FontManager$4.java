package cooperation.qzone.font;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class FontManager$4
  implements Runnable
{
  FontManager$4(FontManager paramFontManager, String paramString, int paramInt) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FontManager", 4, "begin to download font file from network, url =" + this.val$fontUrl);
    }
    if (HttpDownloadUtil.download(null, this.val$fontUrl, new File(FontManager.access$500(this.this$0, this.val$fontID)))) {
      FontManager.access$600(this.this$0, this.val$fontID);
    }
    for (;;)
    {
      FontManager.access$700(this.this$0, this.val$fontID);
      return;
      QLog.e("FontManager", 1, "Font Download Failed, font url = " + this.val$fontUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.4
 * JD-Core Version:    0.7.0.1
 */