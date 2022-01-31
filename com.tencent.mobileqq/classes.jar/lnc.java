import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lnc
  implements aysc
{
  lnc(lnb paramlnb, String paramString, lmv paramlmv, int paramInt) {}
  
  public void onResp(aysz paramaysz)
  {
    ayrx localayrx = (ayrx)paramaysz.jdField_a_of_type_Aysy;
    if (this.jdField_a_of_type_Lnb.jdField_a_of_type_Ayrx == localayrx) {
      this.jdField_a_of_type_Lnb.jdField_a_of_type_Ayrx = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localayrx.jdField_a_of_type_JavaLangString, Integer.valueOf(paramaysz.jdField_a_of_type_Int), Integer.valueOf(paramaysz.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      paramaysz = new File(localayrx.c);
      if (paramaysz.exists())
      {
        try
        {
          String str = paramaysz.getParent();
          bbdx.a(localayrx.c, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          lna.a(this.jdField_a_of_type_Lmv);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          lna.a(-1);
          return;
        }
        paramaysz.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lna.a(100 / this.jdField_a_of_type_Lnb.jdField_a_of_type_Int + this.jdField_a_of_type_Lnb.b);
        paramaysz = this.jdField_a_of_type_Lnb;
        paramaysz.b += 100 / this.jdField_a_of_type_Lnb.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lnb.a(this.jdField_a_of_type_Lmv, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Lnb.jdField_a_of_type_Boolean = false;
        }
        return;
      }
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
      lna.a(i / this.jdField_a_of_type_Lnb.jdField_a_of_type_Int + this.jdField_a_of_type_Lnb.b);
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
 * Qualified Name:     lnc
 * JD-Core Version:    0.7.0.1
 */