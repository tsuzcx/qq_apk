import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class maj
  implements INetEngine.INetEngineListener
{
  maj(mai parammai, mak parammak) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    int i;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          if (!mal.a(localHttpNetReq.mOutPath, this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo.resZipMd5)) {
            break label232;
          }
          String str = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, str, false);
          boolean bool = mal.a(str + File.separator + this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo.resFileName, this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo.resMd5);
          if (!bool) {
            break label232;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
            continue;
            QLog.e("ResMgr", 1, "download end but failed. uncompressZip failed or md5 not match. " + this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo);
            mai.a(-1, this.jdField_a_of_type_Mak.b, this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo);
          }
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        QLog.i("ResMgr", 1, "download successfully. " + this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo);
        mai.a(1, 100, this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo);
        if (this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq)
        {
          this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
          this.jdField_a_of_type_Mak.jdField_a_of_type_Int = 0;
          mai.a(this.jdField_a_of_type_Mai).remove(this.jdField_a_of_type_Mak);
        }
        return;
      }
      label232:
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
      this.jdField_a_of_type_Mak.b = i;
      if (QLog.isColorLevel()) {
        QLog.d("ResMgr", 2, "download... progress = " + i + ", " + this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo);
      }
      mai.a(2, i, this.jdField_a_of_type_Mak.jdField_a_of_type_ComTencentAvSoResInfo);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     maj
 * JD-Core Version:    0.7.0.1
 */