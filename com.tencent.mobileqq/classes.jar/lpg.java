import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lpg
  implements axrt
{
  lpg(lpf paramlpf, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(axsq paramaxsq)
  {
    axro localaxro = (axro)paramaxsq.jdField_a_of_type_Axsp;
    if (this.jdField_a_of_type_Lpf.jdField_a_of_type_Axro == localaxro) {
      this.jdField_a_of_type_Lpf.jdField_a_of_type_Axro = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaxro.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaxsq.jdField_a_of_type_Int), Integer.valueOf(paramaxsq.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = new File(localaxro.c);
      if (paramaxsq.exists())
      {
        try
        {
          if (!lpe.a(localaxro.c, this.jdField_a_of_type_JavaLangString)) {
            break label343;
          }
          String str = paramaxsq.getParent();
          bace.a(localaxro.c, str, false);
          if (((this.jdField_a_of_type_Int != 1) || (!lpe.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_so_wxvoiceembedqqegg, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_so_wxvoiceembedqqegg))) && ((this.jdField_a_of_type_Int != 2) || (!lpe.a(str + File.separator + this.jdField_a_of_type_ComTencentAvSoDownloadInfo.filename_model_wxvoiceembed, this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          lpe.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lpe.a(-1);
          this.jdField_a_of_type_Lpf.jdField_a_of_type_Boolean = false;
          return;
        }
        paramaxsq.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lpe.a(100 / this.jdField_a_of_type_Lpf.jdField_a_of_type_Int + this.jdField_a_of_type_Lpf.b);
        paramaxsq = this.jdField_a_of_type_Lpf;
        paramaxsq.b += 100 / this.jdField_a_of_type_Lpf.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lpf.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Lpf.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      label343:
      i = 0;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      lpe.a(i / this.jdField_a_of_type_Lpf.jdField_a_of_type_Int + this.jdField_a_of_type_Lpf.b);
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
 * Qualified Name:     lpg
 * JD-Core Version:    0.7.0.1
 */