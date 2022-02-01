import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lmb
{
  int jdField_a_of_type_Int = 0;
  bdvs jdField_a_of_type_Bdvs;
  llv jdField_a_of_type_Llv = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(llv paramllv)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Llv == paramllv) || (TextUtils.isEmpty(paramllv.b)) || (paramllv.b.equals(this.jdField_a_of_type_Llv.b))) {
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
        if (this.jdField_a_of_type_Bdvs != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Bdvs.a() }));
              ((bdvu)localObject).b(this.jdField_a_of_type_Bdvs);
            }
          }
        }
        this.jdField_a_of_type_Llv = paramllv;
        this.jdField_a_of_type_Bdvs = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lmd.a(this.jdField_a_of_type_Llv)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Llv }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Llv, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(llv paramllv, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lmd.a(paramllv))
    {
      str2 = paramllv.jdField_a_of_type_JavaLangString;
      str1 = paramllv.b;
      str3 = lmd.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramllv }));
        lma.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lma.a(100);
      return false;
    }
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = new lmc(this, str1, paramllv, paramInt);
    localbdvs.a(str1);
    localbdvs.jdField_a_of_type_JavaLangString = str2;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = new File(str3).getPath();
    localbdvs.b = bgnt.a(bdwu.a().a());
    paramllv = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramllv instanceof QQAppInterface))
    {
      paramllv = ((QQAppInterface)paramllv).getNetEngine(0);
      if (paramllv != null)
      {
        this.jdField_a_of_type_Bdvs = localbdvs;
        paramllv.a(this.jdField_a_of_type_Bdvs);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lma.a(-2);
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
 * Qualified Name:     lmb
 * JD-Core Version:    0.7.0.1
 */