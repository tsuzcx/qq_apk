import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lmv
  implements INetEngine.INetEngineListener
{
  lmv(lmu paramlmu, String paramString, lmo paramlmo, int paramInt) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.jdField_a_of_type_Lmu.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_Lmu.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          lmt.a(this.jdField_a_of_type_Lmo);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lmt.a(-1);
          return;
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lmt.a(100 / this.jdField_a_of_type_Lmu.jdField_a_of_type_Int + this.jdField_a_of_type_Lmu.b);
        paramNetResp = this.jdField_a_of_type_Lmu;
        paramNetResp.b += 100 / this.jdField_a_of_type_Lmu.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lmu.a(this.jdField_a_of_type_Lmo, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Lmu.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      lmt.a(i / this.jdField_a_of_type_Lmu.jdField_a_of_type_Int + this.jdField_a_of_type_Lmu.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmv
 * JD-Core Version:    0.7.0.1
 */