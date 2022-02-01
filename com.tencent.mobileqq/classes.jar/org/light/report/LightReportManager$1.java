package org.light.report;

import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.light.utils.LightLogUtil;

final class LightReportManager$1
  implements Runnable
{
  LightReportManager$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {
      LightLogUtil.e("LightReportManager", "没有SDCARD");
    }
    Object localObject = Environment.getExternalStorageDirectory();
    ((File)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("得到的根目录路径:");
    localStringBuilder.append(localObject);
    LightLogUtil.e("LightReportManager", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.val$finalFileName);
    localStringBuilder.append(".txt");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("GeneratePerfReport path:");
    localStringBuilder.append((String)localObject);
    LightLogUtil.i("LightReportManager", localStringBuilder.toString());
    try
    {
      localObject = new FileOutputStream(new File((String)localObject));
      ((FileOutputStream)localObject).write(this.val$jsonValue.getBytes());
      ((FileOutputStream)localObject).close();
      LightLogUtil.i("LightReportManager", "GeneratePerfReport write compeletly.");
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label177;
    }
    catch (IOException localIOException)
    {
      label169:
      break label169;
    }
    LightLogUtil.i("LightReportManager", "GeneratePerfReport exception:IOException");
    return;
    label177:
    LightLogUtil.i("LightReportManager", "GeneratePerfReport exception:FileNotFoundException");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.report.LightReportManager.1
 * JD-Core Version:    0.7.0.1
 */