import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public abstract class qtn
  implements Manager
{
  protected bihz a;
  protected AppInterface a;
  protected EntityManager a;
  protected ArrayList<biht> a;
  protected HashMap<String, String> a;
  protected ConcurrentHashMap<String, String> a;
  
  public qtn(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bihz = ((bihw)paramAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public String a(String paramString)
  {
    String str2 = bigv.a(antf.ba + ".readInjoy/resource/");
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
  
  public void a(biht parambiht)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambiht);
  }
  
  public void a(String paramString, bihu parambihu) {}
  
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
    if (bdxx.a(new File(str)))
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
        bhmi.a(str);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + (String)localObject, paramBaseResData.url);
      str = str + ".zip";
      File localFile = new File(str);
      Bundle localBundle = new Bundle();
      localBundle.putString("resId", (String)localObject);
      localBundle.putString("prefix", paramString);
      localObject = new bihu(paramBaseResData.url, localFile);
      ((bihu)localObject).b = paramInt;
      ((bihu)localObject).d = 60L;
      this.jdField_a_of_type_Bihz.a((bihu)localObject, new qto(this, str, paramBaseResData, paramString), localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "startDownload");
    return false;
  }
  
  public void b(biht parambiht)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(parambiht);
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
 * Qualified Name:     qtn
 * JD-Core Version:    0.7.0.1
 */