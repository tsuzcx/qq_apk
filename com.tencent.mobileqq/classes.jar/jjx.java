import com.tencent.av.gameplay.QAVGamePlaySoConfigInfo;
import com.tencent.av.gameplay.QavGPDownloader;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class jjx
  implements INetEngine.INetEngineListener
{
  jjx(jjw paramjjw, String paramString, QAVGamePlaySoConfigInfo paramQAVGamePlaySoConfigInfo, int paramInt) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      QavGPDownloader.a(i / this.jdField_a_of_type_Jjw.jdField_a_of_type_Int + this.jdField_a_of_type_Jjw.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
    if (this.jdField_a_of_type_Jjw.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_Jjw.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.jdField_a_of_type_JavaLangString, Integer.valueOf(paramNetResp.jdField_a_of_type_Int), Integer.valueOf(paramNetResp.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      paramNetResp = new File(localHttpNetReq.c);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.a(localHttpNetReq.c, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          QavGPDownloader.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          QavGPDownloader.a(-1);
          return;
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        QavGPDownloader.a(100 / this.jdField_a_of_type_Jjw.jdField_a_of_type_Int + this.jdField_a_of_type_Jjw.b);
        paramNetResp = this.jdField_a_of_type_Jjw;
        paramNetResp.b += 100 / this.jdField_a_of_type_Jjw.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Jjw.a(this.jdField_a_of_type_ComTencentAvGameplayQAVGamePlaySoConfigInfo, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Jjw.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jjx
 * JD-Core Version:    0.7.0.1
 */