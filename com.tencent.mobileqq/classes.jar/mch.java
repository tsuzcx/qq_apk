import android.text.TextUtils;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class mch
{
  int jdField_a_of_type_Int = 0;
  baps jdField_a_of_type_Baps;
  DownloadInfo jdField_a_of_type_ComTencentAvSoDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c;
  
  mch()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
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
        if (this.jdField_a_of_type_Baps != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavSo", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Baps.a() }));
              ((bapv)localObject).b(this.jdField_a_of_type_Baps);
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvSoDownloadInfo = paramDownloadInfo;
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Baps = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!mcl.b(this.jdField_a_of_type_ComTencentAvSoDownloadInfo))
        {
          this.jdField_c_of_type_Int |= 0x1;
          this.jdField_a_of_type_Int += 1;
        }
        if (!mcl.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo))
        {
          this.jdField_c_of_type_Int |= 0x2;
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavSo", 2, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_ComTencentAvSoDownloadInfo }));
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
    if (!mcl.b(paramDownloadInfo))
    {
      str3 = paramDownloadInfo.url_zip_so;
      str1 = paramDownloadInfo.MD5_zip_so;
      str2 = mcl.b() + str1;
      i = 1;
    }
    boolean bool2;
    while (paramInt < 0)
    {
      QLog.d("QavSo", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      mcg.a(-3);
      bool2 = false;
      return bool2;
      if ((paramDownloadInfo.enable) && (!mcl.a(paramDownloadInfo)))
      {
        str3 = paramDownloadInfo.url_zip_model;
        str1 = paramDownloadInfo.MD5_zip_model;
        str2 = mcl.a() + str1;
        i = 2;
      }
      else
      {
        mcg.a(100);
        return false;
      }
    }
    QLog.i("QavSo", 1, String.format("downloadRes. res_flag[%s], outPath[%s], info[%s]", new Object[] { Integer.valueOf(i), str2, paramDownloadInfo }));
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = new mci(this, str1, i, paramDownloadInfo, paramInt);
    localbaps.a(i + "_" + str1);
    localbaps.jdField_a_of_type_JavaLangString = str3;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = new File(str2).getPath();
    localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
    paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramDownloadInfo instanceof QQAppInterface))
    {
      paramDownloadInfo = ((QQAppInterface)paramDownloadInfo).getNetEngine(0);
      if (paramDownloadInfo != null)
      {
        this.jdField_a_of_type_Baps = localbaps;
        paramDownloadInfo.a(this.jdField_a_of_type_Baps);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        mcg.a(-2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */