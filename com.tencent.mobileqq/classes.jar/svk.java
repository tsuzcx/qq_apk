import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;

public class svk
  extends svb
{
  public svk(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  protected void a(String[] paramArrayOfString, svc paramsvc)
  {
    int k = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        paramsvc = new File(paramArrayOfString[i]).listFiles();
        if (paramsvc == null)
        {
          i += 1;
        }
        else
        {
          int m = paramsvc.length;
          int j = 0;
          while (j < m)
          {
            if (j % 150 == 0) {}
            try
            {
              Thread.sleep(100L);
              File localFile = paramsvc[j];
              if (a(localFile)) {
                a(localFile);
              }
              j += 1;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                ved.e("Q.qqstory.cleaner:UploadTmpVideoCleanStep", "sleep error ,InterruptedException");
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean a(File paramFile)
  {
    if (!paramFile.isDirectory()) {}
    while (System.currentTimeMillis() - paramFile.lastModified() <= 86400000L) {
      return false;
    }
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label60;
      }
      if (TextUtils.equals(paramFile[i].getName(), "dont_delete.txt")) {
        break;
      }
      i += 1;
    }
    label60:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */