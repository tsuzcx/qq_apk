import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lzt
  implements aysc
{
  lzt(lzs paramlzs, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(aysz paramaysz)
  {
    ayrx localayrx = (ayrx)paramaysz.jdField_a_of_type_Aysy;
    if (this.jdField_a_of_type_Lzs.jdField_a_of_type_Ayrx == localayrx) {
      this.jdField_a_of_type_Lzs.jdField_a_of_type_Ayrx = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrx.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysz.jdField_a_of_type_Int), Integer.valueOf(paramaysz.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = new File(localayrx.c);
      if (paramaysz.exists())
      {
        try
        {
          if (!lzr.a(localayrx.c, this.jdField_a_of_type_JavaLangString)) {
            break label343;
          }
          String str = paramaysz.getParent();
          bbdx.a(localayrx.c, str, false);
          if (((this.jdField_a_of_type_Int != 1) || (!lzr.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_so_wxvoiceembedqqegg, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_so_wxvoiceembedqqegg))) && ((this.jdField_a_of_type_Int != 2) || (!lzr.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_model_wxvoiceembed, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          lzr.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lzr.a(-1);
          this.jdField_a_of_type_Lzs.jdField_a_of_type_Boolean = false;
          return;
        }
        paramaysz.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lzr.a(100 / this.jdField_a_of_type_Lzs.jdField_a_of_type_Int + this.jdField_a_of_type_Lzs.b);
        paramaysz = this.jdField_a_of_type_Lzs;
        paramaysz.b += 100 / this.jdField_a_of_type_Lzs.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lzs.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Lzs.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      label343:
      i = 0;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      lzr.a(i / this.jdField_a_of_type_Lzs.jdField_a_of_type_Int + this.jdField_a_of_type_Lzs.b);
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
 * Qualified Name:     lzt
 * JD-Core Version:    0.7.0.1
 */