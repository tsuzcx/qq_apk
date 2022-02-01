import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public abstract class ral
  implements Manager
{
  protected bgoj a;
  protected AppInterface a;
  protected EntityManager a;
  protected ArrayList<bgod> a;
  protected HashMap<String, String> a;
  protected ConcurrentHashMap<String, String> a;
  
  public ral(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bgoj = ((bgog)paramAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public String a(String paramString)
  {
    String str2 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/resource/");
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {
      str1 = str2 + paramString + "/";
    }
    return str1;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + paramString2 + "/";
    }
    return paramString1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(bgod parambgod)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambgod);
  }
  
  public void a(String paramString, bgoe parambgoe) {}
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void a(String[] paramArrayOfString) {}
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return a(paramString, paramBaseResData, 0);
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    boolean bool = false;
    Object localObject = paramBaseResData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide: id = " + (String)localObject);
    }
    String str = a(paramString, (String)localObject);
    if (bcro.a(new File(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "isAnimationPackageValid");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString + "_" + (String)localObject) == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("readinjoy", 4, "mDownloadingRes _");
      return false;
      if (!(paramBaseResData instanceof MaterialData)) {
        FileUtils.deleteDirectory(str);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + (String)localObject, paramBaseResData.url);
      str = str + ".zip";
      File localFile = new File(str);
      Bundle localBundle = new Bundle();
      localBundle.putString("resId", (String)localObject);
      localBundle.putString("prefix", paramString);
      localObject = new bgoe(paramBaseResData.url, localFile);
      ((bgoe)localObject).b = paramInt;
      ((bgoe)localObject).d = 60L;
      this.jdField_a_of_type_Bgoj.a((bgoe)localObject, new ram(this, paramBaseResData, str, paramString), localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "startDownload");
    return false;
  }
  
  public void b(bgod parambgod)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(parambgod);
  }
  
  public abstract void b(String paramString, BaseResData paramBaseResData);
  
  public abstract boolean b(String paramString, BaseResData paramBaseResData);
  
  public abstract boolean c(String paramString, BaseResData paramBaseResData);
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ral
 * JD-Core Version:    0.7.0.1
 */