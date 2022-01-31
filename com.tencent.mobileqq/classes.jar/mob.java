import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class mob
  extends batl
{
  mob(moa parammoa) {}
  
  public void onDone(batm parambatm)
  {
    if (parambatm.a == 0) {
      parambatm = parambatm.a().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(parambatm);
        String str = bace.b(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + parambatm);
        }
        localFile.delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException parambatm)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(parambatm));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + parambatm.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mob
 * JD-Core Version:    0.7.0.1
 */