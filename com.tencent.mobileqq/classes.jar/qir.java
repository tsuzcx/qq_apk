import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public abstract class qir
  implements Manager
{
  protected awgf a;
  protected beaj a;
  protected AppInterface a;
  protected ArrayList<bead> a;
  protected HashMap<String, String> a;
  protected ConcurrentHashMap<String, String> a;
  
  public qir(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Beaj = ((beag)paramAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Awgf = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public String a(String paramString)
  {
    String str2 = bdzf.a(alof.aX + ".readInjoy/resource/");
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {
      str1 = str2 + paramString + "/";
    }
    return str1;
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(bead parambead)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambead);
  }
  
  public void a(String paramString, beae parambeae) {}
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void a(String[] paramArrayOfString) {}
  
  public abstract boolean a(String paramString, BaseResData paramBaseResData);
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    boolean bool = false;
    Object localObject = paramBaseResData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide: id = " + (String)localObject);
    }
    String str = b(paramString, (String)localObject);
    if (bady.a(new File(str)))
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
        bdhb.a(str);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + (String)localObject, paramBaseResData.url);
      str = str + ".zip";
      File localFile = new File(str);
      Bundle localBundle = new Bundle();
      localBundle.putString("resId", (String)localObject);
      localBundle.putString("prefix", paramString);
      localObject = new beae(paramBaseResData.url, localFile);
      ((beae)localObject).b = paramInt;
      ((beae)localObject).d = 60L;
      this.jdField_a_of_type_Beaj.a((beae)localObject, new qis(this, str, paramBaseResData, paramString), localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "startDownload");
    return false;
  }
  
  public String b(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + paramString2 + "/";
    }
    return paramString1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(bead parambead)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(parambead);
  }
  
  public abstract void b(String paramString, BaseResData paramBaseResData);
  
  public abstract boolean b(String paramString, BaseResData paramBaseResData);
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    return a(paramString, paramBaseResData, 0);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Awgf.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qir
 * JD-Core Version:    0.7.0.1
 */