import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lnb
{
  int jdField_a_of_type_Int = 0;
  ayrx jdField_a_of_type_Ayrx;
  lmv jdField_a_of_type_Lmv = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(lmv paramlmv)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lmv == paramlmv) || (TextUtils.isEmpty(paramlmv.b)) || (paramlmv.b.equals(this.jdField_a_of_type_Lmv.b))) {
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
        if (this.jdField_a_of_type_Ayrx != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Ayrx.a() }));
              ((aysa)localObject).b(this.jdField_a_of_type_Ayrx);
            }
          }
        }
        this.jdField_a_of_type_Lmv = paramlmv;
        this.jdField_a_of_type_Ayrx = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lnd.a(this.jdField_a_of_type_Lmv)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Lmv }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Lmv, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(lmv paramlmv, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lnd.a(paramlmv))
    {
      str2 = paramlmv.jdField_a_of_type_JavaLangString;
      str1 = paramlmv.b;
      str3 = lnd.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramlmv }));
        lna.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lna.a(100);
      return false;
    }
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = new lnc(this, str1, paramlmv, paramInt);
    localayrx.a(str1);
    localayrx.jdField_a_of_type_JavaLangString = str2;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.jdField_c_of_type_JavaLangString = new File(str3).getPath();
    localayrx.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
    paramlmv = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramlmv instanceof QQAppInterface))
    {
      paramlmv = ((QQAppInterface)paramlmv).getNetEngine(0);
      if (paramlmv != null)
      {
        this.jdField_a_of_type_Ayrx = localayrx;
        paramlmv.a(this.jdField_a_of_type_Ayrx);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lna.a(-2);
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
 * Qualified Name:     lnb
 * JD-Core Version:    0.7.0.1
 */