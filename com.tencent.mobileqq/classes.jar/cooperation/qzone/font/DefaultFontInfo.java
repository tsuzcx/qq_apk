package cooperation.qzone.font;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class DefaultFontInfo
{
  public final String TAG = "DefaultFontInfo";
  public int fontId;
  public String fontUrl;
  public int formatType;
  
  public void readFrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    if (paramString != null)
    {
      if (paramString.length < 3) {
        return;
      }
      try
      {
        this.fontId = Integer.valueOf(paramString[0]).intValue();
        this.formatType = Integer.valueOf(paramString[1]).intValue();
        this.fontUrl = paramString[2];
        return;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadDefaultFontData Throwable, errMsg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("DefaultFontInfo", 1, localStringBuilder.toString());
      }
    }
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.fontUrl)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.fontId);
    localStringBuilder.append(";");
    localStringBuilder.append(this.formatType);
    localStringBuilder.append(";");
    localStringBuilder.append(this.fontUrl);
    localStringBuilder.append(";");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.DefaultFontInfo
 * JD-Core Version:    0.7.0.1
 */