import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lzy
  implements aysa
{
  lzy(lzx paramlzx, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(aysx paramaysx)
  {
    ayrv localayrv = (ayrv)paramaysx.jdField_a_of_type_Aysw;
    if (this.jdField_a_of_type_Lzx.jdField_a_of_type_Ayrv == localayrv) {
      this.jdField_a_of_type_Lzx.jdField_a_of_type_Ayrv = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrv.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysx.jdField_a_of_type_Int), Integer.valueOf(paramaysx.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      paramaysx = new File(localayrv.c);
      if (paramaysx.exists())
      {
        try
        {
          if (!lzw.a(localayrv.c, this.jdField_a_of_type_JavaLangString)) {
            break label343;
          }
          String str = paramaysx.getParent();
          bbdj.a(localayrv.c, str, false);
          if (((this.jdField_a_of_type_Int != 1) || (!lzw.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_so_wxvoiceembedqqegg, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_so_wxvoiceembedqqegg))) && ((this.jdField_a_of_type_Int != 2) || (!lzw.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_model_wxvoiceembed, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          lzw.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lzw.a(-1);
          this.jdField_a_of_type_Lzx.jdField_a_of_type_Boolean = false;
          return;
        }
        paramaysx.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lzw.a(100 / this.jdField_a_of_type_Lzx.jdField_a_of_type_Int + this.jdField_a_of_type_Lzx.b);
        paramaysx = this.jdField_a_of_type_Lzx;
        paramaysx.b += 100 / this.jdField_a_of_type_Lzx.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lzx.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Lzx.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      label343:
      i = 0;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      lzw.a(i / this.jdField_a_of_type_Lzx.jdField_a_of_type_Int + this.jdField_a_of_type_Lzx.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzy
 * JD-Core Version:    0.7.0.1
 */