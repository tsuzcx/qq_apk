import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lcp
{
  int jdField_a_of_type_Int = 0;
  axro jdField_a_of_type_Axro;
  lcj jdField_a_of_type_Lcj = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(lcj paramlcj)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lcj == paramlcj) || (TextUtils.isEmpty(paramlcj.b)) || (paramlcj.b.equals(this.jdField_a_of_type_Lcj.b))) {
        break label273;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGPDownloadManager", 2, String.format("GPsoDownloadTask, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_Axro != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Axro.a() }));
              ((axrr)localObject).b(this.jdField_a_of_type_Axro);
            }
          }
        }
        this.jdField_a_of_type_Lcj = paramlcj;
        this.jdField_a_of_type_Axro = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lcr.a(this.jdField_a_of_type_Lcj)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Lcj }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Lcj, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(lcj paramlcj, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lcr.a(paramlcj))
    {
      str2 = paramlcj.jdField_a_of_type_JavaLangString;
      str1 = paramlcj.b;
      str3 = lcr.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramlcj }));
        lco.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lco.a(100);
      return false;
    }
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = new lcq(this, str1, paramlcj, paramInt);
    localaxro.a(str1);
    localaxro.jdField_a_of_type_JavaLangString = str2;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = new File(str3).getPath();
    localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
    paramlcj = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramlcj instanceof QQAppInterface))
    {
      paramlcj = ((QQAppInterface)paramlcj).getNetEngine(0);
      if (paramlcj != null)
      {
        this.jdField_a_of_type_Axro = localaxro;
        paramlcj.a(this.jdField_a_of_type_Axro);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lco.a(-2);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QavGPDownloadManager", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool1) }));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcp
 * JD-Core Version:    0.7.0.1
 */