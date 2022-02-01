import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class nuv
  extends bhyn
{
  nuv(nuu paramnuu) {}
  
  public void onDone(bhyo parambhyo)
  {
    if (parambhyo.a == 0) {
      parambhyo = parambhyo.a().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(parambhyo);
        String str = FileUtils.readFileToString(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + parambhyo);
        }
        localFile.delete();
        this.a.b(str);
        this.a.a(str);
        return;
      }
      catch (IOException parambhyo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(parambhyo));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + parambhyo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nuv
 * JD-Core Version:    0.7.0.1
 */