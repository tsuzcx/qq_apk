import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class nmf
  extends biht
{
  nmf(nme paramnme) {}
  
  public void onDone(bihu parambihu)
  {
    if (parambihu.a == 0) {
      parambihu = parambihu.a().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(parambihu);
        String str = bhmi.b(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + parambihu);
        }
        localFile.delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException parambihu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(parambihu));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + parambihu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmf
 * JD-Core Version:    0.7.0.1
 */