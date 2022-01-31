import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class mci
  implements baug
{
  mci(mch parammch, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(bavf parambavf)
  {
    baub localbaub = (baub)parambavf.jdField_a_of_type_Bave;
    if (this.jdField_a_of_type_Mch.jdField_a_of_type_Baub == localbaub) {
      this.jdField_a_of_type_Mch.jdField_a_of_type_Baub = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbaub.jdField_a_of_type_JavaLangString, Integer.valueOf(parambavf.jdField_a_of_type_Int), Integer.valueOf(parambavf.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      parambavf = new File(localbaub.c);
      if (parambavf.exists())
      {
        try
        {
          if (!mcg.a(localbaub.c, this.jdField_a_of_type_JavaLangString)) {
            break label343;
          }
          String str = parambavf.getParent();
          bdhb.a(localbaub.c, str, false);
          if (((this.jdField_a_of_type_Int != 1) || (!mcg.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_so_wxvoiceembedqqegg, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_so_wxvoiceembedqqegg))) && ((this.jdField_a_of_type_Int != 2) || (!mcg.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_model_wxvoiceembed, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          mcg.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          mcg.a(-1);
          this.jdField_a_of_type_Mch.jdField_a_of_type_Boolean = false;
          return;
        }
        parambavf.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        mcg.a(100 / this.jdField_a_of_type_Mch.jdField_a_of_type_Int + this.jdField_a_of_type_Mch.b);
        parambavf = this.jdField_a_of_type_Mch;
        parambavf.b += 100 / this.jdField_a_of_type_Mch.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Mch.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Mch.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      label343:
      i = 0;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      mcg.a(i / this.jdField_a_of_type_Mch.jdField_a_of_type_Int + this.jdField_a_of_type_Mch.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mci
 * JD-Core Version:    0.7.0.1
 */