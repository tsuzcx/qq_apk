import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class nbr
  extends bdvu
{
  nbr(nbq paramnbq) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (parambdvv.a == 0) {
      parambdvv = parambdvv.a().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(parambdvv);
        String str = bdcs.b(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + parambdvv);
        }
        localFile.delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException parambdvv)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(parambdvv));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + parambdvv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nbr
 * JD-Core Version:    0.7.0.1
 */