import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lmp
{
  int jdField_a_of_type_Int = 0;
  beum jdField_a_of_type_Beum;
  lmj jdField_a_of_type_Lmj = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(lmj paramlmj)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lmj == paramlmj) || (TextUtils.isEmpty(paramlmj.b)) || (paramlmj.b.equals(this.jdField_a_of_type_Lmj.b))) {
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
        if (this.jdField_a_of_type_Beum != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Beum.a() }));
              ((beuo)localObject).b(this.jdField_a_of_type_Beum);
            }
          }
        }
        this.jdField_a_of_type_Lmj = paramlmj;
        this.jdField_a_of_type_Beum = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lmr.a(this.jdField_a_of_type_Lmj)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Lmj }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Lmj, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(lmj paramlmj, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lmr.a(paramlmj))
    {
      str2 = paramlmj.jdField_a_of_type_JavaLangString;
      str1 = paramlmj.b;
      str3 = lmr.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramlmj }));
        lmo.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lmo.a(100);
      return false;
    }
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new lmq(this, str1, paramlmj, paramInt);
    localbeum.a(str1);
    localbeum.jdField_a_of_type_JavaLangString = str2;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = new File(str3).getPath();
    localbeum.b = bhnv.a(bevn.a().a());
    paramlmj = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramlmj instanceof QQAppInterface))
    {
      paramlmj = ((QQAppInterface)paramlmj).getNetEngine(0);
      if (paramlmj != null)
      {
        this.jdField_a_of_type_Beum = localbeum;
        paramlmj.a(this.jdField_a_of_type_Beum);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lmo.a(-2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmp
 * JD-Core Version:    0.7.0.1
 */