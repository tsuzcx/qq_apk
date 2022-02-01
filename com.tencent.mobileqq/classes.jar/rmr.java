import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public abstract class rmr
  implements Manager
{
  protected bhyt a;
  protected AppInterface a;
  protected EntityManager a;
  protected ArrayList<bhyn> a;
  protected HashMap<String, String> a;
  protected ConcurrentHashMap<String, String> a;
  
  public rmr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bhyt = ((bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private bhyn a(String paramString1, BaseResData paramBaseResData, String paramString2)
  {
    return new rms(this, paramBaseResData, paramString2, paramString1);
  }
  
  private boolean a(BaseResData paramBaseResData, bhyo parambhyo, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramBaseResData instanceof MaterialData))
    {
      bool1 = bool2;
      if (pnn.a() != null)
      {
        uic.a(pnn.a()).a(parambhyo, (MaterialData)paramBaseResData, new File(paramString));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(String paramString1, String paramString2, BaseResData paramBaseResData, String paramString3, bhyo parambhyo)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    for (;;)
    {
      try
      {
        FileUtils.uncompressZip(paramString1.getAbsolutePath(), a(paramString2), false);
        a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), paramString3, paramBaseResData);
        paramString1.delete();
        bool = false;
      }
      catch (Exception paramString2)
      {
        QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide uncompressZip failed: id = " + paramString3 + ", " + QLog.getStackTraceString(paramString2));
        bool = true;
        paramString1.delete();
        continue;
      }
      finally
      {
        paramString1.delete();
      }
      return bool;
      try
      {
        FileUtils.createDirectory(a(paramString2, paramString3));
        if (FileUtils.fileExists((String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambhyo.a)))
        {
          FileUtils.copyDirectory((String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambhyo.a), a(paramString2, paramString3), false);
          QLog.d("ReadInJoyBaseResManager", 2, "it is the same url copy to another dir path from: " + (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(parambhyo.a) + " to :" + a(paramString2, paramString3));
          return false;
        }
      }
      catch (Exception paramString1)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString2 + "_" + paramString3);
        QLog.d("ReadInJoyBaseResManager", 2, "t is the same url copy to another dir path failed: id = " + paramString3 + ", " + QLog.getStackTraceString(paramString1));
      }
    }
    return false;
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
  
  public void a(bhyn parambhyn)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambhyn);
  }
  
  public void a(String paramString, bhyo parambhyo) {}
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void a(String[] paramArrayOfString) {}
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return a(paramString, paramBaseResData, 0);
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    Object localObject = paramBaseResData.id;
    QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide: id = " + (String)localObject);
    String str = a(paramString, (String)localObject);
    if (bdyn.a(new File(str)))
    {
      QLog.d("readinjoy", 2, "isAnimationPackageValid");
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString + "_" + (String)localObject) != null)
    {
      QLog.d("readinjoy", 2, "mDownloadingRes _");
      return false;
    }
    if (!(paramBaseResData instanceof MaterialData)) {
      FileUtils.deleteDirectory(str);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + (String)localObject, paramBaseResData.url);
    str = str + ".zip";
    File localFile = new File(str);
    Bundle localBundle = new Bundle();
    localBundle.putString("resId", (String)localObject);
    localBundle.putString("prefix", paramString);
    localObject = new bhyo(paramBaseResData.url, localFile);
    ((bhyo)localObject).b = paramInt;
    ((bhyo)localObject).d = 60L;
    this.jdField_a_of_type_Bhyt.a((bhyo)localObject, a(paramString, paramBaseResData, str), localBundle);
    QLog.d("readinjoy", 2, "startDownload");
    return false;
  }
  
  public void b(bhyn parambhyn)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(parambhyn);
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
 * Qualified Name:     rmr
 * JD-Core Version:    0.7.0.1
 */