import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class msz
  implements aysc
{
  msz(mtb parammtb) {}
  
  public void onResp(aysz paramaysz)
  {
    if (paramaysz.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((ayrx)paramaysz.jdField_a_of_type_Aysy).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramaysz.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((ayrx)paramaysz.jdField_a_of_type_Aysy).c);
          String str = aurn.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((ayrx)paramaysz.jdField_a_of_type_Aysy).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            paramaysz = new File(this.a.c);
            aljb.a(this.a.c, paramaysz.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + paramaysz.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + mrs.a("qav_score_good.jpg") + ", qav_score_normal : " + mrs.a("qav_score_normal.jpg") + ", qav_score_bad : " + mrs.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception paramaysz)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((ayrx)paramaysy).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     msz
 * JD-Core Version:    0.7.0.1
 */