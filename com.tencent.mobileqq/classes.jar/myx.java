import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class myx
  extends bbwt
{
  myx(myw parammyw) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (parambbwu.a == 0) {
      parambbwu = parambbwu.a().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(parambbwu);
        String str = bbdx.b(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + parambbwu);
        }
        localFile.delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException parambbwu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(parambbwu));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + parambbwu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     myx
 * JD-Core Version:    0.7.0.1
 */