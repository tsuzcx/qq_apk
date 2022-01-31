import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lpf
  implements baug
{
  lpf(lpe paramlpe, String paramString, loy paramloy, int paramInt) {}
  
  public void onResp(bavf parambavf)
  {
    baub localbaub = (baub)parambavf.jdField_a_of_type_Bave;
    if (this.jdField_a_of_type_Lpe.jdField_a_of_type_Baub == localbaub) {
      this.jdField_a_of_type_Lpe.jdField_a_of_type_Baub = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbaub.jdField_a_of_type_JavaLangString, Integer.valueOf(parambavf.jdField_a_of_type_Int), Integer.valueOf(parambavf.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      parambavf = new File(localbaub.c);
      if (parambavf.exists())
      {
        try
        {
          String str = parambavf.getParent();
          bdhb.a(localbaub.c, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          lpd.a(this.jdField_a_of_type_Loy);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lpd.a(-1);
          return;
        }
        parambavf.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lpd.a(100 / this.jdField_a_of_type_Lpe.jdField_a_of_type_Int + this.jdField_a_of_type_Lpe.b);
        parambavf = this.jdField_a_of_type_Lpe;
        parambavf.b += 100 / this.jdField_a_of_type_Lpe.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lpe.a(this.jdField_a_of_type_Loy, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Lpe.jdField_a_of_type_Boolean = false;
        }
        return;
      }
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
      lpd.a(i / this.jdField_a_of_type_Lpe.jdField_a_of_type_Int + this.jdField_a_of_type_Lpe.b);
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
 * Qualified Name:     lpf
 * JD-Core Version:    0.7.0.1
 */