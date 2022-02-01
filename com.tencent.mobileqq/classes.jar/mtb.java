import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class mtb
  implements bdvw
{
  mtb(mtd parammtd) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((bdvs)parambdwt.jdField_a_of_type_Bdws).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (parambdwt.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((bdvs)parambdwt.jdField_a_of_type_Bdws).c);
          String str = azby.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((bdvs)parambdwt.jdField_a_of_type_Bdws).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            parambdwt = new File(this.a.c);
            apcr.a(this.a.c, parambdwt.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + parambdwt.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + mrs.a("qav_score_good.jpg") + ", qav_score_normal : " + mrs.a("qav_score_normal.jpg") + ", qav_score_bad : " + mrs.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception parambdwt)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((bdvs)parambdws).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtb
 * JD-Core Version:    0.7.0.1
 */