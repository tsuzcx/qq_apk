package cooperation.qzone.font;

import java.io.File;
import java.io.FileFilter;

class FontManager$5
  implements FileFilter
{
  FontManager$5(FontManager paramFontManager) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    boolean bool1 = paramFile.endsWith(".ftf");
    boolean bool2 = paramFile.endsWith(".ttf");
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.5
 * JD-Core Version:    0.7.0.1
 */