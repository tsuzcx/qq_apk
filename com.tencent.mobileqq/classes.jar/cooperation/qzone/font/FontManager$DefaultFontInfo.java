package cooperation.qzone.font;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class FontManager$DefaultFontInfo
{
  public int fontId;
  public String fontUrl;
  public int formatType;
  
  public void readFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = paramString.split(";");
    } while ((paramString == null) || (paramString.length < 3));
    try
    {
      this.fontId = Integer.valueOf(paramString[0]).intValue();
      this.formatType = Integer.valueOf(paramString[1]).intValue();
      this.fontUrl = paramString[2];
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("FontManager", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.fontUrl)) {
      return "";
    }
    return this.fontId + ";" + this.formatType + ";" + this.fontUrl + ";";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.DefaultFontInfo
 * JD-Core Version:    0.7.0.1
 */