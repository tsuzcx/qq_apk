import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class mua
  implements beuq
{
  mua(muc parammuc) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((beum)parambevm.jdField_a_of_type_Bevl).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (parambevm.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((beum)parambevm.jdField_a_of_type_Bevl).c);
          String str = azul.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((beum)parambevm.jdField_a_of_type_Bevl).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            parambevm = new File(this.a.c);
            apqh.a(this.a.c, parambevm.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + parambevm.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + msq.a("qav_score_good.jpg") + ", qav_score_normal : " + msq.a("qav_score_normal.jpg") + ", qav_score_bad : " + msq.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception parambevm)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((beum)parambevl).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mua
 * JD-Core Version:    0.7.0.1
 */