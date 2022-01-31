import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lcq
  implements axrt
{
  lcq(lcp paramlcp, String paramString, lcj paramlcj, int paramInt) {}
  
  public void onResp(axsq paramaxsq)
  {
    axro localaxro = (axro)paramaxsq.jdField_a_of_type_Axsp;
    if (this.jdField_a_of_type_Lcp.jdField_a_of_type_Axro == localaxro) {
      this.jdField_a_of_type_Lcp.jdField_a_of_type_Axro = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaxro.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaxsq.jdField_a_of_type_Int), Integer.valueOf(paramaxsq.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      paramaxsq = new File(localaxro.c);
      if (paramaxsq.exists())
      {
        try
        {
          String str = paramaxsq.getParent();
          bace.a(localaxro.c, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          lco.a(this.jdField_a_of_type_Lcj);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lco.a(-1);
          return;
        }
        paramaxsq.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lco.a(100 / this.jdField_a_of_type_Lcp.jdField_a_of_type_Int + this.jdField_a_of_type_Lcp.b);
        paramaxsq = this.jdField_a_of_type_Lcp;
        paramaxsq.b += 100 / this.jdField_a_of_type_Lcp.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lcp.a(this.jdField_a_of_type_Lcj, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Lcp.jdField_a_of_type_Boolean = false;
        }
        return;
      }
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
      lco.a(i / this.jdField_a_of_type_Lcp.jdField_a_of_type_Int + this.jdField_a_of_type_Lcp.b);
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
 * Qualified Name:     lcq
 * JD-Core Version:    0.7.0.1
 */