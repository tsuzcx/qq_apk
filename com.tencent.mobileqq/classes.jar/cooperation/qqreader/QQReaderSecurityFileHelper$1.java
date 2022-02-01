package cooperation.qqreader;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class QQReaderSecurityFileHelper$1
  implements FilenameFilter
{
  QQReaderSecurityFileHelper$1(QQReaderSecurityFileHelper paramQQReaderSecurityFileHelper) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramFile != null) && (paramFile.isDirectory()) && (QQReaderSecurityFileHelper.a(this.a).matcher(paramString).matches());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqreader.QQReaderSecurityFileHelper.1
 * JD-Core Version:    0.7.0.1
 */