import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lpf
  implements bapx
{
  lpf(lpe paramlpe, String paramString, loy paramloy, int paramInt) {}
  
  public void onResp(baqw parambaqw)
  {
    baps localbaps = (baps)parambaqw.jdField_a_of_type_Baqv;
    if (this.jdField_a_of_type_Lpe.jdField_a_of_type_Baps == localbaps) {
      this.jdField_a_of_type_Lpe.jdField_a_of_type_Baps = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localbaps.jdField_a_of_type_JavaLangString, Integer.valueOf(parambaqw.jdField_a_of_type_Int), Integer.valueOf(parambaqw.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      parambaqw = new File(localbaps.c);
      if (parambaqw.exists())
      {
        try
        {
          String str = parambaqw.getParent();
          bdcs.a(localbaps.c, str, false);
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
        parambaqw.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lpd.a(100 / this.jdField_a_of_type_Lpe.jdField_a_of_type_Int + this.jdField_a_of_type_Lpe.b);
        parambaqw = this.jdField_a_of_type_Lpe;
        parambaqw.b += 100 / this.jdField_a_of_type_Lpe.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Lpe.a(this.jdField_a_of_type_Loy, this.jdField_a_of_type_Int - 1)) {
          this.jdField_a_of_type_Lpe.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
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