package cooperation.qzone.font;

import android.text.TextUtils;

public class FontManager$SimpleFontInfo
  extends FontManager.DefaultFontInfo
{
  public boolean hasFont()
  {
    return (this.fontId > 0) && (!TextUtils.isEmpty(this.fontUrl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.SimpleFontInfo
 * JD-Core Version:    0.7.0.1
 */