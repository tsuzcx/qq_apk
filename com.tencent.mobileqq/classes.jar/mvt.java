import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class mvt
  implements bapx
{
  mvt(mvv parammvv) {}
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((baps)parambaqw.jdField_a_of_type_Baqv).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (parambaqw.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((baps)parambaqw.jdField_a_of_type_Baqv).c);
          String str = awiz.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((baps)parambaqw.jdField_a_of_type_Baqv).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            parambaqw = new File(this.a.c);
            amzr.a(this.a.c, parambaqw.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + parambaqw.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + mum.a("qav_score_good.jpg") + ", qav_score_normal : " + mum.a("qav_score_normal.jpg") + ", qav_score_bad : " + mum.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception parambaqw)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((baps)parambaqv).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mvt
 * JD-Core Version:    0.7.0.1
 */