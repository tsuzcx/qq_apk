import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lng
{
  int jdField_a_of_type_Int = 0;
  ayrv jdField_a_of_type_Ayrv;
  lna jdField_a_of_type_Lna = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(lna paramlna)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lna == paramlna) || (TextUtils.isEmpty(paramlna.b)) || (paramlna.b.equals(this.jdField_a_of_type_Lna.b))) {
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
        if (this.jdField_a_of_type_Ayrv != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrv.a() }));
              ((ayry)localObject).b(this.jdField_a_of_type_Ayrv);
            }
          }
        }
        this.jdField_a_of_type_Lna = paramlna;
        this.jdField_a_of_type_Ayrv = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lni.a(this.jdField_a_of_type_Lna)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Lna }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Lna, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(lna paramlna, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lni.a(paramlna))
    {
      str2 = paramlna.jdField_a_of_type_JavaLangString;
      str1 = paramlna.b;
      str3 = lni.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramlna }));
        lnf.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lnf.a(100);
      return false;
    }
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = new lnh(this, str1, paramlna, paramInt);
    localayrv.a(str1);
    localayrv.jdField_a_of_type_JavaLangString = str2;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_c_of_type_JavaLangString = new File(str3).getPath();
    localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
    paramlna = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramlna instanceof QQAppInterface))
    {
      paramlna = ((QQAppInterface)paramlna).getNetEngine(0);
      if (paramlna != null)
      {
        this.jdField_a_of_type_Ayrv = localayrv;
        paramlna.a(this.jdField_a_of_type_Ayrv);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lnf.a(-2);
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
 * Qualified Name:     lng
 * JD-Core Version:    0.7.0.1
 */