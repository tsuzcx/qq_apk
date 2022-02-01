import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class mag
  implements beuq
{
  mag(maf parammaf, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(bevm parambevm)
  {
    beum localbeum = (beum)parambevm.jdField_a_of_type_Bevl;
    if (this.jdField_a_of_type_Maf.jdField_a_of_type_Beum == localbeum) {
      this.jdField_a_of_type_Maf.jdField_a_of_type_Beum = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbeum.jdField_a_of_type_JavaLangString, Integer.valueOf(parambevm.jdField_a_of_type_Int), Integer.valueOf(parambevm.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      parambevm = new File(localbeum.c);
      if (parambevm.exists())
      {
        try
        {
          if (!mae.a(localbeum.c, this.jdField_a_of_type_JavaLangString)) {
            break label343;
          }
          String str = parambevm.getParent();
          bhmi.a(localbeum.c, str, false);
          if (((this.jdField_a_of_type_Int != 1) || (!mae.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_so_wxvoiceembedqqegg, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_so_wxvoiceembedqqegg))) && ((this.jdField_a_of_type_Int != 2) || (!mae.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_model_wxvoiceembed, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          mae.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          mae.a(-1);
          this.jdField_a_of_type_Maf.jdField_a_of_type_Boolean = false;
          return;
        }
        parambevm.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        mae.a(100 / this.jdField_a_of_type_Maf.jdField_a_of_type_Int + this.jdField_a_of_type_Maf.b);
        parambevm = this.jdField_a_of_type_Maf;
        parambevm.b += 100 / this.jdField_a_of_type_Maf.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Maf.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Maf.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      label343:
      i = 0;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      mae.a(i / this.jdField_a_of_type_Maf.jdField_a_of_type_Int + this.jdField_a_of_type_Maf.b);
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
 * Qualified Name:     mag
 * JD-Core Version:    0.7.0.1
 */