import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class mai
{
  private static volatile mai jdField_a_of_type_Mai;
  private ArrayList<mak> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  mai()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    QLog.i("ResMgr", 1, "ResDownloadControl for " + localBaseApplicationImpl.getQQProcessName());
  }
  
  public static mai a()
  {
    if (jdField_a_of_type_Mai == null) {}
    try
    {
      if (jdField_a_of_type_Mai == null) {
        jdField_a_of_type_Mai = new mai();
      }
      return jdField_a_of_type_Mai;
    }
    finally {}
  }
  
  private static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    String str = paramString2;
    if (paramString2.endsWith(File.separator)) {
      str = paramString2.substring(0, paramString2.length() - 1);
    }
    return b(paramString1, str);
  }
  
  private static void b(int paramInt1, int paramInt2, ResInfo paramResInfo)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("ACTION_FIELD_DOWNLOAD_STATE", paramInt1);
    localIntent.putExtra("ACTION_FIELD_DOWNLOAD_PROGRESS", paramInt2);
    localIntent.putExtra("ACTION_FIELD_RES_MD5", paramResInfo.resMd5);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    int i = 0;
    QLog.i("ResMgr", 1, "deleteDir. dir = " + paramString1 + ", excludeSubDirOrFile = " + paramString2);
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    if (i < paramString1.length)
    {
      Object localObject = paramString1[i];
      if (!localObject.getAbsolutePath().equalsIgnoreCase(paramString2)) {
        if (localObject.isDirectory())
        {
          bool = b(localObject.getAbsolutePath(), paramString2);
          if (bool)
          {
            QLog.i("ResMgr", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
            bool = true;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("ResMgr", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("ResMgr", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("ResMgr", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
        bool = true;
      }
    }
    return bool;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    paramQQAppInterface = mal.a();
    if (paramQQAppInterface == null) {
      return;
    }
    a();
    paramString = mal.a().a("AVVoiceRecogSo");
    paramConfigInfo = mal.a().a("AVVoiceRecogModel");
    ResInfo localResInfo1 = mal.a().a("AVGameVoiceRecogSo");
    ResInfo localResInfo2 = mal.a().a("AVGameVoiceRecogModel");
    int i = 0;
    label53:
    ResInfo localResInfo3;
    if (i < paramQQAppInterface.size())
    {
      localResInfo3 = (ResInfo)paramQQAppInterface.get(i);
      QLog.i("ResMgr", 1, "handleNewConfig. " + localResInfo3);
      if ((paramString == null) || (!paramString.resId.equalsIgnoreCase(localResInfo3.resId))) {
        break label193;
      }
      a(mal.b(localResInfo3), mal.a(paramString));
    }
    for (;;)
    {
      if ((localResInfo3.isAutoDownload) && (!mal.a(mal.a(localResInfo3) + localResInfo3.resFileName, localResInfo3.resMd5))) {
        a(localResInfo3);
      }
      i += 1;
      break label53;
      break;
      label193:
      if ((paramConfigInfo != null) && (paramConfigInfo.resId.equalsIgnoreCase(localResInfo3.resId))) {
        a(mal.b(localResInfo3), mal.a(paramConfigInfo));
      } else if ((localResInfo1 != null) && (localResInfo1.resId.equalsIgnoreCase(localResInfo3.resId))) {
        a(mal.b(localResInfo3), mal.a(localResInfo1));
      } else if ((localResInfo2 != null) && (localResInfo2.resId.equalsIgnoreCase(localResInfo3.resId))) {
        a(mal.b(localResInfo3), mal.a(localResInfo2));
      }
    }
  }
  
  public boolean a(ResInfo paramResInfo)
  {
    int i = 0;
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_NET_ENGINE) == null)
      {
        QLog.e("ResMgr", 1, "download failed. getNetEngine is null.");
        return false;
      }
    }
    else
    {
      QLog.e("ResMgr", 1, "download failed. appRuntime is not QQAppInterface.");
      return false;
    }
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mak)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentAvSoResInfo.resId.equalsIgnoreCase(paramResInfo.resId))
      {
        if (((mak)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 2)
        {
          QLog.i("ResMgr", 1, "download repeatedly. ResId = " + ((mak)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentAvSoResInfo.resId);
          return true;
        }
        j = 1;
      }
      i += 1;
    }
    if (j == 0)
    {
      localObject = new mak();
      ((mak)localObject).jdField_a_of_type_ComTencentAvSoResInfo = paramResInfo;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      return a((mak)localObject);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    ArrayList localArrayList = mal.a();
    if (localArrayList == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < localArrayList.size())
      {
        if (((ResInfo)localArrayList.get(i)).resId.equalsIgnoreCase(paramString))
        {
          QLog.i("ResMgr", 1, "downloadByResId. " + localArrayList.get(i));
          return a((ResInfo)localArrayList.get(i));
        }
        i += 1;
      }
    }
  }
  
  boolean a(mak parammak)
  {
    if (parammak.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
    {
      localObject1 = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject1 instanceof AppInterface))
      {
        localObject1 = ((AppInterface)localObject1).getNetEngine(0);
        if (localObject1 != null)
        {
          localObject2 = (String)parammak.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData();
          QLog.i("ResMgr", 1, "startDownload. cancel old download req. old res = " + (String)localObject2);
          ((INetEngine)localObject1).cancelReq(parammak.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
        }
      }
    }
    Object localObject1 = new HttpNetReq();
    ((HttpNetReq)localObject1).setUserData(parammak.jdField_a_of_type_ComTencentAvSoResInfo.resType + "_" + parammak.jdField_a_of_type_ComTencentAvSoResInfo.resId + "_" + parammak.jdField_a_of_type_ComTencentAvSoResInfo.resVersion + "_" + parammak.jdField_a_of_type_ComTencentAvSoResInfo.resZipMd5);
    ((HttpNetReq)localObject1).mReqUrl = parammak.jdField_a_of_type_ComTencentAvSoResInfo.resZipUrl;
    ((HttpNetReq)localObject1).mHttpMethod = 0;
    ((HttpNetReq)localObject1).mOutPath = new File(mal.a(parammak.jdField_a_of_type_ComTencentAvSoResInfo) + parammak.jdField_a_of_type_ComTencentAvSoResInfo.resZipMd5 + ".zip").getPath();
    ((HttpNetReq)localObject1).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject1).mCallback = new maj(this, parammak);
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface))
    {
      localObject2 = ((QQAppInterface)localObject2).getNetEngine(0);
      if (localObject2 != null)
      {
        parammak.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject1);
        ((INetEngine)localObject2).sendReq((NetReq)localObject1);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        QLog.e("ResMgr", 1, "startDownload. failed. NETWORK_ERROR. " + parammak.jdField_a_of_type_ComTencentAvSoResInfo);
        this.jdField_a_of_type_JavaUtilArrayList.remove(parammak);
        b(-2, 0, parammak.jdField_a_of_type_ComTencentAvSoResInfo);
        return bool;
      }
      parammak.jdField_a_of_type_Int = 2;
      QLog.i("ResMgr", 1, "startDownload. " + parammak.jdField_a_of_type_ComTencentAvSoResInfo);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mai
 * JD-Core Version:    0.7.0.1
 */