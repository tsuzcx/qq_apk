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
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("begin to download font file from network, url =");
      localStringBuilder.append(this.val$fontUrl);
      QLog.d("FontManager", 4, localStringBuilder.toString());
    }
    if (HttpDownloadUtil.download(null, this.val$fontUrl, new File(FontManager.access$500(this.this$0, this.val$fontID))))
    {
      FontManager.access$600(this.this$0, this.val$fontID);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Font Download Failed, font url = ");
      localStringBuilder.append(this.val$fontUrl);
      QLog.e("FontManager", 1, localStringBuilder.toString());
    }
    FontManager.access$700(this.this$0, this.val$fontID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.4
 * JD-Core Version:    0.7.0.1
 */