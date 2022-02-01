package cooperation.qqreader;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import mqq.app.ISecurityFileHelper;

public class QQReaderSecurityFileHelper
  implements ISecurityFileHelper
{
  private FilenameFilter jdField_a_of_type_JavaIoFilenameFilter = new QQReaderSecurityFileHelper.1(this);
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{5,}");
  
  public String declareBusinessFileName()
  {
    return "ReaderZone";
  }
  
  public boolean doMigrate(File paramFile)
  {
    File localFile1 = new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/");
    String[] arrayOfString = localFile1.list(this.jdField_a_of_type_JavaIoFilenameFilter);
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return true;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        File localFile2 = new File(localFile1, (String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(declareBusinessFileName());
        localObject = new File(localStringBuilder.toString());
        int k = FileUtils.quickMove(localFile2.getAbsolutePath(), ((File)localObject).getAbsolutePath());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doMigrate：");
        localStringBuilder.append(declareBusinessFileName());
        localStringBuilder.append(" result = ");
        localStringBuilder.append(k);
        localStringBuilder.append(" fromFile = ");
        localStringBuilder.append(localFile2.getAbsolutePath());
        localStringBuilder.append(" targetFile = ");
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        QLog.d("ISecurityFileHelper", 1, localStringBuilder.toString());
        if (k != 0) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean needMigration()
  {
    String[] arrayOfString = new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/").list(this.jdField_a_of_type_JavaIoFilenameFilter);
    return (arrayOfString != null) && (arrayOfString.length > 0);
  }
  
  @NonNull
  public File oldBusinessDir(String paramString)
  {
    return new File(new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/"), paramString);
  }
  
  public boolean oldBusinessDirExist(String paramString)
  {
    paramString = oldBusinessDir(paramString);
    return (paramString.isDirectory()) && (paramString.exists());
  }
  
  public String[] reportHistoryFileInfo()
  {
    String[] arrayOfString1 = new String[2];
    Object localObject = new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/");
    String[] arrayOfString2 = ((File)localObject).list(this.jdField_a_of_type_JavaIoFilenameFilter);
    if ((arrayOfString2 != null) && (arrayOfString2.length > 0))
    {
      int j = arrayOfString2.length;
      long l1 = 0L;
      long l2 = l1;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString2[i];
        l2 += FileUtils.getFileOrFolderSize(new File((File)localObject, str).getAbsolutePath());
        l1 += FileUtils.getFileAmount(new File((File)localObject, str).getAbsolutePath());
        i += 1;
      }
      arrayOfString1[0] = Long.toString(l2);
      arrayOfString1[1] = Long.toString(l1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportHistoryFileInfo:");
      ((StringBuilder)localObject).append(declareBusinessFileName());
      ((StringBuilder)localObject).append(" fileAmount = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" fileSize = ");
      ((StringBuilder)localObject).append(l2);
      QLog.d("ISecurityFileHelper", 1, ((StringBuilder)localObject).toString());
    }
    return arrayOfString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqreader.QQReaderSecurityFileHelper
 * JD-Core Version:    0.7.0.1
 */