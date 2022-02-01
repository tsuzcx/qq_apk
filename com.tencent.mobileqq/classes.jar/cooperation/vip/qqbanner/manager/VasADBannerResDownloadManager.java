package cooperation.vip.qqbanner.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VasADBannerResDownloadManager
{
  private static VasADBannerResDownloadManager jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager;
  private final Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private final File jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getCacheDir(), "vas_ad");
  private final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Map<String, VasADBannerConfigInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static VasADBannerResDownloadManager a()
  {
    if (jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager == null) {
          jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager = new VasADBannerResDownloadManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerResDownloadManager;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("VasADBannerResDownloadManager", 1, "notifyBannerShow");
    BannerManager.a().b(VasADBannerProcessor.a, 3000);
  }
  
  private void a(VasADBannerConfigInfo paramVasADBannerConfigInfo, String paramString, boolean paramBoolean)
  {
    if ((paramVasADBannerConfigInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramVasADBannerConfigInfo.a == null) {
        return;
      }
      int i = 0;
      while (i < paramVasADBannerConfigInfo.a.size())
      {
        VasADBannerConfigInfo.ResourceInfo localResourceInfo = (VasADBannerConfigInfo.ResourceInfo)paramVasADBannerConfigInfo.a.valueAt(i);
        if ((localResourceInfo != null) && (!TextUtils.isEmpty(localResourceInfo.a)) && (localResourceInfo.a.equalsIgnoreCase(paramString))) {
          localResourceInfo.a(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("VasADBannerResDownloadManager", 1, "notifyBannerHide");
    BannerManager.a().b(VasADBannerProcessor.a, 3001);
  }
  
  private void d(QQAppInterface paramQQAppInterface, VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    VasADBannerResDownloadManager.VasBannerDownloadListener localVasBannerDownloadListener;
    int i;
    if ((paramVasADBannerConfigInfo != null) && (paramVasADBannerConfigInfo.a != null) && (paramVasADBannerConfigInfo.a.size() != 0))
    {
      localVasBannerDownloadListener = new VasADBannerResDownloadManager.VasBannerDownloadListener(this, paramQQAppInterface, paramVasADBannerConfigInfo, paramVasADBannerConfigInfo.a.size());
      i = 0;
    }
    while (i < paramVasADBannerConfigInfo.a.size())
    {
      VasADBannerConfigInfo.ResourceInfo localResourceInfo = (VasADBannerConfigInfo.ResourceInfo)paramVasADBannerConfigInfo.a.valueAt(i);
      if ((localResourceInfo != null) && (!TextUtils.isEmpty(localResourceInfo.a)))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("start downloadFile , url = ");
          ((StringBuilder)localObject).append(localResourceInfo.a);
          QLog.i("VasADBannerResDownloadManager", 2, ((StringBuilder)localObject).toString());
        }
        if (FileUtil.b(localResourceInfo.c))
        {
          localVasBannerDownloadListener.onDownloadSucceed(localResourceInfo.a, null);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("current res has download , onsuccess, url = ");
            ((StringBuilder)localObject).append(localResourceInfo.a);
            QLog.i("VasADBannerResDownloadManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
          if (localObject != null) {
            ((Downloader)localObject).download(localResourceInfo.a, localResourceInfo.c, false, localVasBannerDownloadListener);
          }
        }
        i += 1;
      }
      else
      {
        QLog.e("VasADBannerResDownloadManager", 1, "download data = null");
        b(paramQQAppInterface);
        return;
        b(paramQQAppInterface);
      }
    }
  }
  
  public VasADBannerConfigInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("VasADBannerResDownloadManager", 1, "getVasADBannerConfig uin is empty. return.");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      ??? = VasSplashUtil.a(BaseApplicationImpl.getContext(), paramString);
      String str = VasSplashUtil.a(paramString);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCurrentUnionBannerInfoFromSp adId: ");
      ((StringBuilder)localObject2).append(str);
      QLog.i("VasADBannerResDownloadManager", 1, ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("splash_union_banner_type_");
        ((StringBuilder)localObject2).append(str);
        localObject2 = VasADBannerConfigInfo.a(null, ((SharedPreferences)???).getString(((StringBuilder)localObject2).toString(), "-1"));
        if (localObject2 != null)
        {
          ((VasADBannerConfigInfo)localObject2).a((SharedPreferences)???, str);
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject2);
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (VasADBannerConfigInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(Utils.Crc64String(paramString));
    localStringBuilder.append(paramString.substring(paramString.lastIndexOf(".")));
    return localStringBuilder.toString();
  }
  
  public void a(QQAppInterface paramQQAppInterface, VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramQQAppInterface == null)
    {
      QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify app is null. return.");
      return;
    }
    String str = paramQQAppInterface.getCurrentUin();
    if (TextUtils.isEmpty(str))
    {
      QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify uin is empty. return.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("saveVasADBannerConfigAndNotify mIsDownloading = ");
      paramQQAppInterface.append(this.jdField_a_of_type_Boolean);
      paramQQAppInterface.append(" multi banner show");
      QLog.i("VasADBannerResDownloadManager", 1, paramQQAppInterface.toString());
      return;
    }
    a(paramVasADBannerConfigInfo, str);
    b(paramQQAppInterface, paramVasADBannerConfigInfo);
  }
  
  public void a(VasADBannerConfigInfo paramVasADBannerConfigInfo, String paramString)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (paramVasADBannerConfigInfo == null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      break label37;
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramVasADBannerConfigInfo);
      label37:
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("VasADBannerResDownloadManager", 1, "removeVasADBannerConfig uin is empty. return.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (paramVasADBannerConfigInfo == null)
    {
      QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify VasADBannerConfigInfo = null notifyBannerHide");
      b(paramQQAppInterface);
      return;
    }
    if ((paramVasADBannerConfigInfo.c()) && (!paramVasADBannerConfigInfo.b()))
    {
      QLog.i("VasADBannerResDownloadManager", 1, "checkIsFileExist exist , notifyBannerShow ");
      a(paramQQAppInterface);
      return;
    }
    QLog.i("VasADBannerResDownloadManager", 1, "checkIsFileExist is not exist , start downloadFile ");
    this.jdField_a_of_type_Boolean = true;
    d(paramQQAppInterface, paramVasADBannerConfigInfo);
  }
  
  public void c(QQAppInterface paramQQAppInterface, VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    if (paramVasADBannerConfigInfo != null)
    {
      if (paramVasADBannerConfigInfo.a() == null) {
        return;
      }
      if (!paramVasADBannerConfigInfo.c())
      {
        QLog.i("VasADBannerResDownloadManager", 1, "checkIsFileExist is not exist , start downloadFile ");
        this.jdField_a_of_type_Boolean = true;
        d(paramQQAppInterface, paramVasADBannerConfigInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager
 * JD-Core Version:    0.7.0.1
 */