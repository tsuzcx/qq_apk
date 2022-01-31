import android.text.TextUtils;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lpf
{
  int jdField_a_of_type_Int = 0;
  axro jdField_a_of_type_Axro;
  DownloadInfo jdField_a_of_type_ComTencentAvSoDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c;
  
  lpf()
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
        if (this.jdField_a_of_type_Axro != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavSo", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Axro.a() }));
              ((axrr)localObject).b(this.jdField_a_of_type_Axro);
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvSoDownloadInfo = paramDownloadInfo;
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Axro = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lpj.b(this.jdField_a_of_type_ComTencentAvSoDownloadInfo))
        {
          this.jdField_c_of_type_Int |= 0x1;
          this.jdField_a_of_type_Int += 1;
        }
        if (!lpj.a(this.jdField_a_of_type_ComTencentAvSoDownloadInfo))
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
    if (!lpj.b(paramDownloadInfo))
    {
      str3 = paramDownloadInfo.url_zip_so;
      str1 = paramDownloadInfo.MD5_zip_so;
      str2 = lpj.b() + str1;
      i = 1;
    }
    boolean bool2;
    while (paramInt < 0)
    {
      QLog.d("QavSo", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      lpe.a(-3);
      bool2 = false;
      return bool2;
      if ((paramDownloadInfo.enable) && (!lpj.a(paramDownloadInfo)))
      {
        str3 = paramDownloadInfo.url_zip_model;
        str1 = paramDownloadInfo.MD5_zip_model;
        str2 = lpj.a() + str1;
        i = 2;
      }
      else
      {
        lpe.a(100);
        return false;
      }
    }
    QLog.i("QavSo", 1, String.format("downloadRes. res_flag[%s], outPath[%s], info[%s]", new Object[] { Integer.valueOf(i), str2, paramDownloadInfo }));
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = new lpg(this, str1, i, paramDownloadInfo, paramInt);
    localaxro.a(i + "_" + str1);
    localaxro.jdField_a_of_type_JavaLangString = str3;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = new File(str2).getPath();
    localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
    paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramDownloadInfo instanceof QQAppInterface))
    {
      paramDownloadInfo = ((QQAppInterface)paramDownloadInfo).getNetEngine(0);
      if (paramDownloadInfo != null)
      {
        this.jdField_a_of_type_Axro = localaxro;
        paramDownloadInfo.a(this.jdField_a_of_type_Axro);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lpe.a(-2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpf
 * JD-Core Version:    0.7.0.1
 */