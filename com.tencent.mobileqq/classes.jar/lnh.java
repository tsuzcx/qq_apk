import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lnh
  implements aysa
{
  lnh(lng paramlng, String paramString, lna paramlna, int paramInt) {}
  
  public void onResp(aysx paramaysx)
  {
    ayrv localayrv = (ayrv)paramaysx.jdField_a_of_type_Aysw;
    if (this.jdField_a_of_type_Lng.jdField_a_of_type_Ayrv == localayrv) {
      this.jdField_a_of_type_Lng.jdField_a_of_type_Ayrv = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrv.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysx.jdField_a_of_type_Int), Integer.valueOf(paramaysx.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      paramaysx = new File(localayrv.c);
      if (paramaysx.exists())
      {
        try
        {
          String str = paramaysx.getParent();
          bbdj.a(localayrv.c, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          lnf.a(this.jdField_a_of_type_Lna);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lnf.a(-1);
          return;
        }
        paramaysx.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lnf.a(100 / this.jdField_a_of_type_Lng.jdField_a_of_type_Int + this.jdField_a_of_type_Lng.b);
        paramaysx = this.jdField_a_of_type_Lng;
        paramaysx.b += 100 / this.jdField_a_of_type_Lng.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lng.a(this.jdField_a_of_type_Lna, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Lng.jdField_a_of_type_Boolean = false;
        }
        return;
      }
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
      lnf.a(i / this.jdField_a_of_type_Lng.jdField_a_of_type_Int + this.jdField_a_of_type_Lng.b);
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
 * Qualified Name:     lnh
 * JD-Core Version:    0.7.0.1
 */