import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lzk
  implements bdvw
{
  lzk(lzj paramlzj, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(bdwt parambdwt)
  {
    bdvs localbdvs = (bdvs)parambdwt.jdField_a_of_type_Bdws;
    if (this.jdField_a_of_type_Lzj.jdField_a_of_type_Bdvs == localbdvs) {
      this.jdField_a_of_type_Lzj.jdField_a_of_type_Bdvs = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbdvs.jdField_a_of_type_JavaLangString, Integer.valueOf(parambdwt.jdField_a_of_type_Int), Integer.valueOf(parambdwt.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      parambdwt = new File(localbdvs.c);
      if (parambdwt.exists())
      {
        try
        {
          if (!lzi.a(localbdvs.c, this.jdField_a_of_type_JavaLangString)) {
            break label343;
          }
          String str = parambdwt.getParent();
          bgmg.a(localbdvs.c, str, false);
          if (((this.jdField_a_of_type_Int != 1) || (!lzi.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_so_wxvoiceembedqqegg, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_so_wxvoiceembedqqegg))) && ((this.jdField_a_of_type_Int != 2) || (!lzi.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_model_wxvoiceembed, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          lzi.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lzi.a(-1);
          this.jdField_a_of_type_Lzj.jdField_a_of_type_Boolean = false;
          return;
        }
        parambdwt.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lzi.a(100 / this.jdField_a_of_type_Lzj.jdField_a_of_type_Int + this.jdField_a_of_type_Lzj.b);
        parambdwt = this.jdField_a_of_type_Lzj;
        parambdwt.b += 100 / this.jdField_a_of_type_Lzj.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lzj.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Lzj.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      label343:
      i = 0;
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      lzi.a(i / this.jdField_a_of_type_Lzj.jdField_a_of_type_Int + this.jdField_a_of_type_Lzj.b);
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
 * Qualified Name:     lzk
 * JD-Core Version:    0.7.0.1
 */