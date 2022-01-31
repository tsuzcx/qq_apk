import android.text.TextUtils;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.utils.ScoreManager.DownloadInfo;
import com.tencent.mobileqq.ar.arengine.ArResourceConfigUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class khf
  implements INetEngine.INetEngineListener
{
  public khf(ScoreManager.DownloadInfo paramDownloadInfo) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((HttpNetReq)paramNetReq).a + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).a);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramNetResp.jdField_a_of_type_Int == 0)
        {
          File localFile = new File(((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).c);
          String str = PortalUtils.a(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.b)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).a + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            paramNetResp = new File(this.a.c);
            ArResourceConfigUtils.a(this.a.c, paramNetResp.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + paramNetResp.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + ImageResUtil.a("qav_score_good.jpg") + ", qav_score_normal : " + ImageResUtil.a("qav_score_normal.jpg") + ", qav_score_bad : " + ImageResUtil.a("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception paramNetResp)
          {
            new File(this.a.c).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khf
 * JD-Core Version:    0.7.0.1
 */