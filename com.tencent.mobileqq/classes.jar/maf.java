import android.text.TextUtils;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class maf
{
  int jdField_a_of_type_Int = 0;
  beum jdField_a_of_type_Beum;
  DownloadInfo jdField_a_of_type_ComTencentAvSoDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  
  boolean a(DownloadInfo paramDownloadInfo)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentAvSoDownloadInfo == paramDownloadInfo) || (((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_model)) || (paramDownloadInfo.MD5_zip_model.equals(this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_zip_model))) && ((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_so)) || (paramDownloadInfo.MD5_zip_so.equals(this.jdField_a_of_type_ComTencentAvSoDownloadInfo.MD5_zip_so))))) {
        break label348;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSo", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
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
              QLog.d("QavSo", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Beum.a() }));
              ((beuo)localObject).b(this.jdField_a_of_type_Beum);
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvSoDownloadInfo = paramDownloadInfo;
        this.c = 0;
        this.jdField_a_of_type_Beum = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!maj.b(this.jdField_a_of_type_ComTencentAvSoDownloadInfo))
        {
          this.c |= 0x1;
          this.jdField_a_of_type_Int += 1;
        }
        if (!maj.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo))
        {
          this.c |= 0x2;
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavSo", 2, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.c), this.jdField_a_of_type_ComTencentAvSoDownloadInfo }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo, 3);
        return this.jdField_a_of_type_Boolean;
        label348:
        bool = false;
      }
    }
  }
  
  boolean a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    String str3;
    String str1;
    String str2;
    int i;
    if (!maj.b(paramDownloadInfo))
    {
      str3 = paramDownloadInfo.url_zip_so;
      str1 = paramDownloadInfo.MD5_zip_so;
      str2 = maj.b() + str1;
      i = 1;
    }
    boolean bool2;
    while (paramInt < 0)
    {
      QLog.d("QavSo", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      mae.a(-3);
      bool2 = false;
      return bool2;
      if ((paramDownloadInfo.enable) && (!maj.a(paramDownloadInfo)))
      {
        str3 = paramDownloadInfo.url_zip_model;
        str1 = paramDownloadInfo.MD5_zip_model;
        str2 = maj.a() + str1;
        i = 2;
      }
      else
      {
        mae.a(100);
        return false;
      }
    }
    QLog.i("QavSo", 1, String.format("downloadRes. res_flag[%s], outPath[%s], info[%s]", new Object[] { Integer.valueOf(i), str2, paramDownloadInfo }));
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new mag(this, str1, i, paramDownloadInfo, paramInt);
    localbeum.a(i + "_" + str1);
    localbeum.jdField_a_of_type_JavaLangString = str3;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = new File(str2).getPath();
    localbeum.b = bhnv.a(bevn.a().a());
    paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramDownloadInfo instanceof QQAppInterface))
    {
      paramDownloadInfo = ((QQAppInterface)paramDownloadInfo).getNetEngine(0);
      if (paramDownloadInfo != null)
      {
        this.jdField_a_of_type_Beum = localbeum;
        paramDownloadInfo.a(this.jdField_a_of_type_Beum);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        mae.a(-2);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QavSo", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool1) }));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     maf
 * JD-Core Version:    0.7.0.1
 */