import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class mid
  implements axrt
{
  mid(mif parammif) {}
  
  public void onResp(axsq paramaxsq)
  {
    if (paramaxsq.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((axro)paramaxsq.jdField_a_of_type_Axsp).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramaxsq.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((axro)paramaxsq.jdField_a_of_type_Axsp).c);
          String str = attn.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((axro)paramaxsq.jdField_a_of_type_Axsp).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            paramaxsq = new File(this.a.c);
            akuq.a(this.a.c, paramaxsq.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + paramaxsq.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + mgw.a("qav_score_good.jpg") + ", qav_score_normal : " + mgw.a("qav_score_normal.jpg") + ", qav_score_bad : " + mgw.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception paramaxsq)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((axro)paramaxsp).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mid
 * JD-Core Version:    0.7.0.1
 */