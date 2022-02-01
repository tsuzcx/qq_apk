package cooperation.qzone.font;

import java.io.File;
import java.io.FileFilter;

class FontManager$6
  implements FileFilter
{
  FontManager$6(FontManager paramFontManager) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.6
 * JD-Core Version:    0.7.0.1
 */