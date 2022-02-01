import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lmu
{
  int jdField_a_of_type_Int = 0;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  lmo jdField_a_of_type_Lmo = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(lmo paramlmo)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Lmo == paramlmo) || (TextUtils.isEmpty(paramlmo.b)) || (paramlmo.b.equals(this.jdField_a_of_type_Lmo.b))) {
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
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
              ((INetEngine)localObject).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
            }
          }
        }
        this.jdField_a_of_type_Lmo = paramlmo;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lmw.a(this.jdField_a_of_type_Lmo)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Lmo }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Lmo, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(lmo paramlmo, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lmw.a(paramlmo))
    {
      str2 = paramlmo.a;
      str1 = paramlmo.b;
      str3 = lmw.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramlmo }));
        lmt.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lmt.a(100);
      return false;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new lmv(this, str1, paramlmo, paramInt);
    localHttpNetReq.setUserData(str1);
    localHttpNetReq.mReqUrl = str2;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(str3).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    paramlmo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramlmo instanceof QQAppInterface))
    {
      paramlmo = ((QQAppInterface)paramlmo).getNetEngine(0);
      if (paramlmo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
        paramlmo.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lmt.a(-2);
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
 * Qualified Name:     lmu
 * JD-Core Version:    0.7.0.1
 */