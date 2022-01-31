import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class mvt
  implements baug
{
  mvt(mvv parammvv) {}
  
  public void onResp(bavf parambavf)
  {
    if (parambavf.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((baub)parambavf.jdField_a_of_type_Bave).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (parambavf.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((baub)parambavf.jdField_a_of_type_Bave).c);
          String str = awni.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((baub)parambavf.jdField_a_of_type_Bave).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            parambavf = new File(this.a.c);
            anea.a(this.a.c, parambavf.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + parambavf.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + mum.a("qav_score_good.jpg") + ", qav_score_normal : " + mum.a("qav_score_normal.jpg") + ", qav_score_bad : " + mum.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception parambavf)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((baub)parambave).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mvt
 * JD-Core Version:    0.7.0.1
 */